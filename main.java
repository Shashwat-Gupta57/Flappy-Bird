import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main{
    static JFrame f =  new JFrame("Flappy Bird By Shashwat Gupta");
    static Panel1 p = new Panel1();
    static Dimension scSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static void main(String args[]){
        ImageIcon i = new ImageIcon(System.getProperty("user.dir")+"\\res\\icon.png");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(scSize.width,scSize.height);
        f.setLocationRelativeTo(null);
        f.setIconImage(i.getImage());
        f.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){                
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_SPACE && !p.gameOver){
                    new Thread(() ->{
                        p.jumping = false;
                        p.jump();
                    }).start();
                }
            }
            public void keyReleased(KeyEvent e){
            }
        });
        f.setVisible(true);
        f.add(p);
    }
}