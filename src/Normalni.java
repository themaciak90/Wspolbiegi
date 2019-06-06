import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Normalni extends Thread {
    volatile private int ktora_strona;
    volatile private Most most;
    volatile private Circle circle;

    volatile PathTransition animate = new PathTransition();

    public Normalni(int ktora, Most m,Circle circle ){
        this.ktora_strona = ktora;
        this.most = m;
        this.circle = circle;
    }




    @Override
    public void run(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                animacja3();
                Platform.runLater(animate::play);
            }
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               animacja6();
               Platform.runLater(animate::play);
            }
        };
        try {
            Watek w1 = new Watek(circle, ktora_strona);


            Platform.runLater(()->w1.start());
            most.pocz_norm();
            if(ktora_strona == 1 && Most.kierunek_jazdy == 1) {
                animacja2();
                Platform.runLater(animate::play);

                Zjazd z1 = new Zjazd(circle,ktora_strona);
                z1.start();


            }
            else if(ktora_strona == 2 && Most.kierunek_jazdy == 2){
                animacja5();
                Platform.runLater(animate::play);
                Zjazd z1 = new Zjazd(circle,ktora_strona);
                z1.start();

            }
            Thread.sleep(100);

            most.kon_norm();



            Thread.sleep(100);
        }
        catch(InterruptedException e){

        }

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



    private void animacja5(){
        Line line = new Line();
        circle.setCenterX(375);
        circle.setCenterY(300);
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(550);
        line.setEndY(300);
        animate.setNode(circle);
        animate.setDelay(Duration.seconds(3));
        animate.setDuration(Duration.seconds(3));
        animate.setPath(line);

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


}
