class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder ans=new StringBuilder();
        int d=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
               if(d>0)
               {
                ans.append(ch);
               }
               d++;
            }
            else
            {
                d--;
                if(d>0)
                ans.append(ch);
            }
           
        }
        return ans.toString();
    }
}