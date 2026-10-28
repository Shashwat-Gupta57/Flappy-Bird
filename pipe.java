import java.awt.*;
import javax.swing.*;

public class pipe extends Rectangle{
    ImageIcon p = new ImageIcon(System.getProperty("user.dir")+"\\res\\pipe.png");
    pipe(int x,int y){
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 600;
    }
    public void draw(Graphics g){
        g.drawImage(p.getImage(), x, y, null);
    }
}