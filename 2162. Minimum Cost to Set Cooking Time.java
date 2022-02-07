class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min=targetSeconds/60; int sec=targetSeconds%60;
        int ans =Integer.MAX_VALUE;
        ArrayList<String> arr=new ArrayList<>();
        if(min<100){
            String minS= String.format("%02d", min);
            String secS= String.format("%02d", sec);
            arr.add(minS+secS);
        }
        if(min>0&&(sec+60<100)){
            String minS= String.format("%02d", min-1);
            String secS= String.format("%02d", sec+60);
            arr.add(minS+secS);   
        }
        for(String s:arr){
            ans = Math.min(ans,findCost(s,startAt,moveCost,pushCost));
            while(s.charAt(0)=='0'){
                s=s.substring(1);
                ans = Math.min(ans,findCost(s,startAt,moveCost,pushCost));   
            }
        }
        return ans;
    }
    
    int findCost(String s, int startAt, int moveCost, int pushCost){
        int cost=0;
        int curr_pos=startAt;
        for(char c:s.toCharArray()){
            cost +=pushCost;
            if(curr_pos==c-'0'){
                continue;
            }else{
                curr_pos=c-'0';
                cost+=moveCost;
            }
        }
        return cost;
    }
}
