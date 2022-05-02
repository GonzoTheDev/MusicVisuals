package c20703429;

import ie.tudublin.*;
//size(1400, 800);

public class IgnasVisual extends Visual {

    MainVisual mv;


    public IgnasVisual(MainVisual mv) {
        this.mv = mv;
    }

    // global variables
    int orbit = 300;
    int angle = 270; //where the first circle starts from the bottom
    int angle2 = 90; //where the second circle starts from the bottom
    ddf.minim.analysis.BeatDetect beat = BeatDetect();

    public void render() {

        //setup
        mv.background(20);
        mv.colorMode(RGB, 255);      
        mv.calculateAverageAmplitude();
        
        //initialisation 
        float r = mv.getSmoothedAmplitude();
        float r2 = map(r, 0, 40, 50, 1000);
        int midX = mv.width/2;
        int midY = mv.height/2;

        //first fill
        mv.fill(10);
        mv.stroke(153);

        //this is the circle in the middle
        mv.circle(midX, midY, map(r, 0, 1, 0, 1000)); 

        //beat detection
        // if(mv.isBeat() == true)
        // {

        // }
        
        //testing purposes
        println(r + ", " + r2);

        // circles circling
        mv.fill(50);
        mv.noStroke();
            //first circle
            mv.push();

                mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                mv.rotate(radians(angle));

                mv.circle(0, 0, r2);

            mv.pop();

            //second circle
            mv.push();

                mv.translate(700 + (cos(radians(angle2)) * orbit), 400 + (sin(radians(angle2)) * orbit));
                mv.rotate(radians(angle2));

                mv.circle(0, 0, r2);

            mv.pop();

            angle += 5;
            angle2 += 5;

            if(angle > 359)
            {
                angle = 0;
            }

            if(angle2 > 359)
            {
                angle2 = 0;
            }

        //line that goes around main circle

    }
}
