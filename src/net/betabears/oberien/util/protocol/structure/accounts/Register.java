package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.Register)
public class Register implements Packet {
	protected String username;
	protected String email;
	protected String pwdHash;

	public Register() {}

	public Register(String username, String email, String pwdHash) {
		this.username = username;
		this.email = email;
		this.pwdHash = pwdHash;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		username = dataInputStream.readUTF();
		email = dataInputStream.readUTF();
		pwdHash = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(username);
		dataOutputStream.writeUTF(email);
		dataOutputStream.writeUTF(pwdHash);
	}
}
