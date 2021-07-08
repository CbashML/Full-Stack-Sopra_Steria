--ON HR
CREATE TABLE Student(
student_id number(8) primary key,
student_name varchar2(32),
email varchar2(32),
student_password varchar2(64)
);

CREATE SEQUENCE Students_Sequence
MINVALUE 1
START WITH 1
INCREMENT BY 3;


ALTER sequence Students_Sequence restart start with 1;

commit;
/