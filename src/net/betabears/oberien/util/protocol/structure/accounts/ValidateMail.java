package util.protocol.structure.accounts;

import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

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