/**
 * 
 */
package Assignment2;

import java.util.*;
import java.io.*;

/**
 * @author Spoorthi Vaidya
 * 
 */

public class delivery_tracking implements delivery {

	// USING SINGLETON DESIGN PATTERN
	private static delivery_tracking dobject = new delivery_tracking();
	int customerID;
	int deliveryID;
	int nooforders;
	ArrayList<Integer> orderlist;
	ArrayList<Integer> Deliverylist;
	static int[][] list;
	Scanner s = new Scanner(System.in);

	private delivery_tracking() {

		System.out.println("Enter the number of orders received: ");
		nooforders = s.nextInt();
		orderlist = new ArrayList<Integer>(nooforders);
		Deliverylist = new ArrayList<Integer>(nooforders);

	}

	public static delivery_tracking getInstance() {

		return dobject;
	}

	/* Functionality: Receive orders */
	public void received_orders() {

		System.out.println("Enter the customerID list of received orders: ");

		for (int i = 0; i < nooforders; i++) {

			customerID = s.nextInt();
			orderlist.add(customerID);

		}
		System.out.println("CUSTOMER ID ORDER LIST IS :\n");
		System.out.println(orderlist);

	}

	/* Functionality: Cancel the orders */
	public void cancellorders() {

		System.out.println("Enter the number of orders cancelled");
		int k = orderlist.size();
		int cancelledno = s.nextInt();

		if (cancelledno == 0) {

			System.out.println("No orders are cancelled\n");
		} else {

			System.out
					.println("Enter the customerID whose order is cancelled: ");
			for (int i = 0; i < cancelledno; i++) {

				int id = s.nextInt();
				for (int j = 0; j < k; j++) {
					if (orderlist.get(j) == id) {

						System.out.println(orderlist.get(j) + " is removed");
						orderlist.remove(j);
						break;

					}

				}

			}
			System.out
					.println("The order list of customerID after cancellation:"
							+ orderlist);

		}

	}

	/* Functionality: Serve the orders */
	public void serve_orders_and_add_to_list() {

		int flag = 0;
		list = new int[orderlist.size()][orderlist.size()];
		int k = 0, l = 0;
		// Orders aren't full filled in the order they are received.
		System.out
				.println("Enter the customerID and its deliveryID in the order they are served: ");

		for (int i = 0; i < orderlist.size(); i++) {
			int m = i - 1;
			int cid = s.nextInt();
			flag = 0;
			for (int j = 0; j < orderlist.size(); j++) {

				if (orderlist.get(j) == cid) {
					flag = 1;
				}
			}

			if (flag == 1) {

				deliveryID = s.nextInt();
				Deliverylist.add(deliveryID);
				System.out.println("customer_id " + " '" + cid + "' "
						+ " serverd with serverd no: " + (i + 1));
				list[k++][0] = cid;
				list[l++][1] = deliveryID;

			} else {

				System.out.println("Invalid customerID entered");

				i = m;
			}

		}
		System.out.println("Deliverylist before landing : " + Deliverylist);

	}

	public void display() {

		for (int i = 0; i < orderlist.size(); i++) {
			System.out.println("CustomerID: " + list[i][0] + "DeliveryID: "
					+ list[i][1]);

		}
	}

	/*
	 * Functionality:adding the deliveryID of the drones to delivery list, if
	 * returns back safely
	 */

	public void operation_after_landing() {
		System.out
				.println("Enter the number of drones that returned back safely :");
		int m = s.nextInt();
		int flag = 0;
		int n = Deliverylist.size();
		System.out
				.println("Enter the deliveryID of the drone that landed back safely :");
		for (int i = 0; i < m; i++) {
			flag = 0;
			int d = s.nextInt();
			for (int j = 0; j < Deliverylist.size(); j++) {
				if (Deliverylist.get(j) == d) {
					flag = 1;

				}
			}
			if (flag == 1) {

				// adding the deliveryID of the drones to delivery list since it
				// returned back safely.
				Deliverylist.add(d);
			} else {
				i = i - 1;
				try {
					throw new Invalid_DeliveryID_Exception();
				} catch (Invalid_DeliveryID_Exception exp) {
					System.out.println(exp);
				}
			}
		}
		System.out.println("Delivery list after drones returning back"
				+ Deliverylist);

	}

	/* Functionality: Tracking missing drone */

	public void track_missing_drone() {

		int[] l = new int[Deliverylist.size()];
		int flag = 0;
		int k = 0;
		ArrayList<Integer> l2 = new ArrayList<Integer>();

		for (int i = 0; i < Deliverylist.size(); i++) {
			l[i] = Deliverylist.get(i);
		}

		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l.length; j++) {
				if (i != j) {
					if (l[i] != l[j]) {
						flag = 1;
					} else {
						flag = 0;
						break;
					}

				}

			}
			if (flag == 1) {
				l2.add(l[i]);
				k = 1;
			}

		}
		if (k == 1) {
			System.out.println("Number of missing drones: " + l2.size());

			System.out
					.println("The DeliveryIDs of the drone(s) that are missing are :");
			System.out.println(l2);
		} else {

			System.out.println("All drones reached back safely");
		}
	}

}
