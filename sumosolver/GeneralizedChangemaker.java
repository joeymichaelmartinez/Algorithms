package sumosolver;
import java.util.Arrays;
public class GeneralizedChangemaker {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {
            int amount = Integer.parseInt(args[0]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.");
                System.out.println();
                printUsage();
                return;
            }

            String[] denominationStrings = args[1].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.");
                    System.out.println();
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.");
                        System.out.println();
                        printUsage();
                        return;
                    }
                }
            }

            Tuple change = makeChangeWithDynamicProgramming(amount, denominations);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.");
            System.out.println();
            printUsage();
        }
    }

    public static Tuple makeChangeWithDynamicProgramming(int amount, int[] denominations) {
        int numOfDenoms = denominations.length;
        Tuple [][] tuples = new Tuple[numOfDenoms][amount + 1];
        int initialSubtract = 0;
        for (int i = 0; i < numOfDenoms; i++) {
            tuples[i][0] = new Tuple(numOfDenoms);
        }
        
        Tuple firstTuple = new Tuple(numOfDenoms);
        for (int row = 0; row < tuples.length; row++) {
            firstTuple.setElement(row, 1);
            for (int col = 1; col < tuples[row].length; col++) {
                tuples[row][col] = firstTuple; 
                initialSubtract = col - denominations[row];
                if(initialSubtract < 0) {
                    tuples[row][col] = Tuple.IMPOSSIBLE;
                    if (row > 0) {
                        tuples[row][col] = tuples[row-1][col];
                    }
                }
                else {
                    if(tuples[row][initialSubtract].isImpossible()) {
                        if(row > 0) {
                            tuples[row][col] = tuples[row - 1][col];
                        }                       
                        else {
                            tuples[row][col] = Tuple.IMPOSSIBLE;
                        }
                    }                    
                    else {
                        tuples[row][col] = tuples[row][col].add(tuples[row][initialSubtract]);
                    }
                }
                
                if(row > 0 && tuples[row-1][col].total() < tuples[row][col].total() && !tuples[row - 1][col].isImpossible()) {
                    tuples[row][col] = tuples[row-1][col];
                }
            }
        firstTuple.setElement(row, 0);
        }
        
        return tuples[numOfDenoms - 1][amount];
    }
    
    private static void dump(Tuple [][] tuples) {
        
        for(int i = 0; i < tuples.length; i++) {
            for(int j = 0; j < tuples[i].length; j++) {
                System.out.print(tuples[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printUsage() {
        System.out.println("Usage: java GeneralizedChangemaker <amount> <denominations>");
        System.out.println("  - <amount> is the amount for which to make change");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}