USE board_db;

-- 회원 테이블 생성
drop TABLE IF exists `member`;
create table `member`(
	id int not null auto_increment,
	email varchar(100) not null unique, -- 중복금지
	password varchar(100) not null,
	name varchar(10) not null,
	created_at datetime default CURRENT_TIMESTAMP(),
	primary key(id)
);

-- 게시판 테이블 생성
drop table if exists `post`;
create table `post`(
	id int not null auto_increment,
	member_id int,
	title varchar(200) not null,
	content text not null,
	created_at datetime default CURRENT_TIMESTAMP(),
	primary key(id),
	FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE SET null
);

/* 댓글 테이블 CRUD */
drop table if exists `reply`;
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
-- member 테이블에 phone 컬럼(가변 문자열, 최대 20자) 추가
ALTER TABLE member ADD phone VARCHAR(20);

-- member 테이블의 phone 컬럼 데이터타입을 VARCHAR(30)으로 수정하고 필수값(NOT NULL)으로 설정
ALTER TABLE member MODIFY phone VARCHAR(30) NOT NULL;

-- member 테이블의 phone 컬럼을 삭제
ALTER TABLE member DROP COLUMN phone;

drop table reply;