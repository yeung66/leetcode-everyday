class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int ret = -1;
        for (int i=0;i<s.length();i++) {
            if (cnt.containsKey(s.charAt(i))) {
                ret = Math.max(ret, i - cnt.get(s.charAt(i)) - 1);
            } else {
                cnt.put(s.charAt(i), i);
            }
        }


        return ret;
    }
}