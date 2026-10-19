class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int f=0;
        int c=0;
        for(int i:nums)
        {
            if(i==target)
            c++;
            else if(i<target)
            f++;
        }
        List<Integer>l=new ArrayList<>();
        while(c-->0)
        {
            l.add(f++);
        }
        return l;
    }
}