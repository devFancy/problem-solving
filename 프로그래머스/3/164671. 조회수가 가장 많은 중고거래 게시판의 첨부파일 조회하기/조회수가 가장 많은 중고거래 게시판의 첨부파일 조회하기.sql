-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
select 
    concat('/home/grep/src/', file.board_id, '/', file_id, file_name, file_ext) as file_path
from used_goods_file as file
left join used_goods_board as board
on file.board_id = board.board_id
where views = (select max(views) from used_goods_board)
order by file_id desc