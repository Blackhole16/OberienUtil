package util.protocol.structure.administrative;

import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.Kick)
public class Kick implements Packet {
	protected String username;
	protected String from;
	protected String reason;

	public Kick(){}

	public Kick(String username, String from, String reason) {
		this.username = username;
		this.from = from;
		this.reason = reason;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		username = dataInputStream.readUTF();
		from = dataInputStream.readUTF();
		reason = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(username);
		dataOutputStream.writeUTF(from);
		dataOutputStream.writeUTF(reason);
	}
}
