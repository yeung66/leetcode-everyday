# Write your MySQL query statement below
# select name as Employee from Employee e1
# where managerId is not null
# && salary > (select e2.salary from Employee e2 where e2.id = e1.managerId);

select e1.name as Employee from
Employee e1, Employee e2
where e1.managerId = e2.id && e1.salary > e2.salary;