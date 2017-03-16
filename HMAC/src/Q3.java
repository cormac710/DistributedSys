import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Q3 {

	public static void main(String[] args) throws Exception {
		String encodedKey = (String) readFromFile("data/secretkey");
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		SecretKey sk = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");

		String encodedHmac = (String) readFromFile("data/hmac");
		byte[] sentHmac = Base64.getDecoder().decode(encodedHmac);
		String sendText = (String) readFromFile("data/sendText.txt");

		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(sk);
		byte[] myHmac = mac.doFinal(sendText.getBytes());

		System.out.println("check " + Arrays.equals(sentHmac, myHmac));
	}

	private static Object readFromFile(String file) throws Exception {
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object o = oin.readObject();
		oin.close();
		return o;
	}
}
