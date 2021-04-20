package FYP_Testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Random;

public class Car extends Thread {

	private Path p;
	private List<Coord> mapNodes;
	private Coord next;
	private String[] cities = IdentityData.cities;
	private String[] alphabets = IdentityData.Alphabets;
	private Color colour;
	private String regCity;
	private boolean journeyCompleted = false;
	private String regId;
	private int speed;
	private Coord startLocation;
	private Message message;
	private Message rmessage;
	List<Car> recCars;
	RSU rsuMsg;

	public Car() {
		p = new Path();
		mapNodes = p.getPath();
		Random r = new Random();
		speed = r.nextInt(mapNodes.size());
		message = new Message();
		rmessage = new Message();
		startLocation = mapNodes.get(0);

		this.regCity = cities[r.nextInt(cities.length)];
		this.regId = alphabets[r.nextInt(alphabets.length)] + r.nextInt(1000);
		colour = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void run() {
		next=mapNodes.get(0);
		for (int i = 1; i < mapNodes.size(); i++) {
			try {
				sleep(100);
				next = mapNodes.get(i);

				if (App.rsus.size() > 1) {
					rsuMsg = rmessage.setV2RSU(this, App.rsus);
					RSUAP ap = new RSUAP(this, rsuMsg);
					ap.start();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.journeyCompleted = true;
		CarsList.cars.remove(this);
		
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		if (this.isJourneyCompleted() != true) {
			Coord next = this.getNextCoordinate();
			g2.setPaint(this.getColour());
			g2.drawString(this.getRegCity() + this.getRegId(), App.scale(next.getX()), App.scale(next.getY()));
			g2.fillRect(App.scale(next.getX()), App.scale(next.getY()), 10, 10);

		}
	}

	public Color getColour() {
		return colour;
	}

	public String getRegCity() {
		return regCity;
	}

	public String getRegId() {
		return regId;
	}

	public int getSpeed() {
		return speed;
	}

	public boolean isJourneyCompleted() {
		return journeyCompleted;
	}

	public Coord getNextCoordinate() {
		return next;
	}

	public List<Coord> getMapNodes() {
		return mapNodes;
	}

	public Coord getStartLocation() {
		return startLocation;
	}

	public void sendMessage(String msg, Car from, Car to) {
		//Starter.text.append(from.getRegId() + "  has sent message: " + msg + " to " + to.getRegId());
		System.out.println(from.getRegId() + "  has sent message: " + msg + " to " + to.getRegId());
		// System.out.println(" " + msg);

	}

	public void sendMessage(String msg, Car from, RSU to) {
		//Starter.text.append(from.getRegId() + "  has sent message: " + msg + " to " + to.getRegId());
		System.out.println(from.getRegId() + "  has sent message: " + msg + " to " + to.getRegId());
		// System.out.println(" " + );

	}

	public void receiveMessage(String msg, Car from) {
		//Starter.text.append(this.getRegId() + "  has received message: " + msg + " from " + from.getRegId());
		System.out.println(this.getRegId() + "  has received message: " + msg + " from " + from.getRegId());
		// System.out.println(msg);

	}

}