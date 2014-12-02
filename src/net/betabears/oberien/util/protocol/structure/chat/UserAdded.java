package util.protocol.structure.chat;

import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.UserAdded)
public class UserAdded implements Packet {
	protected String[] usernames;

	public UserAdded(){}

	public UserAdded(String... usernames) {
		this.usernames = usernames;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		int count = dataInputStream.readInt();
		usernames = new String[count];
		for (int i = 0; i < count; i++) {
			usernames[i] = dataInputStream.readUTF();
		}
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeInt(usernames.length);
		for (String s : usernames) {
			dataOutputStream.writeUTF(s);
		}
	}
}
