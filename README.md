# Music Visualiser Project

Names: Shane Buckley, Adam O'Shea, Ignas Prakapas

Student Number: C20703429, C20372181, C20424992

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment

## Adam
For my portion of the assignment, I decided to create a few visuals that are each based around a shape. I wanted the shape to grow every time there is a beat in the song until it hits the borders of the screen. Once fully grown, the shape resets to its beginning size and its colour is changed. The background also changes colour with the shape but with a smaller opacity so that the colour in the shape is more prominent. In the centre of each visual is a rotating spiral of dots that grows and retracts with the amplitude analysed from the song.

## Shane
For my visual I wanted to create something to do with fractals, I was originally thinking of doing something related to the mandelbroth set but settled on a fractal tree due to it's simplicity and gave me the ability to make a very psychedelic visual by running multiple tree objects overlapping each other and changing colours at different rates. The circle of trees rotate at a set speed and expand/contract based on the volume of the bass in the music.

## Ignas

# Instructions

## Main Menu
On running our program, a seperate menu window will open with the following options:
- Play Song
- Ignas
- Shane
- Adam

Alternatively you can press the spacebar to change between each visual.

## Adam's Visual Option
Adam's visual has further visual change options based on keypress.
Press a corresponding number on your keyboard to change the visual.

| Keycode | Visual |
|---------|-----------|
| '1' | Centred Circle |
| '2' | Rectangles  |
| '3' | Hourglass Shape |

# How it works

# What I am most proud of in the assignment


This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)



