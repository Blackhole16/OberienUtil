package net.betabears.oberien.util.validate;

public enum Permissions {
	BroadcastToAll(1), Kick(2);


	private final int REQUIRED_PERMISSION;
	Permissions(int requiredPermission) {
		this.REQUIRED_PERMISSION = requiredPermission;
	}

	public int getRequiredPermission() {
		return REQUIRED_PERMISSION;
	}
}
