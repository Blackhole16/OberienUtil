package util.protocol.structure.accounts;

import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.RegisterSuccess)
public class ValidateMailSuccess implements Packet {

	public ValidateMailSuccess() {}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {

	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {

	}
}
