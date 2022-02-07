class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> left=new ArrayList();
        ArrayList<Integer> equal=new ArrayList();
        ArrayList<Integer> right=new ArrayList();
        for(int num:nums){
            if(num<pivot){
                left.add(num);
            }else if(num==pivot){
                equal.add(num);
            }else if(num>pivot){
                right.add(num);
            }
        }
        left.addAll(equal);
        left.addAll(right);
        return left.stream().mapToInt(i->i).toArray();
    }
}
