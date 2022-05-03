package c20703429;

import ie.tudublin.*;

public class MainVisual extends Visual
{    
    int visualSwitch = 0;
    int playSong = 0;
    int stopSong = 0;
    public float eRadius;

    // Initialize each visual object
    AdamVisual adam;
    IgnasVisual ignas;
    ShaneVisual shane;
    AudioBandsVisual example;


    public float fCounter = 0;
    public int branchCounter = 0;
    public int adamOption = 1;

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
        loadAudio("powerlines.wav");   
        
        BeatDetect();
        ellipseMode(RADIUS);
        eRadius = 20;
        colorMode(HSB);

        // Create new instances of each of our 3 visual classes
        adam = new AdamVisual(this);
        ignas = new IgnasVisual(this);
        shane = new ShaneVisual(this);
        example = new AudioBandsVisual(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            as.stop();
            as.trigger();
        }
        if (keyCode >= '1' && keyCode <= '3')
        {
            adamOption = keyCode - '0';
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
                ignas.render();
                break;

            case 1 : 
                shane.render(); 
                break;

            case 2 : 
                adam.render();
                break;

            case 3 : 
                example.render();
                break;
            
            default:
                background(0);
                break;

        }
   
    }
}
