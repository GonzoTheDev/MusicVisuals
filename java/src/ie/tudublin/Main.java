package ie.tudublin;

import c20703429.*;

public class Main
{	

	public void startUI()
	{
		MyVisual visualizer = new MyVisual(); 

		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, visualizer );
		String[] b = {"Second"};
		processing.core.PApplet.runSketch( b, new MyVisualMenu(visualizer));	
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}