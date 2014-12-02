package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.Login)
public class Login implements Packet {
	protected String username;
	protected String password;

	public Login() {}

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		username = dataInputStream.readUTF();
		password = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(username);
		dataOutputStream.writeUTF(password);
	}
}
