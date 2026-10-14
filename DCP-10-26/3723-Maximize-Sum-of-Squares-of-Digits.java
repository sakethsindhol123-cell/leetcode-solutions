class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<num;i++)
        {
            if(sum>=9)
            {
                sum-=9;
                ans.append('9');
            }
            else if(sum>=8)
            {
                sum-=8;
                ans.append('8');
            }
            else if(sum>=7)
            {
                sum-=7;
                ans.append('7');
            }
            else if(sum>=6)
            {
                sum-=6;
                ans.append('6');
            }
            else if(sum>=5)
            {
                sum-=5;
               ans.append('5');
            }
            else if(sum>=4)
            {
                sum-=4;
                ans.append('4');
            }
            else if(sum>=3)
            {
                sum-=3;
                ans.append('3');
            }
            else if(sum>=2)
            {
                sum-=2;
                ans.append('2');
            }
            else if(sum>=1)
            {
                sum-=1;
                ans.append('1');
            }
            else
            {
                ans.append('0');
            }
        }

        if(sum!=0)
        return "";
        else
        return ans.toString();
    }
}