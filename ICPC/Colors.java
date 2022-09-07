package ICPC;

import java.util.Arrays;

public class Colors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "RRR";
		int[] arr = {1,1,0};
		
		memo = new int[str.length()];
		Arrays.fill(memo,-1);
		int res = f(str,0,arr);
		System.out.println(res);
	}
	static int[] memo;
	static int max = (int)1e9;
	static int f(String s,int index,int[] arr) {
		if(index>=s.length()) return 0;
		if(index==s.length()-1) {
			return s.charAt(index)=='B'?max:0;
		}
		if(memo[index]!=-1) return memo[index];
		//red
		System.out.println(s.charAt(index)+","+index);
		int mini = (int)1e9;
		if(s.charAt(index)=='R') {
			for(int step=1;step<=arr[index];step++) {
				mini = Math.min(mini,1+f(s,index+step+1,arr));
			}
		}
		return Math.min(f(s,index+1,arr), mini);
	}
}
