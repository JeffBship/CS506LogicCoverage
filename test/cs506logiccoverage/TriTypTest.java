package cs506logiccoverage;

/**
 * @author James Luczynski
 * @author Jeff Blankenship
 * @author Austin Barrett
 */

import org.junit.Test;
import static org.junit.Assert.*;


public class TriTypTest {
    
    public TriTypTest() {
    }
    
    @Test
    public void testScalene(){
        int result = TriTyp.triang(3, 4, 5);
        assertEquals(result, 1);
    }
    
    @Test
    public void testIsosceles1(){
        int result = TriTyp.triang(2, 2, 3);
        assertEquals(result, 2);
    }
    
    @Test
    public void testIsosceles2(){
        int result = TriTyp.triang(2, 3, 2);
        assertEquals(result, 2);
    }
    
    @Test
    public void testIsosceles3(){
        int result = TriTyp.triang(3, 2, 2);
        assertEquals(result, 2);
    }
    
    @Test
    public void testEquilateral(){
        int result = TriTyp.triang(1, 1, 1);
        assertEquals(result, 3);
    }
    
    @Test
    public void testZeroSideLength1(){
        int result = TriTyp.triang(0, 1, 1);
        assertEquals(result, 4);
    }
    
    @Test
    public void testZeroSideLength2(){
        int result = TriTyp.triang(1, 0, 1);
        assertEquals(result, 4);
    }
    
    @Test
    public void testZeroSideLength3(){
        int result = TriTyp.triang(1, 1, 0);
        assertEquals(result, 4);
    }
    
    @Test 
    public void testTriangleInequality1(){
        int result = TriTyp.triang(1, 2, 4);
        assertEquals(result, 4);
    }
    
    @Test 
    public void testTriangleInequality2(){
        int result = TriTyp.triang(2, 4, 1);
        assertEquals(result, 4);
    }
    
    @Test 
    public void testTriangleInequality3(){
        int result = TriTyp.triang(4, 2, 1);
        assertEquals(result, 4);
    }    
}
