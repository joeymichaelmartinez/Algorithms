package crownandanchor;

public class CrownAndAnchor {
    
    /**
     * The main method runs the simulation of games, and then prints the percentage that 
     * the player lost over the entire game.
     */
    public static void main(String[] args){
        System.out.println(gameSimulator());
    }
    
    /**
     * Simulates the game Crown and Anchor by generating 4 random numbers,
     * the players choice, and the three dice rolls. The players earnings
     * are incremented according to the rules of the game, and then the game
     * is played a large amount of times. Once the games are all finished
     * we divide what the player earned by what the player put in. Since 
     * the player put in $1 each time, we will divide by the number of 
     * games played. Once we have this solution, we multiply by 100 to
     * turn the answer into a percentage. This is the percentage the player
     * is expected to lose over the course of many games. 
     */
    public static double gameSimulator(){
        int gamesPlayed = 10000000;
        double earnings = 0;
        
        for(int i=0; i<gamesPlayed; i++){
            earnings--;
            int choice = (int)(Math.random()*6+1);
            int dice1 = (int)(Math.random()*6+1);
            int dice2 = (int)(Math.random()*6+1);
            int dice3 = (int)(Math.random()*6+1);
            int count=0;
            if(dice1==choice){
                count++;
            }
            if(dice2==choice){
                count++;
            }
            if(dice3==choice){
                count++;
            }
            if(count>0){
                earnings=earnings + (1 + count);
            }
         }
        double percentage = (earnings/gamesPlayed)*100;
        return percentage;
    }
    
    
}
