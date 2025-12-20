package P8;
import java.util.Scanner;
class SharedBuffer{
	private int number;
	private boolean isEmpty = true;
	public synchronized void put(int value) throws InterruptedException{
		while(!isEmpty) {
			wait();
		}
		number = value;
		isEmpty = false;
		System.out.println("Producer puts :"+number);
		System.out.println("Notifying Consumer!");
		notify();
	}
	public synchronized void get() throws InterruptedException{
		while(isEmpty) {
			wait();
		}
		System.out.println("Consumer receives: "+number);
		isEmpty=true;
		System.out.println("Notifying Producer!");
		notify();
	}
}

class Producer extends Thread{
	private SharedBuffer sb;
	private int limit;
	public Producer(SharedBuffer sb,int limit) {
		this.sb = sb;
		this.limit = limit;
	}
	public void run() {
		try {
			for(int i=0;i<limit;i++) {
				sb.put(i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e) {
			System.out.println("Produced Interrupted");
		}
	}
}

class Consumer extends Thread{
	private SharedBuffer sb;
	private int limit;
	public Consumer(SharedBuffer sb,int limit) {
		this.sb = sb;
		this.limit = limit;
	}
	public void run() {
		try {
			for(int i=0;i<limit;i++) {
				sb.get();
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			System.out.println("Consumer Interrupted");
		}
	}
}


public class Program8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SharedBuffer buffer = new SharedBuffer();
		System.out.println("Enter the number of items");
		int items = s.nextInt();
		s.nextLine();
		Producer p = new Producer(buffer, items);
		Producer p1 = new Producer(buffer, items);
		Consumer c = new Consumer(buffer,items);
		Consumer c1 = new Consumer(buffer,items);
		p.start();
		p1.start();
		c.start();
		c1.start();
	}
}
