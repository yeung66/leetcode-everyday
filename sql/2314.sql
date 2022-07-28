select Weather.city_id, min(Weather.day) as day, Weather.degree from Weather
join (select city_id, max(degree) as degree from Weather group by city_id) as x
on Weather.city_id = x.city_id and Weather.degree = x.degree
group by Weather.city_id
order by Weather.city_id;


-- 方法二 使用行号进行判断
select city_id, day, degree
from (
    select city_id, day, degree, row_number() over (partition by city_id order by degree desc, day) as rn from Weather
) as new_weather
where rn = 1;