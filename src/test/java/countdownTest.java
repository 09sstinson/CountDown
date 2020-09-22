import com.sstinson.countdown.Main;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class countdownTest {

    Main m = new Main();
    @Test
    public void testCheckBalancedBrackets(){
        String s1 = ")()";
        String s2 = "((xx)(xx)(xx))";

        assertTrue(m.checkBalancedBrackets(s2));

    }

    @Test
    public void testCheckBinaryBrackets(){
        String s2 = "((a(bc))(de))";
        assertTrue(m.checkBinaryBrackets(s2));
    }

    @Test
    public void testIndexOfNthOccurrence(){
        String s = "aaaaa";
        assertEquals(m.indexOfNthOccurrence(s,"a",4),3);
        String s2 = "(xx)x(xx)";
        assertEquals(m.indexOfNthOccurrence(s2,"x",4),6);

    }

    @Test
    public void testReplaceCharAtIndexWithString(){
        String s2 = "(xx)x(xx)";
        assertEquals(m.replaceCharAtIndexWithString(s2,"(xx)",2),"(x(xx))x(xx)");
    }

    @Test
    public void testGenerateAllPossibleReplacementsOfChar(){
        String s2 = "(xx)x";
        System.out.println(m.generateAllPossibleReplacements(s2,"x","(xx)"));
    }

    @Test
    public void testGenerateAllPossibleReplacementsOfCharArrayList(){
        String s2 = "xx";
        ArrayList<String> list = m.generateAllPossibleReplacements(s2,"x","(xx)");
        System.out.println(list = m.generateAllPossibleReplacements(list,"x","(xx)"));
        System.out.println(m.removeDuplicates(list));
    }

    @Test
    public void testGenerateAllBinaryBrackets(){
        System.out.println(m.generateAllBinaryBrackets(6));
        assertEquals(m.generateAllBinaryBrackets(6).size(),42);

    }
}
