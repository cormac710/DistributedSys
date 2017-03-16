import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Q2 {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		MessageDigest algorithm = MessageDigest.getInstance("sha-256");
		File f = new File("data/test.txt");
		InputStream is = new FileInputStream(f);
		byte[] buffer = new byte[8192];

		int read = 0;
		while ((read = is.read(buffer)) > 0) {
			algorithm.update(buffer, 0,read);
		}
		
		byte[] digest = algorithm.digest();
		
	}

}
