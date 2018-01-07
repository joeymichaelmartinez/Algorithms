package sumosolver;

public class sumoSolverSucky {
        public static Tuple arrayFiller(int[] prices, int[] weights, int priceLimit, Tuple[][] subProblemArray, int row, int col) {
            if(row<=0 || col<=0){
                return Tuple.IMPOSSIBLE;
            }
            
            Tuple priceTuple= new Tuple(prices.length);
            
            //System.out.println(col-prices[row]);
            if(col-prices[row]<0){
                if(row>0){
                    subProblemArray[row][col]=arrayFiller(prices, weights, priceLimit, subProblemArray, row-1, col);
                    if(arrayFiller(prices, weights, priceLimit, subProblemArray, row-1, col)!=null && subProblemArray[row][col]!=null &&
                      tupleCompare(arrayFiller(prices, weights, priceLimit, subProblemArray, row-1, col), subProblemArray[row][col], weights)){
                        subProblemArray[row][col]=subProblemArray[row-1][col];
                        //System.out.println(arrayFiller(prices, weights, priceLimit, subProblemArray, row, col));
                    }
                }
                else{
                    priceTuple=Tuple.IMPOSSIBLE;
                    subProblemArray[row][col]=priceTuple;
                }    
            }
            
            else{
                priceTuple.setElement(row, 1);
                subProblemArray[row][col]=priceTuple;
                //System.out.println(arrayFiller(prices, weights, priceLimit, subProblemArray, row, col-prices[row]));
                if(!arrayFiller(prices, weights, priceLimit, subProblemArray, row, col-prices[row]).isImpossible()){
                    subProblemArray[row][col]=subProblemArray[row][col].add(subProblemArray[row][col-prices[row]]);
                    System.out.println(arrayFiller(prices, weights, priceLimit, subProblemArray, row, col-prices[row]));
                }
                
                if(tupleCompare(arrayFiller(prices, weights, priceLimit, subProblemArray, row-1, col), subProblemArray[row][col], weights)){
                    subProblemArray[row][col]=subProblemArray[row-1][col];
                    //System.out.println(arrayFiller(prices, weights, priceLimit, subProblemArray, row, col));
                }
            }
            
            /*for(int i=0; i<row; i++){
                for(int j=0; j<col;j++){
                    System.out.println("row: " + row + " col: " + col + " " + subProblemArray[i][j]);
                }
            }*/
            return subProblemArray[row][col];
        }
        
        public static boolean tupleCompare(Tuple firstTuple, Tuple secondTuple, int[] weights){
            int firstTotalWeight=0;
            int secondTotalWeight=0;
            if(firstTuple.isImpossible() || secondTuple.isImpossible()){
                return false;
            }
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
    }
