package breakout;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GRect extends JComponent{
	private int x;
	private int y;
	private int w;
	private int h;
	private Color color;
	private boolean isFilled;
	
	public GRect(double x, double y, double w, double h) {
		this.x = (int)x;
		this.y = (int)y;
		this.w = (int)w; 
		this.h = (int)h;
		this.color = Color.BLACK;
		this.setSize(this.w, this.h);
		this.isFilled = true;
	}
	
	public GRect() {
		this.color = Color.BLACK;
		this.setSize(this.w, this.h);
		this.isFilled = true;
	}
	
	public void setFill(boolean bool) {
		this.isFilled = bool;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public int getRectX() {
		return this.x;
	}
	
	public int getRectY() {
		return this.y;
	}
	
	public int getCenterX() {
		return this.x + this.w/2;
	}
	
	public int getCenterY() {
		return this.y + this.h/2; 
	}
	
	public void moveBy(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		if(this.isFilled) {
			g.fillRect(x, y, w, h);
		} else {
			g.drawRect(x, y, w, h);
		}
	}
}
