package cpm;

import java.util.*;

class NODEcpm {
	int activityNum ;
	String activityName;
	int dur;
	int ES,EF,LS,SL,LF;
	ArrayList<NODEcpm> children;
	ArrayList<NODEcpm> predecessor;
	
	public NODEcpm(int actNum, String actName, int dur) {
		this.activityName= actName;
		this.activityNum= actNum;
		this.dur=dur;
		this.children=new ArrayList<NODEcpm>();
		this.predecessor=new ArrayList<NODEcpm>();
	}
}

public class CPMUSe {

	public static ArrayList<NODEcpm> takeInput() {
		Scanner s = new Scanner(System.in);
		ArrayList<NODEcpm> arr = new ArrayList<NODEcpm>();
		arr.add(null);
		System.out.println("Enter the number of activities: ");
		int x = s.nextInt();
		for (int i = 1; i <= x; i++) {
			System.out.println("Enter the activity Number " + i);
			int actNum = i;
			System.out.println("Enter the activity Name: ");
			String actName = s.next();
			System.out.println("Enter the activity Duration: ");
			int dur = s.nextInt();
			NODEcpm node = new NODEcpm(actNum, actName, dur);
			arr.add(node);
		}

		for (int i = 1; i < arr.size(); i++) {
			System.out.println("Enter the number of predecessors of " + arr.get(i).activityName);
			int pre = s.nextInt();
			NODEcpm current = arr.get(i);
			for (int j = 1; j <= pre; j++) {
				System.out.println("enter the activity number");
				int actNum = s.nextInt();
				NODEcpm parent = arr.get(actNum);
				current.predecessor.add(parent);
				parent.children.add(current);
			}
		}
		return arr;

	}

	public static void print(NODEcpm start) {
		if(start.SL!=0) {
			return;
		}
		if(start.SL==0) {
			System.out.print(start.activityName+"->");
		}
		for (int i = 0; i < start.children.size(); i++) {
			print(start.children.get(i));
		}

	}

	public static void main(String[] args) {

		ArrayList<NODEcpm> arr = takeInput();
		NODEcpm start = arr.get(1);

		for (int i = 1; i < arr.size(); i++) {
			NODEcpm current = arr.get(i);
			int max = Integer.MIN_VALUE;

			if (current.predecessor.size() == 0) {
				max = 0;
			} else {
				for (int j = 0; j < current.predecessor.size(); j++) {
					NODEcpm temp = current.predecessor.get(j);
					max = Math.max(max, temp.EF);
				}
			}
			current.ES = max;
			current.EF = current.ES + current.dur;

		}
		for (int i = arr.size() - 1; i >= 1; i--) {
			NODEcpm current = arr.get(i);
			int min = Integer.MAX_VALUE;

			if (current.children.size() == 0) {
				min = current.EF;
			} else {
				for (int j = 0; j < current.children.size(); j++) {
					NODEcpm temp = current.children.get(j);
					min = Math.min(min, temp.LS);
				}
			}
			current.LF = min;
			current.SL = current.LF - current.EF;
			current.LS = current.LF - current.dur;
		}
		System.out.println("Critical Path Formed ");
		print(start);
		
		System.out.println("Finish\n");
		System.out.println("Activity\tES\tEF\tLS\tSL\tLF");
		for(int i=1;i<arr.size();i++) {
			NODEcpm current=arr.get(i);
			System.out.println(current.activityName+'\t'+'\t'+
					current.ES +'\t'+ current.EF +'\t' + current.LS +'\t' + 
					current.SL+'\t' +current.LF);
		}

	}
}
