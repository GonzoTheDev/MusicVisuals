package c20703429;

import ie.tudublin.*;
import processing.core.PApplet;




public class AdamVisual extends Visual {

    MainVisual mainVisual;
    

    public AdamVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    float colour1 = random(0, 255);
    float colour2 = random(0, 255);
    float colour3 = random(0, 255);
    float bgC1, bgC2, bgC3 = 0;
    float eRadius = 20;
    int snareCnt = 0;
    public void render() {
        mainVisual.background(0, 0, 0);
        mainVisual.textSize(20);
        mainVisual.fill(255);
        mainVisual.textAlign(CENTER,CENTER);
                                                            //mouseX affects size, mouseY affects colours, think of other things you uncreative fuck

        mainVisual.beat.detect(mainVisual.as.mix);
        mainVisual.beat.detectMode(0);
        //float a = map(mainVisual.eRadius, 20, 80, 60, 255);
        mainVisual.fill(colour1, colour2, colour3, 20);
        

        if (mainVisual.beat.isSnare())
        {
            snareCnt++;            
        }
        if ( mainVisual.eRadius > ((float)mainVisual.width)/2 ) 
        {
            bgC1 = colour1;
            bgC2 = colour2;
            bgC3 = colour3;
            colour1 = random(0, 255);
            colour2 = random(0, 255);
            colour3 = random(0, 255);
            snareCnt = 0;
            mainVisual.eRadius = 20;
        }
        else
        {
            mainVisual.eRadius = 25*snareCnt;
            System.out.println(snareCnt);
            mainVisual.ellipse(mainVisual.width/2, mainVisual.height/2, mainVisual.eRadius, mainVisual.eRadius);
            
        }
        mainVisual.eRadius -= 5;
        mainVisual.fill(bgC1, bgC2, bgC3, 30);
        mainVisual.rect(0, 0, mainVisual.height*2, mainVisual.width*2);

                
        mainVisual.stroke(PApplet.map(mainVisual.getAmplitude(), 0, 1, 0, 255), 255, 255);
        mainVisual.translate(mainVisual.width/2, mainVisual.height/2);
        float gap = 1*mainVisual.getSmoothedAmplitude();
        for (float i = 0; i < mainVisual.width; i+=0.5 ) 
        {
            float x = (i * PApplet.cos(i)*gap);
            float y = (-i * PApplet.sin(i))*gap;
            mainVisual.point(x, y);
        }
        
    }
    
}
