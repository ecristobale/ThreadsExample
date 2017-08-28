package extendingthread;

public class Main {

	public static void main(String[] args) {

		Client client1 = new Client("Client1", new int[]{3,5,6,1});
		Client client2 = new Client("Client2", new int[]{2,1,3,4});
		
		long startTime = System.currentTimeMillis();

		SuperCashier superCashier1 = new SuperCashier("SuperCashier1", client1, startTime);
		SuperCashier superCashier2 = new SuperCashier("SuperCashier2", client2, startTime);

		superCashier1.start();
		superCashier2.start();
		
	}

}
