// Billington.  email: mlbillington@fcps.edu
// version: 7.25.2007
// updated by Phil Ero 16NOV07

import java.awt.*;
   
public class Polkadot
{
      
   private double myX;         
   private double myY;
   private double myDiameter;
   private Color myColor; 
   private double myRadius;

   /**
    * Creates a red polkadot at (200, 200) with a diamenter of 25.
    */ 
   public Polkadot()    
   {
      myX = 200;
      myY = 200;
      myDiameter = 25;
      myColor = Color.RED;
      myRadius = myDiameter/2;
   }

   /**
    * Creates a polkadot of color c at (x, y) with a diameter of d.
    * @param x the x-coordinate of the center of the polkadot
    * @param y the y-coordinate of the center of the polkadot
    * @param d the diameter of the polkadot
    * @param c the color of the polkadot
    */ 
   public Polkadot(double x, double y, double d, Color c)
   {
      myX = x;
      myY = y;
      myDiameter = d;
      myColor = c;
      myRadius = d/2;
   }

   /**********************
    *                    *
    *  Accessor Methods  *
    *                    *
    **********************/

   
   /**
    * Gets the x-coordinate
    * @return the x-coordinate
    */
   public double getX() 
   { 
      return myX;
   }
		
	/**
    * gets the y-coordinate
    * @return the y-coordinate
    */	
   public double getY()      
   { 
      return myY;
         
   }
		
	/**
    * gets the diameter    
    * @return the diameter
    */	
   public double getDiameter() 
   { 
      return myDiameter;
        
   }
		
	/**
    * gets myColor
    * @returns myColor
    */	
   public Color getColor() 
   { 
      return myColor; 
         //_______________
   }
		
	/**
    * gets the radius
    * @returns myRadius
    */	
   public double getRadius() 
   { 
      return myRadius;
   }
		
	
   /**********************
    *                    *
    *  Modifier Methods  *
    *                    *
    **********************/



   /**
    * Sets the x-coordinate to be x
    * @param x the x-coordinate
    */
   public void setX(double x)
   {
      myX = x;
   }
		
	/**
    * sets the y coordinate
    * @param y the y-coordinate
    */		 
   public void setY(double y)
   {
      myY = y;
   }
		
	/**
    * sets the color    
    * @param c = myColor
    */	 
   public void setColor(Color c)
   {
      myColor = c;
   }
		
	/**
    * sets the diameter and the radius
    * @param d = diameter 
    *@param d/2 = radius
    */	
   public void setDiameter(double d)
   {
      myDiameter = d;
      myRadius = d/2;
   }
		
	/**
    * Sets the radius and the diameter
    * @param r = radius
    * @param 2*r = diameter
    */	
   public void setRadius(double r)
   {
      myRadius = r;
      myDiameter = 2*r;
   }
		
		
   /************************************************
    *
    *      Instance Methods 
    *
    ************************************************/
   
   /*
    * Moves location to random (x, y) withing the edges or given dimensions of
    * the right edge and bottom edge
    * @param rightEdge the right side of the screen or area
    * @param bottomEdge the bottom side of the screen or area
    */	 
   public void jump(int rightEdge, int bottomEdge)
   {
      // moves location to random (x, y) within the edges
      myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
      myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
   }
		
	/**
    * Draws the polkadot of the given color
    * @param myBuffer the grapics object
    */	
   public void draw(Graphics myBuffer) 
   {
      myBuffer.setColor(myColor);
      myBuffer.fillOval((int)(myX - myRadius), (int)(myY-myRadius), (int)myDiameter, (int)myDiameter);
   }
}