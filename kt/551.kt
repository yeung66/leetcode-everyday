class Solution {
    fun checkRecord(s: String): Boolean {
        var absentCnt = 0
        var lateCnt = 0

        s.forEach { record ->
            when (record) {
                'L' -> {
                    lateCnt++
                    if (lateCnt > 2) return false
                }
                'A' -> {
                    absentCnt++
                    if (absentCnt > 1) return false
                    lateCnt = 0
                }
                else -> lateCnt = 0
            }
        }

        return true
    }
}
