package mousereporter;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

import javax.swing.JComponent;

public class GLabel extends JComponent{
	private int x;
	private int y;
	private int width;
	private int height;
	private double theta;
	private String text;
	private boolean isCentered;
	
	public GLabel(String str) {
		this.text = new String(str); 
		this.x = 0;
		this.y = 0;
		this.theta = 0;
		this.isCentered = true;
//		this.setSize(50, 20);
		this.setPreferredSize(new Dimension(100, 200));
	}
	
	public void setText(String str) {
		this.text = new String(str);
	}
	
	public void rotate(double theta) {
		this.theta = theta; 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("Start drawing the Label ...");
		
		Graphics2D g2d = (Graphics2D) g;
		if(isCentered) {
			FontRenderContext frc = g2d.getFontRenderContext();
			Font font = g2d.getFont().deriveFont(14f);
			g2d.setFont(font);
			float sw = (float)font.getStringBounds(text, frc).getWidth();
			LineMetrics lm = font.getLineMetrics(text, frc);
			float sh = lm.getAscent() + lm.getDescent();
			this.width = (int)sw;
			this.height = (int)sh;
			System.out.println("width: "+sw);
			System.out.println("height: "+sh);
			g2d.translate(this.x-sw/2, this.y+sh/2);
		} else {		
			g2d.translate(this.x, this.y);
		}
		g2d.rotate(this.theta);
		g2d.drawString(this.text, 0, 0);
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setFont(String fontname) {
		super.setFont(new Font(fontname, Font.PLAIN, 14));
	}
	
	/*
	 * Make x, y the center of the label.
	 */
	public void setCentered(boolean bool) {
		this.isCentered = bool;
	}
	
	@Override
	public int getWidth() {
		return this.width;
	}
	
	@Override
	public int getHeight() {
		return this.height;
	}
}


//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.font.FontRenderContext;
//import java.awt.font.LineMetrics;
//
//import javax.swing.JComponent;
//
//public class GLabel extends JComponent{
//	private int x;
//	private int y;
//	private int width;
//	private int height;
//	private double theta;
//	private String text;
//	private boolean isCentered;
//	
//	public GLabel(String str) {
//		this.text = new String(str); 
//		this.x = 0;
//		this.y = 0;
//		this.theta = 0;
//		this.isCentered = true;
////		this.setSize(50, 10);
//	}
//	
//	public void setText(String str) {
//		this.text = new String(str);
//	}
//	
//	public void rotate(double theta) {
//		this.theta = theta; 
//	}
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		System.out.println("Start drawing the Label ...");
//		
//		Graphics2D g2d = (Graphics2D) g;
//		if(isCentered) {
//			FontRenderContext frc = g2d.getFontRenderContext();
//			Font font = g2d.getFont().deriveFont(14f);
//			g2d.setFont(font);
//			float sw = (float)font.getStringBounds(text, frc).getWidth();
//			LineMetrics lm = font.getLineMetrics(text, frc);
//			float sh = lm.getAscent() + lm.getDescent();
//			this.width = (int)sw;
//			this.height = (int)sh;
//	//		System.out.println("width: "+sw);
//	//		System.out.println("height: "+sh);
//			g2d.translate(this.x-sw/2, this.y+sh/2);
//		} else {		
//			g2d.translate(this.x, this.y);
//		}
//		g2d.rotate(this.theta);
//		g2d.drawString(this.text, 0, 0);
//	}
//
//	public void setLocation(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	public void setFont(String fontname) {
//		super.setFont(new Font(fontname, Font.PLAIN, 14));
//	}
//	
//	/*
//	 * Make x, y the center of the label.
//	 */
//	public void setCentered(boolean bool) {
//		this.isCentered = bool;
//	}
//}


