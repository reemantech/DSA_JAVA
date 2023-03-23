package arrays;
import java.util.Scanner;
public class Pattern {

	 public static void A(){
	        System.out.print("Good ");
	        throw new RuntimeException();
	    }
	    public static void B(){
	         A();
	         System.out.print("This ");
	    }
	    public static void main(String[] args){
	        int a=10;
	        System.out.println(~a);
	    }
}
