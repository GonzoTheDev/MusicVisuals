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
        mv.noStroke();
        mv.ellipseMode(RADIUS);
        
        //do stuff here

        mv.calculateAverageAmplitude(); 
        float r = mv.getSmoothedAmplitude();

        r = map(r, 0, 40, 0, 20);

        int midX = mv.width/2;
        int midY = mv.height/2;

        mv.circle(midX, midY, map(r, 0, 1, 0, 1000)); //how do I make this run around in a curved ellipse
        println(r);

        //if it touches the edge thats the max it can go
        

    }
}
