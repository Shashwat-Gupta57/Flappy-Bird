import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.nio.file.*;
public class Panel1 extends JPanel{
    Dimension scSize = Toolkit.getDefaultToolkit().getScreenSize();
    int p1x = scSize.width+50,p2x = scSize.width+450,p3x = scSize.width+850,p4x = scSize.width+1250,p5x = scSize.width+1650;
    int p1y = scSize.height/2,p2y = 300,p3y = 400,p4y = 600,p5y = 700;
    int score = 0,speed = 2,highScore = 0;
    Font sF = null;
    boolean gameOver = false,jumping = false,started = false,scored1 = false,scored2 = false,scored3 = false,scored4 = false,scored5 = false;
    Image bg = new ImageIcon(System.getProperty("user.dir")+"\\res\\background.jpg").getImage();
    int x = scSize.width/2,y = scSize.height/2-200;
    JButton start;
    Thread gT,m;
    pipe p1,p2,p3,p4,p5;
    inverted_pipe ip1,ip2,ip3,ip4,ip5;
    bird b;
    main ma = new main();
    Panel1(){
        try{
            sF = Font.createFont(Font.TRUETYPE_FONT,new File(System.getProperty("user.dir")+"\\res\\Font.TTF"));
            sF = sF.deriveFont(70.0f);
        }catch (FontFormatException | IOException ffe){
            ffe.printStackTrace();
        }
        setLayout(null);
        new Thread(() ->{
            while(true){
                if(!gameOver && !jumping && started){
                    y += 6;
                    try{
                        Thread.sleep(20);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }else{
                    try{
                        Thread.sleep(0);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        }).start();
        start = new JButton("\u25B6");
        start.setSize(200,50);
        start.setFont(new Font(start.getFont().getName(),Font.PLAIN,40));
        start.setBorderPainted(false);
        start.setLocation((scSize.width/2)-100,scSize.height/2);
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                started = true;
                ma.f.requestFocusInWindow();
                p1x = scSize.width+50;
                p2x = scSize.width+450;
                p3x = scSize.width+850;
                p4x = scSize.width+1250;
                p5x = scSize.width+1650;
                p1y = scSize.height/2;
                p2y = 300;
                p3y = 400;
                p4y = 600;
                p5y = 700;
                x = scSize.width/2;
                y = scSize.height/2-200;
                score = 0;
                speed = 2;
                gameOver = false;
                remove(start);
                repaint();
            }
        });
        start.setFocusable(false);
        start.setBackground(Color.white);
        start.setForeground(new Color(100,100,100));
        m = new Thread(() -> {
            while(true){
                if(!gameOver && started){
                    p1x-= speed;
                    p2x-= speed;
                    p3x-= speed;
                    p4x-= speed;
                    p5x-= speed;
                    try{
                        Thread.sleep(8);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }else{
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        });
        m.setPriority(m.MAX_PRIORITY);
        
        try{
            highScore = Integer.parseInt(Files.lines(Paths.get(System.getProperty("user.dir")+"\\res\\saves.txt")).findFirst().orElse(String.valueOf(0)));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public void paint(Graphics g){
        super.paint(g);
        if(!started && !gameOver){
            g.drawImage(bg,0,0,getWidth(),getHeight(),this);
            b = new bird(x,y);
            b.draw(g);
            g.setFont(sF);
            g.setColor(new Color(250,250,250));//63,78,186
            g.drawString("Flappy  Bird",scSize.width/2-200,scSize.height/2-300);
            g.drawString("Developed By Shashwat Gupta",scSize.width/2-470,scSize.height/2-220);
            g.setColor(new Color(250,250,250));
            g.drawString("HI  "+highScore,100,100);
            g.setColor(Color.red);
            g.drawString("PRESS SPACE TO JUMP !",scSize.width/2-300,scSize.height-70);
            add(start);
            start.repaint();
        }else if(gameOver){
            g.drawImage(bg,0,0,getWidth(),getHeight(),this);
            b = new bird(x,y);
            p1.draw(g);
            p2.draw(g);
            p3.draw(g);
            p4.draw(g);
            p5.draw(g);
            ip1.draw(g);
            ip2.draw(g);
            ip3.draw(g);
            ip4.draw(g);
            ip5.draw(g);
            b.draw(g);
            g.setFont(sF);
            g.setColor(new Color(250,250,250));
            if(score < 10){
                g.drawString("00"+score,scSize.width/2-60,100);
            }else if(score < 100){
                g.drawString("0"+score,scSize.width/2-60,100);
            }else{
                g.drawString(""+score,scSize.width/2-60,100);
            }
            g.setColor(new Color(242, 120, 107));
            g.drawString("GAME OVER",scSize.width/2-150,scSize.height/2-50);
            g.setFont(sF);
            g.setColor(new Color(250,250,250));
            g.drawString("HI  "+highScore,100,100);
            add(start);
            start.repaint();
        }else{
        g.drawImage(bg,0,0,getWidth(),getHeight(),this);
        b = new bird(x,y);
        p1 = new pipe(p1x,p1y);
        p2 = new pipe(p2x,p2y);
        p3 = new pipe(p3x,p3y);
        p4 = new pipe(p4x,p4y);
        p5 = new pipe(p5x,p5y);
        ip1 = new inverted_pipe(p1x,p1y-800);
        ip2 = new inverted_pipe(p2x,p2y-800);
        ip3 = new inverted_pipe(p3x,p3y-800);
        ip4 = new inverted_pipe(p4x,p4y-800);
        ip5 = new inverted_pipe(p5x,p5y-800);
        p1.draw(g);
        p2.draw(g);
        p3.draw(g);
        p4.draw(g);
        p5.draw(g);
        ip1.draw(g);
        ip2.draw(g);
        ip3.draw(g);
        ip4.draw(g);
        ip5.draw(g);
        b.draw(g);
        g.setFont(sF);
        g.setColor(new Color(250,250,250));
        if(score < 10){
            g.drawString("00"+score,scSize.width/2-60,100);
        }else if(score < 100){
            g.drawString("0"+score,scSize.width/2-60,100);
        }else{
            g.drawString(""+score,scSize.width/2-60,100);
        }
        g.drawString("HI  "+highScore,100,100);
        if(x > p1x+100){
            scored1 = false;
        }else if(x > p1x && x < p1x+100 && !scored1){
            scored1 = true;
            score++;
        }
        if(x > p2x+100){
            scored2 = false;
        }else if(x > p2x && x < p2x+100 && !scored2){
            scored2 = true;
            score++;
        }
        if(x > p3x+100){
            scored3 = false;
        }else if(x > p3x && x < p3x+100 && !scored3){
            scored3 = true;
            score++;
        }
        if(x > p4x+100){
            scored4 = false;
        }else if(x > p4x && x < p4x+100 && !scored4){
            scored4 = true;
            score++;
        }
        if(x > p5x+100){
            scored5 = false;
        }else if(x > p5x && x < p5x+100 && !scored5){
            scored5 = true;
            score++;
        }
        if(p1x < -110){
            p1x = p5x+400;
            p1y = (int)(Math.random()*400)+300;
        }
        if(p2x < -110){
            p2x = p1x+400;
            p2y = (int)(Math.random()*400)+300;
        }
        if(p3x < -110){
            p3x = p2x+400;
            p3y = (int)(Math.random()*400)+300;
        }
        if(p4x < -110){
            p4x = p3x+400;
            p4y = (int)(Math.random()*400)+300;
        }
        if(p5x < -110){
            p5x = p4x+400;
            p5y = (int)(Math.random()*400)+300;
        }
        if(!m.isAlive()){
            m.start();
        }
        if((b.intersects(p1) || b.intersects(p2) || b.intersects(p3) || b.intersects(p4) || b.intersects(p5) || b.intersects(ip1) || b.intersects(ip2) || b.intersects(ip3) || b.intersects(ip4) || b.intersects(ip5) || y < 1 || y > scSize.height-170) && !gameOver){
            gameOver = true;
            started = false;
            if(score > highScore){
                highScore = score;
                try{
                    Files.write(Paths.get(System.getProperty("user.dir")+"\\res\\saves.txt"),String.valueOf(highScore).getBytes());
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            new Thread(() ->{
                while(y < scSize.height-170){
                    y++;
                    b = new bird(x,y);
                    b.draw(g);
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                    repaint();
                }
            }).start();
        }
            repaint();
        }
    }
    public void jump(){
        jumping = true;
        for(int i = 0;i < 100;i++){
            y-= 1;
            try{
                Thread.sleep(4);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            if(!jumping){
                break;
            }
        }
        for(int i = 0;i < 15;i++){
            y-=1;
            try{
                Thread.sleep(7);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            if(!jumping){
                break;
            }
        }
        jumping = false;
    }
}