package net.betabears.oberien.util.protocol;

public enum PacketType {
	ActionFailed(0), GetUserMetaData(1),
	Register(2), RegisterSuccess(3), ValidateMailRequest(4), ValidateMailProofOfWork(10), ValidateMailProofOfWorkAnswer(11), ValidateMailProofOfWorkSuccess(9),
	UserAdded(5), UserRemoved(6), CertificateSigningRequest(7), CertificateSigningSuccess(8),

	Kick(25), Ban(26), BroadcastToAll(27),

	Broadcast(50), PrivateMessage(51),

	WrongCommandType(-1);

	private final int ID;

	private PacketType(int id) {
		this.ID = id;
	}

	public int getID() {
		return ID;
	}
}
