Button b;
String question;
PImage cyan, red, green, pink, vent, kill, cross, bg, arrow;
PFont font1;
PFont font2;
import processing.sound.*;
int starttime;
int value = 0;
boolean showImage = true;
boolean drawBackground = false;
boolean drawBackground2 = false;
int timeclicked;
int moveX = 0;
PImage pickedimage;

SoundFile report, space, defeat, win;

void setup()
{
  noStroke();
  b = new Button();
  b.centreX = 950;
  b.centreY = 550;

  size(1000, 600);

  font1 = loadFont("BookmanOldStyle-48.vlw");
  font2 = loadFont("ForteMT-48.vlw");
  report = new SoundFile(this, "report.mp3"); 
  space = new SoundFile(this, "space.mp3");
  defeat = new SoundFile(this, "defeat.mp3");
  report.play();

  if (millis() > 2000)
  {
    space.play();
  }

  starttime = millis();
}

void draw()
{
  bg = loadImage("bg.jpg");
  bg.resize(width/2, height/2);
  image(bg, 0, 0, width, height);
  int time = millis() - starttime;
  
  cyan = loadImage("Cyan.png");
  cyan.resize(100, 150);
  image(cyan, 95, 400);
  
  red = loadImage("red.png");
  red.resize(150, 150);
  image(red, 295, 400);

  green = loadImage("green.png");
  green.resize(100, 150);
  image(green, 545, 400);

  pink = loadImage("pink.png");
  pink.resize(100, 150);
  image(pink, 795, 400);

  vent = loadImage("vent.png");
  vent.resize(100, 150);
  image(vent, 855, 30);

  kill = loadImage("kill.png");
  kill.resize(100, 150);
  image(kill, 55, 30);
  
  if (b.on)
  {
    question2();
    question3();
    question31();
    question4();
    question5();
  }

  if (time < 20000)
  {
    if (time > 5000)
    {
      question2();
    } else
    {
      question1();
    }

    if (time > 7500)
    {
      question3();
    }

    if (time > 10000)
    {
      question31();
    }

    if (time > 12500)
    {
      question4();
    }

    if (time > 15000)
    {
      question5();
    }
  }

  if (time > 21000)
  {
    if (time > 20000)
    {
      if (!b.on)
      {
        imposter();
      }
      b.display();
      arrow = loadImage("arrow.png");
      arrow.resize(50, 50);
      image(arrow, 925, 525);
    }
    if (time > 5000)
    {
      cross = loadImage("cross.png");
      cross.resize(150, 150);
      image(cross, 295, 400);
    }
  }
  
  if (drawBackground)
  {
    image(bg, 0, 0, width, height);
   
    if(millis() - timeclicked > 2500)
    {
      textFont(font2, 100);
      fill(255, 0, 0);
      textAlign(CENTER);
      text("Defeat", 500, 100);
      pink = loadImage("pink.png");
      pink.resize(100, 150);
      image(pink, 450, 250);
      textFont(font1, 25);
      fill(255);
      textAlign(CENTER);
      text("Pink was the Imposter.", 500, 500);
      if(!defeat.isPlaying())
      {
        defeat.play();
      }
    }
    
    else
    {
      float x = lerp(-100, width + 100, (millis() - timeclicked) / 2500.f);
      
      pushMatrix();
      translate(x, 200);
      rotate(2*PI*sin(x / float (width)));
      image(pickedimage, 0, 0);
      popMatrix();
    }
    
    if(millis() - timeclicked > 2500)
    {
      textFont(font2, 100);
      fill(255, 0, 0);
      textAlign(CENTER);
      text("Victory", 500, 100);
      
      image(cyan, 350, 250);
      image(green, 550, 250);
      
      textFont(font1, 25);
      fill(255);
      textAlign(CENTER);
      text("Pink was the Imposter. You Win!", 500, 500);
      if(!win.isPlaying())
      {
        win.play();
      }
    }
    
    if (millis() - timeclicked > 5000)
    {
      exit();
    }
  }
}
  
void mousePressed()
{
  if (millis() > 20000)
  {
    showImage = !showImage; 
    cyan();
    gree();
    victory();
  }

}

void mouseClicked()
{
  if (b.check())
  {
    b.on = !b.on;
  }
}

//questions
void question1()
{
    textFont(font1, 48);
    fill(255, 0, 0);
    textAlign(CENTER);
    text("Emergency Meeting", 500, 100);
}

void question2()
{
    textFont(font1, 48);
    fill(255, 0, 0);
    textAlign(CENTER);
    text("SCENARIO", 500, 50);
    textFont(font1, 32);
    fill(255);
    text("•Red was killed in the reactor room", 500, 100);
}

void question3()
{
    textFont(font1, 32);
    fill(255);
    textAlign(CENTER);
    text("•Blue and Green were in electrical", 500, 150);
}

void question31()
{
    textFont(font1, 32);
    fill(255);
    textAlign(CENTER);
    text("•Electrical is the closest room to reactor", 500, 200);
}

void question4()
{
    textFont(font1, 32);
    fill(255);
    textAlign(CENTER);
    text("•Pink was in electrical by themself", 500, 250);
}

void question5()
{
    textFont(font1, 32);
    fill(255);
    textAlign(CENTER);
    text("•There is a vent from electrical to reactor", 500, 300);
}

void imposter()
{
    textFont(font1, 48);
    fill(255);
    textAlign(CENTER);
    text("Who is the Imposter?", 500, 100);
}

//Imposter Click = bye bye

boolean mouseInRect(int x, int y, int w, int h)
{
  return (mouseX >= x) && (mouseY >= y) && (mouseX <= x + w) && (mouseY <= y + h);
}

void cyan()
{
  if (mouseInRect(95, 400, 100, 150))
  {
    timeclicked = millis();
    drawBackground = true;
    bg = loadImage("bg.jpg");
    bg.resize(width/2, height/2);
    image(bg, 0, 0, width, height);
    space.stop();
    pickedimage = cyan;
  }
}

void gree()
{
  if (mouseInRect(545, 400, 100, 150))
  {
    timeclicked = millis();
    drawBackground = true;
    bg = loadImage("bg.jpg");
    bg.resize(width/2, height/2);
    image(bg, 0, 0, width, height);
    space.stop();
    pickedimage = green;
  }
}

void victory()
{
  if (mouseInRect(795, 400, 100, 150))
  {
    timeclicked = millis();
    drawBackground = true;
    bg = loadImage("bg.jpg");
    bg.resize(width/2, height/2);
    image(bg, 0, 0, width, height);
    space.stop();
    pickedimage = pink;
  }
}
  


  
