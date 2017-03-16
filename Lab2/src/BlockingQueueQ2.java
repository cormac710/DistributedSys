import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueQ2 {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = 
				new ArrayBlockingQueue<String>(4);
		queue.put("jimmy");
		queue.put("rob");
		queue.put("paul");
		queue.put("john");
		System.out.println(queue.take());
		System.out.println(queue.take());
	}

}
