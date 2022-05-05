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

What I did for my project is to try make a dark, subtle formings based around the circle in the middle. What I ended up doing was having two circles in 
the middle, outer circle for the bass and the inner circle for the amplitude at the song which was mapped to a minimum. As the song progresses more extreme 
versions of the shapes come out, like the rotating small circles, and what I liked most which only appears when the song hits its second section is the 
constantly incrementing orbiting circle, that looks like it is weaving in and our of the transparent outer circle. 

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

## Ignas
I made the visualiser work by using the function getSmoothedBands, this measures the a band of the song that iss currently playing, which in this case is 
11 bands. With these bands, I mapped them to respresent more of a true representation of frequencies I need. This is why I mapped 2 bands and left the rest
alone.  With each of these frequcnies in each ands, I placed them in either the scale of a circle or the colour of a circle. Another thing I managed to do was
make an array list and fill that up with rapidly blinking stars. When it came to having the smaller circles rotate around the circle, I used sin and cos 
functions, so they actually would zoom around the center, and their speed and range are constantly changing to add more dynamics.

# What I am most proud of in the assignment

## Ignas
I really liked the flashing circles I did for this project, this took me a lot of time and head scratching but I managed to implement a seperate class, with different 
functions. This was big for me because I have always went with procedural programming, and having this in my project, especially with the extra requiremnts that were
to have the visuals on while operating the class, was such a delight for me when I finished it.


## Shane
I'm actually most proud of how comfortable I have become with using git, branches, merging, committing and collaborating. I even made a visualization of our entire repository from when it was first created by Bryan Duggan using a great little piece of software called gource. I have included a link to that video below!

Project Video:

[![YouTube](https://img.youtube.com/vi/nqSQb-zz8oU/maxresdefault.jpg)](https://youtu.be/nqSQb-zz8oU)

Repository Visualization Video:

[![YouTube](https://img.youtube.com/vi/nqSQb-zz8oU/maxresdefault.jpg)](https://youtu.be/nqSQb-zz8oU)


