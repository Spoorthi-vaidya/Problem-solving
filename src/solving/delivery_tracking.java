/**
 * 
 */
package solving;
import java.util.*;
import java.io.*;
/**
 * @author Spoorthi Vaidya
 *
 */


interface delivery{
	
	void received_orders();
	void cancellorders();
	void serve_orders_and_add_to_list();
	void operation_after_landing();
	void track_missing_drone();
	
	
	
}


public class delivery_tracking implements delivery {

	private static delivery_tracking dobject= new delivery_tracking();
	//ArrayList<delivery_tracking> list;
	
	//ArrayList<Integer> id_list=new ArrayList<Integer>(1000);
	int customerID;
	int deliveryID;
	int nooforders;
	ArrayList<Integer> orderlist;
	ArrayList<Integer>Deliverylist;
	static int[][] list;
	Scanner s= new Scanner(System.in);
	
	
	private delivery_tracking() {
	

		
		
		System.out.println("Enter the number of orders received: ");
		nooforders=s.nextInt();
		orderlist= new ArrayList<Integer>(nooforders);
		//list=new int[nooforders][nooforders];
		Deliverylist=new ArrayList<Integer>(nooforders);
		//list=new ArrayList<delivery_tracking>()
		
		
	}
	public static delivery_tracking getInstance(){
		
		return dobject;
	}

	public void received_orders() {
		
		
		System.out.println("Enter the customerID list of received order: ");
		
		for(int i=0;i<nooforders;i++)
		{
			
			customerID=s.nextInt();
			orderlist.add(customerID);
			
		}
		System.out.println("CUSTOMER ID ORDER LIST IS :\n");
		System.out.println(orderlist);
		
		
		
		
		
	}

	public void cancellorders(){
	
		System.out.println("Enter the number of orders cancelled");
		int k=orderlist.size();
		int cancelledno=s.nextInt();
		
		if(cancelledno==0){
			
			System.out.println("No orders are cancelled\n");
		}
		else
		{
		
			System.out.println("Enter the customerID whose order is cancelled: ");
			for(int i=0;i<cancelledno;i++)
			{
				
				int id=s.nextInt();
				for(int j=0;j<k;j++)
				{
					if(orderlist.get(j)==id){
						
						System.out.println(orderlist.get(j)+" is removed");
						orderlist.remove(j);
						
					}
					
				}
				
			}
			System.out.println("the order list of customerID after cancellation:"+orderlist);
			
		}
		
		
	/*System.out.println("Enter the order in which the customers are served: ");
	
	
	for(int i=0;i<nooforders;i++)
	{
		
		deliveryID=s.nextInt();
		orderlist.add(deliveryID);
		
	}*/
	
	
		
		
		
	}
	public void serve_orders_and_add_to_list() {
	
		boolean flag = false;
		boolean flag2=false;
		list=new int[orderlist.size()][orderlist.size()];
		System.out.println("Enter the customerID and is deliveryid: ");
		
		for(int i=0;i<orderlist.size();i++)
		{
			if(flag2==true)
			{
				i=i-1;
			}
			int cid=s.nextInt();
			for(int j=0;j<orderlist.size();j++){
				
				if(orderlist.get(j)==cid){
					flag=true;
				}
			}
				
			if(flag==true){
				
				
				deliveryID=s.nextInt();
				Deliverylist.add(deliveryID);
				System.out.println("customer_id "+" '"+cid+"' "+" serverd with serverd no: "+(i+1));
				list[i][0]=cid;
				list[i][1]=deliveryID;
				
			}
			else{
				
				System.out.println("INVALID CUSTOMER ID ENTERED \n");
				flag2=true;
				
			}
			
			
		}
		System.out.println("Deliverylist before landing : "+ Deliverylist);
		
		
	}
	
	public void  display(){
		
		for(int i=0;i<orderlist.size();i++){
			System.out.println("CustomerID: "+list[i][0]+"DeliveryID: "+list[i][1]);
			
			
			
		}
	}
	public void operation_after_landing() {
		System.out.println("Enter the number of drones that returned back safely :");
		int m=s.nextInt();
		
		System.out.println("Enter the deliveryID of the drone that landed back safely :");
		for(int i=0;i<m;i++){
			
			int d=s.nextInt();
			Deliverylist.add(d);
			
			
		}
		System.out.println("Delivery list after drones returning back"+ Deliverylist);
		
		
	}
	public void track_missing_drone() {
		int[] l=new int[Deliverylist.size()];
		int flag=0;
		ArrayList<Integer> l2=new ArrayList<Integer>();
		for(int i=0;i<Deliverylist.size();i++)
		{
			l[i]=Deliverylist.get(i);
		}
		
		

				for(int i=0;i<l.length;i++)
				{
					for(int j=0;j<l.length;j++)
					{
						if(i!=j)
						{
							if(l[i]!=l[j])
							{
								flag=1;
							}
							else
							{
								flag=0;
								break;
							}
							
						}
						
						
					}
					if(flag==1)
					{
						l2.add(l[i]);
					}
					
				}
				System.out.println("No of missing drones: "+l2.size());
				
				System.out.println("The DeliveryIDs of the drone(s) that are missing are :");
               System.out.println(l2);
            	   
         }
			
		
		
		
	}
	
	

	



