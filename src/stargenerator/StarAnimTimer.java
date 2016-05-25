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
import javafx.animation.AnimationTimer;

/**
 *
 * @author jorge
 */
public class StarAnimTimer extends AnimationTimer{
    private ArrayList<Star> stars;
    public StarAnimTimer(ArrayList<Star> stars) {
        this.stars = stars;
    }
    
    @Override
    public void handle(long now) {
        stars.stream().forEach((star) -> {
            star.update();
        });
    }
    
}
