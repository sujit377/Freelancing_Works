package Palindrome;
import Palindrome.ZeldaElement;
public class ZeldaList<T> {
//	created to store head
	ZeldaElement<T> ze = new ZeldaElement<T>();
//	* Adds  the given value  to  the  end  of  the  list.
// 	* 	@param value
// 			the value  to  add.  If {Ocode value == 	null},  nothing happens.
	
 	public  void add(T value) {
// 		if value is not null passed
 		if(value!=null) {
// 			for the first time addition
 			if(ze.getValue()==null) {
 				ze.setValue(value);
 			}
// 			for addition after first;
 			else {
// 				make a node to transverse
 				ZeldaElement<T> temp = new ZeldaElement<T>();
 				temp=ze;
// 				check for the last value
 				while(temp.getNextElement()!=null) {
 					temp=temp.getNextElement();
 				}
// 				additon to the last node
 				ZeldaElement<T> temp2 = new ZeldaElement<T>();
 				temp2.setValue(value);
 				temp.setNextElement(temp2);
 			}
 		}
 	}
 	
// 	* Removes  the first  occurrence  of  the given value from  the  list.
//
// 	* 	@param value  the  value  to  remove.  If  this  is {Ocode null),  nothing  is  removed. 
// 	* 	@return {Ocode  true}  if  the value  was found  and removed, 	{@code false}  otherwise.
 	
 	public  boolean remove(T value) {
// 		if index is less than zero null is returned
 		if(value!=null) {
// 			all the changes made to this only
 			ZeldaElement<T> temp = new ZeldaElement<T>();
// 	 		used to transverse
 			ZeldaElement<T> temp2 = new ZeldaElement<T>();
// 			temp is one behind
 			temp=ze;
// 			temp2 is poiting one node greater than temp
 			temp2=ze.getNextElement();
// 			if list is empty
 			if(ze.getValue()==null) {
 				return false;
 			}
// 			runs if only head have element means size of list is one
 			if(ze.getValue().equals(value) && temp2==null) {
 				ze.setNextElement(null);
 				ze.setValue(null);;
 				return true;
 			}
// 			runs if size is grreater than one
 			if(ze.getValue().equals(value)) {
 				ze=temp2;
 				return true;
 			}
// 			run untill the end of list reached
 			while(temp2!=null) {
// 				check value matched or not
 				if(temp2.getValue().equals(value)) {
// 					temp next element is changed to next of next 
 					temp.setNextElement(temp2.getNextElement());
 					return true;
 				}
// 				inceamention steps
 				temp=temp2;
 				temp2=temp2.getNextElement();
 			}
 			return false;
 		}
 		return false;
 	}
 	
 	
// 	* Removes  all  elements from  the  list.
 	public  void  clear() {
// 		assign null to the variables of head to make it empty
 		ze.setNextElement(null);
 		ze.setValue(null);
 	}
 	
// 	* Returns  the number of  elements  in  the  list.
// 	* 	@return number of  elements.
 	public  int  size() {
// 		store the size
 		int size=0;
// 		used to transverse
 		ZeldaElement<T> temp = new ZeldaElement<T>();
// 		head value is assigned
 		temp=ze;
// 		if head's data value is null the 0 is returned
 		if(temp.getValue()==null) {
 			return 0;
 		}
// 		size increamened untill we get the null node
 		while(temp!=null) {
 			temp=temp.getNextElement();
 			size++;
 		}
 		return size;
 	}
 	
 	
// 	* Returns  the value  at  the given  index  in  the  list.
// 	* 	@param  index
// 	the  index  of  the  element  whose value  to  return.
// 	* 	@return  the value  at  the given  index,  or f@code null) if the index is 	invalid.
// 	
 	public  T get(int  index) {
// 		if index is less than zero null is returned
 		if(index<0) {
 			return null;
 		}
// 		size is used to store index
 		int size=0;
// 		used to transverse
 		ZeldaElement<T> temp = new ZeldaElement<T>();
 		temp=ze;
// 		check for null (is index is more than the size of list then it exits or if index is reached then it will return that
 		while(temp!=null && index!=size) {
 			temp=temp.getNextElement();
 			size++;
 		}
// 		if loop reached to tha last of list but index is not reached then return null
 		if(temp!=null) {
 			return temp.getValue();
 		}
 		return null;
 		
 		
 	}
 	
// 	* Returns  the  smallest  index where  the given value  appears  in  the  list, 	if  it  does.
// 	* 	@param value
// 	the value  to  look for.
// 	* 	@return  the value's  index  or -1  if  fOcode value ==null)  or  if  the value  is  not  in  the  list.
 	public  int  index0f(T value) {
// 		if value is null then -1 returned 
 		if(value==null) {
 			return -1;
 		}
// 		index is start with zero for the first element so -1 increment for every node
 		int index=-1;
// 		used to transverse
 		ZeldaElement<T> temp = new ZeldaElement<T>();
 		temp=ze;
// 		icreamented till data is matched or list ended 
 		while(temp!=null && temp.getValue()!=value) {
 			temp=temp.getNextElement();
 			index++;
 		}
// 		if value is present then temp must not be null
 		if(temp!=null) {
 			return index+1;
 		}
 		return -1;
 	}
 	
// 	Checks  if  the given value  appears  anywhere  in  the  list.
// 	 Oparam value
// 	the value  to  search for.
//
// 	*	@return  fOcode  true)  if  the value  appears  in  the  list,  fOcode false)  if  it  doesn't  or  if	it
// 	is	{@code
 	
