class Solution {
    public boolean checkString(String s) {
        boolean hasB = false;
        for (var ch : s.toCharArray()) {
            if (ch == 'a' && hasB) {
                return false;
            } else if (ch == 'b') {
                hasB = true;
            }
        }

        return true;
    }
}