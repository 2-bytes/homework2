package com.maleficus.homework2.task6;

/**
 *
 * @author Vitalii Umanets
 */
public class ShapeCreator {
    
    public static Ring createNewRing(double radius){
        if(radius<0)
            throw new IllegalArgumentException("Radius should be more then zero!");
        return new Ring(radius);
    }
    
    public static Trapezium createNewTrapecium(double top, double bottom, double left, double right){
        if(top<0||bottom<0||left<0||right<0)
            throw new IllegalArgumentException("One or several sides are less than zero");
        if(top>bottom){
            top+=bottom;
            bottom=top-bottom;
            top-=bottom;
        }
        return new Trapezium(top, bottom, left, right);
    }
    
    public static Parallelohramm createNewParallelohramm(double a, double b, double angle){
        if(a<0||b<0)
            throw new IllegalArgumentException("One or several sides are less than zero");
        if(angle>Math.PI || angle<0)
            throw new IllegalArgumentException("Angle should be in range [0.. PI]");
        return new Parallelohramm(a, b, angle);
    }
    
    public static Triangle createNewTriangle(double a, double b, double c){
        if(a<0||b<0||c<0)
            throw new IllegalArgumentException("One or several sides are less than zero");
        return new Triangle(a, b ,c);

    }
    
    
}
