package FYP_Testing;

public class RSUAP extends Thread {
	Message message;
	RSU rsu;
	Car from;
	
	public RSUAP(Car from,RSU rsu) {
		message=new Message();
		this.rsu=rsu;
		this.from=from;
	}
	public void run() {
		message.Message2RSU(from, rsu);
	}
}
