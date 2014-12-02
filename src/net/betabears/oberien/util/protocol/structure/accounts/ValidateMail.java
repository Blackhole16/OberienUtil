package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.ValidateMail)
public class ValidateMail implements Packet {
	protected String activationToken;

	public ValidateMail() {}

	public ValidateMail(String activationToken) {
		this.activationToken = activationToken;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		activationToken = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(activationToken);
	}
}