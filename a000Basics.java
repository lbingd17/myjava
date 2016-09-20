package javaBasics;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class a000BasicDataStructures {
	public static void main(String[] args) {
		String	s1	=	new	String();
		String	s2	=	"billryan";
		int	s2Len	=	s2.length();
		s2.substring(4,	8);	//	return	"ryan"
		StringBuilder	s3	=	new	StringBuilder(s2.substring(4,	8));
		s3.append("bill");
		String	s2New	=	s3.toString();	//	return	"ryanbill"
		char[]	s2Char	=	s2.toCharArray();//			convert	String	to	char	array
 		char	ch	=	s2.charAt(4);	//	return	'r' 
		int	index	=	s2.indexOf('r');	//	find	index	at	first return	4.	if	not	found,	return	-1
		///Queue
		Queue<Integer> q = new LinkedList<Integer>();
		int qLen = q.size(); // get queue length
		q.add(new Integer(12));
		Integer qir = q.poll();
		Integer qi = q.peek();

		//双端队列（deque，全名double-ended queue）
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.addFirst(new Integer(1));
		deque.push(new Integer(12));
		deque.addLast(new Integer(123));
		
        deque.remove();
        deque.poll();
        
		
		//栈
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.size(); // size of stack
		stack.push(new Integer(11));
		Integer stt = stack.pop();
		
		
		//set
		Set<String> hash = new HashSet<String>();
		hash.add("billryan");
		hash.contains("billryan");
		
		//map
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("bill", 98);
		map.put("ryan", 99);
		boolean exist = map.containsKey("ryan"); // check key exists in map
		int point = map.get("bill"); // get value by key
		int point2 = map.remove("bill"); // remove by key, return value
		Set<String> set = map.keySet();
		
		// iterate Map
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			// do some thing
		}
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			String st = sc.nextLine();  
			System.out.println(st);
			String[] starr = st.split(",");
			for(int i = 0; i< starr.length; i ++){
				System.out.println("dsfds　" +starr[i]);
			}
			/*
			int tm = sc.nextInt();
			System.out.println("tm == " + tm);

			 */
		}
		System.out.println(sc.nextLine());  

		
	}
	
}
