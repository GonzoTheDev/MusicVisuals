package c20703429;

import javax.lang.model.util.ElementScanner14;

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

    public void render() {  
    
        //initialisation
        float[] sb = mv.getSmoothedBands();
        // Star[] stars = new Star[100];

        // //this will fill up the array with star objects
        // for (int i = 0; i < stars.length; i++)
        // {
        //     stars[i] = new Star();
        // }
        
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
        if(ba < 170)
        {
        mv.background(20); 
        }

        else
        {
            mv.background(map(lm, 0, 2500, 0, 255), map(ba, 0, 200, 0, 50), map(hh, 0, 2500, 0, 50));
        }

        //the radius of the main circles
        float mainCirc1 = lerp(map(ba, 0, 300, 0, 300), 100, (float) 0.5);
        float mainCirc2 = r2 * 6;

        float gap = mv.width / (float) mv.getBands().length;
        mv.noStroke();
        
        for(int i = 0 ; i < (mv.getBands().length) ; i++)
        {   

            mv.fill(255, 20);
            mv.rect(gap * i , mv.height, gap,-mv.getSmoothedBands()[i] * 0.1f); 
            mv.fill(255, 10);
            mv.rect(gap * i , mv.height, gap,-mv.getSmoothedBands()[i] * 0.2f); 
            mv.fill(255, 5);
            mv.rect(gap * i , mv.height, gap,-mv.getSmoothedBands()[i] * 0.4f);

        }

        // screen for when the chord stab occurs
        if(ba > 110 && lm > 300 && mi > 2500 && hi > 3000 && hh > 2000)
        {
            mv.fill(100, (float)0.5);
            mv.rect(0, 0, 1400, 800); //needs something to be done to it
        }
        //else continue as normal
        else{
            

            // circles circling
            mv.fill(map(mi, 0, 1500, 100, 255), map(hi, 0, 2000, 100, 255), map(hh, 0, 2000, 100, 255));

                //first circle
                mv.push();

                //when tha small bass kicks in
                if(ba < 40)
                {

                    mv.fill(255, map(ba, 0, 150, 0, 255));

                    mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                    mv.rotate(radians(angle));
 
                    mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                }


                //when the harder bass kicks in
                {

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

                    mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                }

                mv.pop();
                
                //second circle
                    mv.push();

                    //when tha small bass kicks in
                    if(ba < 40)
                    {

                        mv.fill(255, map(ba, 0, 150, 0, 255));

                        mv.translate(700 + (cos(radians(angle - 90)) * orbit), 400 + (sin(radians(angle - 90)) * orbit));
                        mv.rotate(radians(angle));
    
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                    }


                    //when the harder bass kicks in
                    {

                        if(ba > 50)
                        {
                            mv.translate(700 + (cos(radians(angle - 90)) * orbit), 400 + (sin(radians(angle - 90)) * orbit));
                            mv.rotate(radians(angle)); 
                        }
                        else
                        {
                            mv.translate(700 + (cos(radians(angle - 90)) * orbit), 400 + (sin(radians(angle - 90)) * orbit));
                            mv.rotate(radians(angle));

                        }

                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                    }

                    mv.pop();

                //third circle
                    mv.push();

                    //when tha small bass kicks in
                    if(ba < 40)
                    {

                        mv.fill(255, map(ba, 0, 150, 0, 255));

                        mv.translate(700 + (cos(radians(angle - 180)) * orbit), 400 + (sin(radians(angle - 180)) * orbit));
                        mv.rotate(radians(angle));
    
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                    }


                    //when the harder bass kicks in
                    {

                        if(ba > 50)
                        {
                            mv.translate(700 + (cos(radians(angle - 180)) * orbit), 400 + (sin(radians(angle - 180)) * orbit));
                            mv.rotate(radians(angle)); 
                        }
                        else
                        {
                            mv.translate(700 + (cos(radians(angle - 180)) * orbit), 400 + (sin(radians(angle - 180)) * orbit));
                            mv.rotate(radians(angle));

                        }

                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                    }

                    mv.pop();

                //fourth circle
                    mv.push();

                    //when tha small bass kicks in
                    if(ba < 40)
                    {

                        mv.fill(255, map(ba, 0, 150, 0, 255));

                        mv.translate(700 + (cos(radians(angle - 270)) * orbit), 400 + (sin(radians(angle - 270)) * orbit));
                        mv.rotate(radians(angle));
    
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                    }


                    //when the harder bass kicks in
                    {

                        if(ba > 50)
                        {
                            mv.translate(700 + (cos(radians(angle - 270)) * orbit), 400 + (sin(radians(angle - 270)) * orbit));
                            mv.rotate(radians(angle)); 
                        }
                        else
                        {
                            mv.translate(700 + (cos(radians(angle - 270)) * orbit), 400 + (sin(radians(angle - 270)) * orbit));
                            mv.rotate(radians(angle));

                        }

                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                    }

                    mv.pop();










            //fill to make the bigger circle transparent
            mv.fill(10, (float) 0.5); 
            mv.stroke(153);
            
            //main circle 1
            
            if(mainCirc1 > 400)
            {
                mainCirc1 = 400;
            }
            mv.circle(midX, midY, mainCirc1); 
            
            //main circle 2
            mv.fill(map(ba, 0, 200, 0, 255), map(lm, 0, 2500, 0, 50), map(mi, 0, 2500, 0, 50));
            if(mainCirc2 > 300)
            {
                mainCirc2 = 300;
            }
            mv.circle(midX, midY, mainCirc2); 
            
            







            //testing purposes
                // println(mv.getSmoothedBands().length);
                println("spin: " + r + ", mapped spin: " + r2 + ", orbit: " + orbit + "\n\nBA: " + sb[0] + ", LM: " + sb[1] + ", MI: "  + sb[2] + ", HI: "  + sb[3] + ", HH: "  + sb[4] + "\n\nmBA: " + ba + ", mLM: " + lm + ", mMI: "  + mi + ", mHI: "  + hi + ", mHH: "  + hh + "\n\n");

            //this is to make the circles change colour based on the music
            mv.fill(map(lm, 0, 430, 0, 255), map(mi, 0, 3200, 0, 255), map(hi, 0, 4500, 0, 255));

            //incrementals and resets
            angle += 5;
            angle2 += 5;
            if ( ba  > 4 )
            {
            orbit = orbit + (float) 1.5;
            }

            if(orbit > 800) 
            {
                orbit = 0;
            }

            if(angle > 359)
            {
                angle = 0;
            }

            if(angle2 > 359)
            {
                angle2 = 0;
            }



            //beat detector
            mv.beat.detectMode(0);
            mv.beat.detect(mv.as.mix);
            int kickCount = 0;

            if(mv.beat.isSnare() == true)
            {   
                kickCount++;
                mv.circle(500, 500, 1000); 
            }

            print("\n" + kickCount);

                // for (int i = 0; i < stars.length; i++)
                // {
                //     stars[i].update();
                //     stars[i].show();

                // }

        }
    }   
    
}

// class Star extends Visual{

//     MainVisual mv;

//     public Star(MainVisual mv) {
//         this.mv = mv;
//     }

//     float x, y, z;

//     Star(){
//         x = random(1, width);
//         y = random(1, height);
//         z = random(1, width);
//     }

//     void update(){

//     }    
    
//     void show(){
//         mv.ellipse(x, y, 20, 20);
//     }
// }
