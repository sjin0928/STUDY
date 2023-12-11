/* ===================
SELECT * | [ DISTINCT ] {컬럼명, 컬럼명, ...}
  FROM 테이블명
[WHERE 조건절]
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] 
===================== */
-- GROUP BY : 데이터를 그룹핑해서 처리할 경우 사용
-- GROUP BY 사용시 SELECT 항목에 사용할 수 있는 데이터가 제한됨
---- GROUP BY 절에 사용된 컬럼 또는 그룹함수 (COUNT, SUM, AVG, MAX, MIN) 사용가능
---- 상수값 사용가능(문자열, 숫자, 날짜 값)
-------------
-- HAVING절은 단독으로 사용할 수 없고, 반드시 GROUP BY 절과 함께 사용(종속절)
-- HAVING절 : GROUP BY 절에서 만들어진 데이터에서 검색(선택)조건 부여
--==============

-- 출판사별 출판한 책 개수 구하기
SELECT PUBLISHER, COUNT(*),
       SUM(PRICE), AVG(PRICE), MAX(PRICE), MIN(PRICE)
FROM BOOK
GROUP BY PUBLISHER
;

-- 구매 고객별로 구매금액 합계를 구하시오
SELECT CUSTID, SUM(SALEPRICE)
  FROM ORDERS
 GROUP BY CUSTID
;
--- 이름표시 : 이름으로 그룹핑
SELECT C.NAME, SUM(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 ORDER BY SUM(O.SALEPRICE) DESC --큰 금액 순
 --ORDER BY 2 DESC 위치값으로 기재할 수 있음 // 데이터 변동시 바뀜
;

--------
--주문(판매) 테이블의 고객별 데이터 조회(건수, 합계, 평균, 최소, 최대 금액)
SELECT CUSTID,
       COUNT(*), SUM(SALEPRICE),
       TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM ORDERS
 GROUP BY CUSTID
;

-- 박지성, 추신수 데이터 
SELECT C.NAME,
       COUNT(*), SUM(SALEPRICE),
       TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM ORDERS O, CUSTOMER C
 WHERE NAME IN ('박지성', '추신수')
 GROUP BY C.NAME
;
---------------(실습)
-- 고객명 기준으로 고객별 데이터 조회(건수, 합계, 평균, 최소, 최대)
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
;

-- 표준SQL 형식
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM CUSTOMER C INNER JOIN ORDERS O
    ON C.CUSTID = O.CUSTID
 GROUP BY C.NAME
;

---- 추신수, 장미란 고객 2명만 조회(검색)
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 HAVING C.NAME IN('추신수', '장미란')
;


-- 표준SQL 형식
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM CUSTOMER C INNER JOIN ORDERS O
       ON C.CUSTID = O.CUSTID
 WHERE NAME IN ('추신수', '장미란')
 GROUP BY C.NAME
;
------HAVING절--
--3건이상 구입한 고객 조회(이름, 구입수량)
SELECT C.NAME, COUNT(*) CNT
  FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) >= 3
;

--구매한 책중에 20000원 이상인 책을 구입한 사람의 통계 데이터
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MAX(O.SALEPRICE), MIN(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
HAVING MAX(O.SALEPRICE) >= 20000
;
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MAX(O.SALEPRICE), MIN(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
   AND O.SALEPRICE >= 20000
 GROUP BY C.NAME

;  
SELECT * FROM ORDERS ORDER BY SALEPRICE DESC;
--(실습) 필요시 조인(JOIN)과 GROUP BY ~ HAVING 구문을 사용해서 처리
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
---- 별칭 사용시 주의 : 빈칸, 특수문자 사용시 쌍따옴표("")로 묶어서 표기(한글 사용 자제)
SELECT C.NAME,
       COUNT (*) AS "TOTAL COUNT" --TOTAL_COUNT 권장
       , SUM(SALEPRICE) AS "판매액 합계" --한글 사용할 수 있지만 사용하지 말자
       , TRUNC(AVG(SALEPRICE)) 평균값AVG --한글 사용할 수 있지만 사용하지 말자
       , MIN(SALEPRICE) 최저가_MIN -- 언더바(_) 사용가능
       , MAX(SALEPRICE) "최고가(MAX)" --특수문자 사용시 쌍따옴표("")
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
;
--2. 고객별로 주문한 도서의 총수량, 총판매액 구하기
SELECT C.NAME, COUNT(*) CNT, SUM(SALEPRICE) SUM_PRICE
FROM CUSTOMER C INNER JOIN ORDERS O
     ON O.CUSTID = C.CUSTID
GROUP BY C.NAME
;
--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
--ORDER BY C.NAME
;

--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객명으로 정렬
SELECT C.NAME, SUM(SALEPRICE)
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY C.NAME
;
--5. 고객별로 주문한 건수, 합계금액, 평균금액을 구하고(3권 보다 적게 구입한 사람 검색)
SELECT C.NAME, COUNT(*) AS CNT, SUM(SALEPRICE) AS SUM_PRICE,
        TRUNC(AVG(SALEPRICE)) AS AVG_PRICE
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) < 3
-- ORDER BY SUM(O.SALEPRICE) DESC
-- ORDER BY 3 DESC -- 컬럼 위치값 사용
ORDER BY SUM_PRICE DESC -- 컬럼별칭 사용
;


--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??
-- DISTINT : 중복된 데이터를 1개만 표기
SELECT CUSTID FROM CUSTOMER;
SELECT DISTINCT CUSTID
FROM ORDERS
ORDER BY CUSTID
;
-- 고객테이블에 있는데, 주문 (판매)테이블에 없는 사람
--(방법1) MINUS : 차집합 처리
SELECT CUSTID FROM CUSTOMER --1,2,3,4,5...
MINUS
SELECT CUSTID FROM ORDERS--1,1,2,3,4,1,...
;
------
--(방법2) 서브쿼리(SUB QUERY)
SELECT *
FROM CUSTOMER
WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS)
;
----
--(방법3) 외부조인 (OUTER JOIN)
-- 고객중 한번도 구입내역이 없는 고객 명단 구하기
-- NOT NULL인 키값을 해주는게 좋음
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
    , O.ORDERID, O.SALEPRICE, ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID(+) --조인조건(LEFT OUTER JOIN)
  AND O.ORDERID IS NULL -- 찾을(검색)조건
