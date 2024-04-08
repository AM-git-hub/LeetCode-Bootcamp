class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<Integer>();
        Stack<StringBuilder> strings = new Stack<StringBuilder>();
        StringBuilder curr = new StringBuilder();
        int k=0;
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                k = k*10 + Character.getNumericValue(c);
            }
            else if(c=='[')
            {
                counts.push(k);
                k=0;

                strings.push(curr);
                curr = new StringBuilder();
            }
            else if(c==']')
            {
                StringBuilder decodedString = strings.pop();
                int rep = counts.pop();
                for(int i=0;i<rep;i++)
                {
                    decodedString.append(curr);
                }
                curr=decodedString;
            }
            else
            {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}