import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class bird extends Rectangle{
    ImageIcon b = new ImageIcon(System.getProperty("user.dir")+"\\res\\bird.png");
    main m = new main();
    bird(int x,int y){
        this.x = x;
        this.y = y;
        this.width = 15;
        this.height = 9;
    }
    public void draw(Graphics g){
        if(m.p.gameOver){
            Graphics2D g2 = (Graphics2D)g.create();
            g2.translate(x + b.getIconWidth() / 2, y + b.getIconHeight() / 2);
            g2.rotate(Math.toRadians(75));
            g2.drawImage(b.getImage(), -b.getIconWidth() / 2, -b.getIconHeight() / 2, null);
        }else{
            g.drawImage(b.getImage(), x, y, null);
        }
    }
}