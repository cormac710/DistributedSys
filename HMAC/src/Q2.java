import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Q2 {

	public static void main(String[] args) throws Exception {
		String message = "this is the data im sending";
		KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
		SecretKey sk = kg.generateKey();
		String encodedKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		writeToFile("data/secretkey", encodedKey);
		writeToFile("data/secretkey.txt", message);
		byte[] textArray = message.getBytes();
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(sk);
		byte[] hmac = mac.doFinal(textArray);
		String encodedHmac = Base64.getEncoder().encodeToString(hmac);
		writeToFile("data/hmac", encodedHmac);
		
		System.out.println(hmac.length);
		System.out.println("Base 64 encoded digest " + encodedHmac);
	}

	private static void writeToFile(String file, String encodedKey) throws Exception {
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(encodedKey);
		oout.close();
	}
	
}
