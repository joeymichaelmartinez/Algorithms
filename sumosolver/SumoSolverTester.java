package sumosolver;

import static org.junit.Assert.*;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SumoSolverTester {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);
    
    
    
    /*
    @Test
    public void tupleCompareTest() {
        Tuple firstTuple= new Tuple(3);
        
        firstTuple.setElement(0, 1);
        firstTuple.setElement(1, 1);
        firstTuple.setElement(2, 1);
        
        Tuple secondTuple= new Tuple(3);
        secondTuple.setElement(0, 0);
        secondTuple.setElement(1, 0);
        secondTuple.setElement(2, 1);
        int[] weights= new int[3];
        weights[0]= 5;
        weights[1]= 10;
        weights[2]= 20;
        System.out.println(SumoSolver.tupleCompare(firstTuple, secondTuple, weights));
    }*/

    
    @Test
    public void arrayFillerTest(){
        int[] prices= new int[5];
        prices[0]= 2;
        prices[1]= 4;
        prices[2]=6;
        prices[3]=9;
        prices[4]=13;
        int[] weights= new int[5];
        weights[0]= 10;
        weights[1]= 18;
        weights[2]= 22;
        weights[3]= 24;
        weights[4]= 28;
        int priceLimit= 14;
        SumoSolver.Tuple[][] tupleArray= new SumoSolver.Tuple[prices.length][priceLimit+1];
        SumoSolver.Tuple answer = SumoSolver.arrayFiller(prices, weights, priceLimit, tupleArray, prices.length-1, priceLimit);
        System.out.println(answer);
    }
    
    @Test
    public void arrayFillerTest2(){
        
    }
    
    @Test
    public void arrayFillerTest3(){
        
    }
    
    @Test
    public void arrayFillerTest4(){
        
    }
    
    @Test
    public void arrayFillerTest5(){
        
    }
    
    @Test
    public void arrayFillerTest6(){
        
    }
    
    @Test
    public void arrayFillerTest7(){
        
    }
    
    /*
    @Test
    public void tupleTester(){
        Tuple first = new Tuple(3);
        first.setElement(0, 1);
        first.setElement(1, 1);
        first.setElement(2, 0);
        Tuple second = new Tuple(3);
        second.setElement(0, 1);
        second.setElement(1, 1);
        second.setElement(2, 1);
        first.add(second);
        second.add(first);
        System.out.println(second);
    }
  */  
}
