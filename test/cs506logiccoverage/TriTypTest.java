package cs506logiccoverage;

/**
 * @author James Luczynski
 * @author Jeff Blankenship
 * @author Austin Barrett
 */

import org.junit.Test;
import static org.junit.Assert.*;


public class TriTypTest {

  /*
  Tests the TriTyp class's triang method. Predicates investigated:
      p1 = a || b || c
        p1a = !b && !c
        p1b = !a && !c
        p1c = !a && !b
        cases: FFF, TFF, FTF, FFT
      p2 = d
        d always active
        cases: T, F
      p3 = e
        e always active
        cases: T, F
      p4 = f
        f always active
        cases: T, F
      p5 = g || h || i
        p5g = !h && !i
        p5h = !g && !i
        p5i = !g && !h
        cases: FFF, TFF, FTF, FFT
      p6 = j
        j always active
        cases: T, F
      p7 = k && l
        p7k = l
        p7l = k
        cases: TT, FT, TF
      p8 = m && n
        p8m = n
        p8n = m
        cases: TT, FT, TF
      p9 = o && p
        p9o = p
        p9p = o
        cases: TT, FT, TF

  Tests below tests how method counts days between Jan1, and Mar1, to ensure
  days in February are added correctly in leap years and non leap years.
  */

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

    /*
    *
    *
    */
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
