/************************************************
형변환 내장함수
TO_CHAR : 문자타입으로 전환(날짜 -> 문자, 숫자 -> 문자) '~~'
TO_NUMBER : 숫자타입으로 전환(문자 -> 숫자)
TO_DATE : 날짜타입으로 전환(문자 -> 날짜)

      <- TO_NUMBER(문자)  -> TO_DATE(문자)
숫자형   ----    문자형   ----     날짜형
      -> TO_CHAR(숫자)   <- TO_CHAR(날짜)
************************************************
--날짜 -> 문자
TO_CHAR(날짜데이터, '출력형식')
<출력형식>
년도(YYYY, YY), 월(MM), 일(DD)
시간 : HH, HH12(12 시간제), HH24(24 시간제)
분(MI), 초(SS)
오전, 오후: AM, PM
년월일시분초 작성예) YYYY-MM-DD HH24:MI:SS
************************************************/
--TO_CHAR : 문자타입으로 전환(날짜-> 문자, 숫자 -> 문자)
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY/MM/DD')FROM DUAL;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD DY')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD (DY)')FROM DUAL;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS)')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD PM HH:MI:SS)')FROM DUAL;

--==============================
/* TO_CHAR(숫자, '출력형식') : 숫자 -> 문자타입
<형식지정>
0(영) : 자리수를 나타내며, 자리수가 맞지 않는 경우 0을 표시
9(구) : 자리수를 나타내며, 자리수가 맞지 않는 경우 표시하지 않음
L : 지역 통화 문자 표시
.(점) : 소수점
,(콤마) : 1000단위 구분 표시 문자
**************************************/

SELECT 1230000, '1230000', TO_CHAR(1230000) FROM DUAL;
SELECT 123000 + 9, '1230000' + 9 FROM DUAL; -- 오라클에서만 문자+숫자 연산 가능
SELECT '123000' + 9 FROM DUAL; -- 문자열 -> 숫자 자동형변환
SELECT '123ABC' + 9 FROM DUAL; -- ORA-01722: invalid number

--묵시적(자동)형변환, 명시적 형변환
SELECT '123000' + 9, TO_NUMBER('123000') + 9 FROM DUAL;
---------------

SELECT TO_CHAR(123456, 'L999,999,999')FROM DUAL; --     ￦123,456
SELECT TO_CHAR(123456, 'L000,000,000')FROM DUAL; -- ￦000,123,456
SELECT TO_CHAR(0, 'L999,999,999'), TO_CHAR(0, 'L000,000,000') FROM DUAL; -- ￦0, ￦000,000,000

SELECT TO_CHAR(1230.5, 'L999,999,999'), TO_CHAR(1230.5, 'L000,000,000') FROM DUAL; -- ￦1,231 ￦000,001,231
SELECT TO_CHAR(1230.555, 'L999,999,999.99'), TO_CHAR(1230.555, 'L000,000,000.00') FROM DUAL; -- ￦1,231 ￦000,001,231
--------------
-- TO_DATE(문자열, 형식문자) ---> 날짜타입
SELECT '2020-08-09', SYSDATE FROM DUAL;
SELECT '2020-08-09' + 1 FROM DUAL; -- ORA-01722: invalid number
SELECT SYSDATE + 1 FROM DUAL;
SELECT TO_DATE('2020-08-09') + 1 FROM DUAL; -- 날짜타입 형변환하면 날짜연산 가능
-- (주의) 날짜타입으로 형변환시에는 형식지정 문자를 반드시 사용하기를 권장
-- 정확한 형을 입력해줘야 설정이 바뀌어도 문제가 없음
SELECT TO_DATE('2020-08-09', 'YYYY-MM-DD') + 1 FROM DUAL;
SELECT TO_DATE('20200809', 'YYYYMMDD') + 1 FROM DUAL;

SELECT ORDERID, ORDERDATE,
       TO_CHAR(ORDERDATE, 'YYYY-MM-DD HH24:MI:SS')
FROM ORDERS;

----------------
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),
       TO_CHAR(TRUNC(SYSDATE),'YYYY-MM-DD HH24:MI:SS'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD')
FROM DUAL;

--(실습)
SELECT ABS(-15) FROM DUAL; -- 절대값

SELECT CEIL(15.7) FROM DUAL; -- 올림

SELECT COS(3.14159) FROM DUAL;

SELECT FLOOR (15.7) FROM DUAL;

SELECT LOG(10,100) FROM DUAL;

SELECT MOD(11,4) FROM DUAL;

SELECT POWER(3,2) FROM DUAL;

SELECT ROUND(15.7), SIGN(-15), TRUNC(15.7) FROM DUAL;

SELECT CHR(67), CONCAT('HAPPY', 'Birthday') FROM DUAL;

SELECT LOWER('Birthday'), LPAD('Page 1', 15, '*.') FROM DUAL;

SELECT LTRIM('Page 1', 'ae'), REPLACE('JACK', 'J', 'BL') FROM DUAL;

SELECT RPAD('Page 1', 15, '*.'), RTRIM('Page1', 'ae') FROM DUAL;

SELECT SUBSTR('ABCDEFG',3, 4), TRIM(LEADING 0 FROM '00AA00') FROM DUAL;
SELECT TRIM(LEADING '0' FROM '00AA00') FROM DUAL;

SELECT UPPER('Birthday'), ASCII('A'), INSTR('CORPORATE FLOOR', 'OR', 3, 2)
FROM DUAL;

SELECT LENGTH('Birthday'), ADD_MONTHS('14/05/21', 1) FROM DUAL;

SELECT LAST_DAY(SYSDATE), NEXT_DAY(SYSDATE, '화'), ROUND(SYSDATE) FROM DUAL;

SELECT SYSDATE, TO_CHAR(SYSDATE), TO_CHAR(123) FROM DUAL;

SELECT TO_DATE('12 05 2014', 'DD MM YYYY'), TO_NUMBER('12.3') FROM DUAL;

SELECT DECODE(1, 1, 'aa', 'bb'), NULLIF(123, 345), NULLIF(345, 345) FROM DUAL;
SELECT NVL(NULL, 123), NVL(1111, 123) FROM DUAL;


SELECT * FROM BOOK;
SELECT NULLIF(BOOKNAME, '축구의 역사') AS 축구의역사없음 FROM BOOK;

SELECT CONCAT(BOOKNAME, ' - '|| PUBLISHER) AS "책이름 - 출판사"
FROM BOOK;

