package FYP_Testing;

public class Coord implements Cloneable, Comparable<Coord> {
	private double x;
	private double y;

	public Coord(double x, double y) {
		setLocation(x, y);
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setLocation(Coord c) {
		this.x = c.x;
		this.y = c.y;
	}

	public void translate(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	public static double distance(Coord from, Coord other) {
		double dx = other.x - from.x;
		double dy = other.y - from.y;

		return App.scale(Math.sqrt(dx * dx + dy * dy));
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public String toString() {
		return String.format("(%.2f,%.2f)", x, y);
	}

	public Coord clone() {
		Coord clone = null;
		try {
			clone = (Coord) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return clone;
	}

	public boolean equals(Coord c) {
		if (c == this) {
			return true;
		} else {
			return (x == c.x && y == c.y); // XXX: == for doubles...
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		return equals((Coord) o);
	}

	public int hashCode() {
		return (x + "," + y).hashCode();
	}

	public int compareTo(Coord other) {
		if (this.y < other.y) {
			return -1;
		} else if (this.y > other.y) {
			return 1;
		} else if (this.x < other.x) {
			return -1;
		} else if (this.x > other.x) {
			return 1;
		} else {
			return 0;
		}
	}
	/*
	 * public static void main(String[] args) { InputReader input = new
	 * InputReader("ntry.wkt","rsus.wkt"); List<Coord> list=input.getCoordinates();
	 * Coord current; Coord next;
	 * 
	 * for(int i=0;i<list.size();i++) { current=list.get(i); next=list.get(i+1);
	 * System.out.println(current.distance(current, next)); } }
	 */

}
