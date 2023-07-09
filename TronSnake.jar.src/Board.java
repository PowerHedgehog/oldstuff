/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.sound.sampled.AudioInputStream;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import javax.sound.sampled.Clip;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class Board extends JPanel implements ActionListener {
/*  17 */   private final int B_WIDTH = 300;
/*  18 */   private final int B_HEIGHT = 300;
/*  19 */   private final int DOT_SIZE = 10;
/*  20 */   private final int ALL_DOTS = 900;
/*  21 */   private final int RAND_POS = 29;
/*  22 */   private final int DELAY = 140;
/*     */   
/*  24 */   private final int[] x1 = new int[900];
/*  25 */   private final int[] y1 = new int[900];
/*  26 */   private final int[] x2 = new int[900];
/*  27 */   private final int[] y2 = new int[900];
/*     */   
/*     */   private int dots1;
/*     */   private int dots2;
/*     */   private int apple_x;
/*     */   private int apple_y;
/*     */   private boolean leftDirection1;
/*     */   private boolean leftDirection2 = false;
/*     */   private boolean rightDirection1;
/*     */   private boolean rightDirection2 = true;
/*     */   private boolean upDirection1;
/*     */   private boolean upDirection2 = false;
/*     */   private boolean downDirection1;
/*     */   private boolean downDirection2 = false;
/*     */   private boolean inGame = true;
/*     */   private Timer timer;
/*     */   private JButton playAgain;
/*     */   private Clip mainClip;
/*     */   
/*     */   public Board() {
/*  47 */     addKeyListener(new TAdapter(null));
/*  48 */     setBackground(Color.black);
/*  49 */     setFocusable(true);
/*     */     
/*  51 */     setPreferredSize(new Dimension(300, 300));
/*  52 */     initGame();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initGame() {
/*     */     try {
/*  58 */       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("99705__knarmahfox__overworld-full.wav"));
/*  59 */       this.mainClip = AudioSystem.getClip();
/*  60 */       this.mainClip.open(audioInputStream);
/*  61 */       this.mainClip.start();
/*  62 */     } catch (Exception ex) {
/*  63 */       System.out.println("Error with playing sound.");
/*  64 */       ex.printStackTrace();
/*     */     } 
/*     */     
/*  67 */     this.dots1 = 3;
/*  68 */     this.dots2 = 3;
/*     */     int z;
/*  70 */     for (z = 0; z < this.dots1; z++) {
/*  71 */       this.x1[z] = 50 + z * 10;
/*  72 */       this.y1[z] = 50;
/*     */     } 
/*  74 */     for (z = 0; z < this.dots2; z++) {
/*  75 */       this.x2[z] = 150 - z * 10;
/*  76 */       this.y2[z] = 50;
/*     */     } 
/*     */ 
/*     */     
/*  80 */     locateApple();
/*     */     
/*  82 */     this.timer = new Timer(140, this);
/*  83 */     this.timer.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void paintComponent(Graphics g) {
/*  88 */     super.paintComponent(g);
/*     */     
/*  90 */     String msg = "TronSnake v.2.2 by avalS";
/*  91 */     Font small = new Font("Helvetica", 2, 10);
/*  92 */     FontMetrics metr = getFontMetrics(small);
/*     */     
/*  94 */     g.setColor(Color.green);
/*  95 */     g.setFont(small);
/*  96 */     g.drawString(msg, (300 - metr.stringWidth(msg)) / 2, 300);
/*     */     
/*  98 */     doDrawing(g);
/*     */   }
/*     */ 
/*     */   
/*     */   private void doDrawing(Graphics g) {
/* 103 */     if (this.inGame) {
/*     */       
/* 105 */       g.setColor(Color.yellow);
/* 106 */       g.fillOval(this.apple_x, this.apple_y, 10, 10);
/*     */       int z;
/* 108 */       for (z = 0; z < this.dots1; z++) {
/* 109 */         if (z == 0) {
/* 110 */           g.setColor(Color.red);
/* 111 */           g.fillRect(this.x1[z], this.y1[z], 10, 10);
/*     */         } else {
/* 113 */           g.setColor(Color.green);
/* 114 */           g.fillRect(this.x1[z], this.y1[z], 10, 10);
/*     */         } 
/*     */       } 
/*     */       
/* 118 */       for (z = 0; z < this.dots2; z++) {
/* 119 */         if (z == 0) {
/* 120 */           g.setColor(Color.red);
/* 121 */           g.drawRect(this.x2[z], this.y2[z], 10, 10);
/*     */         } else {
/* 123 */           g.setColor(Color.green);
/* 124 */           g.drawRect(this.x2[z], this.y2[z], 10, 10);
/*     */         } 
/*     */       } 
/*     */       
/* 128 */       Toolkit.getDefaultToolkit().sync();
/*     */     }
/*     */     else {
/*     */       
/* 132 */       gameOver(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void gameOver(Graphics g) {
/* 137 */     this.mainClip.stop();
/*     */     try {
/* 139 */       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("135831__davidbain__end-game-fail.wav"));
/* 140 */       Clip clip = AudioSystem.getClip();
/* 141 */       clip.open(audioInputStream);
/* 142 */       clip.start();
/* 143 */     } catch (Exception ex) {
/* 144 */       System.out.println("Error with playing sound.");
/* 145 */       ex.printStackTrace();
/*     */     } 
/*     */     
/* 148 */     String msg1 = "Game Over";
/* 149 */     String msg2 = "Score: " + (this.dots1 + this.dots2 - 6);
/* 150 */     Font small = new Font("Helvetica", 1, 14);
/* 151 */     FontMetrics metr = getFontMetrics(small);
/*     */     
/* 153 */     g.setColor(Color.white);
/* 154 */     g.setFont(small);
/* 155 */     g.drawString(msg1, (300 - metr.stringWidth(msg1)) / 2, 150);
/* 156 */     g.drawString(msg2, (300 - metr.stringWidth(msg2)) / 2, 150 + metr.stringWidth(msg1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkApple() {
/* 162 */     if (this.x1[0] == this.apple_x && this.y1[0] == this.apple_y) {
/*     */       
/* 164 */       this.dots1++;
/* 165 */       locateApple();
/*     */       
/*     */       try {
/* 168 */         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("109662__grunz__success.wav"));
/* 169 */         Clip clip = AudioSystem.getClip();
/* 170 */         clip.open(audioInputStream);
/* 171 */         clip.start();
/* 172 */       } catch (Exception ex) {
/* 173 */         System.out.println("Error with playing sound.");
/* 174 */         ex.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 179 */     if (this.x2[0] == this.apple_x && this.y2[0] == this.apple_y) {
/*     */       
/* 181 */       this.dots2++;
/* 182 */       locateApple();
/*     */       
/*     */       try {
/* 185 */         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("109662__grunz__success.wav"));
/* 186 */         Clip clip = AudioSystem.getClip();
/* 187 */         clip.open(audioInputStream);
/* 188 */         clip.start();
/* 189 */       } catch (Exception ex) {
/* 190 */         System.out.println("Error with playing sound.");
/* 191 */         ex.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void move() {
/*     */     int z;
/* 200 */     for (z = this.dots1; z > 0; z--) {
/* 201 */       this.x1[z] = this.x1[z - 1];
/* 202 */       this.y1[z] = this.y1[z - 1];
/*     */     } 
/*     */     
/* 205 */     if (this.leftDirection1) {
/* 206 */       this.x1[0] = this.x1[0] - 10;
/*     */     }
/*     */     
/* 209 */     if (this.rightDirection1) {
/* 210 */       this.x1[0] = this.x1[0] + 10;
/*     */     }
/*     */     
/* 213 */     if (this.upDirection1) {
/* 214 */       this.y1[0] = this.y1[0] - 10;
/*     */     }
/*     */     
/* 217 */     if (this.downDirection1) {
/* 218 */       this.y1[0] = this.y1[0] + 10;
/*     */     }
/*     */ 
/*     */     
/* 222 */     for (z = this.dots2; z > 0; z--) {
/* 223 */       this.x2[z] = this.x2[z - 1];
/* 224 */       this.y2[z] = this.y2[z - 1];
/*     */     } 
/*     */     
/* 227 */     if (this.leftDirection2) {
/* 228 */       this.x2[0] = this.x2[0] - 10;
/*     */     }
/*     */     
/* 231 */     if (this.rightDirection2) {
/* 232 */       this.x2[0] = this.x2[0] + 10;
/*     */     }
/*     */     
/* 235 */     if (this.upDirection2) {
/* 236 */       this.y2[0] = this.y2[0] - 10;
/*     */     }
/*     */     
/* 239 */     if (this.downDirection2) {
/* 240 */       this.y2[0] = this.y2[0] + 10;
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkCollision() {
/*     */     int z;
/* 246 */     for (z = this.dots1; z > 0; z--) {
/*     */       
/* 248 */       if (z > 4 && this.x1[0] == this.x1[z] && this.y1[0] == this.y1[z])
/*     */       {
/* 250 */         this.inGame = false;
/*     */       }
/*     */     } 
/*     */     
/* 254 */     for (z = this.dots2; z > 0; z--) {
/*     */       
/* 256 */       if (z > 4 && this.x2[0] == this.x2[z] && this.y2[0] == this.y2[z])
/*     */       {
/* 258 */         this.inGame = false;
/*     */       }
/*     */     } 
/*     */     
/* 262 */     for (z = this.dots1; z >= 0; z--) {
/*     */       
/* 264 */       if (this.x1[z] == this.x2[0] && this.y1[z] == this.y2[0])
/* 265 */         this.inGame = false; 
/*     */     } 
/* 267 */     for (z = this.dots2; z >= 0; z--) {
/*     */       
/* 269 */       if (this.x2[z] == this.x1[0] && this.y2[z] == this.y1[0]) {
/* 270 */         this.inGame = false;
/*     */       }
/*     */     } 
/* 273 */     if (this.y1[0] >= 300 || this.y2[0] >= 300) {
/* 274 */       this.inGame = false;
/*     */     }
/*     */     
/* 277 */     if (this.y1[0] < 0 || this.y2[0] < 0) {
/* 278 */       this.inGame = false;
/*     */     }
/*     */     
/* 281 */     if (this.x1[0] >= 300 || this.x2[0] >= 300) {
/* 282 */       this.inGame = false;
/*     */     }
/*     */     
/* 285 */     if (this.x1[0] < 0 || this.x2[0] < 0) {
/* 286 */       this.inGame = false;
/*     */     }
/*     */     
/* 289 */     if (!this.inGame) {
/* 290 */       this.timer.stop();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void locateApple() {
/* 296 */     int r = (int)(Math.random() * 29.0D);
/* 297 */     this.apple_x = r * 10;
/*     */     
/* 299 */     r = (int)(Math.random() * 29.0D);
/* 300 */     this.apple_y = r * 10;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 306 */     if (this.inGame) {
/*     */       
/* 308 */       checkApple();
/* 309 */       checkCollision();
/* 310 */       move();
/*     */     } 
/*     */     
/* 313 */     repaint();
/*     */   }
/*     */   
/*     */   private class TAdapter
/*     */     extends KeyAdapter {
/*     */     private TAdapter() {}
/*     */     
/*     */     public void keyPressed(KeyEvent e) {
/* 321 */       int key = e.getKeyCode();
/*     */       
/* 323 */       if (key == 37 && !Board.this.rightDirection1) {
/* 324 */         Board.this.leftDirection1 = true;
/* 325 */         Board.this.upDirection1 = false;
/* 326 */         Board.this.downDirection1 = false;
/*     */       } 
/* 328 */       if (key == 65 && !Board.this.rightDirection2) {
/* 329 */         Board.this.leftDirection2 = true;
/* 330 */         Board.this.upDirection2 = false;
/* 331 */         Board.this.downDirection2 = false;
/*     */       } 
/*     */       
/* 334 */       if (key == 39 && !Board.this.leftDirection1) {
/* 335 */         Board.this.rightDirection1 = true;
/* 336 */         Board.this.upDirection1 = false;
/* 337 */         Board.this.downDirection1 = false;
/*     */       } 
/* 339 */       if (key == 68 && !Board.this.leftDirection2) {
/* 340 */         Board.this.rightDirection2 = true;
/* 341 */         Board.this.upDirection2 = false;
/* 342 */         Board.this.downDirection2 = false;
/*     */       } 
/*     */       
/* 345 */       if (key == 38 && !Board.this.downDirection1) {
/* 346 */         Board.this.upDirection1 = true;
/* 347 */         Board.this.rightDirection1 = false;
/* 348 */         Board.this.leftDirection1 = false;
/*     */       } 
/* 350 */       if (key == 87 && !Board.this.downDirection2) {
/* 351 */         Board.this.upDirection2 = true;
/* 352 */         Board.this.rightDirection2 = false;
/* 353 */         Board.this.leftDirection2 = false;
/*     */       } 
/*     */       
/* 356 */       if (key == 40 && !Board.this.upDirection1) {
/* 357 */         Board.this.downDirection1 = true;
/* 358 */         Board.this.rightDirection1 = false;
/* 359 */         Board.this.leftDirection1 = false;
/*     */       } 
/* 361 */       if (key == 83 && !Board.this.upDirection2) {
/* 362 */         Board.this.downDirection2 = true;
/* 363 */         Board.this.rightDirection2 = false;
/* 364 */         Board.this.leftDirection2 = false;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Slava\Desktop\TronSnake.jar!\Board.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */