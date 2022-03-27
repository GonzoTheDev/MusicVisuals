package c20703429;

import ie.tudublin.*;

public class MyVisualMenu extends Visual
{    
    MyVisual visualOption;

    
    public MyVisualMenu(MyVisual visual){

        visualOption = visual;
    }
    public MyVisualMenu(){

    }
   

    public int options = 4;
    int boxHeight= 100;
    int boxWidth = 200;
    

    public void settings()
    {
        size(200, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
    
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            visualOption.visualSwitch = (visualOption.visualSwitch+ 1 )%4;;

        }

        
    }

    public void draw()
    {
        background(0);
        
        


        
       

        for(int i = 0; i < options + 1  ; i++ ){
            fill(25);
            stroke(100);
            if(i == 0){
                fill(60,60,180);
            }

            if (i-1 == visualOption.visualSwitch){

                fill(70);

            }


            rect(0, i*boxHeight,boxWidth,boxHeight);

            if(mouseY >= i*boxHeight && mouseY < (i+1)*boxHeight){

                fill(255,20);
                rect(0, i*boxHeight,boxWidth,boxHeight);

                if(mousePressed){

                    if(i != 0){
                        visualOption.visualSwitch = i-1;
                    }
                    else{
                        visualOption.playSong = 1;
                    }
                    
                }

            }

        }


        textSize(20);
        fill(255);
        textAlign(CENTER,CENTER);
        text("Start Song", boxWidth/2,boxHeight/2);
        text("Ignas", boxWidth/2, 1*boxHeight+boxHeight/2);
        text("Shane", boxWidth/2, 2*boxHeight+boxHeight/2);
        text("Adam", boxWidth/2, 3*boxHeight+boxHeight/2);


     
    }
}