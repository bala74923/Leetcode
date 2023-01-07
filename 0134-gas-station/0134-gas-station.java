class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0, total_cost= 0,start = 0,curr =0;
        int N= cost.length;
        for(int i=0;i<N;i++){
            curr+= gas[i]-cost[i];
            total_gas+= gas[i]; total_cost+= cost[i];
            if(curr<0){
                start = i+1;
                curr = 0;
            }
        }
        return total_gas<total_cost?-1: start;
    }
}