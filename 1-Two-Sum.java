class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n;
        boolean s=false;
        int[] ans;
        ans=new int[2];
        for( int i=0;i<nums.length;i++)
        {
            n=target-nums[i];

            for( int j=i+1;j<nums.length;j++)
            {
                if(n==nums[j])
                {
                    s=true;
                    ans[1]=j;
                    break;
                }

            }
            if(s)
            {
                ans[0]=i;
                break;
            }
        }
        return ans;
    }
}