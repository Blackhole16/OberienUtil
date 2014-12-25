package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.ValidateMailProofOfWorkSuccess)
public class ValidateMailProofOfWorkSuccess implements Packet {

	public ValidateMailProofOfWorkSuccess() {
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {

	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {

	}
}
