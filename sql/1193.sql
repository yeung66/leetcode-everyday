# Write your MySQL query statement below
select 
DATE_FORMAT(trans_date, '%Y-%m') as month,
country,
count(*) as trans_count,
sum(case WHEN state = 'approved' THEN 1 else 0 END) as approved_count,
sum(amount) as trans_total_amount,
sum(case WHEN state = 'approved' THEN amount else 0 END) as approved_total_amount
from Transactions
group by month, country
;
