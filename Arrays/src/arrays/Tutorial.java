package arrays;

//import javafx.*;

public class Tutorial extends Thread{
	
	public void run() {
		System.out.println("task");
		System.out.println(Thread.currentThread().isDaemon());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		System.out.println("hiiii");
		Tutorial x = new Tutorial();
		x.setDaemon(true);
		x.start();
		
	}

}
