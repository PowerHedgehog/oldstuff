/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Window extends JPanel {
/*    */   private JButton left;
/*    */   private JButton middle;
/*    */   private JButton right;
/*  9 */   private Character player = new Character(1); private JButton rightest; private JLabel labelTop; private JLabel labelBottom; private JPanel buttonPanel;
/* 10 */   private Character slime = new Character(3);
/*    */   
/*    */   public Window() {
/* 13 */     this.left = new JButton("Attack health");
/* 14 */     this.middle = new JButton("Attack mana");
/* 15 */     this.right = new JButton("Heal");
/* 16 */     this.rightest = new JButton("Generate Mana");
/* 17 */     ButtonListener listener = new ButtonListener(null);
/* 18 */     this.left.addActionListener(listener);
/* 19 */     this.middle.addActionListener(listener);
/* 20 */     this.right.addActionListener(listener);
/* 21 */     this.rightest.addActionListener(listener);
/* 22 */     this.labelTop = new JLabel("Defeat The Evil Slime!");
/* 23 */     this.labelTop.setPreferredSize(new Dimension(400, 50));
/* 24 */     this.labelBottom = new JLabel("Winners, don't do drugs.");
/* 25 */     this.labelBottom.setPreferredSize(new Dimension(400, 50));
/* 26 */     this.buttonPanel = new JPanel();
/* 27 */     this.buttonPanel.setPreferredSize(new Dimension(400, 100));
/* 28 */     this.buttonPanel.setBackground(Color.blue);
/* 29 */     this.buttonPanel.add(this.left);
/* 30 */     this.buttonPanel.add(this.middle);
/* 31 */     this.buttonPanel.add(this.right);
/* 32 */     this.buttonPanel.add(this.rightest);
/* 33 */     setPreferredSize(new Dimension(500, 300));
/* 34 */     setBackground(Color.cyan);
/* 35 */     add(this.labelTop);
/* 36 */     add(this.labelBottom);
/* 37 */     add(this.buttonPanel);
/*    */   }
/*    */   private class ButtonListener implements ActionListener { private ButtonListener() {}
/*    */     
/*    */     public void actionPerformed(ActionEvent event) {
/* 42 */       if (event.getSource() == Window.this.left) {
/* 43 */         Window.this.slime.lowerHealth(Window.this.player.getDamage());
/*    */       }
/* 45 */       if (event.getSource() == Window.this.middle) {
/* 46 */         Window.this.slime.lowerMana(Window.this.player.getDamage());
/*    */       }
/* 48 */       if (event.getSource() == Window.this.right) {
/* 49 */         Window.this.player.genHealth();
/*    */       }
/* 51 */       if (event.getSource() == Window.this.rightest) {
/* 52 */         Window.this.player.genMana();
/*    */       }
/*    */       
/* 55 */       if (Window.this.slime.getMana() <= 10) {
/* 56 */         if (PercRand.isTrue(67)) {
/* 57 */           Window.this.slime.genMana();
/* 58 */         } else if (PercRand.isTrue(50)) {
/* 59 */           Window.this.player.lowerHealth(Window.this.slime.getDamage());
/*    */         } else {
/* 61 */           Window.this.player.lowerMana(Window.this.slime.getDamage());
/*    */         } 
/* 63 */       } else if (Window.this.slime.getHealth() <= 10) {
/* 64 */         if (PercRand.isTrue(67)) {
/* 65 */           Window.this.slime.genHealth();
/* 66 */         } else if (PercRand.isTrue(50)) {
/* 67 */           Window.this.player.lowerHealth(Window.this.slime.getDamage());
/*    */         } else {
/* 69 */           Window.this.player.lowerMana(Window.this.slime.getDamage());
/*    */         } 
/* 71 */       } else if (Window.this.player.getMana() >= Window.this.player.getHealth()) {
/* 72 */         if (PercRand.isTrue(75)) {
/* 73 */           Window.this.player.lowerHealth(Window.this.slime.getDamage());
/*    */         } else {
/* 75 */           Window.this.player.lowerMana(Window.this.slime.getDamage());
/*    */         } 
/*    */       } 
/* 78 */       Window.this.labelTop.setText("Player's " + Window.this.player);
/* 79 */       Window.this.labelBottom.setText("Slime's " + Window.this.slime);
/* 80 */       if (Window.this.player.getHealth() <= 0 || Window.this.player.getMana() <= 0) {
/* 81 */         Window.this.labelTop.setText("You Loose!");
/* 82 */         Window.this.labelBottom.setText("Game Over");
/*    */       }
/* 84 */       else if (Window.this.slime.getHealth() <= 0 || Window.this.slime.getMana() <= 0) {
/* 85 */         Window.this.labelTop.setText("You Win!");
/* 86 */         Window.this.labelBottom.setText("Game Over");
/*    */       } 
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\Slava\Desktop\Slime.jar!\Window.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */