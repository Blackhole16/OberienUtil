package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.LoginSuccess)
public class LoginSuccess implements Packet {
	protected String username;
	protected int permissions;

	public LoginSuccess() {}

	public LoginSuccess(String username, int permissions) {
		this.username = username;
		this.permissions = permissions;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		username = dataInputStream.readUTF();
		permissions = dataInputStream.readInt();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(username);
		dataOutputStream.writeInt(permissions);
	}
}
