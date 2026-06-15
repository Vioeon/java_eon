-- 각 회원별로 작성한 게시글의 개수를 조회
SELECT member_id, count(*)
FROM POST
GROUP BY member_id;

-- 각 게시글 별로 댓글수 조회
SELECT post_id, count(*) AS reply_cnt
FROM REPLY
GROUP BY post_id
ORDER BY reply_cnt DESC;

-- 회원별로 작성한 게시글의 수, 총 조회수 조회 (게시글 오름차순, 조회순 내림차순 정렬)
SELECT member_id, count(*) AS post_cnt, sum(VIEW_COUNT) AS total_views
FROM POST
GROUP BY member_id
ORDER BY post_cnt ASC, total_views desc;

-- 가입 연도별 회원수 조회
SELECT DATE_FORMAT(CREATED_AT, '%Y') AS join_year, COUNT(*) AS member_cnt
FROM MEMBER
GROUP BY join_year;

-- 회원별로 작성한 게시글의 수, 총 조회수 조회 (게시글 오름차순, 조회순 내림차순 정렬)
SELECT member_id, count(*) AS post_cnt, sum(VIEW_COUNT) AS total_views
FROM POST
GROUP BY member_id
HAVING count(*) >= 5; -- db엔진에 따라 호환성이 안될수도있어서 as문 안쓰는거 추천

-- 회원별로 작성한 게시글의 수, 총 조회수 조회 (게시글 오름차순, 조회순 내림차순 정렬)
SELECT group_concat(title ORDER BY title desc SEPARATOR '-'), member_id, count(*) AS post_cnt
FROM POST
GROUP BY member_id
HAVING post_cnt >= 5;

-- title로 GROPU BY 기준에 추가하여 공동 그룹화
SELECT member_id, title, count(*) AS post_cnt
FROM POST
GROUP BY member_id, title;


