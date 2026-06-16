-- 가장 오래전에 가입한 회원의 정보 조회

-- 가장 오래된 회원의 가입일
SELECT min(created_at) FROM MEMBER;

-- 회원 정보 조회
SELECT * FROM MEMBER;

-- 가장 오래전에 가입한 회원의 정보 조회
SELECT *
FROM `member`
WHERE created_at = (SELECT min(created_at) FROM MEMBER);

-- 게시글을 하나라도 작성한 회원의 정보 조회
SELECT *
FROM MEMBER
WHERE EXISTS (SELECT 1 FROM post WHERE MEMBER.id = post.member_id);


-- 각 게시글과 함께 해당 게시글의 댓글 수 조회

-- 게시글 조회
SELECT * FROM post;

-- 1번 게시글의 댓글 수 조회
SELECT count(*) FROM REPLY WHERE post_id = 1;

-- 각 게시글과 함께 해당 게시글의 댓글 수 조회(서브 쿼리)
SELECT id, title,(SELECT count(*) FROM reply WHERE post_id = post.id) AS 'reply_cnt'
FROM post;

-- 각 게시글과 함께 해당 게시글의 댓글 수 조회(JOIN)
SELECT p.id, p.title, count(r.id) -- count안에 컬럼 넣으면 null 제외, *은 행의 갯수라 null포함
FROM POST p
LEFT JOIN reply r
	ON p.id = r.post_id
GROUP BY p.id, p.title;

-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수보다 많은 글을 작성한 회원 조회
SELECT member_id, count(*)
FROM post p
WHERE member_id IS NOT null
GROUP BY member_id;

SELECT avg(cnt)
FROM (SELECT member_id, count(*) AS cnt
	FROM post
	WHERE member_id IS NOT null
	GROUP BY member_id
) AS sub;

SELECT count(*) AS post_cnt
FROM POST
WHERE member_id IS NOT null
GROUP BY member_id;


SELECT member_id, count(*) AS post_cnt
FROM POST
WHERE member_id IS NOT null
GROUP BY member_id
HAVING post_cnt > (
	SELECT avg(cnt)
	FROM (
		SELECT member_id, count(*) AS cnt
		FROM post
		WHERE member_id IS NOT null
		GROUP BY member_id
	) AS sub
);

-- 개선한 버전
-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수보다 많은 글을 작성한 회원 조회
SELECT p.member_id, COUNT(*) AS post_cnt
FROM POST p
GROUP BY p.member_id
HAVING COUNT(*) > (
    SELECT AVG(cnt)
    FROM (
        SELECT COUNT(*) AS cnt
        FROM POST
        GROUP BY member_id
    ) AS sub
);


