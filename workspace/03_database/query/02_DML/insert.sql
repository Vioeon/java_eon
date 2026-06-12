USE board_db;

insert into `member` (email, password, name, phone) values ('haru@gmail.com', '111','하루', '01012345678');
insert into `member` (email, password, name, phone) values ('yong@gmail.com', '222','용쌤', '01011112222');


-- 게시글 데이터 삽입
INSERT INTO post (member_id, title, content) VALUES (1, '첫 번째 게시글', '안녕하세요. 반갑습니다.');
INSERT INTO post (member_id, title, content) VALUES (2, '질문 있습니다', '데이터베이스 기초에 대한 질문입니다.');
INSERT INTO post (member_id, title, content) VALUES (1, '두 번째 게시글', '오늘 날씨가 아주 좋습니다.');
INSERT INTO post (member_id, title, content) VALUES (2, 'MySQL 설치 오류 해결방법', '설치 중 Configurator 단계에서 오류가 날 때 대처법 공유합니다.');
INSERT INTO post (member_id, title, content) VALUES (3, '자기 소개', '안녕하세요 하롱이입니다.');

-- 댓글 데이터 삽입
INSERT INTO reply (post_id, member_id, content) VALUES (1, 2, '환영합니다!');
INSERT INTO reply (post_id, member_id, content) VALUES (1, 3, '반가워요~');
INSERT INTO reply (post_id, member_id, content) VALUES (2, 1, '어떤 부분이 궁금하신가요?');
INSERT INTO reply (post_id, member_id, content) VALUES (4, 3, '정말 유용한 정보네요. 감사합니다!');
INSERT INTO reply (post_id, member_id, content) VALUES (4, 1, '저도 이 방법으로 해결했습니다.');