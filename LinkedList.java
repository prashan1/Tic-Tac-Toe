import java.util.Scanner;
import static  java.lang.System.*;
class LinkedList{
	public static Scanner e = new Scanner( System.in );
	static Node start = null;
		static 	class Node{
		int data;
		Node next;
		
	Node(int data){
		this.data = data;
		next = null;
		}
		
	}
	public static void Insert(int data ){
		
		Node newNode = new Node(data);
		
		if( start == null ){
			start = newNode;
				return ;
		}
		
		
			Node q = start ;
		
		while( q.next != null) 
			q = q.next;
		
		q.next = newNode;
		
	}
		
		
	public static void addFirst( int data ){
		
		Node newNode = new Node( data ) ;
		
		newNode.next = start ;
		start = newNode;
	}
		
		
	public static void addLast( int data ){
		
		Node newNode = new Node( data );
		Node q = start;
		
		while( q.next != null ) q = q.next;
		
		q.next = newNode ;
		newNode.next = null;
		
	}
	
	public static void addMiddle( int pos , int data ){
		
		Node newNode = new Node( data );
		Node q = start; 
		
		while ( --pos > 1 ) q = q.next;
		
		newNode = q.next;
		q.next = newNode;
		
		
	}
		
	public static void print(){
		Node q = start ;
		
		while( q != null ){
			
			out.println ( q.data );
			q = q.next;
		}
		
	}
		
	public static int Length( Node q ){
		if( q == null ) return 0 ;
		else
			return 1 + Length( q.next );
	}
		
		
	
	public static void main( String[] arg){
		LinkedList list = new LinkedList() ;
		
		
		
		int l=1;
		
		while( l==1 ){
			
			out.println( "Enter your choice ");
			out.println ("1--> Insert \n2--> addFirst \n3--> addLast \n4--> addMiddle \n5--> print\n6--> Length?  \n7--> Quit " ) ;
		
			switch( e.nextInt() ){
				
				case 1 : out.println( "data" );
					list.Insert( e.nextInt() ) ;
					break;	
				
				case 2 : out.println( "data" );
				
					list.addFirst( e.nextInt() ) ;
					break;
					
				case 3 : out.println( "data" );
				
					list.addLast( e.nextInt() ) ;
					break;	
					
				case 4 : out.println( "data" );
				int data = e.nextInt();
				
				out.println("pos? ");
				
				int pos = e.nextInt();
				
					list.addMiddle( pos, data ) ;
					break;
				case 5 :
					print();
					break;
					
				case 6 : 
						out.println( Length( start ) );
						break;
						
				case 7:
					l--;
					
					
				default : out.println( "Wrong" );
			}
		}
					
	}
	
	
}	
		