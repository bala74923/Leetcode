class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
           // System.out.println(i+",pos = "+arr[i]+"-1");
            if(arr[i]==-1) {
                i++;
                continue;
            }
            int pos = arr[i]-1;//- base
            //pos ==n when marking repeated elements as n
        
            if(pos!=i && arr[i]!=arr[pos]){
                swap(arr,i,pos);
            }else{
                if(i!=pos && arr[i]==arr[pos]){
                    list.add(arr[i]);
                    arr[i] = -1;
                }
                i++;
            }
        }
        return list;
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}