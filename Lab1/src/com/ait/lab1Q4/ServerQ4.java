package com.ait.lab1Q4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerQ4 {

	public static void main(String[] args) throws IOException {
		Socket s;
		ServerSocket ss = new ServerSocket(2000);
		while (true) {
			System.out.println("server waiting for connection");
			s = ss.accept();

			InputStream in = s.getInputStream();
			Scanner sc = new Scanner(in);
			
			OutputStream out = s.getOutputStream();
			PrintWriter p = new PrintWriter(out);
			
			String fileName = "test.txt";
//			fileName = sc.nextLine();
			
			System.out.println("requested : " + fileName);
			
			FileInputStream fis = new FileInputStream(fileName);
			Scanner f = new Scanner(fis);
			
			while(f.hasNextLine()){
				p.println(f.nextLine());
			}
			p.close();
		}
	}

}
