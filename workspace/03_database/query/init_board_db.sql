-- drop database board_db;
-- 
-- create database board_db;

use board_db;

drop table if exists `reply`;
drop table if exists `post`;
drop TABLE IF exists `member`;

create table `member`(
	id int not null auto_increment,
	email varchar(100) not null unique, -- 중복금지
	password varchar(100) not null,
	name varchar(10) not null,
	phone char(12),
	recommender_id int DEFAULT NULL,
	created_at datetime default CURRENT_TIMESTAMP(),
	primary key(id),
	FOREIGN KEY (recommender_id) REFERENCES member(id) ON DELETE SET NULL
);
create table `post`(
	id int not null auto_increment,
	member_id int,
	title varchar(200) not null,
	content text not null,
	created_at datetime default CURRENT_TIMESTAMP(),
	primary key(id),
	FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE SET null
);
create table `reply`(
	id int not null auto_increment,
	post_id int not null,
	member_id int not null,
	content text not null,
	created_at datetime default CURRENT_TIMESTAMP(),
	primary key(id),
	FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE cascade,
	FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE cascade
);

-- INSERT INTO member (email, password, name, phone) VALUES ('haru@gmail.com', '111','하루', '01012345678');
-- INSERT INTO member (email, password, name, phone) VALUES ('yong@gmail.com', '222','용쌤', '01011112222');
-- INSERT INTO member (email, password, name, phone) VALUES ('harong@gmail.com', 'pwd012', '하롱이', '01033334444');
-- INSERT INTO member (email, password, name, phone) VALUES ('namu@gmail.com', 'pwd789', '나무', '01055556666');

-- 모든 컬럼의 값을 순서대로 입력하여 데이터 삽입 (auto_increment는 NULL, default는 DEFAULT 키워드 사용)
INSERT INTO member VALUES (NULL, 'haru@gmail.com', 'pwd123', '하루', '01011112222', NULL, DEFAULT);
INSERT INTO member VALUES (NULL, 'haru2@gmail.com', 'pwd123', '하루2', NULL, 1, '2025-05-10 12:13:45');
INSERT INTO member (email, password, name, recommender_id, created_at) VALUES ('namu@gmail.com', 'pwd789', '나무', NULL, '2026-04-29 13:34:32');
INSERT INTO member (email, password, name, phone, recommender_id, created_at) VALUES
    ('harong@gmail.com', 'pwd012', '하롱이', '01022223333', 1, '2026-05-29 13:34:32'),
    ('yong@gmail.com', 'pwd456', '용쌤', '0103334444', 2, '2026-06-05 14:34:12'),
    ('qqqq@gmail.com', 'www', 'gd쌤', '0103334444', null, '2026-06-05 14:34:12');

-- 게시글 데이터 삽입
INSERT INTO post (member_id, title, content, created_at) VALUES (1, '첫 번째 게시글', '안녕하세요. 반갑습니다.', '2026-05-23 14:33:54');
INSERT INTO post (member_id, title, content, created_at) VALUES (2, '질문 있습니다', '데이터베이스 기초에 대한 질문입니다.', '2026-05-26 10:33:54');
INSERT INTO post (member_id, title, content, created_at) VALUES (1, '두 번째 게시글', '오늘 날씨가 아주 좋습니다.', '2026-05-21 18:33:54');
INSERT INTO post (member_id, title, content, created_at) VALUES (2, 'MySQL 설치 오류 해결방법', '설치 중 Configurator 단계에서 오류가 날 때 대처법 공유합니다.', '2026-05-17 16:33:54');
INSERT INTO post (member_id, title, content, created_at) VALUES (3, '자기 소개', '안녕하세요 하롱이입니다.', '2026-05-25 09:33:54');

-- 댓글 데이터 삽입
INSERT INTO reply (post_id, member_id, content) VALUES (1, 2, '환영합니다!');
INSERT INTO reply (post_id, member_id, content) VALUES (1, 3, '반가워요~');
INSERT INTO reply (post_id, member_id, content) VALUES (2, 1, '어떤 부분이 궁금하신가요?');
INSERT INTO reply (post_id, member_id, content) VALUES (4, 3, '정말 유용한 정보네요. 감사합니다!');
INSERT INTO reply (post_id, member_id, content) VALUES (4, 1, '저도 이 방법으로 해결했습니다.');


