package util.protocol.structure.status;

import util.protocol.ActionFailureCode;
import util.protocol.PacketType;
import util.protocol.Command;
import util.protocol.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(commandType = PacketType.ActionFailed)
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
