package shapes;

public abstract class Shape {
    double height;

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public abstract double calcVolume();
    public abstract double calcBaseArea();

    public int compareTo(Shape s){
        if ( this.getHeight() > s.getHeight() ) return 1;
        else if ( this.getHeight() < s.getHeight() ) return -1;
        else return 0;
    }

}


