package c20703429;

import ie.tudublin.*;

public class ShaneVisual extends Visual {

    MainVisual mainVisual;

    public ShaneVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    public void render() {
        mainVisual.background(0, 255, 255);
        mainVisual.textSize(20);
        mainVisual.fill(255);
        mainVisual.textAlign(CENTER,CENTER);
        mainVisual.text("Shanes Visual", width, height);
    }
    
}
