package net.betabears.oberien.util.protocol;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Packet {
	void read(DataInputStream dataInputStream) throws IOException;
	void write(DataOutputStream dataOutputStream) throws IOException;
}
