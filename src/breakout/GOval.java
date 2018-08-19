package breakout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class GOval extends JComponent{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private boolean isFilled;
	private int lineWidth;
	
	public GOval(double x, double y, double w, double h) {
		this.x = (int)x;
		this.y = (int)y;
		this.width = (int)w;
		this.height = (int)h;
		this.color = Color.BLACK;
		this.isFilled = true;
		this.lineWidth = 3;
//		this.setSize(this.width,this.height);
//		this.setSize(300,300);
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setFilled(boolean bool) {
		this.isFilled = bool;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(this.lineWidth)); 
//		g2.translate(this.x, this.y);
//		if(this.isFilled) {
//			g2.fillOval(0, 0, this.width, this.height);
//		} else {
//			g2.drawOval(0, 0, this.width, this.height);
//		}
		if(this.isFilled) {
			g2.fillOval(this.x, this.y, this.width, this.height);
		} else {
			g2.drawOval(this.x, this.y, this.width, this.height);
		}
	}
	
	public void moveBy(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public void movePolar(int dist, double angle) {
		double angleRadius = angle / 180.0 * Math.PI;
		double dx = dist * Math.cos(angleRadius);
		double dy = dist * Math.sin(angleRadius);
		this.x += dx;
		this.y += dy;
	}
	
	public void setLineWidth(int linewidth) {
		this.lineWidth = linewidth;
	}
	
	public int getOvalX() {
		return this.x;
	}
	
	public int getOvalY() {
		return this.y;
	}
	
}
