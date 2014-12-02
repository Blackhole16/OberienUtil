package net.betabears.oberien.util.protocol.structure.administrative;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

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
