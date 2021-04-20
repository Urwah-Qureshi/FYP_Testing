package FYP_Testing;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class InputReader {
	private FileReader file = null;
	private BufferedReader br = null;
	private String str = null;

	private FileReader file1 = null;
	private BufferedReader br1 = null;
	private String str1 = null;

	//private List<Coord> stringLines;
	private List<Coord> rsus;
	List<List<Coord>> lines = new ArrayList<List<Coord>>();

	public InputReader(String path, String rsuPoints) {
		try {
			//stringLines = new ArrayList<>();
			rsus = new ArrayList<>();
			file = new FileReader(path);
			br = new BufferedReader(file);
			file1 = new FileReader(rsuPoints);
			br1 = new BufferedReader(file1);

			setCoordinates();
			setRSUPoints();
		} catch (FileNotFoundException e) {
		}
	}

	private void setCoordinates() {
		try {
			str = br.readLine();
			while (str != null) {
				str = str.replaceAll("\\(", "");
				str = str.replaceAll("\\)", "");
				str = str.replaceAll("LINESTRING", "");

				StringTokenizer s = new StringTokenizer(str);
				List<Coord> coords = new ArrayList<Coord>();
				while (s.hasMoreTokens()) {

					String token = s.nextToken(",");
					token = token.trim();
					String[] split = token.split(" ");
					//stringLines.add(new Coord(Double.parseDouble(split[0]), Double.parseDouble(split[1])));
					coords.add(new Coord(Double.parseDouble(split[0]), Double.parseDouble(split[1])));
				}
				if(coords.size()!=0) 
					lines.add(coords);
				str = br.readLine();
			}
		}

		catch (IOException e1) {
		}

	}

	private void setRSUPoints() {
		try {
			str1 = br1.readLine();
			while (str1 != null) {
				str1 = str1.replaceAll("\\(", "");
				str1 = str1.replaceAll("\\)", "");
				str1 = str1.replaceAll("POINT", "");
				StringTokenizer st = new StringTokenizer(str1);
				while (st.hasMoreTokens()) {
					String token1 = st.nextToken(",");
					token1 = token1.trim();
					String sp[] = token1.split(" ");
					Double x = Double.parseDouble(sp[0]);
					Double y = Double.parseDouble(sp[1]);
					rsus.add(new Coord(x, y));
				}
				str1 = br1.readLine();
			}
		} catch (IOException e1) {
		}
	}

	public List<Coord> getRSUPoints() {
		return rsus;
	}

	public List<List<Coord>> getCoordinates() {
		return this.lines;
	}

	/*
	 * public static void main(String[] args) { InputReader in = new
	 * InputReader("ntry.wkt", "rsus.wkt"); System.out.println(in.getCoordinates());
	 * System.out.println(in.getRsusPoints()); }
	 */

}
