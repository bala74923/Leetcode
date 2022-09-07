package ICPC;

public class BeautifulArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,4,8,2,2,2,1};
		//System.out.println(f(arr,0));
	}
//	static int f(int[] arr,int index) {
//		if(index==arr.length) {
//			return 0;
//		}
//		//check is i-2 same
//		boolean two = index<2?false:arr[index-2]==arr[index];
//		boolean three = index<3?true:arr[index-3]==arr[index];
//		if(!two && three) { //no prob
//			return f(arr,index+1);
//		}
//		else if(two == three){
//			int changeTwo = f(arr,index+1)+ (index-2)/2;
//			int changeThree = f(arr,index+1)+(index-3)/3;
//			return Math.min(changeTwo, changeThree);
//		}
//		else if(two && three==false) {
//			return f(arr,index+1);
//		}
//	}

}
