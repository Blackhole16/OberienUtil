package net.betabears.oberien.util.protocol.io;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketHandler;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class PacketReader {
	private DataInputStream dataInputStream;
	private Object o;
	private static Map<Integer, Class<? extends PacketHandler>> packets;
	private PacketHandler currentHandler;

	public PacketReader(Object o, DataInputStream dataInputStream) {
		this.o = o;
		this.dataInputStream = dataInputStream;

		packets = new HashMap<>();
	}

	public PacketType read() throws UnsupportedOperationException, IOException {
		int packetId = dataInputStream.readInt();
		currentHandler = getPacket(packetId);
		if (currentHandler == null || !(currentHandler instanceof Command)) {
			throw new UnsupportedOperationException("Read Package does not have a valid Handler.");
		}
		return ((Command)currentHandler).packetType();
	}

	@SuppressWarnings("unchecked")
	public boolean handle() throws IOException {
		Packet packet = (Packet) currentHandler;
		packet.read(dataInputStream);
		return currentHandler.handle(o);
	}

	@SuppressWarnings("unchecked")
	public boolean handle(Object o) throws IOException {
		Packet packet = (Packet) currentHandler;
		packet.read(dataInputStream);
		return currentHandler.handle(o);
	}

	public void addPacket(Class<? extends PacketHandler> clazz) {
		packets.put(clazz.getAnnotation(Command.class).packetType().getID(), clazz);
	}

	private PacketHandler getPacket(int id) {
		try {
			return packets.get(id).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

	public void close() throws IOException {
		dataInputStream.close();
	}
}
