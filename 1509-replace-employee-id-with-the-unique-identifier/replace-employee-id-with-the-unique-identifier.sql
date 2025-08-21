# Write your MySQL query statement below
select v.unique_id, e.name 
from Employees as e
left join EmployeeUNI as v
    on e.id = v.id;