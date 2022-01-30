class Solution {
    public int countValidWords(String sentence) {
        var tokens = sentence.split(" ");
        int ans = 0;
        for (var token: tokens) {
            if (isValidToken(token)) ans += 1;            
        }

        return ans;
    }

    public boolean isValidToken(String token) {
        if (token.equals("")) return false;
        int cnt = 0;
        for (var i = 0;i<token.length();i++) {
            var c = token.charAt(i);
            if (c == '-') {
                if (i>0 &&i<token.length()-1 &&isLetter(token.charAt(i-1)) && isLetter(token.charAt(i+1))) {
                    cnt++;
                    if (cnt > 1) return false;
                    continue;
                } else {
                    return false;
                }
            } else if (c == '!' || c == '.' || c == ',') {
                if (i != token.length()-1) {
                    return false;
                }
            } else if (isLetter(c)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isLetter(char c) {
        return c>= 'a' && c <= 'z';
    }
}