package net.betabears.oberien.util.protocol.io;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;

import java.io.DataOutputStream;
import java.io.IOException;

public class PacketWriter {
	private DataOutputStream dataOutputStream;

	public PacketWriter(DataOutputStream dataOutputStream) {
		this.dataOutputStream = dataOutputStream;
	}

	public void write(Packet packet) throws IOException {
		if (!(packet instanceof Command)) {
			throw new UnsupportedOperationException("Packet does not implement the Command-Annotation");
		}
		dataOutputStream.writeInt(((Command) packet).packetType().getID());
		packet.write(dataOutputStream);
	}

	public void close() throws IOException {
		dataOutputStream.close();
	}
}
