package com.ait.lab1;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public static void main(String args[]) throws Exception{
		Socket s;
		ServerSocket ss = new ServerSocket(2000);
		while(true){
			System.out.println("server waiting for connection");
			s = ss.accept();
			
			InputStream in = s.getInputStream();
			Scanner sc = new Scanner(in);
			
			OutputStream out = s.getOutputStream();
			PrintWriter p = new PrintWriter(out);
			
			String inputLine = sc.nextLine();
			
			//send string back to the client
			p.println("Hello  " + inputLine + " from SERVER");
			p.close();
			
//			// Q2
//			FileInputStream file = new FileInputStream("test.txt");
//			sc = new Scanner(file);
//			FileOutputStream fout = new FileOutputStream("test2.txt");
//			PrintWriter pWriter = new PrintWriter(fout);
//			
//			while(sc.hasNextLine()){
//				pWriter.println(sc.nextLine());
//			}
//			pWriter.close();
		    
		}
		
		
		
	}

}
