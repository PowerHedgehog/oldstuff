/*   */ import java.util.Random;
/*   */ 
/*   */ public class PercRand {
/*   */   public static boolean isTrue(int perc) {
/* 5 */     Random generator = new Random();
/* 6 */     if (generator.nextInt(100) + 1 <= perc) {
/* 7 */       return true;
/*   */     }
/* 9 */     return false;
/*   */   }
/*   */ }


/* Location:              C:\Users\Slava\Desktop\Slime.jar!\PercRand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */