drop table jpa_student;
drop table jpa_teacher;
drop table jpa_teacher_student;

drop sequence seq_student;
drop sequence seq_teacher;

create table jpa_student(
   student_id number,
   student_name varchar2(200)   
);
create table jpa_teacher(
   teacher_id number,
   teacher_professional varchar2(200)
);
create table jpa_teacher_student(
	thr_id number,
	stu_id number
);

create sequence seq_student;
create sequence seq_teacher;
