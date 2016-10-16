import java.lang.*;

public class Calculator extends Thread{
  private int id=0;
  private int width;
  private int height;
  private int[][] array;

  public Calculator(int id, int width, int height){
    this.id=id;
    this.width=width;
    this.height=height;
  }

  public void run(){
    //Making array
    array=new int[width/2][height/2];
    //Setting offsets
    int offsetX, offsetY;
    switch(id){
      case 0:offsetX=0;offsetY=0;
      break;
      case 1:offsetX=width/2;offsetY=0;
      break;
      case 2:offsetX=0;offsetY=height/2;
      break;
      case 3:offsetX=width/2;offsetY=height/2
      break;
    }
    //finding madelbrots
    for(int x=offsetX;x<offsetX+(width/2);x++){
      for(int y=offsetY;y<offsetY+(height/2);y++){
        double xi=((double)x-(double)width/2.0)/((double)width/4.0);
        double yi=((double)y-(double)height/2.0)/((double)height/4.0);

        //Setting up complex numbers
        Complex z=new Complex(0,0);
        Complex c=new Complex(xi,yi);
        int iteration=0;
        for(int i=0;i<255&&(z.getReal()<=2.0E+307||z.getImaginary()<=2.0E+307);i++){
					z=(z.square()).plus(c);
					++iteration;
				}
        g.setColor(new Color(0,0,iteration));
      }
    }
  }

  public int[][] getSector(){
    return array;
  }
}
