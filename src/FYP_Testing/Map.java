package FYP_Testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class Map {
	InputReader input;
	List<List<Coord>> mapNodes;

	public Map() {
		input = new InputReader("map.wkt", "rsus.wkt");
		mapNodes = input.getCoordinates();
	}

	public int getMapNodesSize() {
		return mapNodes.size();
	}

	public List<List<Coord>> getMapNodes() {
		return mapNodes;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.gray);
		for(List<Coord> l:mapNodes) {
		Coord prev = l.get(0);
		for (int i = 1; i < l.size(); i++) {
			Coord next = l.get(i);
			g2.drawLine(App.scale(prev.getX()), App.scale(prev.getY()), App.scale(next.getX()), App.scale(next.getY()));
			prev = next;
		}}
	}
}
