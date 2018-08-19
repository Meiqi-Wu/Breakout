package breakout;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.OverlayLayout;

public class test extends JFrame implements BreakOutConstants{
	public test() {
		this.setTitle("CS106a BreakOut");
		this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
//		this.setLayout(new OverlayLayout(this.getContentPane()));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void run() {
		GRect rect = new GRect(100, 200, 100, 100);
		rect.setBounds(0, 0, 700, 700);
		GOval oval = new GOval(200, 200, 50, 50);
		oval.setBounds(0, 0, 700, 700);
		this.getContentPane().add(rect);
		this.getContentPane().add(oval);
		this.revalidate();
		
	}
	
	
	public static void main(String[] args) {
		test program = new test();
		program.run();
	}
	
	private Component getElementAt(double x, double y) {		
//		return (JComponent)this.getContentPane().getComponentAt((int)x, (int)y);
		return this.getContentPane().getComponentAt((int)x, (int)y);
	}
}
