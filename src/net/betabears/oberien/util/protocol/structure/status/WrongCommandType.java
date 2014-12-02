package util.protocol.structure.status;

import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.WrongCommandType)
public class WrongCommandType implements Packet {

	public WrongCommandType(){}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {

	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {

	}
}
