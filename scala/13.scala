object Solution {
    def romanToInt(s: String): Int = {
      def mapping(digit: Char) = digit match {
        case 'I' => 1
        case 'V' => 5
        case 'X' => 10
        case 'L' => 50
        case 'C' => 100
        case 'D' => 500
        case 'M' => 1000
      }

      s.foldRight((0, 0)) { case (digit, (sum, prev)) =>
        val value = mapping(digit)
        val newSum = if (value < prev) sum - value else sum + value
        (newSum, value)
      }._1
    }
}