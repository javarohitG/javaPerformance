package demo;


import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws InterruptedException 
	{
		Runtime runtime = Runtime.getRuntime();

		long availableBytes = runtime.freeMemory();
		System.out.println("Available memory at start: " + availableBytes / 1024 + "k");

		
		List<Customer> customers = new ArrayList<Customer>();
		
		for (int i=0; i<500; i++)
		{
			customers.add(new Customer("customer "+i));
		}
		
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  when customers created: " + availableBytes / 1024 + "k");
		
	
		customers = new ArrayList<>();
		
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  when customers no longer referenced: " + availableBytes / 1024 + "k");
		
		Thread.sleep(1000);

		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  1 second later: " + availableBytes / 1024 + "k");

		System.gc();
		Thread.sleep(1000);
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  after GC command: " + availableBytes / 1024 + "k");
	
		
	}

	
}
