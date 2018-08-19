package breakout;

public class Ball implements BreakOutConstants{
	private GOval circle;
//	private double dx;
//	private double dy;
	
	public Ball(double x, double y, double w, double h) {
		this.circle = new GOval(x, y, w, h);
	}
	
//	public void reflectOfWalls() {
//		if(this.circle.getY() < 0) {
//			this.dy *= -1;
//		}
//		if(this.circle.getY() > CANVAS_HEIGHT - BALL_RADIUS) {
//			this.dy *= -1;
//		}
//		if(this.circle.getX() < 0) {
//			this.dx *= -1;
//		}
//		if(this.circle.getX() > CANVAS_WIDTH - BALL_RADIUS) {
//			this.dx *= -1;
//		}
//	}

}
