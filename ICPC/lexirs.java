package ICPC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lexirs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test= sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			String str = sc.next();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			System.out.println(cost(0,str,arr,""));
		}
	}
	static int cost(int index,String str,int[] arr,String prev) {
		if(index== str.length()) {
			return 0;
		}
		int pick = 0;
		for(int end=index+1;end<=str.length();end++) {
			String curr = str.substring(index,end);
			if(curr.compareTo(prev)>0) {
				int value = cost(end,str,arr,curr) + arr[end-index];
				pick = Math.max(pick, value);
			}
		}
		int not_pick = cost(index+1,str,arr,prev);
		return Math.max(pick, not_pick);
	}
//	static int[][] memo ;
//	static int memoise(String str,int[] arr) {
//		int n = str.length();
//		memo = new int[n][n];
//		for(int i=0;i<=n;i++) {
//			for(int j=0;j<=n;j++) {
//				memo[i][j]=-1;
//			}
//		}
//		return costf(0,-1,-1,str,arr);
//	}
	static Map<String,Integer> map; 
	static int memoise(String str,int[] arr) {
		int n = str.length();
		map = new HashMap<>();
		return cost(0,str,arr,"");
	}
	static int costk(int index,String str,int[] arr,String prev) {
		if(index== str.length()) {
			return 0;
		}
		int pick = 0;
		String currState = index+","+str;
		if(map.get(currState)!=null)
			return map.get(currState);
		for(int end=index+1;end<=str.length();end++) {
			String curr = str.substring(index,end);
			if(curr.compareTo(prev)>0) {
				int value = costk(end,str,arr,curr) + arr[end-index-1];
				pick = Math.max(pick, value);
			}
		}
		int not_pick = costk(index+1,str,arr,prev);
		int val = Math.max(pick, not_pick);
		map.put(currState,val);
		return val;
	}
	
	
	static int costf(int index,int prevStart,int prevEnd,String str,int[] arr) {
		if(index== str.length()) {
			return 0;
		}
		int pick = 0;
		for(int end=index+1;end<=str.length();end++) {
			if(compare(prevStart,prevEnd,index,end-1,str)) {
				int value = costf(end,index,end-1,str,arr) +
						arr[end-index];
				pick = Math.max(pick, value);
			}
		}
		int not_pick = costf(index+1,prevStart,prevEnd,str,arr);
		return Math.max(pick, not_pick);
	}
	static boolean compare(int i1,int j1,int i2,int j2,String str) {
		while(i1<j1 && i2<j2) {
			if(str.charAt(i1)>str.charAt(i2))
				return false;
			if(str.charAt(i1)<str.charAt(i2))
				return true;
			i2++;
			j2++;
		}
		return i1<i2;
	}
}
