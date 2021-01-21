# Genetic Engineering
The quest to become an evil genius super villain with his own army is a long and turbulent one, but starts with: genetics! Which, by a crazy random happenstance, we're going to learn everything about in this assignment.
The genetic code of things that have one can be encoded as a string of four distinct bases where each character is either an 'A' (adenosine), 'C' (cytosine), 'G' (guanine), or 'T' (thymine). The DNA molecule consists of two strings of bases that connect to form the characteristical double helix that you will probably have heard of in school. However, the four bases cannot be attached to each other arbitrarily. Adenosine links only with thymine (and vice versa), and cytosine links only with guanine (and vice versa).
Suppose that you have the following short DNA string (yes, we are aware that yours is longer):

0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15
A  T  T  C  C  T  A  A  T  G  T  C  A  A  T  T

Suppose further that you also have this (even shorter) DNA string:


0	1	2	3	4	5	6
G  A  T  T  A  C  A

Write a class DNAMatcher in a package called programming. set9.dna. Add a constructor that accepts a base DNA string that candidate DNA strings can be matched against later. The constructor should only accept non-null and non-empty DNA strings that consist only of the four characters above. If an invalid string is passed to the constructor, it should throw an IllegalArgumentException.
Next, add a method to match candidate DNA strings to the base string:
## Method to implement
### public  int  findFirstBindingPosition(String  candidateDNA)
