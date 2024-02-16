package POJO;

public class Point {
   private double X;
   private double Y;
   private int classe;

    public Point(double Ix, double Iy, int Klass) {
        this.X=Ix;
        this.Y=Iy;
        this.classe=Klass;
    }

    public double getX() {return X;}
    public double getY() {return Y;}
    public int getClasse() {return classe;}


    public void setX(double x) {X = x;}
    public void setY(double y) {Y = y;}
    public void setClasse(int classe) {this.classe = classe;}
}
