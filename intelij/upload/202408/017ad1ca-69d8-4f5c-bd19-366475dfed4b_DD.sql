SELECT NOW();

# 데이터베이스 생성
create database spring default charset utf8;

#계정생성문
create user spring identified by 'spring';

#권한부여
-- grant all privileges on 데이터베이스명.* to 계정명;-- 
grant all privileges on spring.* to spring;




