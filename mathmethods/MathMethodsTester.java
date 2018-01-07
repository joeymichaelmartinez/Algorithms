package mathmethods;

import static org.junit.Assert.*;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class MathMethodsTester {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);
    
    MathMethods m;
    
    @Before
    public void init(){
        m = new MathMethods();
    }
   /* 
    @Test
    public void test() {
        BigInteger big1 = m.fibonacci(0);
        BigInteger big2 = new BigInteger("0");
        assertEquals(big1, big2);
    }
    
    @Test
    public void test2() {
        for(int i=0; i<10; i++){
            BigInteger big1 = m.fibonacci(i);
            System.out.println(big1);
        }
        
        
    }
    
    
    @Test
    public void test3(){
        BigInteger big1 = m.factorial(7);
        System.out.println(big1);
    }
    */
    
    @Test
    public void test4(){
        double[] nums = new double[3];
        nums[0]=2;
        nums[1]=3;
        nums[2]=2;
        double num = MathMethods.poly(2, nums);
        System.out.println(num);
    }
    
    /*
    @Test
    public void test5(){
        long greatest = m.gcd(1,0);
        System.out.println(greatest);
    }
    */
    
    /*
    @Test
    public void test6(){
        long lowest = m.lcm(25,100);
        System.out.println(lowest);
    }
    
    @Test
    public void test7(){
        double exponential = m.power(2, 2);
        System.out.println(exponential);
    }
    */
    @Test
    public void test8(){
        double rooty = m.sqrt(4,.00001);
        System.out.println(rooty);
    }
    
    @Test
    public void test9(){
        double rootytoot = m.root(3, 8,.00001);
        System.out.println(rootytoot);
    }
   
    
}
