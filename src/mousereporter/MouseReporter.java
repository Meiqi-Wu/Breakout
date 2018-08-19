package mousereporter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseReporter extends JFrame implements MouseMotionListener{
	private GLabel label;
//	private JLabel label;
	private final int SCREEN_WIDTH = 400;
	private final int SCREEN_HEIGHT = 500;
	private final int LABEL_X = 40;
	private final int LABEL_Y = 200;
	private final int LABEL_WIDTH = 53;
	private final int LABEL_HEIGHT = 16;
	
	
	public MouseReporter() {
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.label = new GLabel(0+", "+0);
		label.setLocation(LABEL_X, LABEL_Y);
//		label.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
//		this.label = new JLabel(0+", "+0);

		this.add(label);
		this.setVisible(true);
	}
	
	public void run() {
		this.addMouseMotionListener(this);
	}
	
	public static void main(String[] args) {
		MouseReporter program = new MouseReporter();
		program.run();
	}
	
//	private double getMouseX() {
//		double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
//		return mouseX;
//	}
//	private double getMouseY() {
//		double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
//		return mouseY;
//	}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.label.setColor(Color.BLACK);
		int x = e.getX();
		int y = e.getY();
		this.label.setText(x+", "+y);
		
		if(x>LABEL_X-LABEL_WIDTH/2 && x<LABEL_X+LABEL_WIDTH/2 && y>LABEL_Y-LABEL_HEIGHT/2 && y<LABEL_Y+LABEL_HEIGHT/2) {
			this.label.setColor(Color.RED);
		}
		this.repaint();
	}
	
}
