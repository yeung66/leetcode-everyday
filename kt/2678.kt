class Solution {
    fun countSeniors(details: Array<String>): Int {
        return details.map {
            it.substring(11..12).toInt()
        }.count {
            it > 60
        }
    }
}