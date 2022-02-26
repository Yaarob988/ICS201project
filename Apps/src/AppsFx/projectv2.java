package AppsFx;

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

import java.util.Random;
import javafx.stage.Stage;

public class projectv2 extends Application {
	private int x;
	private int y;
	private int xx;
	private int yy;
	Random rng = new Random();
	int r;

	@Override
	public void start(Stage stage) throws Exception {
		Shapes sp = new Shapes();// to Access and create shapes
		FlowPane p = new FlowPane();
		p.setAlignment(Pos.CENTER);
		p.setOrientation(Orientation.VERTICAL);
		p.setVgap(10);
		Button bt = new Button("Start");
		Label l = new Label("Clicking Game Demo\n10 points for circles and 5 for rectangles");
		Scene scene = new Scene(p, 500, 300);
		l.setFont(Font.font(null, FontWeight.BOLD, 25));
		p.getChildren().addAll(l, bt);
		stage.setTitle("Project201");
		stage.setScene(scene);
		stage.show();
		bt.setOnAction(e -> {
			Scene scene2 = new Scene(sp.getP(), 720, 720);// to make the random obj
			p.getChildren().clear();
			stage.setScene(scene2);
			Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000), q -> {

				r = rng.nextInt(2);
				if (r == 0) {
					x = (int) (Math.random() * 400);
					y = (int) (Math.random() * 400);
					sp.r(x, y);// to create rectangle
					x = (int) (Math.random() * 400);
					y = (int) (Math.random() * 400);
					sp.r(x, y);
				} else {
					xx = (int) (Math.random() * 400);
					yy = (int) (Math.random() * 400);
					sp.c(xx, yy);// to create Cercle
					xx = (int) (Math.random() * 400);
					yy = (int) (Math.random() * 400);
					sp.c(xx, yy);

				}

			}));
			tl.setCycleCount(30);
			tl.play();
			tl.setOnFinished(o -> {
				sp.clearP();
				stage.setScene(scene);
				Label lab = new Label("GameOver\nScore: " + sp.getTotal() + "\nTHANK YOU FOR PLAYING");
				lab.setFont(Font.font(null, FontWeight.BOLD, 30));
				p.getChildren().add(lab);
			});

		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
