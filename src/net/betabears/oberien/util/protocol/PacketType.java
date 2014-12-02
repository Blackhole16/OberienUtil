package net.betabears.oberien.util.protocol;

public enum PacketType {
	ActionFailed(0), ActionSucceed(1),
	Register(2), RegisterSuccess(3), Login(3), LoginSuccess(4), ValidateMail(4),
	UserAdded(5), UserRemoved(6),

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
