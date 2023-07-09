/*    */ import java.awt.Component;
/*    */ import java.awt.EventQueue;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class TronSnake
/*    */   extends JFrame
/*    */ {
/*    */   public TronSnake() {
/*  9 */     add(new Board());
/*    */     
/* 11 */     setResizable(false);
/* 12 */     pack();
/*    */     
/* 14 */     setTitle("Snake");
/* 15 */     setLocationRelativeTo((Component)null);
/* 16 */     setDefaultCloseOperation(3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 22 */     EventQueue.invokeLater(new Runnable()
/*    */         {
/*    */           public void run() {
/* 25 */             JFrame ex = new TronSnake();
/* 26 */             ex.setVisible(true);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Slava\Desktop\TronSnake.jar!\TronSnake.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */