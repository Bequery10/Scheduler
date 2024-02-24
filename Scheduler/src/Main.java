import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static Hashtable<String,Class> table=new Hashtable<>();
	
	private static int limit=100;
	
	private static int earlyHour=12;
	
	static List<List<Boolean>>stack=new ArrayList<>(limit);
	static List<String> infoList=new ArrayList<>(); 
	
	static Hashtable<List<List<String>>,Integer> earlyTable=new Hashtable<>();
	
	private static 	List<Boolean> fillStack(List<Boolean>falseList){
		
		for(int i=0;i<100;i++) {
			
			falseList.add(false);
			
		}
	
		return falseList;
	}
	
	private static void printCombinations(){
		boolean[][]occupiedHours=new boolean[5][15];
		
		//System.out.println(infoList);
		
		List<List<List<String>>>combinations=new ArrayList<>();
		
		List<List<String>>combination=new ArrayList<>();
		
		List<String> nameList =new ArrayList<>();
		
		List<Boolean>stack=new ArrayList<>();
		fillStack(stack);
		
		combinations= pCHelper(stack,0,nameList,combination,combinations,occupiedHours);
	
		PriorityQueue < String > PQueue=new PriorityQueue<>(1000);
		
		if(combinations.isEmpty()==false) {
		for(List<List<String>> l: combinations) {
		PQueue.offer(earlyTable.get(l)+l.toString()+"");	
		//System.out.println(l);
		}
		while(PQueue.isEmpty()==false) {
		String s = PQueue.poll();	
		System.out.println(s.substring(1)+"\nearly hours: "+s.substring(0,1));
		
		System.out.println();
		System.out.println();
		System.out.println();
		}
		}
		else {
			System.out.println("there is no possible combination");
		}
		
	}
	
	static int earlyHours=0;
	private static List<List<List<String>>> pCHelper( List<Boolean>stack1,int count,List<String> nameList,List<List<String>> combination,List<List<List<String>>>combinations,boolean[][]occupiedHours){
		

		
		for(String s : table.keySet()) { //----------class
			if(nameList.contains(s)) continue;
			
			boolean[][]occupiedHoursDataSaver=new boolean[5][15];//////////////////////////////////////////////////////////////
			
			for(int n=0;n<occupiedHours.length;n++)
				for(int j=0;j<occupiedHours[n].length;j++) {
					occupiedHoursDataSaver[n][j]=occupiedHours[n][j];
				
				}
			
			String name= s;
			
			nameList.add(s);
			
			Hashtable<Integer,Hashtable<String,List<Integer>>> classTable=table.get(s).sections;
			
			 boolean passBreak=false;
			
			 count++;
			
			 
			 int count1=0;
			
			 int count3=0; // increases when a row is complete 
			  
			 for(Integer i1 : classTable.keySet()) { //---------------section
				count1++;
				 int count2=0;
				 
				 List<String> combination1=new ArrayList<>();
				 combination1.add("\n");
				 
				 int earlyHours1=0;
				 
				 boolean once =true;
				 
				List<Boolean>stack2=new ArrayList<>(stack1.size());
		
				for(int i=0;i<stack1.size();i++) {
					stack2.add(i,stack1.get(i));
				}
				
				
				stack2.set(infoList.indexOf(name+" "+i1),true);
				
			for(String s1 : classTable.get(i1).keySet()) { //--------------------- day-hours
				
				
			count2++;
			
				List<String>combinations1=new ArrayList<>();
				
				if(once) {
				combinations1.add("( sec "+(i1+1)+" )"+name+"\t-->\t");
				once=false;
			}

				
			String day = s1;
			List<Integer> hours=classTable.get(i1).get(s1);
			
			int column=-1;
			switch(day) {
			case "Mo" : column=0;
				break;
				
			case "Tu" : column=1;
				break;
				
			case "We" : column=2;
				break;
				
			case "Th" : column=3;
				break;
				
			case "Fr" : column=4;
				break;
			}
			
			boolean pass=true;
			
			
			
			for(int i : hours) {
				
				if(occupiedHours[column][i-9]==true)  {
					
					pass=false;
					
					for(int n=0;n<occupiedHours.length;n++)
						for(int j=0;j<occupiedHours[n].length;j++) {
							occupiedHoursDataSaver[n][j]=occupiedHours[n][j];
						
						}
					
					if(count1==classTable.size()) count--;
				
					break;
				}			
			
				occupiedHoursDataSaver[column][i-9]=true;
				
			}
			
			
			
			if( pass == false) break;
			
			if((hours.get(0)-1)<=earlyHour) earlyHours1++;
			
			combinations1.add(day+"  "+ (hours.get(0)-1)+" - "+hours.get(hours.size()-1)); 
				
			
					combination1.add(" "+combinations1.toString());
				
				
					
					
					if( count2==classTable.get(i1).size()) {
						combination1.add("\n");
					combination.add(combination1);
					earlyHours+=earlyHours1;
					}
					
					
					
					List<List<String>>combinationCopy=new ArrayList<>();
					
					
					
			if(count == table.size() && count2==classTable.get(i1).size()) {
				
				for(List<String> s2 : combination)
					combinationCopy.add(s2);
				
			
				if(stack.contains(stack2) == false) {
					List<Boolean> newStack=new ArrayList<>(stack2.size());
					
					for(int i=0;i<stack2.size();i++) {
						newStack.add(stack2.get(i));
					}
					
					stack.add(newStack);
					
					
				combinations.add(combinationCopy);
				
				earlyTable.put(combinationCopy, earlyHours);
				
				}
				
				
				
			}
			
			if(count2==classTable.get(i1).size()) {
				
			 combinations= pCHelper(stack2,count,nameList,combination,combinations,occupiedHoursDataSaver);
			 
			 for(int n=0;n<occupiedHours.length;n++)
					for(int j=0;j<occupiedHours[n].length;j++) {
						occupiedHoursDataSaver[n][j]=occupiedHours[n][j];
						
					}
			
			
			 combination.remove(combination1);
			 earlyHours-=earlyHours1;
			
			 if(count1==classTable.size())
			count--;
			
		
			
			}
			
			
			
			}
			
			
			
		}
			
			 nameList.remove(s);
			 if(passBreak) break;
		}
		return combinations;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("How many classes ?");
		
		int n=sc.nextInt(); sc.nextLine();
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter class name: ");
			String name=sc.nextLine();
			
			Class class1=new Class();
			class1.name=name;
			
			System.out.println("How many sections ?");
			int amount=sc.nextInt(); sc.nextLine();
			
			String day="";
			String hours="";
			
	
			Hashtable<String,List<Integer>> daysAndHours =new Hashtable<>();
			
			for(int j=0;j<amount;j++) {
			
				daysAndHours =new Hashtable<>();
				System.out.println("section: "+(j+1));
				String info=sc.nextLine();
				
				if(i==n-1 && j==amount-1) {
					System.out.println("enter an early hour: ");
					earlyHour=sc.nextInt(); sc.nextLine();
					
					sc.close();
					
				}
			
				int k=0;
				
				while(k<info.length() && info.substring(k).indexOf(' ')!=-1) {
					
					int index=info.substring(k).indexOf(' ') + k;
					//System.out.println("k: "+k+"index: "+index);
					
				 day=info.substring(index-2, index);
				
				 hours=info.substring(index+1,index+8);
				
				
				
				int num1=Integer.parseInt(hours.substring(0,2));
				int num2=Integer.parseInt(hours.substring(5));
				
				int duration=num2-num1;
					
				List<Integer> list=new ArrayList<>();
				
				for(int l=1;l<=duration;l++) {
					
					
					list.add(num1+l);
					
				}
				
			
				daysAndHours.put(day, list);
				
				class1.sections.put(j,daysAndHours);
				
				
				k+=11;
				
				}
				infoList.add(name+" "+j);
				
				table.put(name, class1);
			}
			
			
			
		}
		
		printCombinations();
	}

}

class Class{
	String name="";
	
	
	Hashtable<Integer,Hashtable<String,List<Integer>>> sections=new Hashtable<>();
	
	
	
}
