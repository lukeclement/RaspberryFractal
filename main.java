import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.swing.JFrame;
import com.sun.prism.paint.Paint;

public class main extends Canvas{
  public static final int Height=1024;
  public static final int Width=1280;

  public static void main(String[] args){
    JFrame frame = new JFrame();
		frame.setSize(Width, Height);
    main index = new main();
    frame.add(index);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
  }

  public void paint(Graphics g){

  }
}
