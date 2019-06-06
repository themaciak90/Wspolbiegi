import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.concurrent.Semaphore;


public class Zjazd extends Thread {

    volatile private Circle circle;
    volatile static Semaphore wjazd = new Semaphore(1);
    volatile static Semaphore wjazd2 = new Semaphore(1);
    volatile private PathTransition animate = new PathTransition();
    volatile int ktora_strona;




    public Zjazd(Circle circle, int ktora_strona){
        this.circle = circle;
        this.ktora_strona = ktora_strona;
    }

    @Override
    public void run(){

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wjazd.release();
                circle.setOpacity(0);
            }
        };
        if(ktora_strona == 1) {
            try {
                Thread.sleep(10);
                wjazd.acquire();
                Platform.runLater(() -> circle.setOpacity(1));
                animacja3();
                Platform.runLater(animate::play);
                Platform.runLater(() -> animate.setOnFinished(event));
            } catch (InterruptedException e) {

            }
        }
        else if(ktora_strona == 2){
            try {
                Thread.sleep(10);
                wjazd2.acquire();
                Platform.runLater(() -> circle.setOpacity(1));
                animacja6();
                Platform.runLater(animate::play);
                Platform.runLater(() -> animate.setOnFinished(event));
            } catch (InterruptedException e) {

            }
        }

    }






    private void animacja(){
        circle.setCenterX(870);
        circle.setCenterY(240);
        Line line = new Line();
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(640);
        line.setEndY(240);
        animate.setNode(circle);
        animate.setDuration(Duration.seconds(3));
        animate.setPath(line);


    }
    private void animacja2(){
        Line line = new Line();
        circle.setCenterX(550);
        circle.setCenterY(300);
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(375);
        line.setEndY(300);
        animate.setNode(circle);
        animate.setDuration(Duration.seconds(3));
        animate.setPath(line);


    }

    private void animacja3(){
        Line line = new Line();
        circle.setCenterX(290);
        circle.setCenterY(240);
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(30);
        line.setEndY(240);
        animate.setNode(circle);
        animate.setDuration(Duration.seconds(3));
        animate.setPath(line);


    }
    private void animacja4(){
        circle.setCenterX(30);
        circle.setCenterY(360);
        Line line = new Line();
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(290);
        line.setEndY(360);
        animate.setNode(circle);
        animate.setDuration(Duration.seconds(3));
        animate.setPath(line);


    }
    private void animacja5(){
        Line line = new Line();
        circle.setCenterX(375);
        circle.setCenterY(300);
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(550);
        line.setEndY(300);
        PathTransition animacja = new PathTransition();
        animacja.setNode(circle);
        animacja.setDelay(Duration.seconds(3));
        animacja.setDuration(Duration.seconds(3));
        animacja.setPath(line);
        animacja.play();


    }

    private void animacja6(){
        Line line = new Line();
        circle.setCenterX(640);
        circle.setCenterY(360);
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(870);
        line.setEndY(360);
        animate.setNode(circle);
        animate.setDelay(Duration.seconds(6));
        animate.setDuration(Duration.seconds(3));
        animate.setPath(line);

    }


}
