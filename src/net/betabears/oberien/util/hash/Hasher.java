package net.betabears.oberien.util.hash;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Hasher {
	public static byte[] generatePrefixSha512(byte[] pow, int count) {
		String hash;
		byte[] current = pow;

		for (long l = 0; l < Long.MAX_VALUE; l++) {
			current = concat(getBytes(l), current);
			hash = hashSHA512(current);
			if (getPreZeros(hash) >= count) {
				break;
			}
		}
		return current;
	}

	public static int getPreZeros(String hex) {
		int count = 0;
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			if (c == '0') {
				count += 4;
				continue;
			} else if (c < '2') {
				count += 3;
			} else if (c < '4') {
				count += 2;
			} else if (c < '8') {
				count += 1;
			}
			break;
		}
		return count;
	}

	private static byte[] getBytes(long l) {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putLong(l);
		return bb.array();
	}

	public static byte[] concat(byte[] b1, byte[] b2) {
		byte[] result = Arrays.copyOf(b1, b1.length + b2.length);
		System.arraycopy(b2, 0, result, b1.length, b2.length);
		return result;
	}

	public static String hashSHA512(String in) {
		in = in.toLowerCase();
		return hashSHA512(in.getBytes());
	}

	public static String hashSHA512(byte[] in) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(in);

			byte byteData[] = md.digest();
			return byteToHex(byteData);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("This should never happen!", e);
		}
	}

	public static String generateHmacSignature(byte[] message, byte[] key) {
		Mac mac = null;
		try {
			mac = Mac.getInstance("HmacSHA512");
			SecretKeySpec keySpec = new SecretKeySpec(key, "HmacSHA512");
			mac.init(keySpec);
			byte[] result = mac.doFinal(message);
			return Base64.encode(result).replaceAll("\n", "");
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			throw new Error("This should never happen!", e);
		}
	}

	public static boolean verifyHmacSignature(byte[] message, String signature, byte[] key) {
		return generateHmacSignature(message, key).equals(signature);
	}

	public static String byteToHex(byte[] byteData) {
		//convert the byte to hex format method 1
		StringBuilder sb = new StringBuilder();
		for (byte b : byteData) {
			sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
