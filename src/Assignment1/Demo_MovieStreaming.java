package Assignment1;
import java.io.*;
import java.util.Scanner;

public class Demo_MovieStreaming {


	public static void main(String[] args) {
	
		Scanner s=new Scanner(System.in);
		MovieStreaming m=new MovieStreaming();
		
		m.find_movies_samelength();
		
		System.out.println("Enter the travellength: ");
		int travellength=s.nextInt();
		boolean flag=m.check_for_two_movies(travellength);
		
		if(flag==false)
		{
			try{
				throw new NoTwoMovies_Exception();
				
			}
			catch(NoTwoMovies_Exception exp){
				 System.out.println(exp);
			}
		}
		
	}

}
