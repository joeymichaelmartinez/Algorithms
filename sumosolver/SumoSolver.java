package sumosolver;

public class SumoSolver {
    
    public static void main(String[] args){
        if(args.length<3 || args.length%2==0){
            throw new IllegalArgumentException();
        }
        
        if(Integer.parseInt(args[args.length-1])<0){
            throw new IllegalArgumentException();
        }
        
        int[] prices= new int[args.length/2];
        int[] weights= new int[args.length/2];
        String output= "";
        for(int i=0; i<args.length/2;i++){
            if(Integer.parseInt(args[2*i])<=0){
                throw new IllegalArgumentException();
            }
            prices[i]=Integer.parseInt(args[2*i]);
        }
        
        for(int i=0; i<args.length/2;i++){
            if(Integer.parseInt(args[2*i+1])<0){
                throw new IllegalArgumentException();
            }
            weights[i]=Integer.parseInt(args[2*i+1]);
        }
        
        int priceLimit=Integer.parseInt(args[args.length-1]);
        Tuple[][] subProblemArray = new Tuple[prices.length][priceLimit+1];

        Tuple answer = arrayFiller(prices, weights, priceLimit, subProblemArray, prices.length-1, priceLimit);
        int totalItems= answer.totalPricesUsed();
        int totalPrice=0;
        int totalWeight=0;
        for(int i=0; i<answer.length();i++){
            if(answer.getElement(i)==1){
                //System.out.println(answer);
                totalPrice+=prices[i];
                totalWeight+=weights[i];
                output="$" + prices[i] + " / " + weights[i] + " pounds";
                System.out.println(output);
            }
        }
        
        System.out.println(totalItems + " items / $" + totalPrice + " / " + totalWeight + " pounds" );
        
        //System.out.println(output);
    }
    
    public static Tuple arrayFiller(int[] prices, int[] weights, int priceLimit, Tuple[][] subProblemArray, int row, int col) {
        //System.out.println("We printed");
        if(row<0 || col<=0){
            //System.out.println("below zero " + row + ": " + col);
            Tuple emptyTuple= new Tuple(prices.length);
            return emptyTuple;
        }
        
        Tuple priceTuple= new Tuple(prices.length);
        
        //System.out.println(col-prices[row]);
        if(col-prices[row]<0){
            if(row>0){
                if(subProblemArray[row-1][col]!=null){
                    subProblemArray[row][col]=subProblemArray[row-1][col];
                }
                else{
                    subProblemArray[row][col]=arrayFiller(prices, weights, priceLimit, subProblemArray, row-1, col);
                }
                //System.out.println("could not subtract: " + row + ": " + col);
                
            }
            else{
                //System.out.println("at row 0 and could not subtract: " + row + ": " + col);
                subProblemArray[row][col]=priceTuple;
            }    
        }
        
        else{
            priceTuple.setElement(row, 1);
            subProblemArray[row][col]=priceTuple;
            //System.out.println(col-prices[row]);
            if(row>0 && subProblemArray[row][col-prices[row]]!=null){
                subProblemArray[row][col]=subProblemArray[row][col]=subProblemArray[row][col].add(subProblemArray[row-1][col-prices[row]]);
            }
                //System.out.println("InitialSolve: " + row + ": " + col);
            else{
                subProblemArray[row][col]=subProblemArray[row][col].add(arrayFiller(
                prices, weights, priceLimit, subProblemArray, row-1, col-prices[row]));
            }
                
            //System.out.println(arrayFiller(prices, weights, priceLimit, subProblemArray, row, col-prices[row]));
            
            if(row>0 && subProblemArray[row-1][col]!=null){
                tupleCompare(subProblemArray[row-1][col], subProblemArray[row][col], weights);
            }
            
            else if(tupleCompare(arrayFiller(prices, weights, priceLimit, subProblemArray, row-1, col), subProblemArray[row][col], weights)){
                subProblemArray[row][col]=subProblemArray[row-1][col];
                //System.out.println("Above was better: " + row + ": " + col);
            }
        }
        //System.out.println("This is where it was called");
        /*
        for(int i=0; i<=row; i++){
            for(int j=0; j<=col;j++){
                System.out.println("row: " + i + " col: " + j + " " + subProblemArray[i][j]);
            }
        }*/
        return subProblemArray[row][col];
    }
    
    public static boolean tupleCompare(Tuple firstTuple, Tuple secondTuple, int[] weights){
        int firstTotalWeight=0;
        int secondTotalWeight=0;
        
        
        for(int i=0; i<weights.length; i++){
            if(firstTuple.getElement(i)==1){
                firstTotalWeight+=weights[i];
            }
        }
        
        for(int i=0; i<weights.length; i++){
            if(secondTuple.getElement(i)==1){
                secondTotalWeight+=weights[i];
            }
        }
        
        return firstTotalWeight>secondTotalWeight;
    }
    
    public static class Tuple {
        
        private int[] prices;
    
        public Tuple(int numberOfPrices) {
            if (numberOfPrices < 0) {
                throw new IllegalArgumentException();
            }

            prices = new int[numberOfPrices];
            for (int i = 0; i < numberOfPrices; i++) {
                prices[i] = 0;
            }
        }

        public void setElement(int i, int j) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }

            if (i >= length()) {
                throw new IllegalArgumentException();
            }
            prices[i] = j;
        }

        public int getElement(int i) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }

            if (i >= length()) {
                throw new IllegalArgumentException();
            }
            return prices[i];
        }
        
        public int length() {
            return prices.length;
        }
        
        public int totalPricesUsed() {
            int sum = 0;
            for (int i = 0; i < length(); i++) {
                sum = sum + getElement(i);
            }
            return sum;
        }

        public Tuple add(Tuple tupleToAdd) {

            if (length() != tupleToAdd.length()) {
                throw new IllegalArgumentException();
            }

            Tuple sumTuple = new Tuple(length());
            for (int i = 0; i < length(); i++) {
                sumTuple.setElement(i, getElement(i) + tupleToAdd.getElement(i));
            }
            return sumTuple;
        }
        
        public String toString() {
            String result = "<";
            for (int i = 0; i < length(); i++) {
                result += (i > 0 ? "," : "") + prices[i];
            }
            return result + ">";
        }

    }
}
