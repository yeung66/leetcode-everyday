import java.util.*;

class Solution {
    int n;
    int ans;
    int[] prevK;

    public int kIncreasing(int[] arr, int k) {
        n = arr.length;
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrays.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            arrays.get(i % k).add(arr[i]);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> b = arrays.get(i);
            ans += solve(b);
        }
        
        return ans;
    }
    
    private int solve(List<Integer> b) {
        int ans = 0;
        List<Integer> prev = new ArrayList<>();
        prev.add(b.get(0));
        int j = 0;
        for (int i = 1; i < b.size(); i++) {
            int cur = b.get(i);
            if (cur >= prev.get(j)) {
                prev.add(cur);
                j++;
            } else {
                int idx = bs(prev, cur);
                prev.set(idx, cur);
                ans++;
            }

        }
        return ans;
    }
    
    public int bs(List<Integer> list, int key) {
        int l = 0, h = list.size() - 1;
        while (l != h) {
            int mid = (l + h) / 2;
            if (list.get(mid) <= key) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return l;
    }

   
    
}