package c20703429;

import ie.tudublin.*;

class Branch {

    MainVisual mainVisual;
    float start;
    float amplitude; 
    float angle = 0;

    Branch[] branches;
    
    Branch(MainVisual mainVisual,float start, float amplitude, float angle,int branches){

        this.mainVisual = mainVisual;
        this.start = start;
        this.amplitude = amplitude;
        this.angle = angle;

        branch(branches);

    }


    void show(){
        
        
        mainVisual.rotate(this.angle);
        mainVisual.line(0, 0, 0, amplitude);

        if(branches != null){
            mainVisual.translate(0, amplitude);
            mainVisual.pushMatrix();
            branches[0].show();
            mainVisual.popMatrix();
            branches[1].show();

        } 

    } 


    void branch(int branchAmt){

        if (branchAmt > 0){
        
            branches = new Branch[2];
            mainVisual.branchCounter++;
            mainVisual.branchCounter++;


            float angle = MainVisual.map(mainVisual.smothedAmplitude,0,1,3.14f/10f,3.14f/2f);
            
            branches[0] = new Branch(mainVisual, start-amplitude, amplitude/1.5f, angle,branchAmt-2);
            branches[1] = new Branch(mainVisual, start-amplitude, amplitude/1.5f, -angle,branchAmt-2);
        
        }

    }

}

public class ShaneVisual extends Visual {

    MainVisual mainVisual;

    Branch tree;

    public ShaneVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    public void render() {

        mainVisual.colorMode(MainVisual.HSB);
        mainVisual.strokeWeight(1);

        mainVisual.fill(0,40);
        mainVisual.rect(-1, -1, mainVisual.width+1, mainVisual.height+1);


        mainVisual.fill(255);
        mainVisual.stroke(255);


        mainVisual.fCounter++;

        for( int i = 0; i < 6; i++ ){
            mainVisual.resetMatrix();
            

            mainVisual.translate(mainVisual.width / 2, mainVisual.height / 2);
            mainVisual.branchCounter = 0;
        
            mainVisual.rotate( MainVisual.map(mainVisual.fCounter%360, 0, 360, 0, MainVisual.PI*2));
            mainVisual.rotate( MainVisual.map((float)i, 0f, 6f, 0f, MainVisual.PI*2));

            tree = new Branch(mainVisual, 0f, MainVisual.map(mainVisual.smothedAmplitude,0,.4f,-mainVisual.height/30f,-mainVisual.height/4f), 0,18);

            mainVisual.fill((mainVisual.fCounter/10)%255);
            mainVisual.stroke((mainVisual.fCounter/10)%255,255,255);

    
            tree.show();


        }

    }
    
}
