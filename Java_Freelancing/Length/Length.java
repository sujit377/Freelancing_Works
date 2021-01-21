package Palindrome;

public enum Length {
//	calling constructors with parameter
	ARSHIN(0.71),FINGER(0.022225),METRE(1.0),HORSE_LENGTH(2.4),PARSEC(30856776000000000.0),PLUTO_RADIUS(1186000.0);
//	enum constructor to initialize the len var with corresponding value 
	Length(double i){
		this.len = i;
	}
//	this len will hold value for the corresponding si unit
	private double len;
//	return length n metre
	public double getUnitLengthInMetres() {
		return len;
	}
//	convert one len to another
	public double convertTo(Length targetLength, double amount) {
		return amount*(len/targetLength.getUnitLengthInMetres());
	}
//	public static void main(String[] args) {
//		System.out.println(Length.HORSE_LENGTH.getUnitLengthInMetres());
//		System.out.println(Length.HORSE_LENGTH.convertTo(Length.ARSHIN, 1));
//	}
}
