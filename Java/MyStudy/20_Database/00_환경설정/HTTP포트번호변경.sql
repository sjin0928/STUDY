-- SQL에서 한 줄 주석 부호(--)
-- HTTP 포트변경 : 8080 -> 8090
SELECT DBMS_XDB.getHttpPort()FROM dual;
SELECT DBMS_XDB.GETHTTPPORT()FROM dual;
-- 데이터만 대소문자 구분함
-- HTTP 포트변경 : 8090으로 변경
exec dbms_xdb.setHttpPort(8090);
