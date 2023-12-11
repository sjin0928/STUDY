/* 제약조건 옵션
CASCADE(흘러내리다) : 부모테이블(PARENT)의 제약조건을 비활성화 시키면서
  참조하고 있는 자녀테이블(CHILD)의 제약조건까지 비활성화
-------
ON DELETE CASCADE
 테이블간의 관계에서 부모테이블 데이터 삭제시
  자녀테이블 데이터도 함께 삭제 처리
***************/
-- 자녀 테이블에서 참조하고 있는 상태에서는 부모 테이블 컬럼의 PK 비활성화 할 수 없음
-- ORA-02297: cannot disable constraint (MADANG.SYS_C007017) - dependencies exist
-- 참조하고 있는 데이터가 있으므로 불가능함 >> 참조하고 있는 데이터 해제후 진행
ALTER TABLE DEPT DISABLE PRIMARY KEY; --의미 : UNIQUE, NOT NULL 를 비활성화

-- 방법1 : 직접 자녀 테이블 참조키를 모두 삭제 또는 비활성화 후 부모테이블 비활성화

-- DEPT : PK, EMP01, 02, 03 : PK

-- 방법2 : 부모테이블 제약 조건 비활성화하면서 CASCADE 옵션 사용
ALTER TABLE DEPT DISABLE PRIMARY KEY CASCADE;
-- 자녀 테이블의 FOREIGN KEY가 전부 DISABLE로 변경됨

--ON DELETE CASCADE
--테이블간의 관계에서 부모테이블 데이터 삭제시
-- 자녀테이블 데이터도 함께 삭제 처리

CREATE TABLE C_MAIN (
    MAIN_PK NUMBER PRIMARY KEY,
    MAIN_DATA VARCHAR2(30)
);
CREATE TABLE C_SUB (
    SUB_PK NUMBER PRIMARY KEY,
    SUB_DATA VARCHAR2(30),
    SUB_FK NUMBER,
    
    CONSTRAINT C_SUB_FK FOREIGN KEY (SUB_FK)
    REFERENCES C_MAIN(MAIN_PK) ON DELETE CASCADE
    -- 부모테이블 데이터 삭제시 자동으로 삭제 처리
);
INSERT INTO C_MAIN VALUES (1111, '1번 메인 데이터');
INSERT INTO C_MAIN VALUES (2222, '2번 메인 데이터');
INSERT INTO C_MAIN VALUES (3333, '3번 메인 데이터');
COMMIT;

INSERT INTO C_SUB VALUES (1, '1번 SUB', 1111);
INSERT INTO C_SUB VALUES (2, '2번 SUB', 2222);
INSERT INTO C_SUB VALUES (3, '3번 SUB', 3333);
INSERT INTO C_SUB VALUES (4, '4번 SUB', 3333);
COMMIT;
-----
SELECT * FROM C_MAIN;
SELECT * FROM C_SUB;

-------

SELECT * FROM C_MAIN WHERE MAIN_PK = 1111;
SELECT * FROM C_SUB WHERE SUB_FK = 1111;
--메인 테이블 데이터 삭제
DELETE FROM C_MAIN WHERE MAIN_PK = 1111;
DELETE FROM C_MAIN WHERE MAIN_PK = 3333;
--========================
-- 부모테이블 삭제시 자녀 테이블이 있으면 삭제 불가
-- 부모 테이블 삭제 방법
-- 1. 자녀 테이블 참조 제약조건을 삭제 후 부모테이블 삭제 처리
-- 2. CASCADE CONSTRAINTS 옵션 적용하여 삭제
DROP TABLE C_MAIN;
DROP TABLE C_MAIN CASCADE CONSTRAINTS;
-- CASCADE CONSTRAINTS 입력하면 부모테이블만 삭제 가능
