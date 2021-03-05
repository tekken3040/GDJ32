create table temp(
    num1 int,
    str varchar(10)
);
CREATE TABLE member_tbl (

id varchar2(20),

pw varchar2(20),

name varchar2(100),

gender CHAR,

email varchar2(50),

mobile varchar2(13),

phone varchar2(13),

zip1 CHAR(5),

address1 varchar2(600),

zip2 CHAR(6),

address2 varchar2(600),

birthday DATE,

joindate DATE DEFAULT sysdate

);

 

ALTER TABLE member_tbl

ADD CONSTRAINT member_tbl_id_pk PRIMARY KEY(id);

 

ALTER TABLE member_tbl

ADD CONSTRAINT member_tbl_email_u UNIQUE(email);

 

ALTER TABLE member_tbl

ADD CONSTRAINT member_tbl_mobile_u UNIQUE(mobile);

 

ALTER TABLE member_tbl

MODIFY (pw CONSTRAINT member_tbl_pw_nn NOT NULL);

 

ALTER TABLE member_tbl

MODIFY (name CONSTRAINT member_tbl_name_nn NOT NULL);

 

ALTER TABLE member_tbl

MODIFY (gender CONSTRAINT member_tbl_gender_nn NOT NULL);

 

ALTER TABLE member_tbl

MODIFY (email CONSTRAINT member_tbl_email_nn NOT NULL);

 

ALTER TABLE member_tbl

MODIFY (mobile CONSTRAINT member_tbl_mobile_nn NOT NULL);

 

ALTER TABLE member_tbl

MODIFY (phone  CONSTRAINT member_tbl_phone_nn NOT NULL);

CREATE TABLE board_tbl
(
    ID NUMBER(10) NOT NULL,
    TITLE VARCHAR(400) NOT NULL,
    NAME VARCHAR(40) NOT NULL,
    EMAIL VARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT board_id_pk PRIMARY KEY (ID)
);

COMMENT ON COLUMN board_tbl.ID IS '아이디, 숫자';
COMMENT ON COLUMN board_tbl.TITLE IS '글제목, 한글 허용';
COMMENT ON COLUMN board_tbl.NAME IS '글쓴이, 한글 허용';
COMMENT ON COLUMN board_tbl.EMAIL IS '이메일, 영문/숫자 (한글불가)';