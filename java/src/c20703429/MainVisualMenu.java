package c20703429;

import ie.tudublin.*;


// Main menu class
public class MainVisualMenu extends Visual
{    

    // Initialize varaibles
    MainVisual visualOption;

    
    public MainVisualMenu(MainVisual visual){

        visualOption = visual;
    }
   
    // Set amount of menu options and the menu size
    public int options = 3;
    int boxHeight= 80;
    int boxWidth = 300;
    

    // Create settings method and set window size
    public void settings()
    {
        size(300, 320);
    }

    // Create setup method and set colorMode to HSB
    public void setup()
    {
        colorMode(HSB);
    }

    // Create key press method
    public void keyPressed()
    {
        
        // If the user presses spacebar, switch the visual
        if (key == ' ')
        {
            visualOption.visualSwitch = (visualOption.visualSwitch+ 1 ) % 3;

        }

    }


    // Create the draw method
    public void draw()
    {

        // Set default background to black
        background(0);

        // For loop to iterate over menu options
        for(int i = 0; i < options + 1  ; i++ ){

            // Set the button text and background colours
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
            

            // Draw the button rectangles
            rect(0, i*boxHeight,boxWidth,boxHeight);

            // Make the buttons clickable by mouse to change  the visuals
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


        // Set text size
        textSize(40);

        // Set text colour
        fill(255);

        // Align text to center
        textAlign(CENTER,CENTER);

        // Write option buttons text
        text("Play Song", boxWidth/2,boxHeight/2);
        text("Ignas", boxWidth/2, 1*boxHeight+boxHeight/2);
        text("Shane", boxWidth/2, 2*boxHeight+boxHeight/2);
        text("Adam", boxWidth/2, 3*boxHeight+boxHeight/2);
     
    }
}
