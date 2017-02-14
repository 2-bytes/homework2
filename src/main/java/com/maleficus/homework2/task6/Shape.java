/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maleficus.homework2.task6;

/**
 *
 * @author Peter Schwarz
 */
public class Shape {

    private double area;

    public Shape(){
        this.area=0;
    }

    public Shape(double area){
        this.area = area;
    }

    public Shape add(Shape shape){
        return new Shape(this.area+shape.area);
    }
    
    public double getArea(){
        return this.area;
    }
    
    protected void setArea(double area){
        this.area=area;
    }
}

class Ring extends Shape{

    private final double radius;

    protected Ring(double radius){
        super(Math.PI*radius*radius);
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }
}

class Triangle extends Shape{
    
    private final double sideA;
    private final double sideB;
    private final double sideC;
    
    protected Triangle(double sideA, double sideB, double sideC){
        super(Math.sqrt((sideA+sideB+sideC)/2*
                (sideB+sideC-sideA)/2*
                (sideA+sideC-sideB)/2*
                (sideA+sideB-sideC)/2));//sqrt(p(p-a)(p-b)(p-c))
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}

class Parallelohramm extends Shape{
    
    private final double sideA;
    private final double sideB;
    
    protected Parallelohramm(double sideA, double sideB, double angle){
        super(sideA*sideB*Math.sin(angle));
        this.sideA=sideA;
        this.sideB=sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }
    
}

class Trapezium extends Shape{
    
    private final double top;
    private final double bottom;
    private final double leftSide;
    private final double rightSide;
    
    protected Trapezium(double top, double bottom, double leftSide, double rightSide){
        this.top = top;
        this.bottom = bottom;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        double area = (top+bottom)/2*Math.sqrt(leftSide*leftSide
                -Math.pow(((leftSide*leftSide-rightSide*rightSide)/(bottom-top))+bottom-top, 2)/4);
        super.setArea(area);
    }

    public double getTop() {
        return top;
    }

    public double getBottom() {
        return bottom;
    }

    public double getLeftSide() {
        return leftSide;
    }

    public double getRightSide() {
        return rightSide;
    }
    
}