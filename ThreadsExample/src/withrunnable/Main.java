package withrunnable;

public class Main implements Runnable {
	
	private Client client;
	private SuperCashier superCashier;
	private long startUpTime;

	public Main(Client client, SuperCashier superCashier, long startUpTime) {
		this.client = client;
		this.superCashier = superCashier;
		this.startUpTime = startUpTime;
	}

	public static void main(String[] args) {

		Client client1 = new Client("Client1", new int[]{3,5,6,1});
		Client client2 = new Client("Client2", new int[]{2,1,3,4});

		SuperCashier superCashier1 = new SuperCashier("SuperCashier1");
		SuperCashier superCashier2 = new SuperCashier("SuperCashier2");
		
		long startUpTime = System.currentTimeMillis();

		Runnable process1 = new Main(client1, superCashier1, startUpTime);
		Runnable process2 = new Main(client2, superCashier2, startUpTime);

		new Thread(process1).start();
		new Thread(process2).start();
		
	}

	@Override
	public void run() {
		this.superCashier.processProducts(this.client, this.startUpTime);		
	}

}
