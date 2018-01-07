package bucketsort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BucketSort {
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        ArrayList<Double> dataSet = new ArrayList<Double>();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        //FileReader in = new FileReader("C:/Users/joeym/Desktop/Projects/CMSI282/src/bucketsort/FileFullOfDoubles.txt");
        //BufferedReader stdIn = new BufferedReader(in);
        String holder = stdIn.readLine();
        double max=Double.parseDouble(holder);
        double min=Double.parseDouble(holder);
        //int i=0;
        while (holder != null) {
            double x = Double.parseDouble(holder);
            if (x>max){
                max=x;
            }
            if(x<min){
                min=x;
            }
            dataSet.add(x);
            holder = stdIn.readLine();
            //System.out.println(dataSet.get(i));
            //i++;
        }
        
        
        ArrayList<Double> sortedList = sorter(dataSet, max, min);
        for(int i=0; i<sortedList.size(); i++){
            System.out.println(sortedList.get(i));
        }
        
        //System.out.println("Max: " + max);
        //System.out.println("Min: " + min);
        
        
        
        /*
        int kth = Integer.parseInt(args[0]);
        if (kth >= dataset.size() || kth < 0) {
            System.out.println("BAD DATA");
            System.exit(-1);
        }*/
        
        
    }
    
    public static ArrayList<Double> sorter(ArrayList<Double> unsortedList, double max, double min){
        ArrayList<ArrayList<Double>> arrayOfBuckets = new ArrayList<ArrayList<Double>>();
        //ArrayList<Double> bucket = new ArrayList<Double>();
        for(int i=0; i<unsortedList.size(); i++){
            arrayOfBuckets.add(null);
        }
        
        for(int i=0; i<unsortedList.size(); i++){
            //System.out.println((unsortedList.get(i)-min)/(max+1)*unsortedList.size());
            int bucketIndex;
            if(unsortedList.get(i)==max){
               bucketIndex=unsortedList.size()-1;
            }
            else{
                bucketIndex = (int)(((unsortedList.get(i)-min)/(max-min))*unsortedList.size());
            }
            if(arrayOfBuckets.get(bucketIndex)==null){
                ArrayList<Double> bucket = new ArrayList<Double>();
                bucket.add(unsortedList.get(i));
                arrayOfBuckets.set(bucketIndex, bucket);
            }
            else{
                arrayOfBuckets.get(bucketIndex).add(unsortedList.get(i));
            }
        }
        /*
        for(int i=0; i<arrayOfBuckets.size(); i++){
            if(arrayOfBuckets.get(i)!=null){
                for(int j=0;j<arrayOfBuckets.get(i).size(); j++){
                    System.out.println(arrayOfBuckets.get(i).get(j));
                }
            }      
        }
        */
        
        ArrayList<ArrayList<Double>> sortedArrayOfBuckets =  insertSort(arrayOfBuckets);
        ArrayList<Double> sortedArray =  merger(sortedArrayOfBuckets);
        /*
        int k=0;
        for(int i=0; i<unsortedList.size(); i++){
            if(arrayOfBuckets.get(i)!=null){
                for(int j=0;j<arrayOfBuckets.get(i).size(); j++){
                    unsortedList.set(k, arrayOfBuckets.get(i).get(j));
                    k++;
                }
            }      
        }
        return unsortedList;
        */
        //System.out.println(sortedArray);
        return sortedArray;
        
    }
    
    public static ArrayList<ArrayList<Double>> insertSort(ArrayList<ArrayList<Double>> arrayOfBuckets){
        for(int i=0; i<arrayOfBuckets.size(); i++){
            if(arrayOfBuckets.get(i)!=null){
                for(int j=0;j<arrayOfBuckets.get(i).size(); j++){
                    double placeHolder = arrayOfBuckets.get(i).get(j);
                    int hole=j;
                    while(hole>0 && placeHolder < arrayOfBuckets.get(i).get(hole-1)){
                        arrayOfBuckets.get(i).set(hole , arrayOfBuckets.get(i).get(hole-1));
                        hole=hole-1;
                    }
                    arrayOfBuckets.get(i).set(hole, placeHolder);
                }
            }      
        }
        return arrayOfBuckets;
    }
    
    public static ArrayList<Double> merger(ArrayList<ArrayList<Double>> sortedArrayOfBuckets){
        ArrayList<Double> sortedArray = new ArrayList<Double>();
        //int k=0;
        for(int i=0; i<sortedArrayOfBuckets.size(); i++){
            if(sortedArrayOfBuckets.get(i)!=null){
                for(int j=0;j<sortedArrayOfBuckets.get(i).size(); j++){
                    sortedArray.add(sortedArrayOfBuckets.get(i).get(j));
                    //k++;
                }
            }      
        }
        return sortedArray;
    }
    
}

