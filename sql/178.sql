select a.Score as Score,
(select count(distinct b.Score) from Scores b where b.Score >= a.Score) as `rank`
from Scores a
order by a.Score DESC