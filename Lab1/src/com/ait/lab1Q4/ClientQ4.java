package com.ait.lab1Q4;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientQ4 {

	public static void main(String[] args) throws Exception {
		InetAddress inet = InetAddress.getLocalHost();
		Socket s = new Socket(inet, 2000);

		InputStream in = s.getInputStream();
		Scanner sc = new Scanner(in);
		OutputStream outStream = s.getOutputStream();
		PrintWriter print = new PrintWriter(outStream);
		
		print.println("cormac");
		print.flush();
		
		while(sc.hasNext()){
			System.out.println(sc.nextLine());
		}
	}

}
