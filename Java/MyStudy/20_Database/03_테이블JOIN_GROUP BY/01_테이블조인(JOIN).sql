--테이블 조인(JOIN) : 2개 이상의 테이블 데이터를 연결해서 1개의 테이블인 것처럼 사용
SELECT * FROM CUSTOMER WHERE CUSTID = 1; 
SELECT * FROM ORDERS WHERE CUSTID = 1;

-- CUSTOMER, ORDERS 2개 테이블 데이터 함께 사용 (조회/검색)
-- (주의) SELECT절에 동일 컬럼명 2개가 올수 없음. 별칭 사용하여 다른이름으로 변경처리
SELECT *
FROM CUSTOMER, ORDERS -- 조인 대상 테이블(별칭 사용 안한 경우) (조건을 안주면 CUSTOMER*ORDERS )
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID --조인 조건
  AND CUSTOMER.NAME = '박지성' -- 선택조건(찾을조건)
--ORDER BY CUSTOMER.CUSTID
;
------------------
-- 테이블 별칭(alias)사용 : 테이블명을 간단하게 사용
-- ** 테이블 별칭 사용시 테이블명 대신 반드시 별칭을 적용
SELECT *
FROM CUSTOMER C, ORDERS O --조인테이블에 대한 별칭 (alias) 사용
WHERE C.CUSTID = O.CUSTID --조인 조건
AND C.NAME = '김연아' --선택조건(찾을조건)
;

-- 표준 조인 쿼리문(FROM ~ INNER JOIN(or JOIN) ~ ON)
SELECT *
  FROM CUSTOMER C INNER JOIN ORDERS O -- 조인테이블
       ON C.CUSTID = O.CUSTID --조인조건
 WHERE C.NAME = '박지성'
;

------------------
-- 판매된 책 목록 확인 (BOOK, ORDERS)
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
-- 출판한 책중 판매된 책 목록(미디어로 끝나는 출판사)
SELECT O.ORDERID, O.BOOKID,
       B.BOOKID AS B_BOOKID, --(주의) 동일한 컬럼명이 2번선택(사용)될 수 없다
       -- SQL 상에서 실행시 오류 발생할 수 있으므로 컬럼명을 미리변경
       B.BOOKNAME, B.PUBLISHER, B.PRICE, O.SALEPRICE, O.ORDERDATE
       
--SELECT *
  FROM BOOK B INNER JOIN ORDERS O
    ON B.BOOKID = O.BOOKID
   AND B.PUBLISHER LIKE '%미디어'
-- AND B.PUBLISHER = '굿스포츠'
ORDER BY B.PUBLISHER, B.BOOKNAME
;
--==========
--(문제해결) 테이블 조인을 통해서 요청한 데이터 찾기
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
SELECT * FROM CUSTOMER;

--실습 : '야구를 부탁해'라는 책이 팔린 내역을 확인(책제목, 판매금액, 판매일자)

SELECT B.BOOKNAME "책제목", B.PRICE "판매금액", O.ORDERDATE "판매일자"
  FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID -- 조인조건
   AND B.BOOKNAME = '야구를 부탁해' -- 선택(검색)조건
;
--표준SQL 방식
SELECT B.BOOKNAME, B.PRICE, O.ORDERDATE
  FROM BOOK B INNER JOIN ORDERS O --조인테이블 + 조인방식
       ON B.BOOKID = O.BOOKID -- 조인조건
 WHERE B.BOOKNAME = '야구를 부탁해' -- 선택(검색)조건
;

--실습 : '야구를 부탁해'라는 책이 몇 권이 팔렸는지 확인
SELECT COUNT (*) AS "판매부수"
  FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
   AND B.BOOKNAME = '야구를 부탁해'
;
 
SELECT COUNT (*) AS "판매부수"
  FROM BOOK B INNER JOIN ORDERS O
       ON B.BOOKID = O.BOOKID
 WHERE B.BOOKNAME = '야구를 부탁해'
;
------
--실습 : '추신수'가 구입한 책값과 구입일자를 확인(책값, 구입일자)
SELECT C.NAME "이름", O.SALEPRICE "책값", O.ORDERDATE "구입일자"
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID -- 조인조건
  AND C.NAME = '추신수'
;
SELECT C.NAME "이름", O.SALEPRICE "책값", O.ORDERDATE "구입일자"
  FROM CUSTOMER C INNER JOIN ORDERS O
       ON C.CUSTID = O.CUSTID
 WHERE C.NAME = '추신수'
;

--실습 : '추신수'가 구입한 합계금액을 확인
SELECT '추신수' "NAME", SUM (O.SALEPRICE) "SUM_PRICE"
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
  AND C.NAME = '추신수'
;
SELECT '추신수' "NAME", SUM (O.SALEPRICE) "SUM_PRICE"
  FROM ORDERS O INNER JOIN CUSTOMER C
       ON O.CUSTID = C.CUSTID
 WHERE C.NAME = '추신수'
;
--실습 : 박지성, 추신수가 구입한 내역을 확인(이름, 구입(판매)금액, 구입(판매)일자)
SELECT C.NAME , O.SALEPRICE, O.ORDERDATE
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
   AND (C.NAME = '박지성' OR C.NAME = '추신수')
 ORDER BY NAME
;

SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
  FROM CUSTOMER C INNER JOIN ORDERS O
       ON C.CUSTID = O.CUSTID
 WHERE C.NAME IN ('박지성', '추신수')
 ORDER BY NAME
