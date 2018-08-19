package mousereporter;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class test {
	public static void main(String[] args) {
		JFrame frame = new JFrame("test frame");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GLabel label = new GLabel("test label hahahahahhahaha");
		label.setLocation(150, 150);
//		label.setPreferredSize(new Dimension(150, 150));
//		label.setSize(10, 10); // setSize doesn't work for drawString
		frame.getContentPane().add(label);
		frame.revalidate();
		frame.repaint();
		
//		JLabel label = new JLabel("test label hahahahahhahahah");
//		frame.getContentPane().add(label);
////		label.setSize(150, 150);
//		label.setPreferredSize(new Dimension(150, 150));
//		label.setLocation(150, 150);
//		frame.revalidate();
//		frame.repaint();
		
		
//		System.out.println("width: "+label.getW());
//		System.out.println("height: "+label.getH());
	}
}
