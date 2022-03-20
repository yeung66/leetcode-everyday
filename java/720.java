class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (i1, i2) -> i1.length() == i2.length() ? i1.compareTo(i2) : i1.length() - i2.length());
        Set<String> cnt  = new HashSet<>();
        cnt.add("");
        String ans = "";

        for (var w: words) {
            String sub = w.substring(0, w.length() - 1);
            if (cnt.contains(sub)) {
                if (w.length() > ans.length())
                    ans = w;
                cnt.add(w);
            }
            
        }

        return ans;
    }
}