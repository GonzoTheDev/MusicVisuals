package c20703429;

import ie.tudublin.*;

public class AdamVisual extends Visual {

    MainVisual mainVisual;

    public AdamVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    public void render() {
        mainVisual.background(90, 255, 255);
        mainVisual.textSize(20);
        mainVisual.fill(255);
        mainVisual.textAlign(CENTER,CENTER);
        mainVisual.text("Adams Visual", width, height);
    }
    
}
