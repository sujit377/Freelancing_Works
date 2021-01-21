package Palindrome;

public class LinkedElement<T> {
	private T t;
	private LinkedElement<T> le=null;
	
//	construcotr initialise the class ans store the first value
	public LinkedElement(T t2){
//		assigning value to instance variable
		t=t2;
	}
	/**
	 * Returns the value of the i-th linked element, assuming the current element to be at
	 * index 0.
	 *
	 * @param i
	 * 0-based index of the element whose value to return.
	 * @return the i-th element's value, or {@code null} if there is no element with that index.
	 */
	public T get(int i) {
//		created a empty object reference and store the value of head le instance variable in temp
		LinkedElement<T> temp=le;
//		storing the value of head instance variable t
		T ret=t;
//		initializing the loop and store the i the object t value in ret
//		temp is used to reach i object
		for(int j=1;j<=i;j++) {
			ret = temp.t;
			temp=temp.le;
			if(temp==null) {
				return null;
			}
			
		}
		return ret;
	}
	
	/**
	 * Adds a new linked element holding the given value at the end of the linked elements.
	 *
	 * @param newVal
	 * the new value.
	 */
	public void add(T newVal) {
//		created a empty object reference and store the value of head le instance variable in it
		LinkedElement<T> temp=le;
//		if head's le have does have null value then this block will run
		if(temp==null) {
//			the head's le changed with this newly created object
			le= new LinkedElement<T>(newVal);
		}
//		if head's le have doesn't have null value then this block will run
		else {
//			this loop is used to save last object reference in temp
			while(temp.le!=null) {
				temp=temp.le;
			}
//		the last object le changed with this newly created object
		temp.le= new LinkedElement<T>(newVal);
		}
		
	}
	
	/**
	 * Removes the i-th element from the linked elements. If {@code i == 0}, this will effectively
	 * remove the head element. Thus, this method returns the linked element that is the new head
	 * element.
	 *
	 * @param i
	 * index of the element to remove.
	 * @return the new head element.
	 */

	public LinkedElement<T> remove(int i) {
//		this temp is created to reach the node which is just one index less than the node we are going to remove
		LinkedElement<T> temp= new LinkedElement<T>(t);
//		the null value value of temp is replaced with the head's le var
		temp.le=le;
//		head var is used return the starting node
		LinkedElement<T> head=temp;
//		this block will run if we are removing head
		if(i==0) {
			return head.le;
		}
//		this block will run if we are not removing head
		else {
//			this loop is used to reach the node which is just one index less than the node we are going to remove
			for(int j=1;j<i;j++) {
				temp = temp.le;
				if(temp==null || temp.le == null) {
					LinkedElement<T> temp2= new LinkedElement<T>(t);
					temp2.le=le;
					return temp2;
				}
			}
//			the reference of node just after the removing node is saved in the le var of the node which is just befor
//			the removing node
			temp.le=temp.le.le;
			return head;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedElement<String> headElement = new LinkedElement<String>("Yo!");
		headElement.add("Kiel");
		headElement.add("is");
		headElement.add("about");
		headElement.add("to");
		headElement.add("witness");
		headElement.add("another");
		headElement.add("sunny");
		headElement.add("day!");
		System.out.println(headElement.get(11));
		headElement = headElement.remove(9);
		headElement = headElement.remove(6);
		headElement = headElement.remove(0);
		System.out.println(headElement.get(5));
		headElement = headElement.remove(23);
		System.out.println(headElement.get(5));
		System.out.println(headElement.get(6));
		headElement = headElement.remove(9);
		System.out.println(headElement.get(0));
		System.out.println(headElement.get(1));
		System.out.println(headElement.get(2));
		System.out.println(headElement.get(3));
		System.out.println(headElement.get(4));
		System.out.println(headElement.get(0));
		

	}

}
