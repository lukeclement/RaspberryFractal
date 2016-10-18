import java.lang.*;

public class Calculator extends Thread{
  private int id=0;
  private int secondary=0;
  private int secondaryTwo=0;
  private int width;
  private int height;
  private int[][] array;

  public Calculator(int id, int width, int height, int s, int st){
    this.id=id;
    this.width=width;
    this.height=height;
    secondary=s;
    secondaryTwo=st;
  }

  public void run(){
    //Making array
    array=new int[width/2][height/2];
    //Setting offsets
    int offsetX=0, offsetY=0;
    switch(id){
      case 0:offsetX=0;offsetY=0;
      break;
      case 1:offsetX=width/2;offsetY=0;
      break;
      case 2:offsetX=0;offsetY=height/2;
      break;
      case 3:offsetX=width/2;offsetY=height/2;
      break;
    }
    //finding madelbrots
    double q=0.5;
    for(int x=offsetX;x<offsetX+(width/2);x++){
      for(int y=offsetY;y<offsetY+(height/2);y++){
        double xii=(double)x;
        double yii=(double)y;
        double xxii=(double)width;
        double yyii=(double)height;


        double xi=q*((xii/xxii)-2);
        double yi=((double)y-(double)height/2.0)/((double)width/q);
        switch(secondary){
          case 0: xi=q*((xii/xxii)-3);
          break;
          case 1: xi=q*((xii/xxii)-2);
          break;
          case 2: xi=q*((xii/xxii)-1);
          break;
          case 3: xi=q*((xii/xxii)+0);
          break;

        }
        switch(secondaryTwo){
          case 0: yi=((double)y-0)/((double)width/q);
          break;
          case 1: yi=((double)y-(double)height)/((double)width/q);
          break;
        }

        //Setting up complex numbers
        Complex z=new Complex(0,0);
        Complex c=new Complex(xi,yi);
        Complex op=new Complex(1,1);
        int iteration=0;
        for(int i=0;i<255&&(z.getReal()<=2.0E+307||z.getImaginary()<=2.0E+307);i++){
          if(op.getReal()==z.getReal()&&op.getImaginary()==z.getImaginary()){
            iteration=255*255*255-2;
          }
          op.setReal(z.getReal());
          op.setImaginary(z.getImaginary());
          z=(z.square()).plus(c);

          ++iteration;

				}
        array[x-offsetX][y-offsetY]=iteration;
      }
    }
    System.out.println("Done "+id);
  }

  public int[][] getSector(){
    return array;
  }
}
