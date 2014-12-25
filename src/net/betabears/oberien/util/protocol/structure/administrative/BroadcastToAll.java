package net.betabears.oberien.util.protocol.structure.administrative;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.BroadcastToAll)
public class BroadcastToAll implements Packet {
	protected String sender;
	protected String message;

	public BroadcastToAll() {}

	public BroadcastToAll(String sender, String message) {
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
