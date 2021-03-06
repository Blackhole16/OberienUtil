package net.betabears.oberien.util.protocol;

public enum ActionFailureCode {
	UsernameTaken(0), LoginNameTaken(7), UsernameInvalid(1),

	MailNotValidated(2), MailInvalid(3),

	NotLoggedIn(4),

	ValidationTokenInvalid(5), ValidationTokenWrong(6), InvalidProofOfWork(8),

	WrongCredentials(-1), NotEnoughPermissions(-2), InternalServerError(-3);

	private final int ID;

	private ActionFailureCode(int id) {
		this.ID = id;
	}

	public int getID() {
		return ID;
	}

	public static ActionFailureCode getById(int id) {
		ActionFailureCode[] codes = values();
		for (ActionFailureCode code : codes) if (code.getID() == id) return code;
		return null;
	}
}
