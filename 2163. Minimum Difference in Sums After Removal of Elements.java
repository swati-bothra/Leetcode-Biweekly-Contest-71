class Solution {
    public long minimumDifference(int[] nums) {
        PriorityQueue<Integer> left_max_heap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right_min_heap=new PriorityQueue<>();     
        int n=nums.length/3;
        long[] prefix=new long[n+1];
        long[] suffix=new long[n+1];
        
        long sum=0;
        for(int i=0;i<n;i++){
            left_max_heap.add(nums[i]);
            sum+=nums[i];
        }
        prefix[0]=sum;
        for(int i=n;i<2*n;i++){
            left_max_heap.add(nums[i]);
            sum+=nums[i];
            sum-=left_max_heap.poll();
            prefix[i-n+1]=sum;
        }
        //suffix array
        sum=0;
        for(int i=3*n-1;i>=2*n;i--){
            right_min_heap.add(nums[i]);
            sum+=nums[i];
        }
        
        suffix[n]=sum;
        for(int i=2*n-1;i>=n;i--){
            right_min_heap.add(nums[i]);
            sum+=nums[i];
            sum-=right_min_heap.poll();
            suffix[i-n]=sum;
        }
        long ans=Long.MAX_VALUE;
        for(int i=0;i<=n;i++){
            long l=prefix[i]-suffix[i];
            ans = Math.min(ans,l);
        }
        return ans;
    }
}
