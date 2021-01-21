
###Zelda List	

In assignment set 8, you implemented a class called LinkedElement that could be used to string together an arbitrary number of values. Doing so gave you something like a list, but it was a bit of a pain to always have to be sure to keep the correct head element saved somewhere. If we are going to use a list, there should be a main object to represent the list and provide access to it, just like with an ArrayList. The way it is implemented (with an array or using linked elements, for example) should be an implementation detail clients shouldn't have to worry too much about.
In this assignment, you will implement such a class that uses linked elements internally. But since there already is a LinkedList in Java, we will call this one ZeldaList.
Start by creating a new class called ZeldaList in a package called programming. set9 zelda. Your list will use linked objects that are instances of a class we provide to you, ZeldaElement, to store the values in the list. Download that class and put it in the same package. You are not allowed to change it. Neither are you allowed to use existing list implementations or arrays to store anything. In particular, we do not want you to keep an array of list values or even of ZeldaElement instances. Keeping a single head ZeldaElement is enough to reach the other elements.

When you implement remove ( . . . ) , indexOf ( . . . ) and contains (... ), remember: To test non-null objects of and o2 for equality, use ol . equals (o2) instead of of == o2 (think about why the latter would usually be wrong).
## Implement following methods
public  void add(T value)
public  boolean remove(T value) 
public  void  clear() 
public  int  size() 
public  T get(int  index) 
public  int  index0f(T value) 
public boolean  contains(T value)
public boolean  isEmpty()
