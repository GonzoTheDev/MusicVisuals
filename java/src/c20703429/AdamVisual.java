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
        mainVisual.translate(mainVisual.width/2, mainVisual.height/2);

        if (mainVisual.beat.isKick())
        {
            snareCnt++;   
        }

        mainVisual.fill(clrArr[0], clrArr[1], clrArr[2], 30);
        mainVisual.eRadius = 5*snareCnt;
            
        if (mainVisual.adamOption == 1)
        {
            mainVisual.ellipse(0, 0, mainVisual.eRadius, mainVisual.eRadius);
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
        if (mainVisual.adamOption == 2)
        {
            mainVisual.rect(-mainVisual.width/2, -mainVisual.height/2, mainVisual.eRadius, mainVisual.eRadius);
            mainVisual.rect(mainVisual.width/2, -mainVisual.height/2, -mainVisual.eRadius, mainVisual.eRadius);
            mainVisual.rect(-mainVisual.width/2, mainVisual.height/2, mainVisual.eRadius, -mainVisual.eRadius);
            mainVisual.rect(mainVisual.width/2, mainVisual.height/2, -mainVisual.eRadius, -mainVisual.eRadius);
            if ( mainVisual.eRadius > ((float)mainVisual.width)*1.18 ) 
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
        if (mainVisual.adamOption == 3)
        {
            mainVisual.pushMatrix();

            mainVisual.rotate( MainVisual.map(mainVisual.fCounter%360, 0, 360, 0, MainVisual.PI*2));
            mainVisual.triangle(0, -100, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);
            mainVisual.triangle(0, 100, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);
            mainVisual.triangle(-100, 0, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);
            mainVisual.triangle(100, 0, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);

            mainVisual.triangle(0, -100, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);
            mainVisual.triangle(0, 100, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);
            mainVisual.triangle(-100, 0, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);
            mainVisual.triangle(100, 0, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);

            mainVisual.popMatrix();
            
    
            if ( mainVisual.eRadius > ((float)mainVisual.width)*0.7 ) 
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
        
        mainVisual.fill(prevClrs[0], prevClrs[1], prevClrs[2], 25);
        mainVisual.rect(mainVisual.width/2, mainVisual.height/2, mainVisual.height*2, mainVisual.width*2);

        float space = mainVisual.getSmoothedAmplitude();       
        mainVisual.stroke(PApplet.map(mainVisual.getAmplitude(), 0, 1, 0, 255), 255, 255);
        mainVisual.rotate( MainVisual.map(mainVisual.fCounter%360, 0, 360, 0, MainVisual.PI*2));
        for (float i = 0; i < mainVisual.width; i+=0.5 ) 
        { 
            float x = (PApplet.cos(i)*space*i);
            float y = (PApplet.sin(i)*space*i);
            mainVisual.point(x, y);
        }

        
    }
    
}
