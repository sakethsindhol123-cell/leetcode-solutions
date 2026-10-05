class Solution {
    public int scoreOfParentheses(String s) {
       //Stack<Character>st=new Stack<>();
       boolean b=true;
       int ans=0;
       int c=0;
       for(int i=0;i<s.length();i++)
       {
        char ch=s.charAt(i);
        if(ch=='(')
        {
            c++;
            b=true;
        }
        else if(ch==')')
        {
            if(b)
            {
                ans+=Math.pow(2,c);
                b=false;
            }
            c--;
        }
       } 
    
       return ans/2;
    }
}