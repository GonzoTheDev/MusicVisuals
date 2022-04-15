package c20703429;

import ie.tudublin.*;
//size(1400, 800);

public class IgnasVisual extends Visual {

    MainVisual mainVisual;

    public IgnasVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    public void render() {
        mainVisual.background(20);
        mainVisual.stroke(255);
        // mainVisual.textSize(20);
        // mainVisual.textAlign(CENTER,CENTER);
        // mainVisual.text("Ignas' Visual", width, height);
        //do stuff here
        
        mainVisual.fill(20);
        mainVisual.circle(700, 400, 500);

        mainVisual.stroke(20);
        mainVisual.circle(700, 600, 500);// I wanna make this circle go down so that it shows the other circle inn a transition type thing


    }
}
