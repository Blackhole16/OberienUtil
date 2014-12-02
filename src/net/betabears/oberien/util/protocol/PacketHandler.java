package util.protocol;

import server.connection.Connection;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface PacketHandler {
	boolean handle(Connection con) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
}