/*함수(FUNCTION) : 호출하여 값을 돌려받거나 값을 돌려줌 보통 값을 받아서 쓰는게 목적임
CREATE OR REPLACE FUNCTION FUNCTION1 
(
  PARAM1 IN VARCHAR2 -- 파라미터(옵션)
) RETURN VARCHAR2 -- 리턴 데이터 타입 선언(필수)
AS 
BEGIN
  RETURN NULL; -- 리턴값 (필수) : 타입 일치해야 함
END;

-- 리턴 데이터 타입의 선언 필요함
RETURN 데이터유형

-- 프로그램 마지막(중간)에 값 리턴하는 RETURN문 필요
RETURN 리턴 값;

******/
--BOOKID로 책제목 확인 함수( 파라미터 값 : BOOKID, RETURN값 : BOOKNAME)
CREATE OR REPLACE FUNCTION GET_BOOKNAME (
    IN_ID IN NUMBER --(1)숫자를 받아서
)RETURN VARCHAR2 -- 리턴데이터 타입 필수
AS 
    V_BOOKNAME BOOK.BOOKNAME%TYPE; --변수선언은 AS 뒤에 있어야 함
BEGIN
    SELECT BOOKNAME --(4)BOOKNAME 칼럼에서 찾아서
    INTO V_BOOKNAME --(5)변수에 저장하여
    FROM BOOK --(3)BOOK테이블의
    WHERE BOOKID = IN_ID; --(2)숫자와 일치하는 BOOKID의

    RETURN V_BOOKNAME; -- (6)값을 돌려줌
END;

----------------
-- 함수의 사용(SELECT, WHERE 절에서 사용)
-- 동작여부 확인
SELECT GET_BOOKNAME(6) FROM DUAL; -- BOOKID로 BOOKNAME 찾기

-- SELECT 절에서 사용
SELECT BOOKID, BOOKNAME, GET_BOOKNAME(B.BOOKID)
FROM BOOK ㅠ;
------------

SELECT O.*, GET_BOOKNAME(O.BOOKID) --ORDERS의 BOOKID를 IN하여 출력
FROM ORDERS O
;
----------
--WHERE 절에서 함수 사용
-- 축구라는 단어가 들어간 책제목을 구매한
SELECT O.*
    , GET_BOOKNAME(O.BOOKID) AS BOOKNAME
FROM ORDERS O
WHERE GET_BOOKNAME(O.BOOKID) LIKE '%축구%'
;
--================
--(실습) 고객ID 값을 받아서 고객명을 돌려주는 함수 작성(CUSTOMER 테이블 사용)
-- 함수명 : GET_CUSTNAME
-- GET_CUSTNAME 함수 사용해서 고객명 검색 여부 확인해보기
CREATE OR REPLACE FUNCTION GET_CUSTNAME(
    IN_ID IN NUMBER
) RETURN VARCHAR2
AS
    V_NAME CUSTOMER.NAME%TYPE;
BEGIN
    SELECT NAME
      INTO V_NAME
      FROM CUSTOMER
     WHERE CUSTID = IN_ID;
     
    RETURN V_NAME;
END;

-------------------
-- ORDERS 테이블 데이터 조회
---- GET_BOOKNAME, GET_CUSTNAME 함수사용 주문(판매)정보와 책제목, 고객명 조회
-- SELECT * 에서는 칼럼을 추가할 수 없음, 별칭사용하면 추가 가능
SELECT O.*
     , GET_BOOKNAME(O.BOOKID) AS BOOK_NAME
     , GET_CUSTNAME(O.CUSTID) AS CUST_NAME
FROM ORDERS O
;

---------------
-- SUBQUERTY 방식
SELECT O.*
     , (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOK_NAME
     , (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) AS CUST_NAME
FROM ORDERS O
;
--------
--3개 조인문 데이터가 많을때는 조인문이 나음
SELECT O.* 
    , B.BOOKNAME
    , C.NAME
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.BOOKID = B.BOOKID
  AND O.CUSTID = C.CUSTID
;
