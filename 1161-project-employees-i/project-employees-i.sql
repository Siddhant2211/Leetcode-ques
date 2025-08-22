# Write your MySQL query statement below
select project_id, ROUND(SUM(e.experience_years) / COUNT(e.employee_id), 2) as average_years 
from project as p
left join employee as e on p.employee_id = e.employee_id
group by p.project_id
