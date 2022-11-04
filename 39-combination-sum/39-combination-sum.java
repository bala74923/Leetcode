class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list= new ArrayList<>();
        rec(0,0,new ArrayList<>(),candidates,target);
        return list;
    } 
    void rec(int ind,int sum,List<Integer> sub,int[] arr,int target){
        if(ind==arr.length){
            if(sum==target)
                list.add(new ArrayList<>(sub));
            return ;
        }
        //pick
        if(sum+arr[ind]<=target){
            sub.add(arr[ind]);
            rec(ind,sum+arr[ind],sub,arr,target);
            sub.remove(sub.size()-1);
        }
        // dont pick
        rec(ind+1,sum,sub,arr,target);
    }
    
}