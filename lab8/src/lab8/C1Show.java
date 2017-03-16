package lab8;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class C1Show {
	public static void main(String[] args)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		String keystoreFilename = "keystore";
		char[] password = "abcde".toCharArray();
		String alias = "cormac";

		FileInputStream fIn = new FileInputStream(keystoreFilename);
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(fIn, password);
		Certificate cert = keystore.getCertificate(alias);
		System.out.println(cert);
		
	//	writeCert(cert);
	}

}
