/*

Title: Fractal Tree Audio Expansion Visual

*/
package c20703429;

// Import project classes
import ie.tudublin.*;

// Create branch class
class Branch {

    // Initialize variables
    MainVisual mainVisual;
    float start;
    float amplitude; 
    float angle = 0;

    // Initialize branch array
    Branch[] branches;

    // Create Branch method and set to this objects attribute values
    Branch(MainVisual mainVisual,float start, float amplitude, float angle,int branches){

        this.mainVisual = mainVisual;
        this.start = start;
        this.amplitude = amplitude;
        this.angle = angle;

        branch(branches);
 
    }

    // Create display method
    void show(){
        
        // Rotate entire tree visual based on value of this objects angle
        mainVisual.rotate(this.angle);
        mainVisual.line(0, 0, 0, amplitude);

        // If branches array is empty, populate and displau
        if(branches != null){
            mainVisual.translate(0, amplitude);
            mainVisual.pushMatrix();
            branches[0].show();
            mainVisual.popMatrix();
            branches[1].show();

        } 

    } 

    // Create branch method to populate branches array
    void branch(int branchAmt){

        if (branchAmt > 0){
        
            branches = new Branch[2];
            mainVisual.branchCounter++;
            mainVisual.branchCounter++;


            float angle = MainVisual.map(mainVisual.smoothedAmplitude,0,1,3.14f/10f,3.14f/2f);
            
            branches[0] = new Branch(mainVisual, start-amplitude, amplitude/1.5f, angle, branchAmt-2);
            branches[1] = new Branch(mainVisual, start-amplitude, amplitude/1.5f, -angle, branchAmt-2);
        
        }

    }

}

// Main class 
public class ShaneVisual extends Visual {

    // Initialize variables
    MainVisual mainVisual;

    Branch branch1;
    Branch branch2;
    Branch branch3;

    // Set mainVisual variable to this objects mainVisual value
    public ShaneVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    // Render the visual
    public void render() {

        // Set colorMode to HSB
        mainVisual.colorMode(MainVisual.HSB);

        // Set strokeweight and fill
        mainVisual.strokeWeight(1);
        mainVisual.fill(0,40);

        // Set the visual canvas constraints
        mainVisual.rect(-1, -1, mainVisual.width+1, mainVisual.height+1);

        // Set default fill and stroke
        mainVisual.fill(255);
        mainVisual.stroke(255);

        // Increment counter
        mainVisual.fCounter++;

        // For loop to create 6 trees
        for( int i = 0; i < 6; i++ ){

            // Replace current matrix with identity matrix
            mainVisual.resetMatrix();
            
            // Set the visual display window size
            mainVisual.translate(mainVisual.width / 2, mainVisual.height / 2);

            // Set branch counter to 0
            mainVisual.branchCounter = 0;
        
            // Set rotation speed of entire visual
            mainVisual.rotate( MainVisual.map(mainVisual.fCounter%360, 0, 360, 0, MainVisual.PI*2));
            mainVisual.rotate( MainVisual.map((float)i, 0f, 6f, 0f, MainVisual.PI*2));

            // Create 3 branches of varying sizes
            branch1 = new Branch(mainVisual, 0f, MainVisual.map(mainVisual.smoothedAmplitude,0,.4f,-mainVisual.height/30f,-mainVisual.height/4f), 0,16);
            branch2 = new Branch(mainVisual, 0f, MainVisual.map(mainVisual.smoothedAmplitude,0,.4f,-mainVisual.height/30f,-mainVisual.height/4f), 0,18);
            branch3 = new Branch(mainVisual, 0f, MainVisual.map(mainVisual.smoothedAmplitude,0,.5f,-mainVisual.height/15f,-mainVisual.height/4f), 0,20);

            // Set the fill and stroke values then show the branch
            mainVisual.fill((mainVisual.fCounter/10)%255);
            mainVisual.stroke((mainVisual.fCounter/10)%255,255,255);
            branch1.show();

            // Set the fill and stroke values then show the branch
            mainVisual.fill((mainVisual.fCounter/2)%255);
            mainVisual.stroke((mainVisual.fCounter/2)%255,255,255);
            branch3.show();

            // Set the fill and stroke values then show the branch
            mainVisual.fill((mainVisual.fCounter/1)%255);
            mainVisual.stroke((mainVisual.fCounter/1)%255,255,255);
            branch2.show();

        }

    }
    
}
