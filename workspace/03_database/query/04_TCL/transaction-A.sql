SELECT * FROM post;

SELECT * FROM MEMBER;

-- 2번회원 탈퇴 시 게시글 삭제 옵션을 선택한 경우

START TRANSACTION;

-- 2번회원의 게시글 먼저 삭제
DELETE FROM post WHERE member_id = 2;

-- 2번회원 정보 삭제
DELETE FROM MEMBER WHERE id = 2;

-- 정상 완료시 DB에 반영
COMMIT;

-- 오류 발생 시 원래 상태로 복구
ROLLBACK;


