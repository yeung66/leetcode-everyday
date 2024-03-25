class Solution {
    fun replaceSpaces(S: String, length: Int): String {
        return S.substring(0, length).replace(" ", "%20")
    }
}