import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param S string字符串 
     * @param T string字符串 
     * @return string字符串
     */
    public String minWindow (String S, String T) {
        // write code here
        Map<Character, Integer> cnt = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        
        int m = S.length(), n = T.length();
        if (m<n) return "";
        
        int l = 0, r = n;
        for (int i=0;i<n;i++) {
            cnt.put(S.charAt(i), 1 + cnt.getOrDefault(S.charAt(i), 0));
            target.put(T.charAt(i), 1 + target.getOrDefault(T.charAt(i), 0));
        }
        
        int minLen = m+1;
        int ansl = -1, ansr = -1;
        while (r < m) {
            if (mapContains(cnt, target)) {
                if (r-l<minLen) {
                    minLen = r-l;
                    ansl = l;
                    ansr = r;
                }
                cnt.put(S.charAt(l), cnt.getOrDefault(S.charAt(l),0)-1);
                l++;
            } else {
                
                cnt.put(S.charAt(r), cnt.getOrDefault(S.charAt(r),0)+1);
                r++;
            }
            
        }
        
        while (mapContains(cnt, target)) {
                if (r-l<minLen) {
                    minLen = r-l;
                    ansl = l;
                    ansr = r;
                }
                cnt.put(S.charAt(l), cnt.getOrDefault(S.charAt(l),0)-1);
                l++;
            }
        
        if (ansl == -1) return "";
        return S.substring(ansl, ansr);
    }
    
    public boolean mapContains(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (char c:m2.keySet()) {
            if (m1.getOrDefault(c,0) < m2.get(c)) return false;
        }
        
        
        return true;
    }
}