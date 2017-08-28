package withrunnable;

public class SuperCashier {

	private String name;

	public SuperCashier(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void processProducts(Client client, long timestamp) {
		
		System.out.println(this.name +" STARTS to process " + client.getName() + ""
				+ "'s shopping cart with the time of: " + (System.currentTimeMillis() - timestamp) / 1000
				+ " seconds");
		
		for(int i = 0; i < client.getShoppingCart().length; i++) {
			processingProduct(client.getShoppingCart()[i]);
			System.out.println(" · Product " + (i+1) + " processed with the time of " 
				+ (System.currentTimeMillis() - timestamp) / 1000 + " seconds");
		}
		
		System.out.println(this.name +" FINISHED to process " + client.getName() + ""
				+ "'s shopping cart with the time of: " + (System.currentTimeMillis() - timestamp) / 1000
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
