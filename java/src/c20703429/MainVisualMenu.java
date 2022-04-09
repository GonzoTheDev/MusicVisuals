package c20703429;

import ie.tudublin.*;


public class MainVisualMenu extends Visual
{    
    MainVisual visualOption;

    
    public MainVisualMenu(MainVisual visual){

        visualOption = visual;
    }
   

    public int options = 5;
    int boxHeight= 100;
    int boxWidth = 300;
    

    public void settings()
    {
        size(300, 500);

    }

    public void setup()
    {
        colorMode(HSB);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            visualOption.visualSwitch = (visualOption.visualSwitch+ 1 ) % 5;

        }

    }

    public void draw()
    {
        background(0);

        for(int i = 0; i < options + 1  ; i++ ){

            if(i == 0){
                fill(25,255,255);
                stroke(100);
            }
            if(i == 1){
                fill(180, 255, 255);
                stroke(100);
            }
            if(i == 2){
                fill(0, 255, 255);
                stroke(100);
            }
            if(i == 3){
                fill(90, 255, 255);
                stroke(100);
            }
            if(i == 4){
                fill(60,60,180);
                stroke(100);
            }

            


            rect(0, i*boxHeight,boxWidth,boxHeight);

            if(mouseY >= i*boxHeight && mouseY < (i+1)*boxHeight){

                fill(255,100);
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


        textSize(40);
        fill(255);
        textAlign(CENTER,CENTER);
        text("Play Song", boxWidth/2,boxHeight/2);
        text("Ignas", boxWidth/2, 1*boxHeight+boxHeight/2);
        text("Shane", boxWidth/2, 2*boxHeight+boxHeight/2);
        text("Adam", boxWidth/2, 3*boxHeight+boxHeight/2);
        text("Example", boxWidth/2, 4*boxHeight+boxHeight/2);


     
    }
}
