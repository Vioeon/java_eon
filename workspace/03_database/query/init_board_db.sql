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
	created_at datetime default CURRENT_TIMESTAMP(),
	primary key(id)
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

INSERT INTO member (email, password, name, phone) VALUES ('haru@gmail.com', '111','하루', '01012345678');
INSERT INTO member (email, password, name, phone) VALUES ('yong@gmail.com', '222','용쌤', '01011112222');
INSERT INTO member (email, password, name, phone) VALUES ('harong@gmail.com', 'pwd012', '하롱이', '01033334444');
INSERT INTO member (email, password, name, phone) VALUES ('namu@gmail.com', 'pwd789', '나무', '01055556666');
INSERT INTO member (email, password, name, phone) VALUES ('test@gmail.com', 'test111', '데스트', '01077776666');

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


