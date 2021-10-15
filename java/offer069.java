class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int prev = mid > 0 ? mid - 1 : 0;
            int next = mid < arr.length - 1 ? mid + 1 : arr.length - 1;
            if (arr[mid] >= arr[prev] && arr[mid] >= arr[next])
                return mid;
            else if (arr[prev] <= arr[mid] && arr[mid] <= arr[next])
                left = mid + 1;
            else
                right = mid;
        }
        
        return left;
    }
}