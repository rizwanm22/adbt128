class Button
{
  boolean on;
  float centreX;
  float centreY;

  Button()
  {
    on = false;
    centreX = width/2;
    centreY = height/2;
  }

  void display() 
  {
    if (on == false) 
    {
      fill(255);
    } 
    else if (on == true) 
    {
      fill(255);
    }
    rect(centreX - 30, centreY - 30, 60, 60);
  }
  
  boolean check()
  {
    if (mouseX > centreX - 30 && mouseX < centreX + 30)
    {
      if (mouseY > centreY - 30 && mouseY < centreY + 30)
      {
        return true;
      }
    }
    return false;
  }
  
}
