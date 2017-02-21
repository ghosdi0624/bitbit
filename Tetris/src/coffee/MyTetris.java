package coffee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JApplet;
public class MyTetris extends JApplet implements Runnable, KeyListener{
 
 Thread t = new Thread(this);
 static Graphics2D g2d;
 BufferedImage tempImage;
 
 public void init(){
  
  tempImage = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
  g2d = tempImage.createGraphics();
  
  setSize(500,500); 
  setVisible(true);
  t.start();
  
  addKeyListener(this);
 }
 
 public static void main(String[] args){
  
  new MyTetris();
  
  System.out.println("asdf");
 }
 
 public void run(){
  System.out.println("aaaa");
  
  int timer = 0;
  
  while(true){
   try{
    
    Thread.sleep(50);
    
    timer++;
    
    if(timer == 10){
     timer = 0;
     if(Map.current.checkStuck() == 1){
     }else{
      Map.current.y++;
     }
    }
    
    
    for(int i=0;i<Map.map.length;i++){
     Map.checkLine(Map.map[i], i);
    }
    
    
    repaint();
   }catch(Exception e){
    
   }
  }
 }
 public void paint(Graphics g){
  g2d.setColor(Color.WHITE);
  g2d.fillRect(0,0,500,500);
  
  g2d.setColor(Color.BLACK);
  
  for(int i=0;i<11;i++){
   g2d.drawLine(i*20, 0, i*20, 400);
  }
  
  for(int i=0;i<21;i++){
   g2d.drawLine(0, i*20, 200, i*20);
  }
  
  for(int i=0;i<Map.map.length;i++){
   for(int j=0;j<Map.map[0].length;j++){
    if(Map.map[i][j] == 1)
     Map.drawBlock(g, i, j);
   }
  }
  
  if(Map.current != null){
   for(int i=0;i<4;i++){
    for(int j=0;j<4;j++){
     if(Map.current.currentshape[i][j] == 1){
      Map.drawBlock(g, Map.current.y+i, Map.current.x+j);
     }
    }
   }
  }
  
  g2d.setColor(Color.BLACK);
  for(int i=0;i<5;i++){
   g2d.drawLine(280, 40+i*20, 360, 40+i*20);
  }
  
  for(int i=0;i<5;i++){
   g2d.drawLine(280+i*20, 40, 280+i*20, 120);
  }
  
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    if(Map.current.queueshape[i][j] == 1){
     Map.drawBlock(g, 2+i, 14+j);
    }
   }
  }
  
  g.drawImage(tempImage,0,0,this);
  
 }
 public void keyPressed(KeyEvent e){
  if(Map.current != null){
   if(e.getKeyCode() == KeyEvent.VK_RIGHT){
    if(Map.checkSideRight() == 0)
     Map.current.x++;
    
   } if(e.getKeyCode() == KeyEvent.VK_LEFT){
    if(Map.checkSideLeft() == 0)
     Map.current.x--;
    
   } if(e.getKeyCode() == KeyEvent.VK_DOWN){
    if(Map.current.checkStuck() == 1){
    }else{
     Map.current.y++;
    }
   } if(e.getKeyCode() == KeyEvent.VK_SPACE){
    while(Map.current.checkStuck() != 1){
     Map.current.y++;
    }
   } if(e.getKeyCode() == KeyEvent.VK_UP){
    int tempRotate = Map.current.rotate;
    
    Map.current.rotate++;
    Map.current.rotate %= 4;
    
    Shape tempShape = new Shape(Map.current.x, Map.current.y, Map.current.type, Map.current.rotate);
    
    for(int i=0;i<4;i++){
     for(int j=0;j<4;j++){
      if(tempShape.currentshape[i][j] == 1){
       if(((Map.current.x+j)<0)){
        System.out.println("ERROR");
        Map.current.rotate = tempRotate;
        break;
       }else if(((Map.current.x+j)>9)){
        System.out.println("error");
        Map.current.rotate = tempRotate;
        break;
       }
      }
     }
    }
    
    
    
    Map.current = new Shape(Map.current.x, Map.current.y, Map.current.type, Map.current.rotate, Map.current.queuetype);
   }
   
  }
 }
 public void keyReleased(KeyEvent e){
  
 }
 public void keyTyped(KeyEvent e){
  
 }
}
class Map{
 
 static int [][]map = new int[20][10];
 
 static Shape current = new Shape(3, 0, (int)(Math.random()*6), 0);
 
 
 public static void drawBlock(Graphics g, int y, int x){
  MyTetris.g2d.setColor(Color.BLACK);
  MyTetris.g2d.fillRect(x*20,y*20,20,20);
  MyTetris.g2d.setColor(Color.GREEN);
  MyTetris.g2d.drawRect(x*20,y*20,20,20);
 }
 
