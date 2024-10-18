class Solution {
    public String largestWordCount(String[] messages, String[] senders) 
    {
        int n=messages.length;
        
        String ans="";
        int max=0;
        Map<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            int c=0;
            for(int j=0;j<messages[i].length();j++)
            {
                if(messages[i].charAt(j)==' ')
                c++;
            }
            
            c++;
            map.put(senders[i],map.getOrDefault(senders[i],0)+c);
            
            int x=map.get(senders[i]);
            
            if(x<max)
            continue;
            
            if(x==max)
            ans=senders[i].compareTo(ans)>0?senders[i]:ans;
            
            else
            {
                max=x;
                ans=senders[i];
            }
        }
        
        return ans;
    }
}
