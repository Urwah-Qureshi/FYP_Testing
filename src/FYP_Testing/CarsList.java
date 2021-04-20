package FYP_Testing;

import java.util.ArrayList;
import java.util.List;

public class CarsList {

	static ArrayList<Car> cars;

	public CarsList() {
		cars = new ArrayList<>();
		addcars();
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void addcars() {
		int numOfCars = 50;
		for (int i = 0; i < numOfCars; i++) {
			Car c = new Car();
			cars.add(c);
			c.start();
		}
	}

}
