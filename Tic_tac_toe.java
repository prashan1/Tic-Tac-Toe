import java.util.*;	
class Tic_tac_toe{
	static Scanner e = new Scanner( System.in );
	public static boolean variate  = true;
	
	public static List< Integer > userlist = new ArrayList< Integer > ();
	public static List< Integer > cpulist = new ArrayList< Integer > ();
	static String[][] gameboard = {{" "," | "," "," | "," "},								//GameBoard
								   {"-","-|-","-","-|-","-"},
								   {" "," | "," "," | "," "},
								   {"-","-|-","-","-|-","-"},
							       {" "," | "," "," | "," "},};
	public static void main( String[] argr)throws InterruptedException{
		
		System.out.println( "Enter you first command my habibi! ");
		BoardGame();
		boolean terminate = true;
		
	while( terminate ){																		//Game Start
			
		if( variate ){																		// For changing Player
			System.out.println( "YOUR TURN ");
		int userInput = e.nextInt();
		 if( cpulist.contains( userInput ) || userlist.contains( userInput) ){
			 System.out.println( "Position already taken Try another \n" );					//If position is already taken 
			 continue;
		 }
		 input( userInput , "user");
		
		}
		else{
			System.out.println( "CPU turn ");
			Thread.sleep( 800 );
		Random rand = new Random() ; 
		int pcInput = rand.nextInt(9) + 1;
		 if( cpulist.contains( pcInput ) || userlist.contains( pcInput) ){
			 System.out.println( "Position already taken Try Another \n" );
			 continue;
		 }
		 input( pcInput , "cpu");	
			 
		}
	
		System.out.println();
		variate = !variate;																	//to alter players
		
		BoardGame();
		
		 if( checkWinWin() ){																//Check if anybody Won!
			 terminate = false;
			 continue;
		 }
																							
	}
}
	
	public static void BoardGame(){															// Print The Board		
		for(int i = 0 ; i< gameboard.length;i++){
			 for(int j = 0 ; j < gameboard.length ; j++)
				 System.out.print(gameboard[i][j]);
			 System.out.println();
			 
		 
	}
}	
	public static void input( int a , String player){										//Entered data
			String alpha = "";
			if( player == "user" ){
				alpha = "X";
				
			}
			else{
				
				alpha = "0";
			}
			
		switch( a ){
			 case 1 :  if( gameboard[0][0] == " " )
						gameboard[0][0] = alpha;
						
						break;
			 case 2 :  if( gameboard[0][2] == " " )
						gameboard[0][2] = alpha;
						
						break;
			 case 3 :  if( gameboard[0][4] == " " )
						
						gameboard[0][4] = alpha;
						break;
			 case 4 :  if( gameboard[2][0] == " " )
						gameboard[2][0] = alpha;
						
						break;
			 case 5 :	  if( gameboard[2][2] == " " )
							gameboard[2][2] = alpha;
						
						break;
			 case 6 : 
						if( gameboard[2][4] == " " )
						gameboard[2][4] = alpha;
						
			 			break;
			 case 7 :	if( gameboard[4][0] == " " )
						gameboard[4][0] = alpha;
						
			 			break;
			 case 8 :	if( gameboard[4][2] == " " )
						gameboard[4][2] = alpha;
						
			 
						break;
			 case 9 : 	if( gameboard[4][4] == " " )
						gameboard[4][4] = alpha;
						
			 
						break;
		}
		if( player == "user")
			 userlist.add( a );
		else
			 cpulist.add( a );
}
	public static boolean checkWinWin() throws InterruptedException{									//Winning condition
		List row1 =  Arrays.asList( 1 ,2, 3 );
		List row2 = Arrays.asList( 4 ,5, 6 );
		List row3 = Arrays.asList( 7 ,8, 9 );
		List colm1 =  Arrays.asList( 1 ,4, 7 );
		List colm2 = Arrays.asList( 2 ,5, 8 );
		List colm3 = Arrays.asList( 3 ,6, 9 );
		List dia1 = Arrays.asList( 1 ,5, 9 );
		List dia2 =Arrays.asList( 3 ,5, 7 );
		
		List< List > checkAllList = new ArrayList< List >();
		checkAllList.add( row1 );
		checkAllList.add( row2 );
		checkAllList.add( row3 );
		checkAllList.add( colm1 );
		checkAllList.add( colm2 );
		checkAllList.add( colm3 );
		checkAllList.add( dia1 );
		checkAllList.add( dia2 );
		
		for( List l : checkAllList )
		 if( userlist.containsAll( l ) ){
			 Thread.sleep( 500 );
			 System.out.println( "You Won! " );
			return true;
			}
			else if( cpulist.containsAll( l ) ){
				Thread.sleep( 500 );
			 System.out.println( "You Lose! " );
			 return true;
			}
			else if( cpulist.size() + userlist.size() == 9 ){
				Thread.sleep( 500 );
				System.out.println( "That's a Draw ");
				 return true;
			}
			 
			 
	  return false;

		
	}
		
		
}