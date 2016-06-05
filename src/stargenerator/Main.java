/*
 * Copyright (C) 2016 Jorge Maldonado Ventura 
 *
 * Este programa es software libre: usted puede redistruirlo y/o modificarlo
 * bajo los términos de la Licencia Pública General GNU, tal y como está publicada por
 * la Free Software Foundation; ya sea la versión 3 de la Licencia, o
 * (a su elección) cualquier versión posterior.
 *
 * Este programa se distribuye con la intención de ser útil,
 * pero SIN NINGUNA GARANTÍA; incluso sin la garantía implícita de
 * USABILIDAD O UTILIDAD PARA UN FIN PARTICULAR. Vea la
 * Licencia Pública General GNU para más detalles.
 *
 * Usted debería haber recibido una copia de la Licencia Pública General GNU
 * junto a este programa.  Si no es así, vea <http://www.gnu.org/licenses/>.
 */
package stargenerator;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author jorge
 */
public class Main extends Application {
    private static Scene scene;
    private static Pane root;

    static Scene getScene() {
        return scene;
    }

    public static Pane getRoot() {
        return root;
    }
    
    @Override
    public void start(Stage primaryStage) {            
        root = new Pane();
        final short INITIAL_WIDTH = 400, INITIAL_HEIGHT = 400;
        root.setPrefSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        scene = new Scene(root, INITIAL_WIDTH, INITIAL_HEIGHT);
        
        primaryStage.setTitle("Star generator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        generateStars();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void generateStars(){
        ArrayList<Star> stars = new ArrayList<>();
        StarAnimTimer starAnimTimer = new StarAnimTimer(stars);
        Random random = new Random();
        Timeline starTimeline = new Timeline();
        starTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(3), (ActionEvent e) -> {
            Star star = new Star(scene.getWidth() / 2, scene.getHeight() / 2, random.nextDouble() * 11 - 5, random.nextDouble() * 11 - 5);
            root.getChildren().add(star);
            stars.add(star);
        }));
        starTimeline.setCycleCount(Animation.INDEFINITE);
        starTimeline.play();
        starAnimTimer.start();
    }
    
}
