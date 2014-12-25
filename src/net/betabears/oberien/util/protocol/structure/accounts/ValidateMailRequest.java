package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.ValidateMailRequest)
public class ValidateMailRequest implements Packet {
	protected String mail;

	public ValidateMailRequest() {
	}

	public ValidateMailRequest(String mail) {
		this.mail = mail;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		mail = dataInputStream.readUTF();
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(mail);
	}
}
