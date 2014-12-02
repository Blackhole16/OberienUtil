package util.protocol.structure.chat;

import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.PrivateMessage)
public class PrivateMessage implements Packet {
	protected String sender;
	protected String recipient;
	protected String message;

	public PrivateMessage() {}

	public PrivateMessage(String sender, String recipient, String message) {
		this.sender = sender;
		this.recipient = recipient;
		this.message = message;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		sender = dataInputStream.readUTF();
		recipient = dataInputStream.readUTF();
		message = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(sender);
		dataOutputStream.writeUTF(recipient);
		dataOutputStream.writeUTF(message);
	}
}
