//U10416030 陳子勤

import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
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
	
	public void createBall() {	//location of beginning
		Circle playBall = new Circle(210, 85, 4);
		
		int red = 1+random.nextInt(255);	//random color for the ball
		int blue = 1+random.nextInt(255);
		int green = 1+random.nextInt(255);
		Color playBallColor = Color.rgb(red, blue, green);
		playBall.setFill(playBallColor);
		
		beanGame.getChildren().add(playBall);
		
		playBall(playBall, 210, 85);
	}
	
	public void playBall(Node ball, int x, int y) {	//start the ball
		Path path = new Path();
		path.getElements().add(new MoveTo(x, y));	//let the ball start to move
		
		y = y + 60;	//drop on the first block circle
		path.getElements().add(new LineTo(x, y));
		for (int i = 0; i < 6; i++) {	//decide where the ball will drop
			y = y + 30;
			int leftOrRight = random.nextInt(2);
			if (leftOrRight == 1) {
				x = x + 20;
			}
			if (leftOrRight == 0) {
				x = x - 20;
			}
			path.getElements().add(new LineTo(x, y));
		}
		y = y + 118;	//drop to the botton
		path.getElements().add(new LineTo(x, y));
		
		PathTransition p = new PathTransition();
		p.setDuration(Duration.millis(3500));
		p.setPath(path);
		p.setNode(ball);
		p.setOrientation(OrientationType.NONE);       
        	p.setCycleCount(1);
	        p.setAutoReverse(false);
        	p.play();
	}
	
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(beanGame, 420, 500);
		
		beanGame.setOnMouseClicked(event -> {	//mouseClick event to beanGame
            		createBall();
       		});
		
		stage.setTitle("U10416030 陳子勤");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


class BeanGamePane extends Pane {
	BeanGamePane() {
		Line buttonLine = new Line(60, 450, 360, 450);	//底線
		buttonLine.setStrokeWidth(5);
		
		Line lineLeftSlanting = new Line(360, 20, 225, 120);	//左斜線及右斜線
		Line lineRightSlanting = new Line(60, 20, 195, 120);	
		lineLeftSlanting.setStrokeWidth(5);
		lineRightSlanting.setStrokeWidth(5);
	
		Line lineLeft = new Line(60, 450, 60, 20);	//左線及右線
		Line lineRight = new Line(360, 450, 360, 20);
		lineLeft.setStrokeWidth(5);	//設粗細{5}
		lineRight.setStrokeWidth(5);
		getChildren().addAll(buttonLine, lineLeft, lineRight, 
				lineLeftSlanting, lineRightSlanting);
		
		Line line[] = new Line[6];
		for (int i=0;i<=5;i++) {
			line[i] = new Line(110 + (40*i), 450, 110 + (40*i), 320);	//分割線 1~6
			line[i].setStrokeWidth(3);	//設粗細{3}
			getChildren().add(line[i]);
		}
		
		Circle circle1 = new Circle(210, 155, 4);	//一層
		getChildren().add(circle1);
		
		Circle circle2[] = new Circle[2];	//二層
		for (int i=0;i<=1;i++) {
			circle2[i] = new Circle(190 + (40*i), 185, 4);
			getChildren().add(circle2[i]);
		}
		
		Circle circle3[] = new Circle[3];	//三層
		for (int i=0;i<=2;i++) {
			circle3[i] = new Circle(170 + (40*i), 215, 5);
			getChildren().add(circle3[i]);
		}

		Circle circle4[] = new Circle[4];	//四層
		for (int i=0;i<=3;i++) {
			circle4[i] = new Circle(150 + (40*i), 245, 6);
			getChildren().add(circle4[i]);
		}

		Circle circle5[] = new Circle[5];	//五層
		for (int i=0;i<=4;i++) {
			circle5[i] = new Circle(130 + (40*i), 275, 7);
			getChildren().add(circle5[i]);
		}

		Circle circle6[] = new Circle[6];	//六層
		for (int i=0;i<=5;i++) {
			circle6[i] = new Circle(110 + (40*i), 305, 8);
			getChildren().add(circle6[i]);
		}
	}
}
