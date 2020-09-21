import com.sstinson.countdown.Main;
import org.junit.Test;

import static org.junit.Assert.*;

public class countdownTest {

    Main m = new Main();
    @Test
    public void testCheckBalancedBrackets(){
        String s1 = ")()";
        String s2 = "((a)x(1x1)(12))";

        assertTrue(m.checkBalancedBrackets(s2));
        //assertFalse(m.checkBalancedBrackets(s1));
    }


}
