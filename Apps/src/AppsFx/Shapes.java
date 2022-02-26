package AppsFx;

import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.animation.*;
import javafx.util.Duration;
import java.util.Random;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.animation.*;
import javafx.util.Duration;


public class Shapes {
	final int rscore = 5;
	final int cscore = 10;
	private int total;
	Color[] color = new Color[] { Color.RED, Color.BLUE, Color.ORANGE, Color.AQUA, Color.CHOCOLATE, Color.CHARTREUSE,
			Color.CORAL, Color.IVORY, Color.AZURE, Color.FUCHSIA, Color.PINK, Color.PURPLE, Color.KHAKI, Color.BLACK,
			Color.MAGENTA };
	Random rng = new Random();
	private Pane root = new Pane();

	public int getrscore() {
		return rscore;

	}

	public int getcscore() {
		return cscore;

	}

	public Circle c(int xx, int yy) {// to create moving circles
		Circle c = new Circle(xx, yy, 30);
		c.setFill(color[rng.nextInt(color.length)]);
		c.setStroke(Color.BLACK);
		TranslateTransition tt2 = new TranslateTransition();
		tt2.setToX(rng.nextInt(250) + 1);
		tt2.setToY(rng.nextInt(250) + 1);
		tt2.setAutoReverse(true);
		tt2.setDuration(Duration.seconds(rng.nextInt(3) + 1));
		tt2.setAutoReverse(true);
		tt2.setCycleCount(Animation.INDEFINITE);
		tt2.setNode(c);
		tt2.play();
		root.getChildren().add(c);
		c.setOnMouseClicked(k -> {
			total += cscore;
			root.getChildren().remove(c);

		});
		return c;

	}

	public Rectangle r(int x, int y) {// to create moving rectangles
		Rectangle r = new Rectangle(x, y, 50, 50);
		r.setFill(color[rng.nextInt(color.length)]);
		r.setStroke(Color.BLACK);
		TranslateTransition tt = new TranslateTransition();
		tt.setToX(rng.nextInt(250) + 1);
		tt.setToY(rng.nextInt(250) + 1);
		tt.setAutoReverse(true);
		tt.setDuration(Duration.seconds(rng.nextInt(3) + 1));
		tt.setAutoReverse(true);
		tt.setCycleCount(Animation.INDEFINITE);
		tt.setNode(r);
		tt.play();
		root.getChildren().add(r);
		r.setOnMouseClicked(k -> {
			total += rscore;
			root.getChildren().remove(r);

		});
		return r;

	}

	public int getTotal() {
		return total;
	}

	public Pane getP() {
		return root;
	}

	public void clearP() {
		root.getChildren().clear();
	}

}

