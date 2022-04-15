package c20703429;

import ie.tudublin.*;


// This is an example of a visual that uses the audio bands
public class AudioBandsVisual extends Visual
{
    MainVisual mv;

    public AudioBandsVisual(MainVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        
        mv.beat.detect(mv.as.mix);
        mv.beat.detectMode(0);
        mv.background(255);
        float a = map(mv.eRadius, 20, 80, 60, 255);
        mv.fill(60, 255, 0, a);
        if ( mv.beat.isSnare() ) mv.eRadius = 80;
        mv.ellipse(width/2, height/2, mv.eRadius, mv.eRadius);
        mv.eRadius *= 0.95;
        if ( mv.eRadius < 20 ) mv.eRadius = 20;
    }
}