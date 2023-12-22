-- 조건에 맞는 사용자 정보 조회하기(23.12.22)
select user.user_id, user.nickname, 
concat(user.city,' ', user.street_address1,' ', user.street_address2) AS 전체주소,
concat(LEFT(tlno, 3), '-', MID(tlno, 4, 4),'-', RIGHT(tlno, 4)) AS 전화번호
from used_goods_board as board
join used_goods_user as user
on board.writer_id = user.user_id
group by writer_id
having count(writer_id) >= 3
order by user.user_id desc;