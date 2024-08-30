object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    strs.fold(strs(0))((acc, str) => acc.zip(str).takeWhile(x => x._1 == x._2).map(_._1).mkString)
  }
}