package c20703429;

import ie.tudublin.*;
import processing.core.PApplet;

public class AdamVisual extends Visual {

    MainVisual mainVisual;

    public AdamVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    float[] clrArr = new float[]{random(0, 255),random(0, 255),random(0, 255)};
   
    float[] prevClrs = new float[]{0,0,0};

    float eRadius = 20;
    int snareCnt = 0;
    int unlock = 0;
    int option = 0;    

    public float[] reassignColours(float[] clrArr)
    {
        float[] colours = new float[]{random(0, 255),random(0, 255),random(0, 255)};
        for(int i=0;i<3;i++)
        {
            clrArr[i] = colours[i];
        }
        return clrArr;
    }
    
    

    public void render() {
        mainVisual.background(0, 0, 0);
        mainVisual.textSize(20);
        mainVisual.fill(255);
        mainVisual.textAlign(CENTER,CENTER);

        mainVisual.beat.detect(mainVisual.as.mix);
        mainVisual.beat.detectMode(0);
        mainVisual.fCounter++;
        

        println(mainVisual.adamOption);

        if (mainVisual.beat.isKick())
        {
            snareCnt++;   
        }

        mainVisual.fill(clrArr[0], clrArr[1], clrArr[2], 50);
        mainVisual.eRadius = 5*snareCnt;
            
        if (mainVisual.adamOption == 0)
        {
            // mainVisual.fill(clrArr[0], clrArr[1], clrArr[2], 50);
               // mainVisual.eRadius = 5*snareCnt;
            mainVisual.ellipse(mainVisual.width/2, mainVisual.height/2, mainVisual.eRadius, mainVisual.eRadius);
            if ( mainVisual.eRadius > ((float)mainVisual.width)/2 ) 
            {
                for (int i=0; i < 3; i++)
                {
                    prevClrs[i] = clrArr[i];
                }
                reassignColours(clrArr);
                snareCnt = 0;
                mainVisual.eRadius = 20;
                
            }
        }
        if (mainVisual.adamOption == 1)
        {
            for (int i = 0; i < 200; i += 20) 
            {
                mainVisual.bezier((float) mainVisual.width/2, (float)mainVisual.height/2, (float)mainVisual.eRadius, (float)mainVisual.eRadius, (float)mainVisual.eRadius/2, (float)mainVisual.eRadius/2,  (float)mainVisual.eRadius/2,  (float)mainVisual.eRadius/2);
                mainVisual.bezier((float) mainVisual.width/2, (float)mainVisual.height/2, (float)mainVisual.eRadius, (float)mainVisual.eRadius, (float)mainVisual.eRadius/2, (float)mainVisual.eRadius/2,  (float)mainVisual.eRadius/2,  (float)mainVisual.eRadius/2);
            }
            
        }
        
        mainVisual.fill(prevClrs[0], prevClrs[1], prevClrs[2], 25);
        mainVisual.rect(0, 0, mainVisual.height*2, mainVisual.width*2);

        float space = mainVisual.getSmoothedAmplitude();       
        mainVisual.stroke(PApplet.map(mainVisual.getAmplitude(), 0, 1, 0, 255), 255, 255);
        mainVisual.translate(mainVisual.width/2, mainVisual.height/2);
        for (float i = 0; i < mainVisual.width; i+=0.5 ) 
        { 
            float x = (PApplet.cos(i)*space*i);
            float y = (PApplet.sin(i)*space*i);
            mainVisual.point(x, y);
        }

        
    }
    
}
