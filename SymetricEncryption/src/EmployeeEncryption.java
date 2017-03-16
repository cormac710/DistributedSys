import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class EmployeeEncryption {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, IOException, ClassNotFoundException, BadPaddingException {
		String ALGORITHM = "DES";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		
		System.out.println(ALGORITHM);
		// init cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);
		
		SealedObject so = new SealedObject(new Employee("cormac", "123", "087"), eCipher);
		
		System.out.println(so);
		writeObject("sealedObject.dat", so);
		
		//Decrypt
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);
		
		//unseal
		Employee o = (Employee) so.getObject(dCipher);
		System.out.println(o.getName());
		writeObject("secretKey", key);
		
	}

	private static void writeObject(String file, Object obj) throws IOException {
		FileOutputStream fout = new FileOutputStream(new File(file));
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(obj);
		oout.close();
	}
	
}
