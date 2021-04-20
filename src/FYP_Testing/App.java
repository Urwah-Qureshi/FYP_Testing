package FYP_Testing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class App extends JPanel implements ActionListener {
	static Map map = new Map();
	Random randomNum;
	List<Car> cars;
	Timer timer;
	Timer timer2;
	static double scale = 1;
	CarsList carList;
	static List<RSU> rsus;
	ArrayList<Car> msgReceivers;
	RSU rsuMsg;
	Message rmessage;
	RSU msgtoRSU;
	JScrollPane simScroll;
	public static final double ZOOM_MIN = 0.001;
	public static final double ZOOM_MAX = 10;
	JTextArea text;

	public App() {
		randomNum = new Random();
//		carList = new CarsList();
//		cars = carList.getCars();
//
//		rsus = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			RSU roadSU = new RSU();
//			rsus.add(roadSU);
//		}

		timer = new Timer(100, this);
		timer2 = new Timer(randomNum.nextInt(100) * 100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// carList.addcars();
			}
		});
		timer.start();
		timer2.start();

		this.setPreferredSize(new Dimension(5900, 5800));
//		JFrame Pframe = new JFrame("FYP Simulation");
//		Pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Pframe.setSize(900, 800);
//		Pframe.add(simScroll);
//		Pframe.setVisible(true);
	}

	public static int scale(double value) {
		return (int) Math.round(scale * value);
	}

	public static Map getMap() {
		return map;
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		map.paint(g);

		//for (RSU roadsu : rsus) {
			//roadsu.paint(g2);
		//}

//		for (int i = 0; i < cars.size(); i++) {
//			if (CarsList.cars.size() > 1) {
//				AdhocAP a = new AdhocAP(cars.get(i));
//				a.start();
//			}
//			cars.get(i).paint(g2);
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	/*
	 * public static void main(String[] args) { new App(); }
	 */

	/*
	 * private class PlayfieldMouseHandler extends MouseAdapter implements
	 * MouseWheelListener {
	 *//**
		 * If mouse button is clicked, centers view at that location.
		 */
	/*
	 * public void mouseClicked(MouseEvent e) {
	 * 
	 * java.awt.Point p = e.getPoint(); centerViewAt(new Coord(p.x, p.y)); }
	 * 
	 * public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) { int delta =
	 * e.getWheelRotation(); SpinnerNumberModel model = (SpinnerNumberModel)
	 * zoomSelector.getModel(); double curZoom = model.getNumber().doubleValue();
	 * Number newValue = new Double(curZoom + model.getStepSize().doubleValue() *
	 * delta * curZoom * 100);
	 * 
	 * if (newValue.doubleValue() < ZOOM_MIN) { newValue = ZOOM_MIN; } else if
	 * (newValue.doubleValue() > ZOOM_MAX) { newValue = ZOOM_MAX; }
	 * 
	 * model.setValue(newValue); } }
	 */}
