-- 서브(SUB QUERY) : SQL문 내부에 있는 SQL문
-- SQL (SELECT, INSERT, UPDATE, DELETE)문 내에 있는 쿼리문
-----------------------

SELECT O.ORDERID, O.SALEPRICE, O.ORDERDATE,
       O.CUSTID, C.NAME,
       O.BOOKID,
       (SELECT BOOKNAME FROM BOOK 
       WHERE BOOKID = O.BOOKID) AS BOOKNAME -- 스칼라 서브쿼리(Scalar Subquery)
FROM ORDERS O,
     (SELECT * FROM CUSTOMER WHERE NAME IN ('장미란', '추신수')) C -- 인라인 뷰(Inline View)
WHERE O.CUSTID = C.CUSTID
  AND SALEPRICE > (SELECT AVG(SALEPRICE)FROM ORDERS) -- 중첩 서브쿼리(Nested Subquery)
;
--================
SELECT * FROM ORDERS; --구입내역
SELECT * FROM CUSTOMER WHERE NAME = '박지성'; -- CUSTID : 1

-- 서브쿼리 사용 : 쿼리내부의 데이터만 사용 가능
SELECT * FROM ORDERS
WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성')
;
--조인문 처리 : 두개테이블의 데이터 전부사용 가능
SELECT C.NAME, O.*
FROM ORDERS O, CUSTOMER C -- 조인테이블
WHERE O.CUSTID = O.CUSTID -- 조인조건
 AND C.NAME = '박지성' --선택조건
;
-----------
-- WHERE 절에서 서브쿼리 사용시 서브쿼리 조회 결과가 2건 이상인 경우 IN 사용
SELECT * FROM ORDERS
WHERE CUSTID IN (SELECT CUSTID FROM CUSTOMER
                 WHERE NAME IN ('박지성', '김연아'))
                 ;
----------
-- (서브쿼리) 책중 정가가 가장 비싼 도서의 이름을 구하시오
SELECT MAX(PRICE) FROM BOOK; --35000 : 가장 비싼 책 금액
SELECT * FROM BOOK WHERE PRICE = 35000;
--서브쿼리를 WHERE 절에 사용
SELECT * FROM BOOK 
WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK);
---------------------
--서브쿼리를 FROM 절에 사용 (테이블 조인형태)
SELECT * 
  FROM BOOK B,
    (SELECT MAX(PRICE) AS MAX_PRICE FROM BOOK) M
WHERE B.PRICE = M.MAX_PRICE -- 찾을 조건
;
-----------
-- 박지성, 김연아 구매내역 (서브쿼리 - FROM 절)
-- 두 테이블의 데이터 전부 쓸 수 있음
---- CUSTOMER, ORDERS 테이블 조인
SELECT *
FROM ORDERS O,
    (SELECT * FROM CUSTOMER WHERE NAME IN ('박지성', '김연아')) C
WHERE O.CUSTID = C.CUSTID
;
---- CUSTOMER, ORDERS 테이블 조인
SELECT *
FROM ORDERS O,CUSTOMER C
WHERE O.CUSTID = C.CUSTID
AND C. NAME IN('박지성', '김연아')
;
----------
-- SELECT 절에 서브쿼리 사용
-- 메인쿼리의 데이터를 서브쿼리에서 사용 가능
-- 서브쿼리에는 1개의 컬럼만 출력할 수 있음
SELECT * FROM ORDERS;
SELECT ORDERID, CUSTID, BOOKID,
       (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUST_NAME,
       (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) BOOK_NAME,
       SALEPRICE, ORDERDATE
  FROM ORDERS O
;
------
-- 박지성이 구매한 책 목록 
-- 직접적으로 연결되어 있지 않은 테이블은 중간테이블 사용하여 연결
SELECT *
  FROM BOOK
 WHERE BOOKID IN (SELECT BOOKID
                    FROM ORDERS
                   WHERE CUSTID IN (SELECT CUSTID
                                      FROM CUSTOMER
                                     WHERE NAME IN ('박지성'))
                   )
;

--(실습) 서브쿼리 이용
--1. 한 번이라도 구매한 내역이 있는 사람
---- (또는 한 번도 구매하지 않은 사람)
SELECT *
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS)
;
SELECT *
FROM CUSTOMER C
WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS)
;
-- JOIN
SELECT NAME
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY NAME
;
SELECT NAME
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
 AND O.CUSTID IS NULL
GROUP BY NAME
;

--2. 20000원 이상되는 책을 구입한 고객 명단 조회
SELECT C.*
FROM CUSTOMER C, (SELECT * FROM ORDERS)O
WHERE C.CUSTID = O.CUSTID
  AND O.SALEPRICE >= 20000
;
SELECT *
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000)
;

--3. '대한미디어' 출판사의 책을 구매한 고객이름 조회
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID 
                   FROM ORDERS
                  WHERE BOOKID IN 
                        (SELECT BOOKID
                           FROM BOOK
                          WHERE PUBLISHER = '대한미디어')
                 )
;

--4. 전체 책가격 평균보다 비싼 책의 목록 조회
SELECT *
FROM BOOK
WHERE PRICE >= (SELECT AVG(PRICE)FROM BOOK)
;
SELECT AVG(PRICE)FROM BOOK
;
SELECT * FROM BOOK
;