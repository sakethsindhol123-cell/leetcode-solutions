class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character>st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        boolean start=false;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                if(start)
                {
                    ans.append(ch);
                }
                st.push(ch);
                if(st.size()==1)
                {
                    start=true;
                }
            }
            else if(ch==')')
            {
                
                st.pop();
                if(st.isEmpty())
                {
                    start=false;
                }
                if(start)
                {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}