;
--=========
-- 이름 책이름 금액 날짜
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
-- 3개 테이블 조인하기 : CUSTOMER, BOOK, ORDERS
-- 고객명, 책제목, 판매가격, 판매일자, 출판사명
-- 조인조건 : O = B, O = C
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER -- 중복아닌 컬럼은 생략가능하지만 명시해주는게 좋음
  FROM BOOK B, CUSTOMER C, ORDERS O -- 조인 대상 테이블 : 필요한 테이블만 조인해서 사용
 WHERE C.CUSTID = O.CUSTID -- 조인조건
   AND B.BOOKID = O.BOOKID -- 조인조건 (테이블3개 - 조인조건2개 7개-6개 조인조건 = 테이블개수 -1)
 ORDER BY NAME
;

----
-- 조인조건 : B = O, O = C
SELECT *
  FROM ORDERS O INNER JOIN BOOK B --조인테이블
       ON O.BOOKID = B.BOOKID --조인조건
       INNER JOIN CUSTOMER C --조인테이블
       ON O.CUSTID = C.CUSTID --조인조건
 WHERE C.NAME = '추신수' --찾을(검색)조건
;

--(실습) BOOK, CUSTOMER, ORDERS 테이블 데이터를 조회
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

--1.장미란이 구입한 책제목, 출판사, 구입가격, 구입일자
SELECT B.BOOKNAME, B.PUBLISHER, O.SALEPRICE, O.ORDERDATE
FROM BOOK B, ORDERS O, CUSTOMER C
WHERE C.CUSTID = O.CUSTID
  AND B.BOOKID = O.BOOKID
  AND C.NAME = '장미란'
;
SELECT B.BOOKNAME, B.PUBLISHER, O.SALEPRICE, O.ORDERDATE
FROM BOOK B INNER JOIN ORDERS O
     ON B.BOOKID = O.BOOKID
     INNER JOIN CUSTOMER C
     ON C.CUSTID = O.CUSTID
WHERE C.NAME = '장미란'
;

--2.장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 구입한 내역
SELECT B.BOOKNAME, B.PUBLISHER,
       TO_CHAR (O.SALEPRICE, '999,999')"SALEPRICE",
       TO_CHAR (O.ORDERDATE, 'YY-MM-DD DAY') "DATE"
FROM BOOK B INNER JOIN ORDERS O
     ON B.BOOKID = O.BOOKID
     INNER JOIN CUSTOMER C
     ON C.CUSTID = O.CUSTID
WHERE C.NAME = '장미란'
  AND O.ORDERDATE BETWEEN TO_DATE('2014-01-01', 'YYYY-MM-DD')
                      AND TO_DATE('2014-07-08', 'YYYY-MM-DD')
;
  --AND O.ORDERDATE >= '2014-01-01' AND O.ORDERDATE <= '2014-07-08' --날짜 VS 문자
  --ORDERDATE 는 날짜타입임
  --시간이 있을경우
SELECT ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY-MM-DD, HH24:MI:SS')
FROM ORDERS
WHERE ORDERDATE BETWEEN TO_DATE('2014-01-01', 'YYYY-MM-DD')
                    AND TO_DATE('2014-07-08', 'YYYY-MM-DD')
;

--3.'야구를 부탁해'라는 책을 구입한 사람과 구입일자를 확인
SELECT C.NAME,
       TO_CHAR(O.ORDERDATE, 'YY-MM-DD (DY)') "DATE"
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
     INNER JOIN BOOK B
     ON B.BOOKID = O.BOOKID
WHERE BOOKNAME = '야구를 부탁해'
;

--4.추신수, 장미란이 구입한 책제목, 구입금액, 구입일자 확인
SELECT B.BOOKNAME,
       TO_CHAR(O.SALEPRICE, '999,999')"PRICE", 
       TO_CHAR(O.ORDERDATE, 'YYYY-MM-DD DY') "DATE"
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
     INNER JOIN BOOK B
     ON B.BOOKID = O.BOOKID
WHERE NAME IN ('추신수', '장미란')
;

---- (정렬 : 고객명, 구입일자 순으로)
SELECT C.NAME, B.BOOKNAME, 
       TO_CHAR(O.SALEPRICE, 'L999,999')"SALEPRICE",
       O.ORDERDATE
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
     INNER JOIN BOOK B
     ON B.BOOKID = O.BOOKID
WHERE NAME IN ('추신수', '장미란')
ORDER BY C.NAME, O.ORDERDATE
;

--5.추신수가 구입한 책갯수, 합계금액, 평균값, 가장 큰금액, 가장 작은금액
SELECT '추신수' NAME,
       COUNT(*) "CNT",
       SUM(SALEPRICE)"SUM_PRICE",
       TO_CHAR(AVG(SALEPRICE), '999,999') "AVG_PRICE",
       TO_CHAR(MAX(SALEPRICE), '999,999') "MAX",
       TO_CHAR(MIN(SALEPRICE), '999,999') "MIN"
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
WHERE C.NAME = '추신수'
;
-------------------------
-- 고객별로 구입한 내역
SELECT C.NAME,
       COUNT(*) "CNT",
       SUM(SALEPRICE)"SUM_PRICE",
       TO_CHAR(AVG(SALEPRICE), '999,999') "AVG_PRICE",
       TO_CHAR(MAX(SALEPRICE), '999,999') "MAX",
       TO_CHAR(MIN(SALEPRICE), '999,999') "MIN"
FROM CUSTOMER C INNER JOIN ORDERS O
     ON C.CUSTID = O.CUSTID
--WHERE C.NAME IN ('추신수', '장미란')
GROUP BY C.NAME
;
---------------------------
