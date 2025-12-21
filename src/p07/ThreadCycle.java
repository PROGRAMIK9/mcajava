package src;

class Thread1 extends Thread{
	public void run(){
		try {
			for(int i=1;i<=5;i++) {
				System.out.println("Thread 1 :"+i);
				System.out.println("Thread 1 asleep for 2 seconds");
				Thread.sleep(2000);
			}
		}catch(InterruptedException e) {
			System.out.println("Thread 1 asleep");
		}
		System.out.println("Thread 1 finished execution.");
	}
}

class Thread2 extends Thread{
	public void run() {
		try {
			
			for(int i=10;i<=15;i++) {
				System.out.println("Thread 2:"+ i);
				System.out.println("Thread 2 asleep for 2 seconds");
				Thread.sleep(2000);
			}
		}catch(InterruptedException e) {
			System.out.println("Thread 2 asleep");
		}
		System.out.println("Thread 2 finished execution.");
	}
}

public class ThreadCycle {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread t2 = new Thread2();
		System.out.println("Starting Threads:");
		t1.start();
		t2.start();
	}

}
