package FYP_Testing;

import java.util.List;

public class AdhocAP extends Thread {
	List<Car> recCars;
	Car from;
	static int obj=0;
	public AdhocAP(Car from) {
		this.from=from;
		obj++;
	}
	public void run() {
		Message message=new Message();
		recCars=message.connectCars(from, CarsList.cars);
		for(Car c:recCars) {
			//System.out.println("Objects Created "+obj);
			//System.out.println(from.getRegId());
			message.v2VsMessage(from, c);
			//System.out.println("Receivers "+recCars.size());
			//System.out.println("CarsList "+CarsList.cars.size());
		}
	}
}
