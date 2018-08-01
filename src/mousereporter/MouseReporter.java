package mousereporter;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseReporter extends JFrame implements MouseMotionListener{
	
	


//	private double getMouseX() {
//		double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
//		return mouseX;
//	}
//	private double getMouseY() {
//		double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
//		return mouseY;
//	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		
	}
	
}
