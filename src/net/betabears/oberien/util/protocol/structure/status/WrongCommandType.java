package net.betabears.oberien.util.protocol.structure.status;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

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
