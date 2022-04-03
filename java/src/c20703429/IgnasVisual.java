package c20703429;

import ie.tudublin.*;

public class IgnasVisual extends Visual {

    MainVisual mainVisual;

    public IgnasVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    public void render() {
        mainVisual.background(180, 255, 255);
        mainVisual.textSize(20);
        mainVisual.fill(255);
        mainVisual.textAlign(CENTER,CENTER);
        mainVisual.text("Ignas' Visual", width, height);
    }
    
}
