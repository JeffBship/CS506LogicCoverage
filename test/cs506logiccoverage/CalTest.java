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
    //Tests p2, bcd=TFT 
    //Tests p3, e=F
    public void test_P1aT_P2TFT_P3eF(){
        //(month1, day1, month2, day2, year)
        int result = Cal.cal(1, 1, 1, 3, 99);
        assertEquals(result, 2);
    }
    
    
    
    @Test
    //tests p1, a=T  
    //test p2, not reached
    //test p3, not reached
    public void test_P1aT(){
        //(month1, day1, month2, day2, year)
        int result = Cal.cal(1, 1, 1, 31, 1);
        assertEquals(result, 30);
    }
    
    @Test
    //tests p1, a=F  -> P2,P3 reachable
    //tests p2, bcd=FTT
    //tests p3, e=T
    public void test_P1aF_P2FTT_P3eT(){
        //(month1, day1, month2, day2, year)
        int result = Cal.cal(1, 1, 12, 31, 100);
        assertEquals(result, 364);
    }
    
    @Test
    //tests p1, a=F  -> P2,P3 reachable
    //tests p2, bcd=FFT 
    //tests p3, 
    public void test_P2cT_P2FFT(){
        int result = Cal.cal(1, 1, 12, 31, 4);
        assertEquals(result, 365);
    }
    
    @Test
    //tests p1, a=f -> P2,P3 reachable
    //tests p2, bcd=FTF
    //tests p3, 
    public void test_P2FTF(){
        int result = Cal.cal(1, 1, 12, 31, 400);
        assertEquals(result, 365);
    }
    
}
