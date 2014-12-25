package net.betabears.oberien.util.protocol;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface PacketHandler<T> {
	boolean handle(T t) throws IOException;
}