 	public boolean  contains(T value) {
// 		if value is null then -1 returned 
 		if(value == null) {
 			return false;
 		}
// 		used to transverse
 		ZeldaElement<T> temp = new ZeldaElement<T>();
 		temp=ze;
// 		increamented till data is matched or list ended 
 		while(temp!=null) {
			if(temp.getValue()!=null &&temp.getValue().equals(value)) {
				return true;
			}
			temp=temp.getNextElement();
 		}
// 		if not matched
 		return false;
 	}
 	
// 	* Checks  if  the  list  contains  any  elements.
// 	@return  fOcode  true)  if  the  list  is  empty,  f@code false) if it  isn't.
// 
 	public boolean  isEmpty()	{
// 		if value of head is empty means it is null
 		if(ze.getValue()==null) {
 			return true;
 		}
 		return false;
 	}
 	



 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeldaList<Integer> z = new ZeldaList<Integer>(); 
		z.add(-2147483648);
		System.out.println(z.size());
		System.out.println(z.get(0));
		System.out.println(z.get(1));
		System.out.println(z.get(2));
		System.out.println(z.get(47));
		System.out.println(z.get(-59));
		System.out.println(z.size());
		z.add(-2147483648);
		System.out.println(z.size());
		System.out.println(z.get(0));
		System.out.println(z.get(1));
		System.out.println(z.get(2));
		System.out.println(z.get(3));
		System.out.println(z.get(16));
		System.out.println(z.get(-22));
		System.out.println(z.size());
		z.add(-2147483648);
		System.out.println(z.size());
		System.out.println(z.get(0));
		System.out.println(z.get(1));
		System.out.println(z.get(2));
		System.out.println(z.get(3));
		System.out.println(z.get(4));
		System.out.println(z.get(94));
		System.out.println(z.get(-27));
		System.out.println(z.size());
		z.add(-2147483648);
		System.out.println(z.size());	
		System.out.println(z.get(0));
		System.out.println(z.get(1));
		System.out.println(z.get(2));
		System.out.println(z.get(3));
		System.out.println(z.get(4));
		System.out.println(z.get(5));
		System.out.println(z.get(13));
		System.out.println(z.get(-23));
		System.out.println(z.size());
		System.out.println(z.get(3));
		System.out.println(z.remove(-2147483648));
		System.out.println(z.size());
		
		
//		z.add(-2147483648);
//		z.add(-2147483648);
//		System.out.println(z.size());
//		System.out.println(z.contains(2));
//		System.out.println(z.isEmpty());
//		System.out.println(z.index0f(2));
//		System.out.println(z.get(1));
//		System.out.println(z.get(11));
//		System.out.println(z.remove(-2147483648));
//		System.out.println(z.get(-11));
//		System.out.println(z.size());
		

	}

}
