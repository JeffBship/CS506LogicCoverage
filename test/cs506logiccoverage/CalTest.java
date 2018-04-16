package cs506logiccoverage;

/**
 * @author James Luczynski
 * @author Jeff Blankenship
 * @author Austin Barrett
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class CalTest {

    /*
    Tests the cal method. Predicates investigated:
        p1 = a
          p1 is always reachable
          a is always active
          cases: T, F
        p2 = b || (c && d)
          p2 reachable when a = F
          p2b = !c || !d
          p2c = !b && d
          p2d = !b && c
          cases: FFT, TFT, FTT, FTF
          b active: FFT, TFT
          c active: FFT, FTT
          d active: FTF, FTT
        p3 = e
          p3 reachable when a = F
          e is always active
          if e = T initially, loop will repeat until e = F
          cases: T, F

    Tests below tests how method counts days between Jan1, and Mar1, to ensure
    days in February are added correctly in leap years and non leap years.
    */

    @Test
    //p1 - T
    public void sameMonth(){
        int result = Cal.cal(1, 1, 1, 3, 2000);
        assertEquals(result, 2);
    }

    @Test
    //p1 - F
    //p2 - TFT - year not divisible by 4 (not leap year)
    //p3 - T, then F
    public void yearNotDivBy4(){
        int result = Cal.cal(1, 1, 3, 1, 1995);
        assertEquals(result, 59);
    }

    @Test
    //p1 - F
    //p2 - FFT - year divisible by 4 but not by 100 (leap year)
    //p3 - T, then F
    public void yearDivBy4Not100(){
        int result = Cal.cal(1, 1, 3, 1, 1996);
        assertEquals(result, 60);
    }

    @Test
    //tests p1, a active a=F
    //p2 - FTT - year divisible by 100 but not by 400 (not leap year)
    //p3 - T, then F
    public void yearDivBy100Not400(){
        int result = Cal.cal(1, 1, 3, 1, 1900);
        assertEquals(result, 59);
    }

    @Test
    //tests p1, a active a=F
    //p2 - FTF - year divisible by 400 (leap year)
    //p3 - T, then F
    public void yearDivBy400(){
        int result = Cal.cal(1, 1, 3, 1, 2000);
        assertEquals(result, 60);
    }
}
