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
    array=new int[width/2][height/4];
    
  }

  public int[][] getSector(){
    return array;
  }
}
