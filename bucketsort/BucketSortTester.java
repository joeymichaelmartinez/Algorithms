package bucketsort;

import static org.junit.Assert.*;
import java.util.ArrayList;
//import java.math.BigInteger;
//import org.junit.Before;
//import org.junit.Rule;
import org.junit.Test;
//import org.junit.rules.Timeout;

public class BucketSortTester {
    @Test
    public void ArrayTest(){
        ArrayList<Double> unsorted = new ArrayList<Double>();
        unsorted.add(3.0);
        unsorted.add(1.0);
        unsorted.add(5.0);
        unsorted.add(4.0);
        unsorted.add(2.0);
        unsorted.add(6.0);
        unsorted.add(0.0);
        unsorted.add(7.0);
        unsorted.add(8.0);
        unsorted.add(9.0);
        double max = 9.0;
        double min = 0.0;
        ArrayList<Double> sorted = BucketSort.sorter(unsorted, max, min);
        //assertEquals(sorted.indexOf(0.0), 0);
        assertEquals(sorted.indexOf(1.0), 1);
        //assertEquals(sorted.indexOf(2.0), 2);
        assertEquals(sorted.indexOf(3.0), 3);
        assertEquals(sorted.indexOf(4.0), 4);
        assertEquals(sorted.indexOf(5.0), 5);
        assertEquals(sorted.indexOf(6.0), 6);
        assertEquals(sorted.indexOf(7.0), 7);
        assertEquals(sorted.indexOf(8.0), 8);
        assertEquals(sorted.indexOf(9.0), 9);
    }
    
    @Test
    public void ArrayTest2(){
        ArrayList<Double> unsorted = new ArrayList<Double>();
        unsorted.add(3.0);
        unsorted.add(2.0);
        unsorted.add(6.0);
        unsorted.add(5.0);
        unsorted.add(4.0);
        unsorted.add(1.0);
        unsorted.add(7.0);
        unsorted.add(9.0);
        unsorted.add(8.0);
        unsorted.add(0.0);
        double max = 9.0;
        double min = 0.0;
        ArrayList<Double> sorted = BucketSort.sorter(unsorted, max, min);
        assertEquals(sorted.indexOf(0.0), 0);
        assertEquals(sorted.indexOf(1.0), 1);
        assertEquals(sorted.indexOf(2.0), 2);
        assertEquals(sorted.indexOf(3.0), 3);
        assertEquals(sorted.indexOf(4.0), 4);
        assertEquals(sorted.indexOf(5.0), 5);
        assertEquals(sorted.indexOf(6.0), 6);
        assertEquals(sorted.indexOf(7.0), 7);
        assertEquals(sorted.indexOf(8.0), 8);
        assertEquals(sorted.indexOf(9.0), 9);

    }
    @Test
    public void ArrayTest3(){
        ArrayList<ArrayList<Double>> unsorted = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> bucket1 = new ArrayList<Double>();
        bucket1.add(3.0);
        bucket1.add(5.0);
        bucket1.add(2.0);
        bucket1.add(0.0);
        bucket1.add(1.0);
        bucket1.add(4.0);
        unsorted.add(bucket1);
        unsorted.add(bucket1);
        //System.out.println(unsorted);
        ArrayList<ArrayList<Double>> sorted = BucketSort.insertSort(unsorted);
        //System.out.println(sorted);
        assertEquals(sorted.get(1).indexOf(0.0), 0);
        assertEquals(sorted.get(1).indexOf(1.0), 1);
        assertEquals(sorted.get(1).indexOf(2.0), 2);
        assertEquals(sorted.get(1).indexOf(3.0), 3);
        assertEquals(sorted.get(1).indexOf(4.0), 4);
        assertEquals(sorted.get(1).indexOf(5.0), 5);
    }
    
}
