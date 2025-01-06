object Solution {
    def getSmallestString(s: String): String = {
        s.indices.init.find(i => s(i) > s(i + 1) && ((s(i) - s(i+1)) % 2 == 0)) match {
            case Some(i) => 
                s.updated(i, s(i+1)).updated(i+1, s(i))
            case None => s
        }
    }
}