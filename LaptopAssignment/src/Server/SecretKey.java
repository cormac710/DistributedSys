package Server;

import java.util.Base64;

import javax.crypto.KeyGenerator;

public class SecretKey {

	public static void main(String[] args) throws Exception {
		System.out.println(createKey("123"));
	}

	private static String createKey(final String clientId)
			throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
		javax.crypto.SecretKey sk = kg.generateKey();
		String encodedKey = Base64.getEncoder().encodeToString(sk.getEncoded());

		return encodedKey;
	}

}
