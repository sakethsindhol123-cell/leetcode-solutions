class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty())
                {
                    ans++;
                }
                else
                st.pop();
            }
        }
        ans+=st.size();
        return ans;
    }
}