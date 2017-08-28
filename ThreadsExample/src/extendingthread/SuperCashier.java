package extendingthread;

public class SuperCashier extends Thread {

	private String cashierName;
	private Client client;
	private long startTime;

	public SuperCashier(String cashierName, Client client, long startTime) {
		this.cashierName = cashierName;
		this.client = client;
		this.startTime = startTime;
	}

	public String getCashierName() {
		return cashierName;
	}
	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public void run() {
		
		System.out.println(this.cashierName +" STARTS to process " + client.getName() + ""
				+ "'s shopping cart with the time of: " + (System.currentTimeMillis() - this.startTime) / 1000
				+ " seconds");
		
		for(int i = 0; i < client.getShoppingCart().length; i++) {
			processingProduct(client.getShoppingCart()[i]);
			System.out.println(" · Product " + (i+1) + " processed with the time of " 
				+ (System.currentTimeMillis() - this.startTime) / 1000 + " seconds");
		}
		
		System.out.println(this.cashierName +" FINISHED to process " + client.getName() + ""
				+ "'s shopping cart with the time of: " + (System.currentTimeMillis() - this.startTime) / 1000
				+ " seconds\n");
	}
	
	private void processingProduct(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}
}
