package Palindrome;

public class MorseCoder {
//	used to return correspondence morse code of alphabet like a/A = m_code[0] b/B = m_code[1]
	static String m_code[] ={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
			".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
			"-----",".----","..---","...--","....-",".....","-....","--...","---..","----."};
	static char alphabet_array[] ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
			'Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
	
//	* Returns  a new string  which  is  the Morse  code version  of  the  input  string.
//	* Each word  in  the  output  will  be  on  a  separate  line.   The Morse  representation
//	*  of  each  character of  the  input  string  is  separated from  the next  by  a  space
//	*  character  in  the  output  string.
//	* Oparam  input  the  input  string.
//	@return  the Morse  code version  of  the  input  string,   igoring  all  characters
//	in  the  input  string  that  cannot  be  represented  in  international Morse
//	code.

	public static String encode(String input) {
//		it contains the space seperated strings
		String[] splited_input=input.split("\\s");
//		it used to store the returning string
		String ret_string ="";
//		iterating words of alphabet
		for(String i:splited_input) {
//			used to store the morse code of word
			String words="";
//			if the word is empty then perform nothing ---this happens when two spaces occurs simultaneously then string.trim do this 
			if(i.equals("")) {
				continue;
			}
//			iterating characters of words
			for(int j=0;j<i.length();j++) {
//				char iteration
				char a = i.charAt(j);
//				saving ascii value of alphabet
				int ascii= (int)a;
//				this is to check that the character is alphabet(small and capital both) or not 
				if((ascii<91 && ascii>64) || (ascii>96 && ascii<123 || ascii>47 && ascii <58) ) {
//					if it is small then this will run
					if(ascii>96) {
						ascii=ascii-97;
					}
//					if it is caps then it runs
					else if(ascii>64) {
						ascii=ascii-65;
					}
//					if it is number then it will run
					else {
						ascii=ascii-22;
					}
//					adding the code with words with space
					words=words+m_code[ascii]+" ";
				}
				
			}
//			trim is used to remove trailing spaces
			if(words.trim().equals("")) {
				continue;
			}
//			word is combined with ret_string
			ret_string= ret_string + words.trim() + "\n";
		}
		return ret_string;
	}
	
//		* Returns  a new string  which  is  the natural-language version  of  the  input
//		* string,  which  is  assumed  to  be  in Morse  code format  as produced  by  the  encode
//		* method.
//
//		* Oparam  input  morse  code  input  string.
//		*	@return natural  language version  or f@code null}  if  the  input  string  could
//		not  be properly parsed.

	public static String decode(String input) {
//		it contains the new line seperated strings
		String[] new_line_splited_input=input.split("[\\r\\n]+");
		String ret_string="";
//		iterating new line separeted strings
		for(String i:new_line_splited_input) {
			String[] splited_input=i.split("\\s");
			String words="";
//			iterating space separeted strings
			for(String j:splited_input) {
				boolean match=true;
//				declared to get correspondece value of alphabet_array 
				int m = 0;
//				iterate each value of alphabet_array 
				for(String k:m_code) {
//					match code with the already declared array elements alphabet_array 
					if(j.equals(k)) {
						match=false;
						words=words+alphabet_array[m];
						break;
					}
//					incremented
					m++;
				}
//				if doesnot match any sequence means code is wrong then it will executed 
				if(match) {
					return null;
				}
			}
//			words added to ret_string
			ret_string = ret_string+words+" ";
			
		}
//		trim is used to remove trailling spaces
		return ret_string.trim();		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = MorseCoder.encode("Thou1, , shalt2 no9t 6 prod5uce bu0gs.");
		System.out.println(s);
		System.out.println(MorseCoder.decode(s));
		s="... .... .- .-.. -\r\n" + 
				"-. --- -\r\n" + 
				".--. .-.-..- -.. ..- -.-. .\r\n" + 
				"-... ..- --. ...";
		System.out.print(MorseCoder.decode(s));
	}

}
