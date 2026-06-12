USE board_db;

-- 전체 회원의 이름과 가입일 조회
SELECT name, created_at FROM member;
-- 전체 회원의 모든 컬럼 조회
SELECT * FROM member;
-- 별칭을 사용하여 컬럼명을 가독성 있게 표현
SELECT name, created_at AS 가입일 FROM MEMBER;
-- 게시글을 작성한 회원 ID 목록을 중복 없이 조회
SELECT member_id FROM post;

-- 중복 제거
SELECT DISTINCT member_id FROM post;

-- 마지막에 '게시글' 이 들어간 TITLE
SELECT ID, TITLE FROM POST WHERE TITLE LIKE '%게시글';
-- '하'로 시작하는 2자리 NAME
SELECT ID, NAME FROM MEMBER WHERE name LIKE '하_';
-- MEMBER_ID가 1,3,5 인 정보
SELECT ID, TITLE, MEMBER_ID FROM POST WHERE MEMBER_ID IN (1,3,5);
-- 특정 날짜 사이에 생성된 정보
SELECT ID, NAME, CREATED_AT FROM MEMBER WHERE CREATED_AT BETWEEN '2026-06-01' AND '2026-06-12 23:59:59';
-- 전화번호가 있는 회원 정보
SELECT ID, NAME, PHONE FROM MEMBER WHERE PHONE IS NOT NULL;

-- 생성시간 기준으로 내림차순 정렬 후, 시간이 중복된 행에 한해 이름으로 오름차순 정렬
SELECT ID, EMAIL, NAME, CREATED_AT FROM MEMBER ORDER BY CREATED_AT DESC, NAME ASC;

-- 가장 최근에 작성된 게시글 2개만 조회
SELECT id, title, created_at FROM post ORDER BY created_at DESC LIMIT 2;
-- 페이징 처리: 한 페이지에 10건씩, 2페이지 조회 (11번째~20번째 행)
SELECT id, title, created_at FROM post ORDER BY created_at DESC LIMIT 2, 2;
