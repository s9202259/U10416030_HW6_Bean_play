//U10416030 陳子勤

import java.security.SecureRandom;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class BeanGameFuction extends Application {
	BeanGamePane beanGame = new BeanGamePane();
	SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		
	}
	
	public void createBall() {
		Circle playBall = new Circle(210, 80, 4);
		
		int red = 1+random.nextInt(255);
		int blue = 1+random.nextInt(255);
		int green = 1+random.nextInt(255);
		Color playBallColor = Color.rgb(red, blue, green);
		playBall.setFill(playBallColor);
		
		beanGame.getChildren().add(playBall);
		
		playBall(playBall, 210, 80);
	}
	
	public void playBall(Node ball, int x, int y) {
		int newX = x;
		int newY = y;
		Path path = new Path();
		
		path.getElements().add(new MoveTo(newX, newY));
		for (int i = 0; i < 7; i++) {
			newY = newY + 30;
			int leftOrRight = random.nextInt(2);
			if (leftOrRight == 1) {
				newX = newX + 20;
			}
			if (leftOrRight == 2) {
				newX = newX - 20;
			}
			path.getElements().add(new LineTo(newX, newY));
		}
		PathTransition p = new PathTransition();
		p.setDuration(Duration.millis(3000));
        p.setPath(path);
        p.setNode(ball);
        p.setOrientation(OrientationType.NONE);       
        p.setCycleCount(1);
        p.setAutoReverse(false);
        p.play();
	}
}


class BeanGamePane extends Application {
	@Override
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 420, 500);
		
		primaryStage.setTitle("U10416030 陳子勤");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Line buttonLine = new Line(60, 450, 360, 450);	//底線
		buttonLine.setStrokeWidth(5);
		
		Line lineLeftSlanting = new Line(360, 20, 225, 120);	//左線及右線
		Line lineRightSlanting = new Line(60, 20, 195, 120);	//左線及右線
		lineLeftSlanting.setStrokeWidth(5);
		lineRightSlanting.setStrokeWidth(5);
	
		Line lineLeft = new Line(60, 450, 60, 20);	//左線及右線
		Line lineRight = new Line(360, 450, 360, 20);
		lineLeft.setStrokeWidth(5);	//設粗細{5}
		lineRight.setStrokeWidth(5);
		pane.getChildren().addAll(buttonLine, lineLeft, lineRight, 
				lineLeftSlanting, lineRightSlanting);
		
		Line line[] = new Line[6];
		for (int i=0;i<=5;i++) {
			line[i] = new Line(110 + (40*i), 450, 110 + (40*i), 320);	//分割線 1~6
			line[i].setStrokeWidth(3);	//設粗細{3}
			pane.getChildren().add(line[i]);
		}
		
		Circle circle1 = new Circle(210, 155, 4);	//一層
		pane.getChildren().add(circle1);
		
		Circle circle2[] = new Circle[2];	//二層
		for (int i=0;i<=1;i++) {
			circle2[i] = new Circle(190 + (40*i), 185, 4);
			pane.getChildren().add(circle2[i]);
		}
		
		Circle circle3[] = new Circle[3];	//三層
		for (int i=0;i<=2;i++) {
			circle3[i] = new Circle(170 + (40*i), 215, 5);
			pane.getChildren().add(circle3[i]);
		}

		Circle circle4[] = new Circle[4];	//四層
		for (int i=0;i<=3;i++) {
			circle4[i] = new Circle(150 + (40*i), 245, 6);
			pane.getChildren().add(circle4[i]);
		}

		Circle circle5[] = new Circle[5];	//五層
		for (int i=0;i<=4;i++) {
			circle5[i] = new Circle(130 + (40*i), 275, 7);
			pane.getChildren().add(circle5[i]);
		}

		Circle circle6[] = new Circle[6];	//六層
		for (int i=0;i<=5;i++) {
			circle6[i] = new Circle(110 + (40*i), 305, 8);
			pane.getChildren().add(circle6[i]);
		}
	}
}
