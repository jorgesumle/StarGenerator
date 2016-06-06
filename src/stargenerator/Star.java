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

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jorge
 */
public class Star extends Rectangle{
    private double xPos;
    private double yPos;
    private double xVeloc;
    private double yVeloc;
    
    Star(double xPos, double yPos, double xVeloc, double yVeloc) {
        setX(xPos);
        setY(yPos);
        setWidth(1);
        setHeight(1);
        
        setFill(Color.WHITE);
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVeloc = xVeloc;
        this.yVeloc = yVeloc;
    }
    
    void update(){
        xPos += xVeloc;
        yPos += yVeloc;
        relocate(xPos, yPos);
        if(isOutOfScreen()){
            Main.getRoot().getChildren().remove(this);
        }
    }
    
    private boolean isOutOfScreen(){
        return xPos <= 0 - getWidth() || xPos > Main.getScene().getWidth() || yPos <= 0 - getHeight() || yPos > Main.getScene().getHeight();
    }
    
}
