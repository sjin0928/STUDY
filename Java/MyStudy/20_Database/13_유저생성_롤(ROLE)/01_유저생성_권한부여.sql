/* 유저(USER) 생성 
-- 사용자 생성 : MDGUEST / mdguest
-- 롤(ROLE) 부여 : CONNECT, RESOURCE

-- USER SQL
CREATE USER "MDGUEST" -- 사용자명(USER 명)
IDENTIFIED BY "mdguest"  --비밀번호
DEFAULT TABLESPACE "USERS" --테이블스페이스
TEMPORARY TABLESPACE "TEMP"; --임시직업 테이블스페이스

-- 사용할 용량 지정(수정)QUOTAS
ALTER USER "MDGUEST" QUOTA UNLIMITED ON "USERS";

-- 사용자 수정 : ALTER USER
ALTER USER 사용자명(유저명) IDENTIFIED BY 비밀번호;

-- 권한부여(롤/사용권한 부여) : ROLES
GRANT "CONNECT" TO "MDGUEST" ;
GRANT "RESOURCE" TO "MDGUEST" ;

-- 뷰 생성 권한부여 - SYSTEM PRIVILEGES
GRANT CREATE VIEW TO "MDGUEST" ;

-- 사용자(유저) 삭제 : DROP USER
DROP USER 유저명 [CASCADE] ;
--CASCADE : 삭제 시점에 사용자 (유저)가 보유한 모든 데이터 삭제
*******/
-- (관리자 계정 SYSTEM) 유저 생성 권한이 있는 유저에서 작업

CREATE USER MDGUEST IDENTIFIED BY mdguest
DEFAULT TABLESPACE USERS --테이블스페이스
TEMPORARY TABLESPACE TEMP; --임시직업 테이블스페이스

--롤(ROLE) 부여 : CONNECT, RESOURCE
GRANT CONNECT, RESOURCE TO MDGUEST;

-- 뷰 생성 권한부여 - SYSTEM PRIVILEGES
GRANT CREATE VIEW TO MDGUEST ;
----------------
-- (SYSTEM) CONNECT, RESOURCE 롤(ROLE)에 있는 권한 확인
SELECT *
FROM DBA_SYS_PRIVS
WHERE GRANTEE IN ('CONNECT', 'RESOURCE')
ORDER BY GRANTEE, PRIVILEGE
;

--=============================
/****** 권한 부여(GRANT), 권한 취소(REVOKE) **********************
GRANT 권한 [ON 객체] TO {사용자|ROLE|PUBLIC,.., n} [WITH GRANT OPTION]
--PUBLIC은 모든 사용자에게 적용을 의미

GRANT 권한 TO 사용자; --권한을 사용자에게 부여
GRANT 권한 ON 객체 TO 사용자; -객체에 대한 권한을 사용자에게 부여
-->> WITH GRANT OPTION : 객체에 대한 권한을 사용자에게 부여 

-- 권한을 받은 사용자가 다른 사용자에게 권한부여할 권리 포함
GRANT 권한 ON 객체 TO 사용자 WITH GRANT OPTION;
--------------------
-->>>권한 취소(REVOKE)
REVOKE 권한 [ON 객체] FROM {사용자|ROLE|PUBLIC,.., n} CASCADE
--CASCADE는 사용자가 다른 사용자에게 부여한 권한까지 취소시킴
  (확인 및 검증 후 작업)

REVOKE 권한 FROM 사용자; --권한을 사용자에게 부여
REVOKE 권한 ON 객체 FROM 사용자; -객체에 대한 권한을 사용자에게 부여
*************************************************/

-- 권한부여 : MADANG유저의 BOOK테이블에 대한SELECT 권한을 MDGUEST에게 권한을 부여
-- (SYSTEM) 권한부여 - MADANG.BOOK을 SELECT할 수 있는 권한을 MDGUEST에게 부여

SELECT * FROM MADANG.BOOK;
--SYSTEM 유저는 관리자 계정이므로 모든 데이터베이스 접근 가능

GRANT SELECT ON MADANG.BOOK TO MDGUEST;

--(SYSTEM)권한 회수
REVOKE SELECT ON MADANG.BOOK FROM MDGUEST;

-----------
--(MADANG) 권한부여, 권한 회수( BOOK테이블에 대한 SELECT 권한 MDGUEST에게)
SELECT * FROM BOOK;
GRANT SELECT ON BOOK TO MDGUEST;
REVOKE SELECT ON BOOK FROM MDGUEST;

-- (MADANG) WITH GRANT OPTION : 다른 유저에게 권한부여할 수 있도록 허용
GRANT SELECT, UPDATE ON CUSTOMER TO MDGUEST WITH GRANT OPTION;
REVOKE SELECT, UPDATE ON CUSTOMER FROM MDGUEST; -- 모두 취소됨
---
--(SYSTEM) 유저삭제 - 계단식 - CASCADE : 연결된거 전부 삭제
DROP USER MDGUEST; --USER 삭제 권한은 SYSTEM에 있음

DROP USER MDGUEST CASCADE; -- 연결된거 전부 삭제
-- ORA-01940: cannot drop a user that is currently connected (사용중엔 삭제 안되므로 접속 해제 후 삭제)
-- 삭제가 되어도 접속 리스트에는 있음, 접속은 안됨

