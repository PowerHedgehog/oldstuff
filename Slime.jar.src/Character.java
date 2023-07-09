/*    */ 
/*    */ public class Character {
/*    */   private int health;
/*    */   private int mana;
/*  5 */   private Random generator = new Random(); private int level; private int damage;
/*    */   
/*    */   public Character(int value) {
/*  8 */     this.level = value;
/*  9 */     this.health = 19 + this.level;
/* 10 */     this.mana = 19 + this.level;
/* 11 */     this.damage = 4 + this.level;
/*    */   }
/*    */   
/*    */   public int getHealth() {
/* 15 */     return this.health;
/*    */   }
/*    */   
/*    */   public int getMana() {
/* 19 */     return this.mana;
/*    */   }
/*    */   
/*    */   public int getDamage() {
/* 23 */     return this.generator.nextInt(this.damage) + 1;
/*    */   }
/*    */   
/*    */   public void lowerHealth(int value) {
/* 27 */     this.health -= value;
/*    */   }
/*    */   
/*    */   public void lowerMana(int value) {
/* 31 */     this.mana -= value;
/*    */   }
/*    */   
/*    */   public void genHealth() {
/* 35 */     this.mana -= this.generator.nextInt(5) + this.level;
/* 36 */     this.health += this.generator.nextInt(5) + this.level;
/*    */   }
/*    */   
/*    */   public void genMana() {
/* 40 */     this.mana += this.generator.nextInt(5) + this.level;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 44 */     return "health: " + this.health + "; mana: " + this.mana + "; level: " + this.level;
/*    */   }
/*    */ }


/* Location:              C:\Users\Slava\Desktop\Slime.jar!\Character.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */