# Linked Elements: Elements That Are Linked
Linking has long been a core concept in the history of humanity, which explains old proverbs such as “A chain
is no stronger than its weakest link.” or “At the link of an eye.”
During the lecture, you saw how you can link objects together. In this assignment, we will use this concept to
link objects together that hold an arbitrary value. If we save the first such object (the head element), we have
effectively built what is usually called a linked list. Starting at the head element, we can assign each item in
the linked list a 0-based index: the head element will have index 0, the next element will have index 1, and so
on. The end of the list is reached once an element doesn’t link to a next element anymore. Once finished, you
should be able to use your class like this:

Note that the element with index i can be understood as the head of a smaller linked list where it can be
found at index 0 (and element i + 1 in the original list can be found at index 1, and so on).
Start by writing a class LinkedElement<T> in a package called programming.set8.links. T will be a placeholder for the data type of the value the element can hold. Add two private instance variables: one should hold
the value the element stores, and the other should be a link to the next element, if any. Add a constructor that
takes a parameter of type T that will become the value of the new linked element. Then, add the following
methods:

public T get(int i)
public void add(T newVal)
public LinkedElement<T> remove(int i)
