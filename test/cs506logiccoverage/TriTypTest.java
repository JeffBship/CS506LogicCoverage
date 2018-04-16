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
        p1 always reached
        p1a = !b && !c
        p1b = !a && !c
        p1c = !a && !b
        cases: FFF, TFF, FTF, FFT
        a active: FFF, TFF
        b active: FFF, FTF
        c active: FFF, FFT
      p2 = d
        p2 reached when p1 = F
        d always active
        cases: T, F
      p3 = e
        p3 reached when p1 = F
        e always active
        cases: T, F
      p4 = f
        p4 reached when p1 = F
        f always active
        cases: T, F
      p5 = q
        p5 reached when p1 = F
        q always active
        cases: T, F
      p6 = g || h || i
        p6 reached when p1 = F and p5 = T
        p6g = !h && !i
        p6h = !g && !i
        p6i = !g && !h
        cases: FFF, TFF, FTF, FFT
        g active: FFF, TFF
        h active: FFF, FTF
        i active: FFF, FFT
      p7 = j
        p7 reached when p1,p5 = F
        j always active
        cases: T, F
      p8 = k && l
        p8 reached when p1,p5,p7 = F
        p8k = l
        p8l = k
        cases: TT, FT, TF
        k active: TT, FT
        l active: TT, TF
      p9 = m && n
        p9 reached when p1,p5,p7,p8 = F
        p9m = n
        p9n = m
        cases: TT, FT, TF
        m active: TT, FT
        n active: TT, TF
      p10 = o && p
        p10 reached when p1,p5,p7,p8,p9 = F
        p10o = p
        p10p = o
        cases: TT, FT, TF
        o active: TT, FT
        p active: TT, TF

  */

    public TriTypTest() {
    }

    //p1 - FFF
    //p2 - F
    //p3 - F
    //p4 - F
    //p5 - T
    //p6 - FFF
    @Test
    public void testScalene(){
        int result = TriTyp.triang(3, 4, 5);
        assertEquals(result, 1);
    }

    //p1 - FFF
    //p2 - T
    //p3 - F
    //p4 - F
    //p5 - F
    //p7 - F
    //p8 - TT
    @Test
    public void testIsosceles1(){
        int result = TriTyp.triang(2, 2, 3);
        assertEquals(result, 2);
    }

    //p1 - FFF
    //p2 - F
    //p3 - T
    //p4 - F
    //p5 - F
    //p7 - F
    //p8 - FT
    //p9 - TT
    @Test
    public void testIsosceles2(){
        int result = TriTyp.triang(2, 3, 2);
        assertEquals(result, 2);
    }

    //p1 - FFF
    //p2 - F
    //p3 - F
    //p4 - T
    //p5 - F
    //p7 - F
    //p8 - FT
    //p9 - FT
    //p10 - TT
    @Test
    public void testIsosceles3(){
        int result = TriTyp.triang(3, 2, 2);
        assertEquals(result, 2);
    }

    //p1 - FFF
    //p2 - F
    //p3 - F
    //p4 - T
    //p5 - F
    //p7 - F
    //p8 - FT
    //p9 - FT
    //p10 - TF
    @Test
    public void testIsosceles4(){
        int result = TriTyp.triang(4, 2, 2);
        assertEquals(result, 2);
    }

    //p1 - FFF
    //p2 - F
    //p3 - T
    //p4 - F
    //p5 - F
    //p7 - F
    //p8 - FT
    //p9 - TF
    //p10 - FT
    @Test
    public void testIsosceles5(){
        int result = TriTyp.triang(2, 4, 2);
        assertEquals(result, 2);
    }

    //p1 - FFF
    //p2 - F
    //p3 - T
    //p4 - F
    //p5 - F
    //p7 - F
    //p8 - TF
    //p9 - FT
    //p10 - FT
    @Test
    public void testIsosceles6(){
        int result = TriTyp.triang(2, 2, 4);
        assertEquals(result, 2);
    }

    //p1 - FFF
    //p2 - T
    //p3 - T
    //p4 - T
    //p5 - F
    //p7 - T
    @Test
    public void testEquilateral(){
        int result = TriTyp.triang(1, 1, 1);
        assertEquals(result, 3);
    }

    //p1 - TFF
    @Test
    public void testZeroSideLength1(){
        int result = TriTyp.triang(0, 1, 1);
        assertEquals(result, 4);
    }

    //p1 - FTF
    @Test
    public void testZeroSideLength2(){
        int result = TriTyp.triang(1, 0, 1);
        assertEquals(result, 4);
    }

    //p1 - FFT
    @Test
    public void testZeroSideLength3(){
        int result = TriTyp.triang(1, 1, 0);
        assertEquals(result, 4);
    }

    //p1 - FFF
    //p2 - F
    //p3 - F
    //p4 - F
    //p5 - T
    //p6 - TFF
    @Test
    public void testTriangleInequality1(){
        int result = TriTyp.triang(1, 2, 4);
        assertEquals(result, 4);
    }

    //p1 - FFF
    //p2 - F
    //p3 - F
    //p4 - F
    //p5 - T
    //p6 - FFT
    @Test
    public void testTriangleInequality2(){
        int result = TriTyp.triang(2, 4, 1);
        assertEquals(result, 4);
    }

    //p1 - FFF
    //p2 - F
    //p3 - F
    //p4 - F
    //p5 - T
    //p6 - FTF
    @Test
    public void testTriangleInequality3(){
        int result = TriTyp.triang(4, 2, 1);
        assertEquals(result, 4);
    }
}
