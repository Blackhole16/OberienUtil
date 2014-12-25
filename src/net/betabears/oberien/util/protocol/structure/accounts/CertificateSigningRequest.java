package net.betabears.oberien.util.protocol.structure.accounts;

import net.betabears.oberien.util.protocol.Command;
import net.betabears.oberien.util.protocol.Packet;
import net.betabears.oberien.util.protocol.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Command(packetType = PacketType.CertificateSigningRequest)
public class CertificateSigningRequest implements Packet {
	protected String mail;
	protected String clientName;
	protected boolean permanent;
	protected byte[] csr;

	public CertificateSigningRequest() {
	}

	public CertificateSigningRequest(String mail, String clientName, boolean permanent, byte[] csr) {
		this.mail = mail;
		this.clientName = clientName;
		this.permanent = permanent;
		this.csr = csr;
	}

	@Override
	public void read(DataInputStream dataInputStream) throws IOException {
		mail = dataInputStream.readUTF();
		clientName = dataInputStream.readUTF();
		permanent = dataInputStream.readBoolean();
		int length = dataInputStream.readInt();
		csr = new byte[length];
		int read = dataInputStream.read(csr);
		if (read != length) {
			throw new IOException("CSR-Length derived");
		}
	}

	@Override
	public void write(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(mail);
		dataOutputStream.writeUTF(clientName);
		dataOutputStream.writeBoolean(permanent);
		dataOutputStream.writeInt(csr.length);
		dataOutputStream.write(csr);
	}
}
