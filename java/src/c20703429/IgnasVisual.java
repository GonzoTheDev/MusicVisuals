package c20703429;

import ie.tudublin.*;
//size(1400, 800);


public class IgnasVisual extends Visual {

    MainVisual mv;


    public IgnasVisual(MainVisual mv) {
        this.mv = mv;
    }

    // global variables

    float orbit = 0;
    int angle = 270; //where the first circle starts from the bottom
    int angle2 = 90; //where the second circle starts from the bottom
    //maybe
    // @Override
    // public void background(float gray) {
    //     // TODO Auto-generated method stub
    //     super.background(0);
    // }

    public void render() {

        //setup
        // if (key==' ') {
        //     clear();
        //     background(0);
        //     float orbit = 0;
        //     int angle = 270; //where the first circle starts from the bottom
        //     int angle2 = 90; //where the second circle starts from the bottom
        // }

        mv.colorMode(HSB);      
        mv.getFFT();        
        float[] sb = mv.getSmoothedBands();

        //initialisation
            //moving bits
                float r = mv.getSmoothedAmplitude();
                float r2 = map(r, 0, 1 , 0, 40);
                //bass frequencies
                float ba = map(sb[0], 0, 50, 0, 200);
                //low-mid frequencies
                float lm = map(sb[1], 0, 400, 0, 400 ); 
                //mid frequencies
                float mi = sb[2];  
                //high frequencies
                float hi = sb[3]; 
                //super high frequencies
                float hh = sb[4]; 
        //basics
        int midX = mv.width/2; 
        int midY = mv.height/2;

        if(ba > 45)
        {
            mv.background(20); 
        }
        // pulse of something for that chord
        if(ba > 110 && lm > 300 && mi > 2500 && hi > 3000 && hh > 2000)
        {
            mv.fill(100, (float)0.5);
            mv.rect(0, 0, 1400, 800);
        }
        else{
            mv.noStroke();

            // circles circling
                
                //first circle
                mv.push();

                //when tha bass kicks in
                if(ba < 40)
                {

                    mv.fill(255, map(ba, 0, 150, 0, 255));

                    mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                    mv.rotate(radians(angle));

                    mv.circle(0, 0, r2 * (map( 5 , 0, lerp(r, r2, 10), 1, 10)) * 3);
                }

                //when the harder bass kicks in
                else
                {
                    mv.fill(map(mi, 0, 500, 100, 255), map(mi, 0, 3500, 100, 255), map(mi, 0, 5000, 100, 255));

                    if(ba > 50)
                    {
                        mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                        mv.rotate(radians(angle)); 
                    }
                    else
                    {
                        mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                        mv.rotate(radians(angle));
                    }

                    mv.circle(0, 0, r2 * (map( 5 , 0, lerp(mi, hi, (float) 0.5), 1, 10)) * 3);
                }

                mv.pop();

                //second circle
                // mv.push();

                //     mv.translate(700 + (cos(radians(angle2)) * orbit), 400 + (sin(radians(angle2)) * orbit));
                //     mv.rotate(radians(angle2));

                //     mv.circle(0, 0, r2 * (map( 5 , 0, lerp(r, r2, 10), 1, 10)) * 3);

                // mv.pop();

            //fill to make the bigger circle transparent
            mv.fill(10, (float) 0.5); 
            mv.stroke(153);

            //this is the circle in the middle, I want it to only put out the bass frequencies
            mv.circle(midX, midY, lerp(map(ba, 0, 50, 0, 200), 100, (float) 0.5)); 

            //this will be the second circle, I want it to be smaller and have it put out the average amplitude
            mv.fill(100);
            mv.circle(midX, midY, r2 * 6); 
            
            //testing purposes
            // println(mv.getSmoothedBands().length);
            println("spin: " + r + ", mapped spin: " + r2 + ", orbit: " + orbit + "\n\nBA: " + sb[0] + ", LM: " + sb[1] + ", MI: "  + sb[2] + ", HI: "  + sb[3] + ", HH: "  + sb[4] + "\n\nmBA: " + ba + ", mLM: " + lm + ", mMI: "  + mi + ", mHI: "  + hi + ", mHH: "  + hh + "\n\n");

            //this is to make the circles change colour based on the music
            mv.fill(map(lm, 0, 430, 0, 255), map(mi, 0, 3200, 0, 255), map(hi, 0, 4500, 0, 255));



                angle += 5;
                angle2 += 5;
                if ( ba  > 4 )
                {
                orbit = orbit + (float) 1.115;
                }

                if(orbit > 850)
                {
                    orbit = 50;
                }

                if(angle > 359)
                {
                    angle = 0;
                }

                if(angle2 > 359)
                {
                    angle2 = 0;
                }

        // }
        
            //arc that goes around main circle
        
        }


    }
}