;
-- 표준 SQL (LEFT OUTER JOIN)
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
    --, O.ORDERID, O.SALEPRICE, ORDERDATE
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
WHERE O.ORDERID IS NULL
;

SELECT C.NAME, COUNT(O.CUSTID) ORDERCNT
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(O.CUSTID) = 0
;
---------------------------
--RIGHT OUTER JOIN
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
    --, O.ORDERID, O.SALEPRICE, ORDERDATE
FROM ORDERS O RIGHT OUTER JOIN CUSTOMER C
     ON C.CUSTID = O.CUSTID
WHERE O.ORDERID IS NULL
;

--외부조인(우측기준)
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
    , O.ORDERID, O.SALEPRICE, ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE O.CUSTID(+) = C.CUSTID --조인조건(RIGHT OUTER JOIN) (+) 부족한 부분은 채운다
  AND O.ORDERID IS NULL -- 찾을(검색)조건
;
---------------
-- 조인(JOIN, INNER JOIN, 내부조인) : 조인테이블 모두에 존재하는 데이터 검색
-- 외부조인 (OUTER JOIN) : 어느 한 쪽 테이블에만 존재하는 데이터 검색
-----------------
CREATE TABLE DEPT (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
    );
INSERT INTO DEPT VALUES ('10', '총무부');
INSERT INTO DEPT VALUES ('20', '급여부');
INSERT INTO DEPT VALUES ('30', 'IT부');
COMMIT;

CREATE TABLE DEPT1(
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
    );
INSERT INTO DEPT1 VALUES ('10', '총무부');
INSERT INTO DEPT1 VALUES ('20', '급여부');
COMMIT;

CREATE TABLE DEPT2 (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
    );
INSERT INTO DEPT2 VALUES ('20', '급여부');
INSERT INTO DEPT2 VALUES ('30', 'IT부');
COMMIT;

SELECT * FROM DEPT;
SELECT * FROM DEPT1;
SELECT * FROM DEPT2;

-- LEFT OUTER JOIN : 좌측 테이블 기준(모두표시)
SELECT * 
  FROM DEPT D, DEPT1 D1
 WHERE D.ID = D1.ID(+)
;
-- RIGHT OUTER JOIN : 우측 테이블 기준(모두표시)
SELECT * 
  FROM DEPT2 D2, DEPT D
 WHERE D2.ID(+) = D.ID
;

-- FULL OUTER JOIN(표준SQL) : 모두표시
SELECT *
  FROM DEPT1 D1 FULL OUTER JOIN DEPT2 D2
       ON D1.ID = D2.ID
ORDER BY D1.ID
;

-----------------------
--(실습) DEPT1, DEPT2 테이블 사용해서
--1. DEPT1에는 있고, DEPT2에는 없는 데이터 찾기 (LEFT OUTER JOIN)
SELECT D1.*
  FROM DEPT1 D1, DEPT2 D2 --조인테이블
 WHERE D1.ID = D2.ID(+) --조인조건(좌측기준)
   AND D2.ID IS NULL
;

SELECT D1.*
  FROM DEPT1 D1 LEFT OUTER JOIN DEPT2 D2 -- 조인테이블 + 조인방식(좌측기준)
       ON D1.ID = D2.ID -- 조인조건
 WHERE D2.ID IS NULL -- 찾을 조건(검색 조건)
;
--2. DEPT2에는 있고, DEPT1에는 없는 데이터 찾기 (RIGHT OUTER JOIN)
SELECT D2.* 
  FROM DEPT1 D1, DEPT D2
 WHERE D1.ID(+) = D2.ID
   AND D1.ID IS NULL
;

SELECT D2.*
  FROM DEPT1 D1 RIGHT OUTER JOIN DEPT2 D2
       ON D1.ID = D2.ID
 WHERE D1.ID IS NULL
;