-- 자동차 대여 기록에서 장기/단기 대여 구분하기(23.12.22)
select history_id, car_id, 
date_format(start_date, '%Y-%m-%d') as start_date,
date_format(end_date,  '%Y-%m-%d') as end_date,
case when datediff(end_date, start_date) + 1 >= 30 then "장기 대여"
else "단기 대여" end as rent_type
from car_rental_company_rental_history
where start_date between '2022-09-01' and '2022-09-30'
order by history_id desc;