ALTER TABLE post ADD COLUMN view_count INT NOT NULL DEFAULT 0;
INSERT INTO post (member_id, title, content, created_at, view_count) VALUES
  (1, '세 번째 게시글', '오늘도 자바 공부를 열심히 하고 있습니다.', '2026-06-12 13:00:00', 15),
  (2, '자바 복습 방법 질문', '자바를 처음 배우는데 복습은 어떻게 하는게 좋을까요?', '2026-06-12 14:00:00', 5),
  (3, '자바 OOP 기초 정리', '상속과 다형성에 대한 개념을 정리했습니다.', '2026-06-12 15:00:00', 23),
  (4, '가입 인사 올립니다', '하롱이입니다. 반갑습니다.', '2026-06-12 16:00:00', 8),
  (5, '배열과 리스트의 차이', 'ArrayList와 일반 배열의 주요 차이점을 아시는 분 계신가요?', '2026-06-12 17:00:00', 50),
  (1, '네 번째 게시글', '날씨가 흐리네요. 비가 올 것 같습니다.', '2026-06-12 18:00:00', 4),
  (2, '자바 스터디원 모집합니다', '자바 기초 문법 같이 공부할 스터디원 모집합니다.', '2026-06-12 19:00:00', 12),
  (3, '클래스와 객체 차이점', '붕어빵 틀과 붕어빵의 비유가 잘 이해되지 않아요.', '2026-06-12 20:00:00', 30),
  (4, '자바 단축키 꿀팁', 'IntelliJ에서 자주 쓰는 유용한 단축키들 공유합니다.', '2026-06-12 21:00:00', 17),
  (5, '반복문 break와 continue', '반복문에서 break와 continue의 차이점 정리입니다.', '2026-06-12 22:00:00', 42),
  (1, '다섯 번째 게시글', '자바 예제 문제를 푸는 재미에 푹 빠졌습니다.', '2026-06-13 01:00:00', 9),
  (2, '메서드 오버로딩과 오버라이딩', '이름은 비슷한데 개념이 완전히 달라서 정리해 봤어요.', '2026-06-13 02:00:00', 28),
  (3, '자바 예외 처리 가이드', '프로그램이 멈추지 않도록 예외 처리하는 방법 공부 중입니다.', '2026-06-13 03:00:00', 19),
  (4, '자바 변수 명명 규칙', '변수 이름을 지을 때 camelCase를 지키는 것이 좋네요.', '2026-06-13 04:00:00', 11),
  (5, '자바 상속 개념 이해하기', '부모 클래스의 변수와 메서드를 자식이 물려받는 예제입니다.', '2026-06-13 05:00:00', 35),
  (1, '여섯 번째 게시글', '자바 조건문 switch-case 문 실습을 하고 있습니다.', '2026-06-13 06:00:00', 7),
  (2, '안녕 테스트 글', '이 본문에는 안녕이라는 단어가 들어갑니다. 반갑습니다.', '2026-06-13 07:00:00', 13),
  (3, '추상 클래스와 인터페이스', '둘 다 추상 메서드를 가지는데 어떤 상황에 구분해서 쓸까요?', '2026-06-13 08:00:00', 25),
  (null, '자바 static 키워드 정리', '클래스 멤버와 인스턴스 멤버의 차이를 정리했습니다.', default, 6),
  (null, '자바 형변환(Casting) 복습', '기본 타입과 참조 타입의 형변환 규칙을 정리해 봅니다.', default, 33);

