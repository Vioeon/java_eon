-- board_db라는 데이터베이스 생성
create database board_db;

-- 생성한 데이터베이스로 전환하여 이후 쿼리가 해당 데이터베이스를 대상으로 실행되도록 설정
use board_db;

-- 필요없는 board_db 데이터베이스 삭제
drop database board_db;