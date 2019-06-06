import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Zmiana extends Thread{
    private Most most;
    private Circle circle;
    private int ktora_strona;


    public Zmiana(Most m, Circle circle, int ktora){
        this.most = m;
        this.circle = circle;
        this.ktora_strona = ktora;
    }

    @Override
    public void run() {
        try {
            most.pocz_zmian();
            Most.kierunek_jazdy = ktora_strona;
            if (ktora_strona == 1) {
                animacja();
                animacja2();
                animacja3();
            } else if (ktora_strona == 2) {
                animacja4();
                animacja5();
                animacja6();

            }


        }
        catch (InterruptedException e) {
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
        PathTransition animacja = new PathTransition();
        animacja.setNode(circle);
        animacja.setDuration(Duration.seconds(3));
        animacja.setPath(line);
        animacja.play();


    }
    private void animacja2(){
        Line line = new Line();
        circle.setCenterX(550);
        circle.setCenterY(300);
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(375);
        line.setEndY(300);
        PathTransition animacja = new PathTransition();
        animacja.setNode(circle);
        animacja.setDelay(Duration.seconds(3));
        animacja.setDuration(Duration.seconds(3));
        animacja.setPath(line);
        animacja.play();


    }

    private void animacja3(){
        Line line = new Line();
        circle.setCenterX(290);
        circle.setCenterY(240);
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(30);
        line.setEndY(240);
        PathTransition animacja = new PathTransition();
        animacja.setNode(circle);
        animacja.setDelay(Duration.seconds(6));
        animacja.setDuration(Duration.seconds(3));
        animacja.setPath(line);
        animacja.play();

    }
    private void animacja4(){
        circle.setCenterX(30);
        circle.setCenterY(360);
        Line line = new Line();
        line.setStartX(circle.getCenterX());
        line.setStartY(circle.getCenterY());
        line.setEndX(290);
        line.setEndY(360);
        PathTransition animacja = new PathTransition();
        animacja.setNode(circle);
        animacja.setDuration(Duration.seconds(3));
        animacja.setPath(line);
        animacja.play();


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
        PathTransition animacja = new PathTransition();
        animacja.setNode(circle);
        animacja.setDelay(Duration.seconds(6));
        animacja.setDuration(Duration.seconds(3));
        animacja.setPath(line);
        animacja.play();

    }
}




