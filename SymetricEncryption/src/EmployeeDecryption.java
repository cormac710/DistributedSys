import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class EmployeeDecryption {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String ALGORITHM = "DES";
		SecretKey key = (SecretKey) readFromFile("secretKey");
		SealedObject so = (SealedObject) readFromFile("sealedObject.dat");
		
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);
		
		Employee emp = (Employee) so.getObject(dCipher);
		System.out.println(emp);
	}

	private static Object readFromFile(String file) throws IOException, ClassNotFoundException {
		FileInputStream fIn = new FileInputStream(new File(file));
		ObjectInputStream oIn = new ObjectInputStream(fIn);
		return oIn.readObject();
	}
	
}
