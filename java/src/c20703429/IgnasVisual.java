package c20703429;

import ie.tudublin.*;
//size(1400, 800);

public class IgnasVisual extends Visual {

    MainVisual mv;

    public IgnasVisual(MainVisual mv) {
        this.mv = mv;
    }

    public void render() {
        mv.background(20);
        mv.stroke(255);

        //do stuff here

        mv.fill(0);
        mv.circle(700, 400, 500);
        
        mv.noStroke();
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(20);
            mv.stroke(20);
            mv.circle(700, 600, -mv.getSmoothedBands()[i] * 0.25f);
        
            mv.stroke(200);
            mv.circle(700, 600, -mv.getSmoothedBands()[i] * 0.15f);

        }


    }
}
