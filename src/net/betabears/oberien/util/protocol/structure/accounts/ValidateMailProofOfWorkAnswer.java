package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.ValidateMailProofOfWorkAnswer)
public class ValidateMailProofOfWorkAnswer implements Packet {
	public byte[] proofOfWorkPrefix;
	public String email;

	public ValidateMailProofOfWorkAnswer() {
	}

	public ValidateMailProofOfWorkAnswer(byte[] proofOfWorkPrefix, String email) {
		this.proofOfWorkPrefix = proofOfWorkPrefix;
		this.email = email;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		int length = dataInputStream.readInt();
		proofOfWorkPrefix = new byte[length];
		dataInputStream.read(proofOfWorkPrefix);
		email = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeInt(proofOfWorkPrefix.length);
		dataOutputStream.write(proofOfWorkPrefix);
		dataOutputStream.writeUTF(email);
	}
}
