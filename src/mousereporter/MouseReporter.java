package mousereporter;

import javax.swing.JFrame;

public class MouseReporter extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame("test frame");
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GLabel label = new GLabel("test label hahahahahhahahah");
		label.setLocation(150, 150);
		frame.getContentPane().add(label);
		frame.revalidate();
		frame.repaint();
		System.out.println("width: "+label.getWidth());
		System.out.println("height: "+label.getHeight());
	}
	
}
