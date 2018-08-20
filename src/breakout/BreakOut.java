package breakout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.OverlayLayout;

public class BreakOut extends JFrame implements BreakOutConstants, MouseMotionListener{
	private ArrayList<GRect> bricks;
	private GOval ball;
	private GRect paddle;
	private double dx;
	private double dy;
	
	public static void main(String[] args) {
		BreakOut program = new BreakOut();
		program.run();
	}
	
	public void run() {
		this.addMouseMotionListener(this);
		while(true) {
			heartBeat();
		}
//		println(" "+paddle.getRectY());
	}
	
	public BreakOut() {
		this.setTitle("CS106a BreakOut");
		this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		this.setLayout(new OverlayLayout(this.getContentPane()));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.bricks = new ArrayList<GRect>();
		buildBricks();
		this.ball = new GOval(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, BALL_RADIUS, BALL_RADIUS);
		this.add(ball);
		this.dx = VELOCITY_X;
		this.dy = VELOCITY_Y;
		this.paddle = new GRect(CANVAS_WIDTH/2, CANVAS_HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.add(paddle);
		this.revalidate();
//		println("x: "+ paddle.getRectX());
	}
	
	private void buildBricks() {
		double rectX = BRICK_SEP;
		double rectY = BRICK_Y_OFFSET;  
		for(int i=0; i< NBRICK_COLUMNS; i++) {			
			for(int j=0; j<NBRICK_ROWS; j++) {		
				GRect brick = new GRect(rectX, rectY, BRICK_WIDTH, BRICK_HEIGHT);
				if(i<2) { brick.setColor(Color.RED); } 
				else if(i<4) { brick.setColor(Color.ORANGE); } 
				else if(i<6) { brick.setColor(Color.YELLOW); }
				else if(i<8) { brick.setColor(Color.GREEN); }
				else if(i<NBRICK_COLUMNS) { brick.setColor(Color.CYAN); }
				this.add(brick);
				this.revalidate();
				this.repaint();
				this.bricks.add(brick);
				rectX += BRICK_SEP + BRICK_WIDTH;
			}
			rectY += BRICK_SEP + BRICK_HEIGHT;
			rectX = BRICK_SEP;
		}
	}
	
	private void heartBeat() {
		this.ball.moveBy(dx, dy);
		double ballX = this.ball.getOvalX();
		double ballY = this.ball.getOvalY();
//		println("dx = "+dx);
//		println("ballX = "+ballX +", ballY: "+ballY);
//		println("ballY: "+ballY);
//		Component comp1 = this.getElementAt(ballX, ballY);
//		GRect comp1 = this.getElementAt(ballX, ballY);
////		if(comp1 != null && !comp1.equals(this.paddle)) {
////		this.getContentPane().remove(comp1);
////		this.bricks.remove(comp1);
////		this.dy *= -1;
////	}
//		if(comp1 != null) {
//			if(!comp1.equals(this.paddle)){
//				this.getContentPane().remove(comp1);
//				this.bricks.remove(comp1);
//			}
//			this.dy *= -1;
//		}
//		
////		Component comp2 = this.getElementAt(ballX+2*BALL_RADIUS, ballY);
//		GRect comp2 = this.getElementAt(ballX+2*BALL_RADIUS, ballY);
////		if(comp2 != null && !comp2.equals(this.paddle)) {
////			this.getContentPane().remove(comp2);
////			this.bricks.remove(comp2);
////			this.dy *= -1;
////		}
//		if(comp2 != null) {
//			if(!comp2.equals(this.paddle)){
//				this.getContentPane().remove(comp2);
//				this.bricks.remove(comp2);
//			}
//			this.dy *= -1;
//		}
//		
////		Component comp3 = this.getElementAt(ballX, ballY+2*BALL_RADIUS);
//		GRect comp3 = this.getElementAt(ballX, ballY+2*BALL_RADIUS);
//		if(comp3 != null) {
//			if(!comp3.equals(this.paddle)){
//				this.getContentPane().remove(comp3);
//				this.bricks.remove(comp3);
//			}
//			this.dy *= -1;
//		}
//		Component comp4 = this.getElementAt(ballX+2*BALL_RADIUS, ballY+2*BALL_RADIUS);
//		GRect comp4 = this.getElementAt(ballX+2*BALL_RADIUS, ballY+2*BALL_RADIUS);
//		if(comp4 != null) {
//			if(!comp4.equals(this.paddle)){
//				this.getContentPane().remove(comp4);
//				this.bricks.remove(comp4);
//			}
//			this.dy *= -1;
//		}
		
		
		GRect comp1 = this.getElementAt(ballX, ballY);
		if(comp1 != null) {
			if(!comp1.equals(this.paddle)) {
				this.getContentPane().remove(comp1);
				this.bricks.remove(comp1);
			}
			this.dy *= -1;
		}else {
			GRect comp2 = this.getElementAt(ballX + 2*BALL_RADIUS, ballY);
			if(comp2 != null ) {
				if(!comp2.equals(this.paddle)) {
					this.getContentPane().remove(comp2);
					this.bricks.remove(comp2);
				}
				this.dy *= -1;
				
			}else{
				GRect comp3 = this.getElementAt(ballX, ballY+ 2*BALL_RADIUS);
				if(comp3 != null) {
					if(!comp3.equals(this.paddle)){
						this.getContentPane().remove(comp3);
						this.bricks.remove(comp3);
					}
					this.dy *= -1;
				}else {		
					GRect comp4 = this.getElementAt(ballX+2*BALL_RADIUS, ballY+2*BALL_RADIUS);
					if(comp4 != null) {
						if(!comp4.equals(this.paddle)){
							this.getContentPane().remove(comp4);
							this.bricks.remove(comp4);
						}
						this.dy *= -1;
					}
				}
			}
		}

		if(this.ball.getOvalX() < 0) { this.dx *= -1; }
		if(this.ball.getOvalX() > CANVAS_WIDTH - 2 * BALL_RADIUS) { this.dx *= -1; }
		if(this.ball.getOvalY() < 0) { this.dy *= -1; }
		if(this.ball.getOvalY() > CANVAS_HEIGHT - 2 * BALL_RADIUS) { 
//			this.dy *= -1;
			this.dispose();
			System.exit(0);
//			this.getContentPane().removeAll();
//			GLabel label = new GLabel("Game Over ! ");
//			label.setFont(new Font("Times-24", Font.PLAIN, 20));
//			label.setLocation(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
//			label.setSize(100, 100);
//			this.getContentPane().add(label);
//			this.revalidate();
		}
		
		try {
			Thread.sleep(16);
		} catch(InterruptedException ie) {
			throw new RuntimeException();
		}
		this.revalidate();
		this.repaint();	
	}
	
	private void println(String x) {
		System.out.println(x);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		double mouseX = e.getX();

		if(this.paddle.getCenterX() < mouseX) {
			if(this.paddle.getRectX()+PADDLE_VELOCITY <= CANVAS_WIDTH-BRICK_WIDTH) {
				this.paddle.moveBy(PADDLE_VELOCITY, 0);
			}
		} else {
			if(this.paddle.getRectX()-PADDLE_VELOCITY >= 0) {
				this.paddle.moveBy(-PADDLE_VELOCITY,  0);
			}
		}		
//		println("X: "+this.paddle.getRectX());
		try {
			Thread.sleep(16);
		} catch(InterruptedException ie) {
			throw new RuntimeException();
		}
		this.revalidate();
		this.repaint();	
		
	}
	
//	private Component getElementAt(double x, double y) {		
////		return (JComponent)this.getContentPane().getComponentAt((int)x, (int)y);
//		return this.getContentPane().getComponentAt((int)x, (int)y);
//	}
	
	private GRect getElementAt(double x, double y) {
		GRect rect = new GRect();
		if(x>paddle.getRectX() && x<paddle.getRectX()+PADDLE_WIDTH && y>paddle.getRectY() && y<paddle.getRectY()+PADDLE_HEIGHT) {
			return this.paddle;
		}
		for(int i=0; i< this.bricks.size(); i++) {
			rect = bricks.get(i);
			if(x>rect.getRectX() && x<rect.getRectX()+BRICK_WIDTH && y>rect.getRectY() && y<rect.getRectY()+BRICK_HEIGHT) {
				return rect;
			}
		}
		return null;
	}

}
