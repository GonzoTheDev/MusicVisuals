package c20703429;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    int visualSwitch = 1;
    int playSong = 0;

    public float fCounter = 0;
    public int branchCounter = 0;

    public void settings()
    {
        size(1400, 800);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("powerlines.mp3");        
        
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            as.stop();
            as.trigger();
        }
    }

    public void draw()
    {
        if(playSong == 1){
            as.stop();
            as.trigger();
            playSong = 0;
        }

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 
        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();   
        
        // __________________________ RENDERER CODE


        switch(visualSwitch){

            case 0 : 
                break;
            case 1 : 
                background(50);
                break;

            case 2 : 
                background(125);
                break;

            case 3 : 
                background(255);
                break;
            
            default:
                background(0);
                break;

        }
   
    }
}