-- 3. reply 테이블에 샘플 댓글 30개를 추가하세요.(작성일은 기본값 대신 각각 다른 값으로 직접 입력하세요.)
-- 작성일은 기본값(CURRENT_TIMESTAMP) 대신 각각 다른 값으로 직접 입력하세요.
INSERT INTO reply (post_id, member_id, content, created_at) VALUES
  (6, 2, '좋은 글이네요.', '2025-06-12 13:30:00'),
  (6, 3, '저도 공감합니다.', '2025-06-12 14:00:00'),
  (7, 1, '저는 배운 날 바로 타이핑하며 복습해요.', '2025-06-12 14:30:00'),
  (8, 4, '오늘 날씨 진짜 좋네요.', '2025-06-12 15:30:00'),
  (9, 5, '가입을 환영합니다! 열심히 해봐요.', '2025-06-12 16:30:00'),
  (9, 1, '하롱이님 반갑습니다. 같이 파이팅해요!', '2025-06-12 17:30:00'),
  (10, 4, 'ArrayList가 사용하기 훨씬 편리하더군요.', '2025-06-12 17:45:00'),
  (11, 2, '세 번째 게시글 축하드려요!', '2025-06-12 18:30:00'),
  (12, 3, '저도 스터디 참여하고 싶습니다! 쪽지 드릴게요.', '2026-06-12 19:30:00'),
  (13, 4, '다형성은 정말 중요한 개념이죠.', '2026-06-12 20:30:00'),
  (14, 5, '하롱이님도 가입 축하드립니다.', '2026-06-12 21:30:00'),
  (15, 1, 'for문 빠져나갈 때 continue 요긴해요.', '2026-06-12 22:30:00'),
  (16, 2, '네 번째 게시글도 쓰셨네요. 대단해요.', '2026-06-13 01:30:00'),
  (17, 3, '매개변수 개수나 타입만 다르면 이름이 같아도 되더라고요.', '2026-06-13 02:30:00'),
  (18, 4, '예외 처리는 에러 방지에 필수인 것 같아요.', '2026-06-13 03:30:00'),
  (19, 5, '카멜케이스 표기법이 아주 가독성이 높습니다.', '2026-06-13 04:30:00'),
  (20, 1, '상속을 쓰면 코드 중복을 획기적으로 줄여주네요.', '2026-06-13 05:30:00'),
  (21, 2, '다섯 번째 글이군요! 파이팅입니다.', '2026-06-13 06:30:00'),
  (22, 3, '저도 본문 글 읽고 안녕이라고 답글 남겨봅니다.', '2026-06-13 07:30:00'),
  (22, 1, '메서드 내부 변수는 static으로 선언이 안 되네요.', '2026-06-13 08:40:00'),
  (23, 4, '상세한 가이드 고맙습니다.', '2026-06-13 08:10:00'),
  (23, 5, '인터페이스는 규격을 맞출 때 유용한 것 같습니다.', '2026-06-13 08:20:00'),
  (24, 5, 'static은 프로그램 시작할 때 메모리에 바로 올라간대요.', '2026-06-13 08:25:00'),
  (24, 4, '상속 관계에서 super 키워드도 유용하더군요.', '2026-06-13 08:35:00'),
  (25, 1, '자동 형변환과 강제 형변환 차이 복습 잘 했습니다.', '2026-06-13 08:35:00'),
  (25, 3, '반갑습니다! 좋은 하루 되세요.', '2026-06-13 08:50:00'),
  (3, 2, '두 번째 게시글에도 댓글 남깁니다.', '2026-05-27 14:00:00'),
  (3, 3, '유익한 내용이네요.', '2026-05-27 15:00:00'),
  (3, 5, '저도 참고해야겠습니다.', '2026-05-27 16:00:00'),
  (3, 1, '댓글 주신 분들 모두 감사드립니다.', '2026-05-27 17:00:00');


-- 사용자 삭제
DROP USER IF EXISTS 'user1'@'localhost';
-- 사용자 계정 생성
CREATE USER 'user1'@'localhost'
IDENTIFIED BY '1111';


DROP ROLE IF EXISTS 'developer';
-- 개발자용 권한 그룹 생성
CREATE ROLE 'developer';

-- 개발자 그룹에 board_db의 모든 테이블에 대한 CRUD 권한 부여
GRANT SELECT, INSERT, UPDATE, DELETE ON board_db.* TO 'developer';

-- user1에게 개발자 그룹 권한 부여
GRANT 'developer' TO 'user1'@'localhost';

-- user1 로그인 시 developer 권한 그룹이 기본으로 활성화되도록 설정
SET DEFAULT ROLE 'developer' TO 'user1'@'localhost';


-- db 사용자 조회
-- SELECT USER, host FROM mysql.USER;
-- 
-- SHOW grants;
-- SHOW GRANTS FOR 'user1'@'localhost';
