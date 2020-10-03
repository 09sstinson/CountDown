import com.sstinson.countdown.Add;
import com.sstinson.countdown.CombinatoricsUtil;
import com.sstinson.countdown.Main;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class countdownTest {

    Main m = new Main();
    CombinatoricsUtil obj = new CombinatoricsUtil();
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
        System.out.println(m.generateAllBinaryBrackets(10));
        assertEquals(m.generateAllBinaryBrackets(6).size(),42);

    }


    @Test
    public void testCombinatoricsUtil(){
        System.out.println(obj.combinations);
        System.out.println(obj.opCombs);
        System.out.println(obj.permutations.size());
        System.out.println(obj.chosenNumbers);
        System.out.println(obj.factorialCombs.size());
    }

    @Test
    public void testCalculateAtIndex(){
        Add adder = new Add();
        ArrayList<Double> result = adder.calculateAtIndex(obj.chosenNumbers,1);
        System.out.println(obj.chosenNumbers);
        System.out.println(result);
    }

    @Test
    public void testCalculateAll() {
        ArrayList<Double> chosenNumbers = new ArrayList<Double>() {
            {
                add(100.0);
                add(75.0);
                add(2.0);
                add(5.0);
                add(7.0);
                add(9.0);
            }
        };
        m.calculateAll(chosenNumbers,obj.opCombs.get(1));

        System.out.println(m.results);
        System.out.println(m.results.size());

    }

    @Test
    public void testCalculateEvery() {
        ArrayList<Double> chosenNumbers = new ArrayList<Double>() {
            {
                add(9.0);
                add(4.0);
                add(10.0);
                add( 6.0);
                add(75.0);
                add(100.0);
            }
        };
        //System.out.println(chosenNumbers);
        m.calculateEveryForPermutation();

        System.out.println(m.orderOfOperations);
        System.out.println(m.targetOperations);
        System.out.println(m.targetPermutation);
        m.printOutput();
    }
}
