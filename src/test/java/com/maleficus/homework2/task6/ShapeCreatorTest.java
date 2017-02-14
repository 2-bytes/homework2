/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maleficus.homework2.task6;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitalii Umanets
 */
public class ShapeCreatorTest {
    
    public ShapeCreatorTest() {
    }

    /**
     * Test of createNewRing method, of class ShapeCreator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNewRing() {
        double radius = 2.0;
        double expResult = Math.PI*radius*radius;
        Ring result = ShapeCreator.createNewRing(radius);
        assertEquals("Should create a ring with area 4*PI", true, result.getArea()-expResult<0.001);
        ShapeCreator.createNewRing(-1);//Should throw IllegalArgumentException
    }

    /**
     * Test of createNewTrapecium method, of class ShapeCreator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNewTrapecium() {
        double top = 2.0;
        double bottom = 1.0;
        double left = 1.5;
        double right = 1.5;
        double expResult = bottom;
        Trapezium result = ShapeCreator.createNewTrapecium(top, bottom, left, right);
        assertEquals("Top should always be shorter than bottom.", true, expResult-result.getTop()<0.001);
        expResult = 2.121;
        assertEquals("top=1, bottom=2, left=right=1.5 => S=2.121", true, expResult-result.getArea()<0.001);
        ShapeCreator.createNewTrapecium(-1, bottom, left, right);//All of these should throw IllegalArgumentException
        ShapeCreator.createNewTrapecium(top, -1, left, right);
        ShapeCreator.createNewTrapecium(top, bottom, -1, right);
        ShapeCreator.createNewTrapecium(top, bottom, left, -1);

    }

    /**
     * Test of createNewParallelohramm method, of class ShapeCreator.
     */
    @Test
    public void testCreateNewParallelohramm() {
        double a = 2.0;
        double b = 2.0;
        double angle = Math.PI/6;//30 degrees
        double expResult = 2;
        Parallelohramm result = ShapeCreator.createNewParallelohramm(a, b, angle);
        assertEquals("Area should be 2; a*b*sin(angle)=2*2*sin(PI/6)", true, expResult-result.getArea()<0.001);
        ShapeCreator.createNewParallelohramm(-1, 1, 1);//These three should throw IllegalArgumentException
        ShapeCreator.createNewParallelohramm(1, -1, 1);
        ShapeCreator.createNewParallelohramm(1, 1, -1);

    }

    /**
     * Test of createNewTriangle method, of class ShapeCreator.
     */
    @Test
    public void testCreateNewTriangle() {
        System.out.println("createNewTriangle");
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;
        double expResult = 6;
        Triangle result = ShapeCreator.createNewTriangle(a, b, c);
        assertEquals("", true, expResult-result.getArea()<0.001);
        ShapeCreator.createNewTriangle(-1, 1, 1);//These three should throw IllegalArgumentException
        ShapeCreator.createNewTriangle(1, -1, 1);
        ShapeCreator.createNewTriangle(1, 1, -1);
    }
    
}
