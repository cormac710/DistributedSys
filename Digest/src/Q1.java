import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Q1 {

	public static void main(String[] args) {
		String password = "12345";
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}

		algorithm.reset();
		algorithm.update(password.getBytes());
		byte[] messageDigest = algorithm.digest();

		System.out.println("length " + messageDigest.length);

		String encodedDigest = Base64.getEncoder().encodeToString(messageDigest);
		System.out.println("encoded : " + encodedDigest);

		password = "12345";
		algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}

		algorithm.reset();
		algorithm.update(password.getBytes());
		messageDigest = algorithm.digest();

		System.out.println("length " + messageDigest.length);

		encodedDigest = Base64.getEncoder().encodeToString(messageDigest);
		System.out.println("encoded : " + encodedDigest);

	}

}
