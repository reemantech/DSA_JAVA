package computerNetworks;
import java.util.*;

public class Parity {

	public static boolean getParity(int n)
    {
        boolean parity = false;
        while(n != 0)
        {
            parity = !parity;
            n = n & (n-1);
        }
        return parity;
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = s.nextInt();
        System.out.println("Parity of no " + n + " = " +(getParity(n)? "odd": "even"));

	}

}
