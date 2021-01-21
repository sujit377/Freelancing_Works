package Palindrome;
import java.lang.IllegalArgumentException;
public class DNAMatcher {
//	TO STORE BASEDNA
	String baseDNA;
	
//	CONSTRUTOR
	public DNAMatcher(String base_DNA) throws IllegalArgumentException {
		base_DNA=base_DNA.trim();
//		IF STRING IS EMPTY OR NULL THEN THROW ERROR
		if(base_DNA==null || base_DNA.equals("")) {
			throw new IllegalArgumentException();
		}
//		CHECK ALPHABETS ARE ONLY A T G C
		for(int i=0;i<base_DNA.length();i++) {
			if((base_DNA.charAt(i)!='C')&& (base_DNA.charAt(i)!='G')&&(base_DNA.charAt(i)!='T')&&(base_DNA.charAt(i)!='A')) {
				throw new IllegalArgumentException();
			}
		}
//		ASSIGNING VALUE TO VARIABLE IF EVERYTHING RIGHT
		baseDNA = base_DNA;
		
	}
	
	
//	* Returns  the  index  of  the first position  in  the  base DNA  string  where
//	*  candidateDNA  can  bind,   if any.
//	* Oparam candidateDNA
//		the DNA  string  to  try  to  bind  to  the  base DNA.
//@return  index  of  the first  binding position  or f@code -1  if  the  candidate
//	DNA  string  cannot  bind  to  the  base  string.
//throws  IllegalArgumentException
//if	{@code  candidateDNA} is f@code null},  empty,  or contains
//characters  other  than A,  C,  G,  and  T.

	public int findFirstBindingPosition(String candidateDNA) {
//		IF STRING IS EMPTY OR NULL THEN THROW ERROR
		candidateDNA = candidateDNA.trim();
		if(candidateDNA==null || candidateDNA.equals("")) {
			throw new IllegalArgumentException();
		}
//		CHECK ALPHABETS ARE ONLY A T G C
		for(int i=0;i<candidateDNA.length();i++) {
			if((candidateDNA.charAt(i)!='C')&&(candidateDNA.charAt(i)!='G')&&(candidateDNA.charAt(i)!='T')&&(candidateDNA.charAt(i)!='A')) {
				throw new IllegalArgumentException();
			}
		}
//		REVERSING THE DNA FOR MATCHING
		String reverseDNA = "";
		for(int i=0;i<candidateDNA.length();i++) {
			switch(candidateDNA.charAt(i)) {
			case 'A':
				reverseDNA+='T';
				break;
			case 'T':
				reverseDNA+='A';
				break;
			case 'C':
				reverseDNA+='G';
				break;
			case 'G':
				reverseDNA+='C';
				break;
			}
		}
//		ITERATING EACH ALPHABET OF BASEDNA
		for(int i=0;i<(baseDNA.length()-reverseDNA.length()+1);i++) {
//			IF FIRST ALPHABET MATCH THEN ENTERS IN IF BLOCK
			if(baseDNA.charAt(i)==reverseDNA.charAt(0)) {
//				BOOLEAN IS USED TO CHECK LOOP RUNS SUCCEFULLY OR NOT
				boolean check = true;
//				ITERATING THE CANDIDATEDNA VALUE FOR MATCHING
				for(int j=1;j<candidateDNA.length();j++) {
//					IF DOESNT MATCH THEN BREAK AND EXIT
					if(baseDNA.charAt(i+j)!=reverseDNA.charAt(j)) {
						check=false;
						break;
					}
				}
//				IF EVERY CANDIDATE DNA FOUND IN BASEDNA 
				if(check) {
					return i;
				}
			}
		}
//		IF DIDNOT MACTCH SEQUENCE
		return -1;
		
	}

	public static void main(String[] args) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		DNAMatcher d = new DNAMatcher("ATTCCTAATGTCAATT");
		System.out.println(d.findFirstBindingPosition("TTAAA"));
		System.out.println(d.findFirstBindingPosition("TAAG"));
		System.out.println(d.findFirstBindingPosition("GATTACA"));
		System.out.println(d.findFirstBindingPosition(null));
//		System.out.println(d.findFirstBindingPosition("TTAMA")); //PRODUCE EXCEPTION

	}

}
