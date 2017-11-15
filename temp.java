import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class temp extends Application{
	

	private int x = 0, y = 0, w = 15;
	private Color c = Color.BLACK;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Game Title");

		// For setting canvas
		Group root = new Group();
		BorderPane pane = new BorderPane();
		Canvas canvas = new Canvas(1200, 800);
		pane.setTop(canvas);

		// For Spawning initial character position
		spawn();
		draw(canvas, getW(), getX(), getY(), getC());

		// For character movement
		canvas.setOnMouseMoved(e -> {
			moveDown(canvas, getW(), getX(), getY(), getC());
			moveRight(canvas, getW(), getX(), getY(), getC());
			});

		root.getChildren().add(pane);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	// Methods
	public void draw(Canvas canvas, int w, int x, int y, Color c) {
		MainCharacter mc = new MainCharacter(x, y);
		mc.draw(canvas.getGraphicsContext2D(), w, c);

	}

	public void spawn() {
		setX(600);
		setY(400);
	}

	public void moveRight(Canvas canvas, int w, int x, int y, Color c) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		setX(x + 1);
		MainCharacter mc = new MainCharacter(x, y);
		mc.draw(canvas.getGraphicsContext2D(), w, c);

	}

	public void moveLeft(Canvas canvas, int w, int x, int y, Color c) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		setX(x - 1);
		MainCharacter mc = new MainCharacter(x, y);
		mc.draw(canvas.getGraphicsContext2D(), w, c);

	}

	public void moveUp(Canvas canvas, int w, int x, int y, Color c) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		setY(y - 1);
		MainCharacter mc = new MainCharacter(x, y);
		mc.draw(canvas.getGraphicsContext2D(), w, c);

	}

	public void moveDown(Canvas canvas, int w, int x, int y, Color c) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		setY(y + 1);
		MainCharacter mc = new MainCharacter(x, y);
		mc.draw(canvas.getGraphicsContext2D(), w, c);

	}

}


