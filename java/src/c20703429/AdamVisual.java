package c20703429;

import ie.tudublin.*;
import processing.core.PApplet;

public class AdamVisual extends Visual {

    MainVisual mainVisual;

    public AdamVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    //Arrays for setting starting colours of shapes and background respectively
    float[] clrArr = new float[]{random(0, 255),random(0, 255),random(0, 255)};
    float[] prevClrs = new float[]{0,0,0};

    //Initalise variable for measuring beats in song
    int kickCount = 0;  

    //method for reassigning colours when shape resets
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
        //counting framerate
        mainVisual.fCounter++;
        //translate so that the centre of the screen is (0, 0)
        mainVisual.translate(mainVisual.width/2, mainVisual.height/2);

        //When a kick is detected in song, increment variable
        if (mainVisual.beat.isKick())
        {
            kickCount++; 
        }

        //fill shapes with colour
        mainVisual.fill(clrArr[0], clrArr[1], clrArr[2], 40);
        //increase radius of shape with kickCount
        mainVisual.eRadius = 5*kickCount;
        
        //Default visual (circle) - KeyCode 1
        if (mainVisual.adamOption == 1)
        {
            //Draw circle
            mainVisual.ellipse(0, 0, mainVisual.eRadius, mainVisual.eRadius);
            //Reset circle once it hits boundary
            if ( mainVisual.eRadius > ((float)mainVisual.width)/2 ) 
            {
                for (int i=0; i < 3; i++)
                {
                    prevClrs[i] = clrArr[i];
                }
                reassignColours(clrArr);
                kickCount = 0;
                mainVisual.eRadius = 20;
                
            }
        }
        // Rectangle Visual - KeyCode 2
        if (mainVisual.adamOption == 2)
        {
            //Draw rectangles 
            mainVisual.fill(clrArr[0], clrArr[1], clrArr[2], 25);
            mainVisual.rect(-mainVisual.width/2, -mainVisual.height/2, mainVisual.eRadius, mainVisual.eRadius);
            mainVisual.rect(mainVisual.width/2, -mainVisual.height/2, -mainVisual.eRadius, mainVisual.eRadius);
            mainVisual.rect(-mainVisual.width/2, mainVisual.height/2, mainVisual.eRadius, -mainVisual.eRadius);
            mainVisual.rect(mainVisual.width/2, mainVisual.height/2, -mainVisual.eRadius, -mainVisual.eRadius);
            //reset when boundary hit
            if ( mainVisual.eRadius > ((float)mainVisual.width)*1.1 ) 
            {
                for (int i=0; i < 3; i++)
                {
                    prevClrs[i] = clrArr[i];
                }
                reassignColours(clrArr);
                kickCount = 0;
                mainVisual.eRadius = 20;
                
            }
            
        }
        // Hourglass visual - KeyCode 3
        if (mainVisual.adamOption == 3)
        {
            mainVisual.pushMatrix();

            //Rotate shape around centre of screen
            mainVisual.rotate( MainVisual.map(mainVisual.fCounter%360, 0, 360, 0, MainVisual.PI*2));
            
            //Draw triangles
            mainVisual.triangle(0, -100, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);
            mainVisual.triangle(0, 100, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);
            mainVisual.triangle(-100, 0, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);
            mainVisual.triangle(100, 0, 60+(float)0.6*mainVisual.eRadius, mainVisual.eRadius, (-60-(float)0.6*mainVisual.eRadius), mainVisual.eRadius);

            mainVisual.triangle(0, -100, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);
            mainVisual.triangle(0, 100, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);
            mainVisual.triangle(-100, 0, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);
            mainVisual.triangle(100, 0, 120+(float)0.6*mainVisual.eRadius, -mainVisual.eRadius, (-120-(float)0.6*mainVisual.eRadius), -mainVisual.eRadius);

            mainVisual.popMatrix();
            
            //Reset when boundary hit
            if ( mainVisual.eRadius > ((float)mainVisual.width)*0.7 ) 
            {
                for (int i=0; i < 3; i++)
                {
                    prevClrs[i] = clrArr[i];
                }
                reassignColours(clrArr);
                kickCount = 0;
                mainVisual.eRadius = 20;
            }
            
        }
        
        //Draw rectangle for background 
        mainVisual.fill(prevClrs[0], prevClrs[1], prevClrs[2], 25);
        mainVisual.rect(-(mainVisual.width/2)-2, -mainVisual.height/2, mainVisual.height*2, mainVisual.width*2);

        //Spiral that is in centre of screen for all visuals
        //space variable makes shape expand and retract with amplitude of the song
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
