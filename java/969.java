class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length, target = n;
        List<Integer> ans = new ArrayList<>();
        while (target > 1) {
            int find = indexOf(arr, target);
            if (find + 1 == target) {
                target--;
            } else {
                ans.add(find + 1);
                rever(arr, find);
                ans.add(target);
                rever(arr, target - 1);
                target--;
            }
        }

        return ans;
    }

    public int indexOf(int[] arr, int target) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==target) return i;
        }

        return 0;
    }

    public void rever(int[] arr, int r) {
        int l = 0;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;r--;
        }
    }
}