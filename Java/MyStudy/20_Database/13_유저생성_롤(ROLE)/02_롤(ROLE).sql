/* ********* 역할(롤 ROLE) ***********
역할(롤, ROLE) : DB 객체 및 시스템에 대한 권한을 모아둔 집합을 의미
역할 생성 : CREATE ROLE 역할이름
역할 제거 : DROP ROLE 역할이름
역할에 권한 부여 : GRANT 권한 [ON 객체] TO 역할이름
역할의 권한 회수 : REVOKE 권한 [ON 객체] FROM 역할이름
사용자에게 역할 부여 : GRANT 역할이름 TO 사용자

<역할 생성부터 사용자 추가까지의 단계>
CREATE ROLE - 역할생성
GRANT - 만들어진 역할에 권한 부여
GRANT - 사용자에게 역할 부여
-->>역할 제거할 경우 반대로 수행
DROP ROLE - 역할 삭제(사용자에게 부여된 역할에 대한 권한 역시 제거됨)
***************************************/

-- 사용자 계정에서 검색 역할(롤) 조회
SELECT * FROM USER_ROLE_PRIVS;

-- 관리자계정-SYSTEM 검색 역할(롤) 조회
SELECT *
FROM DBA_SYS_PRIVS 
WHERE GRANTEE IN ('CONNECT', 'RESOURCE')
ORDER BY GRANTEE, PRIVILEGE
;
-----------------------
-- (SYSTEM) 롤(ROLE)생성 : PROGRAMER(개발자)라는 역할(롤) 생성
CREATE ROLE PROGRAMER;
--SYSTEM 유저의 ROLE에 생성됨

-- (SYSTEM) PROGRAMER 롤에게 유저의 테이블, 뷰(VIEW) 생성 권한 부여
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO PROGRAMER;

-- (SYSTEM) MDGUEST 유저에게 PROGRAMER 롤(역할) 부여
CREATE USER MDGUEST IDENTIFIED BY mdguest
DEFAULT TABLESPACE USERS --테이블스페이스
TEMPORARY TABLESPACE TEMP; --임시직업 테이블스페이스

--롤(ROLE) 부여 : CONNECT, RESOURCE
GRANT CONNECT, RESOURCE TO MDGUEST;

--PROGRAMER 역할을 MDGUEST에게 부여
GRANT PROGRAMER TO MDGUEST;
-- MDGUEST 유저 테이블, 뷰 생성 가능

--(MDGUEST) 테이블 생성 테스트 MADANG.BBB 만들기
SELECT * FROM USER_ROLE_PRIVS;
-- 접속되어있을 때는 역할 갱신이 안됨 유저 재접속
CREATE TABLE MADANG.BBB(BBB NUMBER); -- 테이블 생성 성공
CREATE TABLE MYSTUDY.BBB(BBB NUMBER); -- 테이블 생성 성공

--(SYSTEM) 롤(권한) 회수(취소)
REVOKE PROGRAMER FROM MDGUEST;

--(SYSTEM) 롤(삭제)
DROP ROLE PROGRAMER;
