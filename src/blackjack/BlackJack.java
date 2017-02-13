/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ShadowX
 */
public class BlackJack extends Application {

    //https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
    //Due March 4
/*10 points for graphics

10 points objects

10 points polymorphism

10 points abstract classes

10 points linked lists

10 points 2D array

10 points >2D array (or arraylist)

10 points - maps & keys

20 points playable, worthwhile game*/
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Blackjack");
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(512 - 64, 256);
        root.getChildren().add(canvas);

        Button hitBtn = new Button();
        hitBtn.setText("Hit");
        hitBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        root.getChildren().add(hitBtn);

        ArrayList<String> input = new ArrayList<String>();

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();

                // only add once... prevent duplicates
                if (!input.contains(code)) {
                    input.add(code);
                }
            }
        });

        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                input.remove(code);
            }
        });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image left = new Image("left.png");
        Image leftG = new Image("leftG.png");

        Image right = new Image("right.png");
        Image rightG = new Image("rightG.png");

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Clear the canvas
                gc.clearRect(0, 0, 512, 512);

                if (input.contains("LEFT")) {
                    gc.drawImage(leftG, 64, 64);
                } else {
                    gc.drawImage(left, 64, 64);
                }

                if (input.contains("RIGHT")) {
                    gc.drawImage(rightG, 256, 64);
                } else {
                    gc.drawImage(right, 256, 64);
                }
            }
        }.start();

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
