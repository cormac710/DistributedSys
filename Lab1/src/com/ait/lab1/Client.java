package com.ait.lab1;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		InetAddress inet = InetAddress.getByName("localhost");
		Socket socket = new Socket(inet, 2000);
		
		OutputStream outStream = socket.getOutputStream();
		PrintWriter print = new PrintWriter(outStream);
		InputStream in = socket.getInputStream();
		Scanner sc = new Scanner(in);
		
		print.println("Cormac");
		print.flush();
		
		String inputLine = sc.nextLine();
		System.out.println("Client: " + inputLine);
		
		System.out.println("Q2 Reading from File");
//		FileInputStream fin = new FileInputStream("com.ait.lab1/file.txt");
//	    Scanner scanner = new Scanner(fin);
//
//	    while (scanner.hasNextLine()) {
//	      System.out.println(scanner.nextLine());
//	    }

	}

}
