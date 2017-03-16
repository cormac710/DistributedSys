import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.spec.DHParameterSpec;

public class dhGenerate {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidParameterSpecException, IOException {
		AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DH");
		paramGen.init(1024);
		
		AlgorithmParameters params = paramGen.generateParameters();
		DHParameterSpec dhSpec = params.getParameterSpec(DHParameterSpec.class);
		String s = dhSpec.getP() + "," + dhSpec.getG() + "," + dhSpec.getL();
		System.out.println(s);
		writeTofile("dhParams", s);
	}

	private static void writeTofile(String file, String s) throws IOException {
		FileOutputStream fout = new FileOutputStream(new File(file));
		byte[] content = s.getBytes();
		fout.write(content);
		fout.flush();
		fout.close();
	}
	
}
