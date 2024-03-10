class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<words.length;i++)
        {
            map.put(words[i],i);
        }
        for(int i=0;i<words.length;i++)
        {
            // case 1: Empty String
            if(words[i].equals(""))
            {
                for(int j=0;j<words.length;j++)
                {
                    if(i==j) continue;
                    if(checkPalindrome(words[j]))
                    {
                        res.add(Arrays.asList(new Integer[]{i,j}));
                        res.add(Arrays.asList(new Integer[]{j,i}));
                    }
                }
                continue;
            }
            // case 2: Reverse of string exists
            StringBuilder sb = new StringBuilder(words[i]);
            String reversed = sb.reverse().toString();
            if(map.containsKey(reversed) && map.get(reversed)!=i)
            {
                res.add(Arrays.asList(new Integer[]{i,map.get(reversed)}));
            }

            //case 3: normal case
            for (int len = 1; len <= words[i].length()-1; len++) {
                String prefix = words[i].substring(0, len);
                String suffix = words[i].substring(len);
                
                // Check if the prefix forms a palindrome with some suffix
                if (checkPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(reversedSuffix) && map.get(reversedSuffix) != i) {
                        res.add(Arrays.asList(map.get(reversedSuffix), i));
                    }
                }
                
                // Check if the suffix forms a palindrome with some prefix
                if (checkPalindrome(suffix)) {
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (map.containsKey(reversedPrefix) && map.get(reversedPrefix) != i) {
                        res.add(Arrays.asList(i, map.get(reversedPrefix)));
                    }
                }
            }
        }
        return res;
    }
    boolean checkPalindrome(String str)
    {
        int l=0,r=str.length()-1;
        while(r>l)
        {
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}