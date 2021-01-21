package Palindrome;
import java.util.ArrayList;

public class StatisticsCollector {
	
	ArrayList<Double> list = new ArrayList<Double>();
	double sum=0;
	public void addItem(double data) {
		list.add(data);
		sum=sum+data;
	}
	public int getCount() {
		return list.size();
	}
	public double getSum() {
		double sum=0;
		for(double s:list) {
			sum=sum+s;
		}
		return sum;
	}
	public double getMinimum() {
		double min = Double.POSITIVE_INFINITY;
		for(double m:list) {
			if(min>m) {
				min = m;
			}
		}
		return min;
	}
	public double getMaximum() {
		double max = Double.NEGATIVE_INFINITY;
		for(double m:list) {
			if(max<m) {
				max = m;
			}
		}
		return max;
	}
	public double getAverage() {
		if(list.isEmpty()) {
			return 0;
		}
		return sum/list.size();
	}
	public double getStandardDeviation() {
		if(list.isEmpty()) {
			return 0;
		}
		double std=0;
		double mean = sum/list.size();
		for(double l:list) {
			std+=Math.pow(l-mean,2);
		}
		return Math.sqrt(std/list.size());
	}
	
	public static void main(String[] args) {
		StatisticsCollector s= new StatisticsCollector();
		s.addItem(5);
		s.addItem(92);
		s.addItem(42);
		s.addItem(17);
		s.addItem(53);
		s.addItem(23);
		s.addItem(13);
		s.addItem(1);
		s.addItem(6);
		System.out.println(s.getCount());
		System.out.println(s.getSum());
		System.out.println(s.getMinimum());
		System.out.println(s.getMaximum());
		System.out.println(s.getAverage());
		System.out.println(s.getStandardDeviation());
	}
	
	

}
