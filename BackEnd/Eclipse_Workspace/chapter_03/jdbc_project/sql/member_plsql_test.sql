CREATE OR REPLACE PROCEDURE dummy_member_gen_proc
IS
BEGIN
 
    FOR i IN 1..100 LOOP
        INSERT INTO member VALUES
        ('goodee_' || (1000 + i), 
         '#Oracle1234', 
         '별명', 
         '김' || (100 + i), 
         'm', 
         'goodee_' || i || '@abcd.com', 
         '010-1234-' || (1000 + i), 
         '1990-1-1', 
         '12345', 
         '서울 금천구 가산대로', 
         '구디아카데미', 
         SYSDATE); 
     END LOOP; 
 
    COMMIT; 
END; 
/
 
EXECUTE dummy_member_gen_proc; -------------------------------------------------
   
CREATE OR REPLACE PROCEDURE name_update_gen_proc  
IS  
      TYPE first_name_array      IS VARRAY(20)OF CLOB; 
      TYPE middle_name_array      IS VARRAY(10)OF CLOB; 
      TYPE last_name_array      IS VARRAY(10)OF CLOB; 
      first_names   first_name_array; 
      middle_names   middle_name_array; 
      last_names   last_name_array; 
      v_firstName CLOB; 
      v_middleName CLOB; 
      v_lastName CLOB; 
      totalName CLOB; 
      temp_num NUMBER(2); 
BEGIN  
      first_names: = first_name_array('김', '이', '박', '최', '주', '임', '엄', '성', '남궁', '독고', '황', '황보', '송', '오', '유', '류', '윤', '장', '정', '추'); 
      middle_names: = middle_name_array('숙', '갑', '영', '순', '선', '원', '우', '이', '운', '성'); 
      last_names: = last_name_array('영', '수', '희', '빈', '민', '정', '순', '주', '연', '영'); 
       
      FOR i IN 1..100 LOOP  
         
        temp_num: = round(DBMS_RANDOM.VALUE(1, 20), 0); 
        v_firstName: = first_names(temp_num); 
        temp_num: = round(DBMS_RANDOM.VALUE(1, 10), 0); 
        v_middleName: = middle_names(temp_num); 
        temp_num: = round(DBMS_RANDOM.VALUE(1, 10), 0); 
        v_lastName: = last_names(temp_num); 
        totalName: = v_firstName || v_middleName || v_lastName; 
                         
        UPDATE member SET member_name = totalName  
        WHERE member_id = 'goodee_' || (1000 + i); 
 
    END LOOP; 

    COMMIT; 
  END; 
/  
 
EXECUTE name_update_gen_proc; 

SELECT * 
FROM (SELECT ROWNUM, 
             m. * , 
             FLOOR((ROWNUM - 1)/10 + 1)page  
      FROM (
             SELECT * FROM member  
             ORDER BY member_id ASC
           )m  
      )
WHERE page = 1; 

SELECT *
FROM (SELECT ROWNUM,  
             m.*,    
             FLOOR((ROWNUM - 1) / 10 + 1) page  
      FROM (  
             SELECT * FROM member 
             WHERE member_name like '%순%'
             ORDER BY member_id ASC  
           ) m    
      )    
WHERE page = 1;