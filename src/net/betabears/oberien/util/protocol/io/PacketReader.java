package util.protocol.io;

import logger.ErrorLogger;
import server.connection.Connection;
import util.protocol.Command;
import util.protocol.Packet;
import util.protocol.PacketHandler;
import util.protocol.PacketType;
import protocol.implementation.accounts.LoginImpl;
import protocol.implementation.accounts.RegisterImpl;
import protocol.implementation.accounts.ValidateMailImpl;
import protocol.implementation.status.WrongCommandTypeImpl;

import java.io.DataInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class PacketReader {
	private DataInputStream dataInputStream;
	private Connection connection;
	private static Map<Integer, Class<? extends PacketHandler>> packets;
	private PacketHandler currentHandler;

	public PacketReader(Connection connection, DataInputStream dataInputStream) {
		this.connection = connection;
		this.dataInputStream = dataInputStream;

		packets = new HashMap<>();
		addPacket(LoginImpl.class);
		addPacket(RegisterImpl.class);
		addPacket(WrongCommandTypeImpl.class);
		addPacket(ValidateMailImpl.class);
	}

	public PacketType read() throws UnsupportedOperationException, IOException {
		int packetId = dataInputStream.readInt();
		currentHandler = getPacket(packetId);
		if (currentHandler == null || !(currentHandler instanceof Command)) {
			throw new UnsupportedOperationException("Read Package does not have a valid Handler.");
		}
		return ((Command)currentHandler).commandType();
	}

	public boolean handle() throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		Packet packet = (Packet) currentHandler;
		packet.read(dataInputStream);
		return currentHandler.handle(connection);
	}

	private void addPacket(Class<? extends PacketHandler> clazz) {
		packets.put(clazz.getAnnotation(Command.class).commandType().getID(), clazz);
	}

	private PacketHandler getPacket(int id) {
		try {
			return packets.get(id).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

	public void close() {
		try {
			dataInputStream.close();
		} catch (IOException e) {
			ErrorLogger.logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
