import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Q1 {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
		KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
		SecretKey sk = kg.generateKey();
		
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(sk);
		byte[] result = mac.doFinal("Hi There".getBytes());
		System.out.println(result.length);
		
		/// Receiver
		Mac mac2 = Mac.getInstance("HmacSHA256");
		mac2.init(sk);
		byte[] result2 = mac.doFinal("Hi There".getBytes());
		System.out.println("result 1 " + result);
		System.out.println("result 2 " + result2);
		System.out.println("Check: " + Arrays.equals(result, result2));
		
		// Base64 encode a secret key
		String encodedKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		System.out.println("Encoded Key :" + encodedKey);
		// Base64 decode a secret key
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		sk = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
	}
	
}