 public static void checkLine(int line[], int row){
  for(int i=0;i<line.length;i++){
   if(line[i] != 1){
    return; // 0, the line is not full.
   }
  }
  for(int i=row-1;i>=0;i--){
   for(int j=0;j<map[0].length;j++){
    map[i+1][j] = map[i][j];
   }
  }
  for(int i=0;i<map[0].length;i++){
   map[0][i] = 0;
  }
 }
 public static int checkSideRight(){
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    if(current.currentshape[i][j] == 1){
     if(((current.x+j+1)>9) || map[current.y+i][current.x+j+1]== 1){
      System.out.println("error");
      return 1;
     }
    }
   }
  }
  
  return 0;
 }
 public static int checkSideLeft(){
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    if(current.currentshape[i][j] == 1){
     if(((current.x+j-1)<0) || map[current.y+i][current.x+j-1] == 1){
      System.out.println("Error");
      return 1;
     }
    }
   }
  }
  
  return 0;
 }
}
class Shape{
 
 static int x;
 static int y;
 
 static int shape[][][][] =     //  shape [type] [rotate] [y] [x]
       {{{ {0,1,0,0},
        {0,1,1,0},
        {0,0,1,0},
        {0,0,0,0}},
       
       { {0,0,0,0},
        {0,0,1,1},
        {0,1,1,0},
        {0,0,0,0}},
        
       { {0,1,0,0},
        {0,1,1,0},
        {0,0,1,0},
        {0,0,0,0}},
        
       { {0,0,0,0},
        {0,0,1,1},
        {0,1,1,0},
        {0,0,0,0}}},
        
       
       {{ {0,0,1,0},
        {0,1,1,0},
        {0,1,0,0},
        {0,0,0,0}},
        
       { {0,0,0,0},
        {1,1,0,0},
        {0,1,1,0},
        {0,0,0,0}},
        
       { {0,0,1,0},
        {0,1,1,0},
        {0,1,0,0},
        {0,0,0,0}},
         
       { {0,0,0,0},
        {1,1,0,0},
        {0,1,1,0},
        {0,0,0,0}}},
        
        
       {{ {0,0,0,0},
        {0,1,1,0},
        {0,1,1,0},
        {0,0,0,0}},
         
       { {0,0,0,0},
        {0,1,1,0},
        {0,1,1,0},
        {0,0,0,0}},
         
       { {0,0,0,0},
        {0,1,1,0},
        {0,1,1,0},
        {0,0,0,0}},
          
       { {0,0,0,0},
        {0,1,1,0},
        {0,1,1,0},
        {0,0,0,0}}},
        
       
       
       {{ {0,0,1,0},
        {0,0,1,0},
        {0,0,1,0},
        {0,0,1,0}},
         
       { {0,0,0,0},
        {1,1,1,1},
        {0,0,0,0},
        {0,0,0,0}},
         
       { {0,0,1,0},
        {0,0,1,0},
        {0,0,1,0},
        {0,0,1,0}},
         
       { {0,0,0,0},
        {1,1,1,1},
        {0,0,0,0},
        {0,0,0,0}}},
        
        
       {{ {0,0,0,0},
        {0,1,1,0},
        {0,0,1,0},
        {0,0,1,0}},
        
       { {0,0,0,0},
        {0,1,1,1},
        {0,1,0,0},
        {0,0,0,0}},
        
       { {0,1,0,0},
        {0,1,0,0},
        {0,1,1,0},
        {0,0,0,0}},
         
       { {0,0,0,0},
        {0,0,1,0},
        {1,1,1,0},
        {0,0,0,0}}},
        
        
       {{ {0,0,0,0},
        {0,1,1,0},
        {0,1,0,0},
        {0,1,0,0}},
         
       { {0,0,0,0},
        {0,1,0,0},
        {0,1,1,1},
        {0,0,0,0}},
         
       { {0,0,1,0},
        {0,0,1,0},
        {0,1,1,0},
        {0,0,0,0}},
          
       { {0,0,0,0},
        {1,1,1,0},
        {0,0,1,0},
        {0,0,0,0}}}};
       
       
 
 int currentshape[][] = new int[4][4];
 int type;
 
 int queueshape[][] = new int[4][4];
 int queuetype;
 
 int rotate;
 
 public Shape(int x, int y, int type, int rotate){
  this.x = x;
  this.y = y;
  
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    currentshape[i][j] = shape[type][rotate][i][j];
   }
  }
  
  this.type = type;
  
  this.queuetype = (int)(Math.random()*6);
  
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    queueshape[i][j] = shape[queuetype][0][i][j];
   }
  }
  
  this.rotate = rotate;
 }
 
 public Shape(int x, int y, int type, int rotate, int queuetype){
  this.x = x;
  this.y = y;
  
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    currentshape[i][j] = shape[type][rotate][i][j];
   }
  }
  
  this.type = type;
  
  this.queuetype = queuetype;
    
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    queueshape[i][j] = shape[queuetype][0][i][j];
   }
  }
  
  this.rotate = rotate;
 }
 
 public int checkStuck(){
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    
    if(currentshape[i][j] == 1){
     
     if((y+i==19) || (Map.map[y+i+1][x+j]==1)){
      
      drawStuck(y, x);
      
      type = (int)(Math.random()*6);
      System.out.println(type);
      
      Map.current = new Shape(3,0,queuetype, 0);
      
      return 1;
     }
    }
   }
  }
  return 0;
 }
 
 public void drawStuck(int y, int x){
  for(int i=0;i<4;i++){
   for(int j=0;j<4;j++){
    if(currentshape[i][j] == 1){
     Map.map[y+i][x+j] = 1;
    }
   }
  }
 }
}
