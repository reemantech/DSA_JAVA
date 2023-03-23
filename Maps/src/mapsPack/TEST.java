package mapsPack;
import java.util.*;
public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner scan= new Scanner(System.in);
        
        int t= scan.nextInt();
        int n=1;
        while(n<=t){
        	Scanner s= new Scanner(System.in);
            String I= s.next();
            String P= s.next();
            HashMap<Character,Integer> map= new HashMap<>();
            
            for(int i=0;i<I.length();i++){
                if( map.containsKey(I.charAt(i)) ){
                    map.put(I.charAt(i), map.get(I.charAt(i)) +1);
//                    System.out.println(map.get(I.charAt(i)));
                }
                else{
                    map.put(I.charAt(i), 1);
                }
            }
            
            for(int i=0;i<P.length();i++){
                if(map.containsKey(P.charAt(i))){
                    map.put(P.charAt(i), map.get(P.charAt(i)) -1);
         
                }
                
            }
            
            
            int count =0;
            boolean flag= false;
            Set<Character> set=map.keySet();
            for(char str : set) {
                if(map.get(str)>0){
			        flag= true;
			        System.out.println("Case #"+n+ ": IMPOSSIBLE");
			        break;
			    }
			    else{
			        count= count+ ( map.get(str));
			    }
			    
		    }
            if(count<=0 && flag==false){
                System.out.println("Case #"+n+ ": "+ (count * -1));
            }
            
            n++;
        }
	}

}
