import java.awt.Color;


public class Player extends Polkadot{
	private double dy;
	private double dx;
	 /**
	    * The number of pixels (change in y) the player will move vertically each time 
	    * move() is called.  If y is positive, the player will move down.  
	    * If y is negative, the player will move to the up.
	    */ 

	public Player(){
		super(200, 200, 50, Color.BLACK);
		 dy = (Math.random() * 13) - 6; 
	}
	 public Player(double x, double y,double dia, Color c)
	   {
		 super(x, y, dia ,c);
		  dy = (Math.random() * 13) - 6;
	      
	   }
	 
	 public void setdy(double y)
	   {
	      dy = y;
	   }
	   
	 public void setdx(double x){
		 dx=x;
	 }
	 public  double getdy(){
		 return dy;
	 }
	 public double getdx(){
		 return dx;
	 }
	 public void move(double rightEdge, double bottomEdge)
	   {
	      
	      setX(getX()+dx);
	      setY(getY() + dy);                
	      
	      
	    
	       // If the ball hits the bottom edge, change dy (the direction the ball travels)
	   
	      if (getY() >= 800 - getRadius())
	      {
	         //setY(bottomEdge - getRadius());
	         
	         dy = dy * -1;
	      }   
	       // If the ball hits the top edge, change dy (the direction the ball travels)
	      
	      else if (getY() <= 200 + getRadius())
	      {
	         //setY(0 + getRadius());
	         
	         dy =dy * -1;
	         
	      
	        
	      }  
	      if(getX() >= rightEdge - getRadius())     
	      {
	         // place the ball on the right edge of screen
	         setX(50);
	         
	         // change directions (now move left)
	         dx = dx * -1; 
	      }
	      // If the ball hits the left edge, change dx (the direction the ball travels)
	      else if (getX() <= 0 + getRadius())
	      {
	         setX(975);
	         
	         dx= dx * -1;
	        
	      
//	      }  
//	   // Translation:  The x-coord of the ball (center) is past the right edge - radius of the ball
//	      if(getX() >= rightEdge - getRadius())     
//	      {
//	         // place the ball on the right edge of screen
//	         setX(rightEdge - getRadius());
//	         
//	         // change directions (now move left)
//	         dx = dx * -1; 
//	      }
//	      // If the ball hits the left edge, change dx (the direction the ball travels)
//	      else if (getX() <= 0 + getRadius())
//	      {
//	         setX(0 + getRadius());
//	         
//	         dx= dx * -1;
//	        
	      
	      }  
	   }
}
