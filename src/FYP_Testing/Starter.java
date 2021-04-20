package FYP_Testing;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Starter extends JFrame {
	JScrollPane simScroll;
	public static final double ZOOM_MIN = 0.001;
	public static final double ZOOM_MAX = 10;
	private javax.swing.JSpinner zoomSelector;
	static double data;
	App p=new App();
	static JTextArea text;
	JScrollPane textScroll;

	public Starter() {
		text=new JTextArea("",2,1);
		text.setLineWrap(true);
		textScroll=new JScrollPane(text);
		textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.zoomSelector = new JSpinner(new SpinnerNumberModel(1.0, ZOOM_MIN, ZOOM_MAX, 0.001));
		this.zoomSelector.setVisible(true);
		this.zoomSelector.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				App.scale = (double) zoomSelector.getValue();
				data = (double) zoomSelector.getValue();
			}
		});

		p.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int delta = e.getWheelRotation();
				SpinnerNumberModel model = (SpinnerNumberModel) zoomSelector.getModel();
				double curZoom = model.getNumber().doubleValue();
				Number newValue = new Double(curZoom + model.getStepSize().doubleValue() * delta * curZoom * 100);

				if (newValue.doubleValue() < ZOOM_MIN) {
					newValue = ZOOM_MIN;
				} else if (newValue.doubleValue() > ZOOM_MAX) {
					newValue = ZOOM_MAX;
				}

				model.setValue(newValue);
			}
		});
		
		simScroll = new JScrollPane(p);
		simScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		simScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//simScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

		//simScroll.getViewport();
		simScroll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				java.awt.Point p = e.getPoint();
				centerViewAt(new Coord(p.x, p.y));
			}
		});

		
		this.add(textScroll,BorderLayout.SOUTH);
		this.add(zoomSelector, BorderLayout.NORTH);
		this.add(simScroll, BorderLayout.CENTER);
		this.setSize(900, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void centerViewAt(Coord loc) {
		int midX, midY;

		midX = (int) loc.getX() - simScroll.getViewport().getWidth() / 2;
		midY = (int) loc.getY() - simScroll.getViewport().getHeight() / 2;

		simScroll.getHorizontalScrollBar().setValue(midX);
		simScroll.getVerticalScrollBar().setValue(midY);
	}

	public static void main(String[] args) {
		new Starter();
	}
}
