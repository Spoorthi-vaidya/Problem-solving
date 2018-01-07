package Assignment1;
import java.util.*;
import java.io.*;

/**
 * @author Spoorthi Vaidya
 *
 */

public class MovieStreaming extends MoviesList {

	
	
	public MovieStreaming() {
	
		this.displayMovieList();
	}
	
	public void displayMovieList(){
		
		Set<Map.Entry<Integer,MovieKeys> >a=movielist.entrySet();
		
		System.out.println("Existing movieid, moviename and their corresponding length : \n");
		
		for(Map.Entry<Integer,MovieKeys> s:a){	
			System.out.println(s.getKey()+":"+s.getValue().moviename+":"+s.getValue().movielength);
		}
		
		
		
	}
	
	public boolean check_for_two_movies(int travellength){
	
		int[][] movie_length=new int[noofmovies][noofmovies];
		int k=0;
		int l=0;
		boolean flag=false;
		
		Set<Map.Entry<Integer,MovieKeys>>a=movielist.entrySet();
		for(Map.Entry<Integer,MovieKeys>s:a){	
			movie_length[k++][0]=s.getKey();	
			movie_length[l++][1]=s.getValue().movielength;
			
		}
		
		
		System.out.println("\nMovieID,movielength of two movies whose sum is equal to travel length is: ");

		for(int i=0;i<noofmovies;i++){
			int l1=movie_length[i][1];
			for (int m= i + 1; m <noofmovies; m++){
				 int l2 = movie_length[m][1];
				 if(movie_length[m][0]!=movie_length[i][0])
				 {	 
				 		if ((l1 + l2) == travellength) 
				 		{
				 			flag=true;
				 			System.out.println("[("+movie_length[i][0]+","+movie_length[i][1]+")"+" , "+"("+movie_length[m][0]+","+movie_length[m][1]+")]");
				 		}
				 		
				 }
			}
			
			
			
			
		}
	
		
		return flag;
		
		
	}
	
	public void find_movies_samelength(){
		int[][] movie_length=new int[noofmovies][noofmovies];
		int[]l;
		int m=0;
		int n=0;
		Set<Map.Entry<Integer,MovieKeys>>a=movielist.entrySet();
		for(Map.Entry<Integer,MovieKeys>s:a){
			movie_length[m++][0]=s.getKey();	
			movie_length[n++][1]=s.getValue().movielength;
			
		}
		System.out.println("\nMovieIds which have same length: ");
		for(int i=0;i<noofmovies;i++){
			for(int j=i+1;j<noofmovies;j++)
			{
				 if(movie_length[j][0]!=movie_length[i][0])
				 {
					 	if(movie_length[i][1]==movie_length[j][1])
					 	{
					 		System.out.println("("+movie_length[i][0]+","+movie_length[j][0]+")");
					
						}
				 }
				
			}
		}
		
		
	}
	
	

}
