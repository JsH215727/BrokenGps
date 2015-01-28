/* 
 * Algorithm
 * 1. Calculate coordinates distance
 * 2. Generate random numbers
 * 3. Display results
 * 
 */
import java.util.Random;

public class Gps {
	private static int xCoord=0;
	private static int yCoord=0;
	
	public static void main( String[] args ){
		final int TURNS=12;
		
		System.out.println( "\t\t**Broken GPS**\nSpeed: 60 miles/hour \nDriver starting point: ( "+xCoord+", "+yCoord+" )" );
		System.out.println( "Random Directions took at each intersection: " );
		
		for( int i=0; i<TURNS ;i++ ){
			System.out.println( newDirection() );			
			// Determines a random direction
			System.out.println( "New Coordinates: "+"( "+xCoord+", "+yCoord+" )" );
		}
		
		System.out.println( "\n-->Final Coordinates: "+"( "+xCoord+", "+yCoord+" )" );
		System.out.println( "Distance: "+calculateDistance() +" miles" );
	}
	
	public static char newDirection(){		
		char direction='N';
		int dir;
                int x = 0, y = 0;
		// dir will store a random value between 0 and 3 as a supposed direction
		Random randGen = new Random();
		dir = randGen.nextInt(4);							
		// gives a random number from 0 to 3													
		// from 0  to 3 each is taken as a direction
		if( dir==0){										
			// North
			direction = 'N';
			yCoord++;
		}
		else if( dir==1 ){									
			// South
			direction = 'S';
			yCoord--;
		}
		else if( dir==2 ){									
			// East
			xCoord++;
			direction = 'E';
		}
		else if( dir==3){									
			// West
			xCoord--;
			direction = 'W';
		}
		return direction;									
		// Returns this new direction
	}
	
	public static double calculateDistance(){
		double dis=0;															
		// formula for distance = sqrt( (x2-x1)^2 + (y2-y1)^2 ); as x1 and y1 are 0 they are not needed
		dis = Math.sqrt(Math.pow( xCoord, 2 )+ Math.pow( yCoord, 2 ));	
		//if( dis!=0 & dis!=1 )						
			// Do not need to compute these values
			//dis = Math.sqrt( dis );
		//dis*=5;										
		// As each intersection is 5 miles away 
		//dis = Math.round(dis*100)/100;			
		// Rounding off the answer to 2 decimal places
		return dis;
	}
}