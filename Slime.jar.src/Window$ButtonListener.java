/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ButtonListener
/*    */   implements ActionListener
/*    */ {
/*    */   private ButtonListener() {}
/*    */   
/*    */   public void actionPerformed(ActionEvent event) {
/* 42 */     if (event.getSource() == Window.access$0(Window.this)) {
/* 43 */       Window.access$1(Window.this).lowerHealth(Window.access$2(Window.this).getDamage());
/*    */     }
/* 45 */     if (event.getSource() == Window.access$3(Window.this)) {
/* 46 */       Window.access$1(Window.this).lowerMana(Window.access$2(Window.this).getDamage());
/*    */     }
/* 48 */     if (event.getSource() == Window.access$4(Window.this)) {
/* 49 */       Window.access$2(Window.this).genHealth();
/*    */     }
/* 51 */     if (event.getSource() == Window.access$5(Window.this)) {
/* 52 */       Window.access$2(Window.this).genMana();
/*    */     }
/*    */     
/* 55 */     if (Window.access$1(Window.this).getMana() <= 10) {
/* 56 */       if (PercRand.isTrue(67)) {
/* 57 */         Window.access$1(Window.this).genMana();
/* 58 */       } else if (PercRand.isTrue(50)) {
/* 59 */         Window.access$2(Window.this).lowerHealth(Window.access$1(Window.this).getDamage());
/*    */       } else {
/* 61 */         Window.access$2(Window.this).lowerMana(Window.access$1(Window.this).getDamage());
/*    */       } 
/* 63 */     } else if (Window.access$1(Window.this).getHealth() <= 10) {
/* 64 */       if (PercRand.isTrue(67)) {
/* 65 */         Window.access$1(Window.this).genHealth();
/* 66 */       } else if (PercRand.isTrue(50)) {
/* 67 */         Window.access$2(Window.this).lowerHealth(Window.access$1(Window.this).getDamage());
/*    */       } else {
/* 69 */         Window.access$2(Window.this).lowerMana(Window.access$1(Window.this).getDamage());
/*    */       } 
/* 71 */     } else if (Window.access$2(Window.this).getMana() >= Window.access$2(Window.this).getHealth()) {
/* 72 */       if (PercRand.isTrue(75)) {
/* 73 */         Window.access$2(Window.this).lowerHealth(Window.access$1(Window.this).getDamage());
/*    */       } else {
/* 75 */         Window.access$2(Window.this).lowerMana(Window.access$1(Window.this).getDamage());
/*    */       } 
/*    */     } 
/* 78 */     Window.access$6(Window.this).setText("Player's " + Window.access$2(Window.this));
/* 79 */     Window.access$7(Window.this).setText("Slime's " + Window.access$1(Window.this));
/* 80 */     if (Window.access$2(Window.this).getHealth() <= 0 || Window.access$2(Window.this).getMana() <= 0) {
/* 81 */       Window.access$6(Window.this).setText("You Loose!");
/* 82 */       Window.access$7(Window.this).setText("Game Over");
/*    */     }
/* 84 */     else if (Window.access$1(Window.this).getHealth() <= 0 || Window.access$1(Window.this).getMana() <= 0) {
/* 85 */       Window.access$6(Window.this).setText("You Win!");
/* 86 */       Window.access$7(Window.this).setText("Game Over");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Slava\Desktop\Slime.jar!\Window$ButtonListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */