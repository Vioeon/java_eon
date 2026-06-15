-- 회원 이름과 이메일을 결합해서 조회
SELECT name, email, CONCAT(name, ' (', email, ')') AS member_info
FROM MEMBER;

-- 각 회원의 이메일 바이트 크기 조회
SELECT email, LENGTH('hello'), LENGTH('안녕하세요'), LENGTH(email)AS email_length
FROM MEMBER; 

-- 게시글 본문 중 '안녕하세요'가 있는 내용을 찾아서 Hi로 수정
SELECT content, REPLACE(content, '안녕하세요', 'Hi') AS replaced_content
FROM post
WHERE content LIKE '%안녕하세요%';

-- 게시글 본문의 첫 10글자만 미리보기로 가져오기(잘린 뒷부분은 ...으로 표시)
SELECT title, CONCAT(SUBSTRING(title,1,10), '...') AS preview
FROM post;

-- 이메일을 소문자/대문자로 조회
SELECT email, LOWER(email) AS email_lower, UPPER(email) AS email_upper
FROM MEMBER;

-- 이메일 앞뒤 공백 제거
SELECT email, TRIM(email) AS trimmed_email
FROM MEMBER;

-- 현재 날짜와 시간을 조회
SELECT now() AS current_datetime;

-- 게시글 작성일을 연-월-일 형식으뢰 조회
SELECT id, title, created_at, DATE_FORMAT(created_at, '%Y년 %m월 %d일 %a요일 %H시 %i분 %s초')
FROM post;

SELECT CURDATE() AS curr_date;

-- 오늘 작성된 게시글만 조회
SELECT id, title, created_at
FROM post
WHERE created_at >= curdate();

-- 최근 7일 이내에 가입한 회원 조회
SELECT id, title, created_at, CURDATE(), DATE_SUB(CURDATE(), INTERVAL 7 day) AS before_7days
FROM post
WHERE created_at >= DATE_SUB(CURDATE(), INTERVAL 7 day);

-- 가입한지 1개월이 지난 회원 조회
SELECT *, date_sub(curdate(), INTERVAL 1 MONTH) AS before_1month
FROM `member`
WHERE created_at < date_sub(curdate(), INTERVAL 1 MONTH);

-- 가입한지 1개월 3일이 지난 회원 조회
SELECT *, date_sub(curdate(), INTERVAL '10-12' day_hour) AS before_1month
FROM `member`
WHERE created_at < date_sub(curdate(), INTERVAL '10-12' day_hour);

-- 각 회원의 가입 경과일수 조회
SELECT *, DATEDIFF(now(), created_at) AS datediff
FROM MEMBER;

-- id=3인 회원의 모든 게시글의 조회수 조회
SELECT id, member_id, view_count
FROM POST
WHERE MEMBER_ID=1;

-- 모든 회원수 조회
SELECT count(*) AS cnt_member
FROM MEMBER;

-- 모든 게시글 수 조회
SELECT count(*) AS cnt_post
FROM post;

-- id=3 회원의 총 게시글 수 조회
SELECT member_id, count(*) AS total_count
FROM post
WHERE member_id = 3;

-- id=3 회원의 모든 게시글의 총 조회수
SELECT member_id, view_count
FROM post
WHERE member_id=3;

-- id=3인 회원의 모든 게시글의 총 조회수
SELECT member_id, count(*) AS total_counts, sum(view_count) AS total_views, avg(view_count) AS avg_views, 
	MIN(view_count) AS min_view, max(view_count) AS max_view
FROM post
WHERE member_id=3;

-- 전화번호가 NULL인 회원은 '미등록'으로 표시하여 조회
SELECT name, ifnull(phone, '미등록') AS phone
FROM `member`;

-- 전화번호가 NULL이면 이메일을, 이메일도 NULL이면 '연락처 없음'으로 조회
SELECT name, ifnull(phone, ifnull(email, '연락처 없음')) AS contact
FROM MEMBER;
SELECT name, COALESCE(phone, email, '연락처 없음') AS contact
FROM MEMBER;
SELECT name, IF(phone IS NULL, IF(email IS NULL,'연락처 없음',email), phone) AS contact
FROM MEMBER;

-- 전화번호 등록 여부에 따라 상태 표시
SELECT name, IF(phone IS NULL, '연락처 없음', '연락처 등록') AS contact
FROM MEMBER;

-- 가입연도가 1년이 넘었으면 '우수 회원', 1달이 넘었으면 '일반 회원', 그렇지 않으면 '신규 회원'을 출력
SELECT name, created_at,
	CASE
		WHEN created_at < DATE_SUB(curdate(), INTERVAL 1 year) THEN '우수 회원'
		WHEN created_at < date_sub(curdate(), INTERVAL 1 MONTH) THEN '일반 회원'
		ELSE '신규 회원'
	END AS member_grade
FROM MEMBER;
