-- 모든 게시글의 모든 컬럼 조회
SELECT * FROM post;

-- 모든 게시글의 id, member_id, title, view_count컬럼 조회
SELECT id, member_id, title, view_count FROM post;

-- 모든 게시글의 id, member_id, title, view_count, 작성자 이름, 작성자이메일 컬럼 조회
SELECT p.id, member_id, title, view_count, m.id, m.name, m.email
FROM post p
JOIN MEMBER m
on m.id = p.MEMBER_ID;


-- 모든 댓글 조회
SELECT * FROM reply;

-- 모든 댓글의 id, content, member_id, post_id 조회
SELECT id, content, member_id, post_id FROM reply;

-- 모든 댓글의 id, content, member_id, post_id, 작성자이름, 게시글제목 조회
SELECT reply.id, reply.content, reply.member_id, reply.post_id, MEMBER.name, post.title
FROM reply
INNER JOIN MEMBER
	ON reply.member_id = MEMBER.id
INNER JOIN post
	ON reply.POST_ID = post.id;

-- 게시글 기준으로 댓글 뭐있는지 조회, 정렬
SELECT post.title 게시글, reply.content 댓글, MEMBER.name 댓글작성자
FROM reply
INNER JOIN MEMBER
	ON reply.member_id = MEMBER.id
INNER JOIN post
	ON reply.POST_ID = post.id
ORDER BY post.id DESC, reply.id;

-- left outer join
-- 모든 게시글의 id, member_id, title, view_count, 작성자 이름, 작성자이메일 컬럼 조회
SELECT p.id, member_id, title, view_count, m.id, m.name, m.email
FROM post p
LEFT JOIN MEMBER m
on m.id = p.MEMBER_ID;

-- 전체 회원 목록과 각 회원이 작성한 게시글 수를 조회하세요.(게시글을 작성하지 않은 회원도 포함되어야 함)
-- 전체 회원 목록 조회
SELECT * FROM MEMBER;
-- 필요한 컬럼만 추출
SELECT m.id, m.name, p.id, p.title
FROM MEMBER m
LEFT JOIN POST p
	ON m.id = p.MEMBER_ID;

SELECT m.id, m.name, count(*) post_cnt
FROM MEMBER m
LEFT JOIN POST p
	ON m.id = p.MEMBER_ID
GROUP BY m.id;


-- right outer join
-- 모든 게시글의 id, member_id, title, view_count, 작성자 이름, 작성자이메일 컬럼 조회
SELECT p.id, member_id, title, view_count, m.id, m.name, m.email
FROM post p
RIGHT JOIN MEMBER m
on m.id = p.MEMBER_ID;

SELECT p.id, member_id, title, view_count, m.id, m.name, m.email
FROM MEMBER m
LEFT  JOIN post p
on m.id = p.MEMBER_ID;

-- FULL OUTER JOIN(MySQL은 지원하지 않으므로 UNION으로 대체 가능)
SELECT m.id, m.name, p.title
FROM MEMBER m
LEFT  JOIN post p
on m.id = p.MEMBER_ID
UNION
SELECT m.id, m.name, p.title
FROM MEMBER m
RIGHT  JOIN post p
on m.id = p.MEMBER_ID;


-- SELF JOIN
-- 회원명과 추천인명을 조회
SELECT m1.name 회원명, m1.recommender_id, IFNULL(m2.name, '-') 추천인명
FROM MEMBER m1
LEFT JOIN MEMBER m2 -- 모든 회원명과 추천인명 조회
	ON m1.recommender_id = m2.id;
-- INNER JOIN MEMBER m2 -- 추천인이 있는 회원명과 추천인명 조회
-- 	ON m1.recommender_id = m2.id;

