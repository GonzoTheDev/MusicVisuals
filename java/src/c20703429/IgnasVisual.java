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
        mv.colorMode(RGB, 255);
        // mv.noStroke();
        // mv.ellipseMode(RADIUS);
        
        //do stuff here

        mv.calculateAverageAmplitude(); 
        float r = mv.getSmoothedAmplitude();

        // r = map(r, 0, 40, 0, 20);

        // int midX = mv.width/2;
        // int midY = mv.height/2;

        // mv.circle(midX, midY, map(r, 0, 1, 0, 1000)); //how do I make this run around in a curved ellipse
        // println(r);
        // mv.fill(200);
        // for (int i = 0; i < 700; i++) {
        //     for (int j = 0; j < 1400; j++) {
        //         mv.line(700, 400, i, j); //x1 and y1 will be static but we want x2 and y2 to extend to the edge of the application 
        //     }
        // }
        int i = 0;
        int j = 0;
        for(i = 0; i < 1400; i = i + 20) //last condition controls the amount of lines dependant on the second condition
        {
            for(j = 0; j < 800; j = j + 20) //last condition controls the amount of lines dependant on the second condition
        {
            mv.stroke(r, r, r);
            mv.line(700, 1400, i, j); //x1 and y1 will be static but we want x2 and y2 to extend to the edge of the application 
        }
        }
        println(r);
    }
}
