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
        return new Shape(this.area+area);
    }
}

class Ring extends Shape{

    private double radius;

    public Ring(double radius){

    }

    public double getRadius(){
        return this.radius;
    }
}

class Triangle extends Shape{

}

class Parallelogram extends Shape{

}

class Trapecium extends Shape{

}