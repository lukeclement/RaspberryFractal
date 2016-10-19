import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.swing.JFrame;
//import com.sun.prism.paint.Paint;

public class main extends Canvas{
  public static final int Height=1024;
  public static final int Width=1280;
  public static int xid;
  public static int yid;

  public static void main(String[] args){
    JFrame frame = new JFrame();
		frame.setSize(Width, Height);
    main index = new main();
    xid=Integer.parseInt(args[0]);
    yid=Integer.parseInt(args[1]);
    frame.add(index);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(true);
    int it=24563;
    int p=it/(255*255);
    int o=(it/255)-p*255;
    int l=it-o*255-p*255*255;
    System.out.println(it+"="+p+":"+o+":"+l);
    frame.setTitle(args[0]+","+args[1]);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
  }

  public void paint(Graphics g){
    Scanner scan=new Scanner(System.in);
    //int beta=scan.nextInt();
    System.out.println(xid);
    int x=xid;
    int y=yid;
    Calculator[] pieces=new Calculator[4];
    for(int i=0;i<4;i++){
      pieces[i]=new Calculator(i,Width,Height,x,y);
      pieces[i].start();
    }
    for(int q=0;q<4;q++){
      try{
        pieces[q].join();
        int[][] a=pieces[q].getSector();
        int offsetX=0, offsetY=0;
        switch(q){
          case 0:offsetX=0;offsetY=0;
          break;
          case 1:offsetX=Width/2;offsetY=0;
          break;
          case 2:offsetX=0;offsetY=Height/2;
          break;
          case 3:offsetX=Width/2;offsetY=Height/2;
          break;
        }
        for(int i=offsetX;i<offsetX+Width/2;i++){
          for(int j=offsetY;j<offsetY+Height/2;j++){
            int it=a[i-offsetX][j-offsetY];
            int p=it/(255*255);
            int o=(it/255)-p*255;
            int l=it-o*255-p*255*255;
            g.setColor(new Color(l/3,l/2,l));
            //g.setColor(new Color(255,255,255));
            g.drawLine(i,j,i,j);
          }
        }
      }catch(Exception ex){}
    }
    System.out.println("Done");

  }
}
