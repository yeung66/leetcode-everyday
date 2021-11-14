class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;

        int x = 0, y = 0, startX, startY;
        StringBuilder sb = new StringBuilder();
        while (x < rows && y < cols) {
            startX = x;
            startY = y;

            while (x < rows && y < cols) {
                char c = encodedText.charAt(x * cols + y);
                sb.append(c);
                x++;
                y++;
                if (x == rows || y == n / rows) {
                    x = 0;
                    y = startY + 1;
                    break;
                }
            }
        }

        return sb.toString().stripTrailing();
    }
}