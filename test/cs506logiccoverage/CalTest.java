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
            a is always active
        p2 = b | (c & d)
            p2 reachable when a = F
        p3 = e
            e is always active
            p3 reachable when a = F
            if e = T initially, loop will repeat until e = F
    
    Tests below tests how method counts days between Jan1, and Mar1, to ensure
    days in February are added correctly in leap years and non leap years.
    */    
    
    @Test
    //Tests p1, a=T
    public void sameMonth(){
        int result = Cal.cal(1, 1, 1, 3, 2000);
        assertEquals(result, 2);
    }
    
    @Test
    //tests p1, a=F
    //tests p2, (bcd) = (TFT) year not divisible by 4 (not leap year)
    //tests p3, e=T, then e=F
    public void yearNotDivBy4(){
        int result = Cal.cal(1, 1, 3, 1, 1995);
        assertEquals(result, 59);
    }
    
    @Test
    //tests p1, a active, a=F
    //tests p2, (bcd) = (FFT) year divisible by 4 but not by 100 (leap year)
    //tests p3, e=T, then e=F
    public void yearDivBy4Not100(){
        int result = Cal.cal(1, 1, 3, 1, 1996);
        assertEquals(result, 60);
    }
    
    @Test
    //tests p1, a active a=F
    //tests p2, (bcd) = (FTT) year divisible by 100 but not by 400 (not leap year)
    //tests p3, e=T, then e=F
    public void yearDivBy100Not400(){
        int result = Cal.cal(1, 1, 3, 1, 1900);
        assertEquals(result, 59);
    }
    
    @Test
    //tests p1, a active a=F
    //tests p2, (bcd) = (FTF) year divisible by 400 (leap year)
    //tests p3, e=T, then e=F
    public void yearDivBy400(){
        int result = Cal.cal(1, 1, 3, 1, 2000);
        assertEquals(result, 60);
    }
}
