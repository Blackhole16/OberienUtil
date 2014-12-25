package net.betabears.oberien.util.protocol.structure.status;

import net.betabears.oberien.util.protocol.ActionFailureCode;
import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.ActionFailed)
public class ActionFailed implements Packet {
	protected ActionFailureCode failureCode;

	public ActionFailed() {}

	public ActionFailed(ActionFailureCode failureCode) {
		this.failureCode = failureCode;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		failureCode = ActionFailureCode.getById(dataInputStream.readInt());
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeInt(failureCode.getID());
	}
}
