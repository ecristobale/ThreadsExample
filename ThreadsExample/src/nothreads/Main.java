package nothreads;

public class Main {

	public static void main(String[] args) {
		//System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());

		SuperCashier superCashier1 = new SuperCashier("SuperCashier1");
		SuperCashier superCashier2 = new SuperCashier("SuperCashier2");

		Client client1 = new Client("Client1", new int[]{3,5,6,1});
		Client client2 = new Client("Client2", new int[]{2,1,3,4});
		
		long startTime = System.currentTimeMillis();

		superCashier1.processProducts(client1, startTime);
		superCashier2.processProducts(client2, startTime);
		
	}

}
