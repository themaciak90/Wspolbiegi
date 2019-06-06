

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;




import javafx.scene.input.MouseEvent;



public class Controller {


    @FXML
    private Label cord;


    @FXML
    private Pane tlo;


    public Controller(){

    }
    @FXML
    void initialize(){
        Circle car = new Circle(30,Color.DODGERBLUE);
        Circle car2 = new Circle(30, Color.RED);
        Circle car3 = new Circle(30, Color.WHITE);
        Circle car4 = new Circle(30, Color.VIOLET);
        car.setOpacity(0);
        car2.setOpacity(0);
        car3.setOpacity(0);
        car4.setOpacity(0);

        tlo.getChildren().addAll(car, car2, car3, car4);
        Most most = new Most();
       // Normalni n1 = new Normalni(2,most,car3);
        Normalni n3 = new Normalni(2,most,car4);
        Normalni n4 = new Normalni(2,most,car);
        Normalni n2 = new Normalni(2,most,car2);
        //n1.start();
        n3.start();
        n4.start();
        n2.start();
        try{
          //  n1.join();
            n3.join();
            n4.join();
            n2.join();
        }
        catch (InterruptedException e){}


    }




    @FXML
    private void displayPosition(MouseEvent event){
        cord.setText("X = " + event.getX() + "        Y = " + event.getY());
    }






}
