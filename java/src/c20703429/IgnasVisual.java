package c20703429;

import java.util.ArrayList;
import ie.tudublin.*;

//this files main class
public class IgnasVisual extends Visual {

    //MainVisual shortcut
    MainVisual mv;

    public IgnasVisual(MainVisual mv) {
        this.mv = mv;
    }

    // global variables
    float orbit = 0; //how fast we want our four circles to go
    float orbit2 = 0; //how fast we want our 5th circle that orbits the centre from left to right
    int angle = 0; //the rotating circles starting angle in relation to the centre

    //the function where we render all of the goodness we want on the screen
    public void render() {  
    
        //initialisation
            //getting an array of the 11 bands
            float[] sb = mv.getSmoothedBands();

            //getting an arraylist for the stars
            ArrayList<Star> stars = new ArrayList<Star>();
        
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
                //high high frequencies
                float hh = sb[4]; 

        //basics
        int midX = mv.width/2; 
        int midY = mv.height/2;
        //have a normal background when the mapped bass frequencies are below 170Hz
        if(ba < 170)
        {
            //dark grey background
            mv.background(20); 
        }

        else
        {   
            //this makes the background turn into different dark colours based on the low-mids, bass, and high highs of the music
            mv.background(map(lm, 0, 2500, 0, 255), map(ba, 0, 200, 0, 50), map(hh, 0, 2500, 0, 50));
        }

        //the radius of the main circles
        float mainCirc1 = lerp(map(ba, 0, 300, 0, 300), 100, (float) 0.5); //circle 1 - the bigger circle
        float mainCirc2 = r2 * 6; //circle 2 - the smaller circle

        float gap = mv.width / (float) mv.getBands().length; //to get he gaps that are needed by equally dividing the number of bands (11 bands) by the width of the application
        mv.noStroke();
        
        // a loop that loops all the way to the length of the amount of bands which is 11 
        for(int i = 0 ; i < (mv.getBands().length) ; i++)
        {   
            //this fill means make it more visible while having a grey colour
            mv.fill(255, 20);
            //each rect means make a rectangle at the x-axis at every point where a gap(definition above) ends, next is the y-coordinate which uses the full height of the application, thirdly is the width of the rectangle itself, then the height is made by measuring what that i iteration of the bands frequency is and this is multiplied by a float so that it would fit the screen more appropriately
            mv.rect(gap * i , mv.height, gap,-mv.getSmoothedBands()[i] * 0.1f); //multiplied by a float of 0.1
            mv.fill(255, 10); //this fill makes the bands more transparent
            mv.rect(gap * i , mv.height, gap,-mv.getSmoothedBands()[i] * 0.2f); //multiplied by a float of 0.2
            mv.fill(255, 5); //the most transparent of the three
            mv.rect(gap * i , mv.height, gap,-mv.getSmoothedBands()[i] * 0.4f);//multiplied by a float of 0.4

        }

        // screen for when the chord stab occurs, to give off a more immersive effect
        if(ba > 110 && lm > 300 && mi > 2500 && hi > 3000 && hh > 2000)
        {
            mv.fill(100, (float)0.5); //sligth bit of transparency
            mv.rect(0, 0, 1400, 800); //gives off a quick flash
        }
        //else continue as normal, this is the default
        else
        {
            // circles circling

            //a fill with random wonderful colours based on the music, this is applied to all of the circles
            mv.fill(map(mi, 0, 1500, 100, 255), map(hi, 0, 2000, 100, 255), map(hh, 0, 2000, 100, 255));

            //first circle

                //start translation
                mv.push();

                //when the bass is below 40Hz
                if(ba < 40)
                {
                    //a fill with random wonderful colours based on the music, this is applied to the circle when it is below 40Hz
                    mv.fill(255, map(ba, 0, 150, 0, 255));

                    //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                    mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                    mv.rotate(radians(angle));
                    
                    //this is the circle that is translated
                    mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                }


                {
                //when the bass is above 50Hz
                if(ba > 50)
                    {   
                        //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                        mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                        mv.rotate(radians(angle)); 
                    }
                //when the bass is not above 50Hz
                else
                    {
                        //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                        mv.translate(700 + (cos(radians(angle)) * orbit), 400 + (sin(radians(angle)) * orbit));
                        mv.rotate(radians(angle));
                    }

                    //this is the circle that is translated
                    mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                }

                //end translation
                mv.pop();
                
            //second circle

                //start translation
                mv.push();

                //when the bass is below 40Hz
                if(ba < 40)
                    {
                        //a fill with random wonderful colours based on the music, this is applied to the circle when it is below 40Hz
                        mv.fill(255, map(ba, 0, 150, 0, 255));

                        //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                        mv.translate(700 + (cos(radians(angle - 90)) * orbit), 400 + (sin(radians(angle - 90)) * orbit));
                        mv.rotate(radians(angle));
    
                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                    }

                    {
                
                // when the bass is above 50Hz
                if(ba > 50)
                        {
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 90)) * orbit), 400 + (sin(radians(angle - 90)) * orbit));
                            mv.rotate(radians(angle)); 
                        }
                        else
                        {
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 90)) * orbit), 400 + (sin(radians(angle - 90)) * orbit));
                            mv.rotate(radians(angle));

                        }

                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                    }

                    //end of translation
                    mv.pop();

            //third circle

                //start of translation
                mv.push();

                //when the bass is below 40Hz
                if(ba < 40)
                    {

                    //a fill with random wonderful colours based on the music, this is applied to the circle when it is below 40Hz
                    mv.fill(255, map(ba, 0, 150, 0, 255));

                        //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                        mv.translate(700 + (cos(radians(angle - 180)) * orbit), 400 + (sin(radians(angle - 180)) * orbit));
                        mv.rotate(radians(angle));
                        
                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                    }


                    {
                    //when the bass is above 50Hz
                    if(ba > 50)
                        {
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 180)) * orbit), 400 + (sin(radians(angle - 180)) * orbit));
                            mv.rotate(radians(angle)); 
                        }
                        else
                        {   
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 180)) * orbit), 400 + (sin(radians(angle - 180)) * orbit));
                            mv.rotate(radians(angle));

                        }

                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                    }
                    //end translation
                    mv.pop();

            //fourth circle
                //start of translation
                mv.push();

                    //when the bass is below 40Hz
                    if(ba < 40)
                    {
                        //a fill with random wonderful colours based on the music, this is applied to the circle when it is below 40Hz
                        mv.fill(255, map(ba, 0, 150, 0, 255));

                        //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                        mv.translate(700 + (cos(radians(angle - 270)) * orbit), 400 + (sin(radians(angle - 270)) * orbit));
                        mv.rotate(radians(angle));
                        
                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit, 0, 1000, 0, 10));
                    }


                    //when the harder bass kicks in
                    {
                        //when the bass is above 50Hz
                        if(ba > 50)
                        {   
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 270)) * orbit), 400 + (sin(radians(angle - 270)) * orbit));
                            mv.rotate(radians(angle)); 
                        }
                        else
                        {   
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 270)) * orbit), 400 + (sin(radians(angle - 270)) * orbit));
                            mv.rotate(radians(angle));

                        }

                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit, 0, 2000, 0, 10));
                    }

                //end translation
                mv.pop();

                //start of translation
                mv.push();

                    //when the bass is below 40Hz
                    if(ba < 40)
                    {
                        //a fill with random wonderful colours based on the music, this is applied to the circle when it is below 40Hz
                        mv.fill(255, map(ba, 0, 150, 0, 255));
                        //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                        mv.translate(700 + (cos(radians(angle - 270)) * orbit2), 400 + (sin(radians(angle - 270)) * orbit2));
                        mv.rotate(radians(angle));
                        
                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(r, r2, 10), 1, 10)) * map(orbit2, 0, 1000, 0, 10));
                    }

                    {   
                        //a fill with random wonderful colours based on the music, this is applied to all of the circles
                        mv.fill(map(lm, 0, 430, 0, 200), map(mi, 0, 3200, 0, 200), map(hi, 0, 4500, 0, 200));

                        //when the bass is above 50Hz
                        if(ba > 50)
                        {   
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 270)) * orbit), 400 + (sin(radians(angle - 270)) * 2));
                            mv.rotate(radians(angle)); 
                        }
                        else
                        {   
                            //this is what the translation does, rotate makes it so the circle goes around the centre point of the application, and translate controls the orbit which controls where it starts and what speed it will go at(which is later setup in incrementals at the bottom of the code)
                            mv.translate(700 + (cos(radians(angle - 270)) * orbit2), 400 + (sin(radians(angle - 270)) * orbit2));
                            mv.rotate(radians(angle));

                        }

                        //this is the circle that is translated
                        mv.circle(0, 0, r2 * (map( 5 , 1, lerp(mi, hi, (float) 0.5), 1, 10)) * map(orbit2, 0, 2000, 0, 2));
                    }
                //end translation
                mv.pop();










            //fill to make the bigger circle transparent
            mv.fill(10, (float) 0.5); 
            mv.stroke(153);
            
            //main circle 1
                
            //this is to make sure the circle does not get overly big, so the max radius is 400
            if(mainCirc1 > 400)
            {
                mainCirc1 = 400;
            }
            //this is circle 1, which is slighly transparent
            mv.circle(midX, midY, mainCirc1); 
            
            //main circle 2
            //a dill with a range of colours for the inner circle which is circle 2
            mv.fill(map(ba, 0, 200, 0, 255), map(lm, 0, 2500, 0, 50), map(mi, 0, 2500, 0, 50));

            //this is to make sure the circle does not get too big
            if(mainCirc2 > 300)
            {
                mainCirc2 = 300;
            }
            //this is circle 2
            mv.circle(midX, midY, mainCirc2); 
            
            







            //testing purposes
                // println(mv.getSmoothedBands().length);
                println("spin: " + r + ", mapped spin: " + r2 + ", orbit: " + orbit + "\n\nBA: " + sb[0] + ", LM: " + sb[1] + ", MI: "  + sb[2] + ", HI: "  + sb[3] + ", HH: "  + sb[4] + "\n\nmBA: " + ba + ", mLM: " + lm + ", mMI: "  + mi + ", mHI: "  + hi + ", mHH: "  + hh + "\n\n");

            //this is to make the circles change to a rnage of colours based on frequencies
            mv.fill(map(lm, 0, 430, 0, 255), map(mi, 0, 3200, 0, 255), map(hi, 0, 4500, 0, 255));

            //incrementals and resets

            //this is to make the smaller outer circles keep moving
            angle += 5;

            //this is so the orbit does not start strught away until there is sound
            if ( ba  > 4 )
            {
                //the speed of the circles is 1.5
                orbit = orbit + 1.5f;
            }

            //this is for the second orbit, so there are more varied speeds
            orbit2 = orbit2 + 2;

            //this is so the outer circles reset once they reach the edge of the screen
            if(orbit > 800) 
            {
                orbit = 0;
            }

            //this is so that the outer circles reset everytime they make a full rotation
            if(angle > 359)
            {
                angle = 0;
            }

            //beat detector
            mv.beat.detectMode(0);

            //this detects beats in the song
            mv.beat.detect(mv.as.mix);

            //whenever a beat is recognised, a star is initialised and added to the stars list
            if(mv.beat.isKick() == true)
            {   
                Star s = new Star(mv);
                stars.add(s);
            }

            //this is the same as the previous function but this is for more stars whenever the songs basss frequencies are over 40
            if(ba > 40)
            {   
                Star s = new Star(mv);
                stars.add(s);
            }

            //this is a simple for loop, where every star in the stats list, and each star is called s
            for( Star s : stars){
                // this is to make it move
                s.update();

                //this is to add nice dark colours to the stars as they appear
                mv.fill(map(lm, 0, 300, 0, 255), map(mi, 0, 3000, 0, 255), map(hi, 0, 4000, 0, 255));

                //render is making them visible on the screen
                s.render();
            }

            //this is a limit fot stars so that once a limit is reached, delete the oldest one
            if(stars.size() > 50)
            {
                stars.remove(0);
            }

        }
    }// end of the render   
    
} //end of main


class Star {

    //main visual shortcut
    MainVisual mv;

    //initialising variables
    float x, y, z;

    //if star is active
    Boolean isActive = true;

    //star constructor
    Star(MainVisual mv) {
        this.mv = mv;
        //random positions for each time star is called
        x = mv.random(1, mv.width);
        y = mv.random(1, mv.height);
        z = mv.width;
    }

    //this is to make it move in a z direction
    void update(){
        //if the star is on screen
        if(z>0)
        {   
            //move by one pixel
            z -= 1;
        }
    }    
    
    //this is the finction where the actual star object is displayed
    void render(){
        //if the star is on screen
        if(z>0)
        {   
            mv.noStroke();
            mv.ellipse(x, y, 20, 20);
        }
    }

} //end of class star
