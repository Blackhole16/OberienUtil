package util.protocol.structure.chat;

import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.Broadcast)
public class Broadcast implements Packet {
	protected String sender;
	protected String message;

	public Broadcast() {}

	public Broadcast(String sender, String message) {
		this.sender = sender;
		this.message = message;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		sender = dataInputStream.readUTF();
		message = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(sender);
		dataOutputStream.writeUTF(message);
	}
}
