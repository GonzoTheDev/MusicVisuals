package c20703429;

import ie.tudublin.*;

import processing.core.*;

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
        mv.background(20, 255, 255);
        mv.textSize(20);
        mv.fill(255);
        mv.textAlign(CENTER,CENTER);
        mv.text("Example", width, height);
        float gap = mv.width / (float) mv.getBands().length;
        mv.noStroke();
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255);
            mv.rect(i * gap, mv.height, gap,-mv.getSmoothedBands()[i] * 0.2f); 
        }
    }
}