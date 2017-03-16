package com.ait.lab1Q3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerQ3 {

	public static void main(String[] args) throws IOException {
		Socket s;
		ServerSocket ss = new ServerSocket(2002);
		while(true){
			System.out.println("server waiting for connection");
			s = ss.accept();
			
			InputStream in = s.getInputStream();
			Scanner r = new Scanner(in);
			OutputStream o = s.getOutputStream();
			PrintWriter p = new PrintWriter(o);
			
			String name = r.nextLine();
			System.out.println(name);

			p.println("hello " + name);
			p.println("hello " + name);
			p.println("hello " + name);
			p.println("hello " + name);
			p.println("hello " + name);
			p.close();
		}

	}

}
