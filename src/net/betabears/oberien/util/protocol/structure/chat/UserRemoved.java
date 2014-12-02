package net.betabears.oberien.util.protocol.structure.chat;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.UserRemoved)
public class UserRemoved implements Packet {
	protected String username;

	public UserRemoved(){}

	public UserRemoved(String username) {
		this.username = username;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		username = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(username);
	}
}
