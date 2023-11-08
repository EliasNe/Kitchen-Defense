package src.Model;

import java.awt.*;

public abstract class ATower implements IPlacable{
   private int x;
   private int y;
   private int cost;
   private int range;
   private Image model;

   public ATower(int x, int y, int cost, int range, Image model) {
       this.x = x;
       this.y = y;
       this.cost = cost;
       this.range = range;
       this.model = model;
   }

   public int getX() {
       return x;
   }

   public void setX(int x) {
       this.x = x;
   }

   public int getY() {
       return y;
   }

   public void setY(int y) {
       this.y = y;
   }

   public int getCost() {
       return cost;
   }

   public void setCost(int cost) {
       this.cost = cost;
   }

   public int getRange() {
       return range;
   }

   public void setRange(int range) {
       this.range = range;
   }

   public Image getModel() {
       return model;
   }

   public void setModel(Image model) {
       this.model = model;
   }
}
