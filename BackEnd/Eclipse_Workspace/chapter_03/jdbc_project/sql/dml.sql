 -- CRUD(insert, select, update, delete) : 
 
INSERT INTO member VALUES
('java1234', '#Abcd1234', '자바맨', '홍길동', 'm', 'abcd@abcd.com',
'010-1234-5678', '1990-01-01', '12345','서울 금천구 가산',
'대륭 3차 11층', sysdate);
 
SELECT * FROM member WHERE member_id='java1234';
 
UPDATE member SET
member_password='#Spring1234',
member_zip='12345',
member_address_basic='서울 금천구 가산디지털단지',
member_address_detail='구디아카데미'
WHERE member_id='java1234';
 
DELETE member WHERE member_id='java1234';