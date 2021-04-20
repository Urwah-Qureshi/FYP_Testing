package FYP_Testing;

import java.util.ArrayList;
import java.util.List;

public class Path {
	private Map map;
	private List<Coord> inputCoordinates;
	private List<Coord> path;

	Coord start, end;

	public Path() {
		map = new Map();
		inputCoordinates = map.getMapNodes();
		path = new ArrayList<>();
		int s, e;
		s = (int) (Math.random() * (inputCoordinates.size()));
		e = (int) (Math.random() * (inputCoordinates.size()));
		if (s > e) {
			int temp;
			temp = s;
			s = e;
			e = temp;
		}
		setPath(s, e);
	}

	public void setPath(int s, int e) {
		int i = 0;
		while (i <= e) {
			if (i == s) {
				path.add(inputCoordinates.get(i));
			}
			if (i > s) {
				path.add(inputCoordinates.get(i));
			}
			if (i == e) {
				path.add(inputCoordinates.get(i));
				break;
			}
			i++;
		}
	}

	public List<Coord> getPath() {
		return this.path;
	}

}
