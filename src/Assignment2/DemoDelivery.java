package Assignment2;

public class DemoDelivery {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			delivery_tracking d=delivery_tracking.getInstance();
			d.received_orders();
			d.cancellorders();
			d.serve_orders_and_add_to_list();
			d.display();
			d.operation_after_landing();
			d.track_missing_drone();
			
	

	}

}
