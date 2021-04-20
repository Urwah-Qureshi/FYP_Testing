package FYP_Testing;

import java.util.ArrayList;
import java.util.List;

public class Message {
	Car to;
	Car from;
	String msgVariable;
	Coord cLocation;
	Coord sLocation;
	double distance;
	String carId;
	ArrayList<Car> cars;
	private static RSU v2RSU;

	private String message;
	private String fromId;
	private Double distanceCovered;
	private Coord currentLocation;
	private Coord startLocation;

	public ArrayList<Car> connectCars(Car from, List<Car> cars2) {
		ArrayList<Car> msgReceivers = new ArrayList<>();
		for (int i = 0; i < cars2.size(); i++) {
			if (from.getRegId() != cars2.get(i).getRegId()) {
				if (Coord.distance(from.getNextCoordinate(), cars2.get(i).getNextCoordinate()) <= 10)
					msgReceivers.add(cars2.get(i));
			}
		}
		return msgReceivers;

	}

	public void v2VsMessage(Car from, Car to) {
		this.from = from;
		this.fromId = from.getRegId();
		startLocation = from.getStartLocation();
		currentLocation = from.getNextCoordinate();
		this.distanceCovered = Coord.distance(startLocation, currentLocation);
		message = "Message received from " + fromId + " Current Location " + currentLocation + " Distance covered "
				+ distanceCovered;

		from.sendMessage(message, from, to);
		to.receiveMessage(message, from);
	}

	public RSU setV2RSU(Car from, List<RSU> rsus) {
		double smallest;
		Double distance;
		distance = Coord.distance(from.getNextCoordinate(), rsus.get(0).getLocation());
		smallest = distance;
		for (int i = 0; i < rsus.size(); i++) {
			distance = Coord.distance(from.getNextCoordinate(), rsus.get(i).getLocation());
			if (distance < smallest) {
				smallest = distance;
				v2RSU = rsus.get(i);
			}
		}
		return v2RSU;
	}

	public void Message2RSU(Car from, RSU to) {
		this.from = from;
		this.fromId = from.getRegId();
		this.distanceCovered = Coord.distance(from.getNextCoordinate(), to.getLocation());
		this.currentLocation = from.getNextCoordinate();
		message = "RSU " + from.getRegId() + "  " + currentLocation + "  " + distanceCovered;

		from.sendMessage(message, from, to);
		to.receiveMessage(message, from);
	}

	public String getMessage() {
		return message;
	}

}
