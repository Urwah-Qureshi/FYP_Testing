package FYP_Testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Random;

public class RSU extends Thread {
	InputReader input;
	String[] alphabets = IdentityData.Alphabets;
	String regId;
	Color colour;
	Coord location;

	List<Coord> rsuPoints;
	int i = 0;
	Random r;

	public RSU() {
		input = new InputReader("ntry.wkt", "rsus.wkt");
		Random r = new Random();

		rsuPoints = input.getRSUPoints();
		this.location = rsuPoints.get(r.nextInt(rsuPoints.size()));
		this.regId = "RSU_" + alphabets[r.nextInt(alphabets.length)] + r.nextInt(100);
	}

	public Coord getLocation() {
		return location;
	}

	public String getRegId() {
		return regId;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.red);
		g2.drawString(regId, App.scale(location.getX()), App.scale(location.getY()));
		g2.fillOval(App.scale(location.getX()), App.scale(location.getY()), 20, 20);
	}

	public void sendMessage(String msg, RSU from, Car to) {
		//Starter.text.append(from.getRegId() + "  has sent message: "+msg +" to " + to.getRegId());
		System.out.println(from.getRegId() + "  has sent message: "+msg +" to " + to.getRegId());
		//System.out.println(from.getRegId() + "  has sent message: "+msg +" to " + to.getRegId());
		//System.out.println("      " + msg);

	}

	public void receiveMessage(String msg, Car from) {
		//Starter.text.append(this.getRegId() + " has received message: "+msg+" from " + from.getRegId());
		System.out.println(this.getRegId() + " has received message: "+msg+" from " + from.getRegId());
		//System.out.println(this.getRegId() + " has received message: "+msg+" from " + from.getRegId());
		//System.out.println(" " + msg);

	}

}
