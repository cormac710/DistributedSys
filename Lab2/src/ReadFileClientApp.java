import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ReadFileClientApp {

	public static void main(String args[]) throws Exception {

		BlockingQueue<Socket> queue = new ArrayBlockingQueue<Socket>(4);
		ServerSocket ss = new ServerSocket(2010);

		for (int i = 0; i < 4; i++) {
			WorkerThreadClient t1 = new WorkerThreadClient(queue);
			t1.start();
		}

		while (true) {
			Socket s = ss.accept();
			System.out.println(s);
		}
	}
}

class WorkerThreadClient extends Thread {
	BlockingQueue<Socket> queue;

	public WorkerThreadClient(BlockingQueue<Socket> queue) {
		System.out.println("ctor");
		this.queue = queue;
	}

	public void run() {
		try {
			while (true) {
				Socket s = queue.take();
				
				InputStream in = s.getInputStream();
				Scanner r = new Scanner(in);
				OutputStream o = s.getOutputStream();
				PrintWriter p = new PrintWriter(o);
				
				String fileName = r.nextLine();
				
				FileInputStream fin = new FileInputStream(fileName);
				Scanner f = new Scanner(fin);

				String line;
				while(f.hasNextLine()){
					line = f.nextLine();
					p.println(line);
				}

				sleep(150);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
