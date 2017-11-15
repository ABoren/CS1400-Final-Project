import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MainCharacter implements Moveable {
	// Attributes
	private double x, y;

	// Constructors
	public MainCharacter(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// Setters and getters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// Methods
	public void draw(GraphicsContext gc, double w, Color c) {
		gc.setStroke(c);
		gc.setLineWidth(w);
		gc.strokeLine(x, y, x, y);
	}
}
