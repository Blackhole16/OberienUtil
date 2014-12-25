package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.GetUserMetaData)
public class GetUserMetaData implements Packet {
	protected String username;
	protected int permissions;

	public GetUserMetaData() {
	}

	public GetUserMetaData(String username, int permissions) {
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
