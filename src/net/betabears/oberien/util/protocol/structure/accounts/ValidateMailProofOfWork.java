package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.ValidateMailProofOfWork)
public class ValidateMailProofOfWork implements Packet {
	protected byte[] pow;
	protected int zeroCount;

	public ValidateMailProofOfWork() {
	}

	public ValidateMailProofOfWork(byte[] pow, int zeroCount) {
		this.pow = pow;
		this.zeroCount = zeroCount;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		int length = dataInputStream.readInt();
		pow = new byte[length];
		dataInputStream.read(pow);
		zeroCount = dataInputStream.readInt();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeInt(pow.length);
		dataOutputStream.write(pow);
		dataOutputStream.writeInt(zeroCount);
	}
}
