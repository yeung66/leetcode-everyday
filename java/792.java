class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<String>> buckets = new HashMap<>();
        for (String w: words) {
            buckets.putIfAbsent(w.charAt(0), new ArrayList<>());
            buckets.get(w.charAt(0)).add(w);
        }

        int ans = 0;
        for (char c: s.toCharArray()) {
            if (buckets.containsKey(c)) {
                List<String> matches = buckets.get(c);
                buckets.remove(c);

                for (String w: matches) {
                    if (w.length() == 1) ans++;
                    else {
                        buckets.putIfAbsent(w.charAt(1), new ArrayList<>());
                        buckets.get(w.charAt(1)).add(w.substring(1));
                    }
                    
                }
            }
        }

        return ans;
    }
}