import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class symetricEncryptor {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		String ALGORITHM = "DES";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		System.out.println(ALGORITHM);
		// init cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);

		String s = "This is an example";
		System.out.println("Clear Text : " + s);
		byte[] cleartext = s.getBytes();

		// encrypt clearText
		byte[] cipherText = eCipher.doFinal(cleartext);
		System.out.println("Cipher text : " + cipherText);

		// Decrypt
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);

		// decript ciphertext
		byte[] clearTextNew = dCipher.doFinal(cipherText);
		String text = new String(clearTextNew);
		System.out.println("Decrypted : " + text);

		AES();
		Blowfish();
	}

	private static void AES() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		String ALGORITHM = "AES";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		System.out.println(ALGORITHM);
		// init cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);

		String s = "This is an example";
		System.out.println("Clear Text : " + s);
		byte[] cleartext = s.getBytes();

		// encrypt clearText
		byte[] cipherText = eCipher.doFinal(cleartext);
		System.out.println("Cipher text : " + cipherText);

		// Decrypt
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);

		// decript ciphertext
		byte[] clearTextNew = dCipher.doFinal(cipherText);
		String text = new String(clearTextNew);
		System.out.println("Decrypted : " + text);
	}
	


	private static void Blowfish() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		String ALGORITHM = "Blowfish";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		System.out.println(ALGORITHM);
		// init cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);

		String s = "This is an example";
		System.out.println("Clear Text : " + s);
		byte[] cleartext = s.getBytes();

		// encrypt clearText
		byte[] cipherText = eCipher.doFinal(cleartext);
		System.out.println("Cipher text : " + cipherText);

		// Decrypt
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);

		// decript ciphertext
		byte[] clearTextNew = dCipher.doFinal(cipherText);
		String text = new String(clearTextNew);
		System.out.println("Decrypted : " + text);
	}

}
