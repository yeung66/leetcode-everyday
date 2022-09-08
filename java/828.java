class Solution {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> pos = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (!pos.containsKey(c)){
                pos.put(c, new ArrayList<>());
                pos.get(c).add(-1);
            }
            pos.get(c).add(i);
        }

        int ans=0;
        for(List<Integer> indexes: pos.values()) {
            int n = indexes.size();
            indexes.add(s.length());
            for (int i=1;i<n;i++){
                // System.out.printf("%d %d %d\n",indexes.get(i-1),indexes.get(i),indexes.get(i+1));
                ans+= (indexes.get(i)-indexes.get(i-1))*(indexes.get(i+1)-indexes.get(i));
            }
        }

        return ans;
    }
}