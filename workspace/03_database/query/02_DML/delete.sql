use board_db;

-- 1번 댓글 삭제
SELECT * FROM reply WHERE id = 1;
DELETE FROM reply WHERE id = 1;

-- 2번 게시글 삭제 + 2번 댓글 자동 삭제
SELECT * FROM post WHERE id = 2;
DELETE FROM post WHERE id = 2;

-- 1번 회원 삭제 (게시글 테이블 생성시 ON DELETE SET NULL 제약 조건을 지정하여
-- 회원삭제 시 관련된 하위 게시글 데이터의 FK 값이 NULL이 된다.
SELECT * FROM MEMBER WHERE id = 1;
DELETE FROM MEMBER WHERE id = 1;
