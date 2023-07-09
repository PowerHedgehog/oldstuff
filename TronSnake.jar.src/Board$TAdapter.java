/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class TAdapter
/*     */   extends KeyAdapter
/*     */ {
/*     */   private TAdapter() {}
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 321 */     int key = e.getKeyCode();
/*     */     
/* 323 */     if (key == 37 && !Board.access$0(Board.this)) {
/* 324 */       Board.access$1(Board.this, true);
/* 325 */       Board.access$2(Board.this, false);
/* 326 */       Board.access$3(Board.this, false);
/*     */     } 
/* 328 */     if (key == 65 && !Board.access$4(Board.this)) {
/* 329 */       Board.access$5(Board.this, true);
/* 330 */       Board.access$6(Board.this, false);
/* 331 */       Board.access$7(Board.this, false);
/*     */     } 
/*     */     
/* 334 */     if (key == 39 && !Board.access$8(Board.this)) {
/* 335 */       Board.access$9(Board.this, true);
/* 336 */       Board.access$2(Board.this, false);
/* 337 */       Board.access$3(Board.this, false);
/*     */     } 
/* 339 */     if (key == 68 && !Board.access$10(Board.this)) {
/* 340 */       Board.access$11(Board.this, true);
/* 341 */       Board.access$6(Board.this, false);
/* 342 */       Board.access$7(Board.this, false);
/*     */     } 
/*     */     
/* 345 */     if (key == 38 && !Board.access$12(Board.this)) {
/* 346 */       Board.access$2(Board.this, true);
/* 347 */       Board.access$9(Board.this, false);
/* 348 */       Board.access$1(Board.this, false);
/*     */     } 
/* 350 */     if (key == 87 && !Board.access$13(Board.this)) {
/* 351 */       Board.access$6(Board.this, true);
/* 352 */       Board.access$11(Board.this, false);
/* 353 */       Board.access$5(Board.this, false);
/*     */     } 
/*     */     
/* 356 */     if (key == 40 && !Board.access$14(Board.this)) {
/* 357 */       Board.access$3(Board.this, true);
/* 358 */       Board.access$9(Board.this, false);
/* 359 */       Board.access$1(Board.this, false);
/*     */     } 
/* 361 */     if (key == 83 && !Board.access$15(Board.this)) {
/* 362 */       Board.access$7(Board.this, true);
/* 363 */       Board.access$11(Board.this, false);
/* 364 */       Board.access$5(Board.this, false);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Slava\Desktop\TronSnake.jar!\Board$TAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */