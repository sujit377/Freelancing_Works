package Palindrome;

public final class Calendar {
	final int year;
	final int month;
	final int day;
	public static final int getDaysInMonth(int year, int month) {
		if( month == 2) {
			if (year % 4 == 0) {
			      // if the year is century
			      if (year % 100 == 0) {
			        // if year is divided by 400
			        // then it is a leap year
			        if (year % 400 == 0)
			          return 29;
			        else
			          return 28;
			      }
			      else {
			    	  return 29;
			      }
			}
			return 28;
		}
		else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		else {
			return 0;
		}
	}
	public static final boolean validate(int year, int month, int day) {
		if( year<0) {
			return false;
		}
		if(month<1 || month>12) {
			return false;
		}
		final int a = Calendar.getDaysInMonth(year, month);
		if(day<1 || day >a) {
			return false;
		}
		return true;
	}
	
	public Calendar(int year, int month, int day) {
		if(!Calendar.validate(year,month,day)) {
			throw new IllegalArgumentException("This is not a valid date");
		}
		this.year=year;
		this.month = month;
		this.day = day;
	}
	
	public final int getYear() {
		return this.year;
	}
	public final int getMonth() {
		return this.month;
	}
	public final int getDay() {
		return this.day;
	}
	
	public final int dayOfYear() {
		int count=0;
		for(int i =1;i<this.month;i++) {
			count=count+Calendar.getDaysInMonth(this.year, i);
		}
		
		return count+this.day;
	}
	
	public final int sameYearDiff(Calendar other) {
		if(this.year == other.year) {
			return  other.dayOfYear()-this.dayOfYear();
		}
		return 0;
	}
	
	public final String toString() {
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
		return monthString+" " +Integer.toString(this.day)+", "+Integer.toString(this.year);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = new Calendar(2019,5,20);
		Calendar c2 = new Calendar(2019,5,30);
		int a= Calendar.getDaysInMonth(99, 4);
		boolean b = Calendar.validate(1999, 11, 30);
		System.out.println(a);
		System.out.println(c.getDay());
		System.out.println(c.getMonth());
		System.out.println(c.getYear());
		System.out.println(c.dayOfYear());
		System.out.println(c.sameYearDiff(c2));
		System.out.println(c);		
	}

}
