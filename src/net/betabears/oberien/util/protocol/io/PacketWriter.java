package util.protocol.io;

import logger.ErrorLogger;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;

public class PacketWriter {
	private DataOutputStream dataOutputStream;

	public PacketWriter(DataOutputStream dataOutputStream) {
		this.dataOutputStream = dataOutputStream;
	}

	public void write(Packet packet) throws IOException {
		if (!(packet instanceof Command)) {
			throw new UnsupportedOperationException("Packet does not implement the Command-Annotation");
		}
		dataOutputStream.writeInt(((Command) packet).commandType().getID());
		packet.write(dataOutputStream);
	}

	public void close() {
		try {
			dataOutputStream.close();
		} catch (IOException e) {
			ErrorLogger.logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
