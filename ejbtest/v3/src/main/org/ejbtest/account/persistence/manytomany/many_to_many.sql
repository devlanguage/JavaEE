DROP TABLE EJB_RELATION_MTM_Student CASCADE CONSTRAINTS;
DROP TABLE EJB_RELATION_MTM_Teacher CASCADE CONSTRAINTS;
DROP TABLE EJB_RELATION_MTM_Teach_Stu CASCADE CONSTRAINTS;
DROP SEQUENCE  EJB_SEQ_Student_Id;
DROP SEQUENCE  EJB_SEQ_Teacher_Id;

CREATE SEQUENCE EJB_SEQ_Student_Id;
CREATE SEQUENCE EJB_SEQ_Teacher_Id;

CREATE TABLE EJB_RELATION_MTM_Student (
  STU_ID NUMBER(10, 0) NOT NULL,
  STU_NAME VARCHAR2(32 CHAR) NOT NULL
, PRIMARY KEY ( STU_ID )
);

CREATE TABLE EJB_RELATION_MTM_Teacher (
  THR_ID NUMBER(10, 0) NOT NULL,
  THR_NAME VARCHAR2(32 CHAR) NOT NULL
, PRIMARY KEY ( THR_ID )
);
CREATE TABLE EJB_RELATION_MTM_Teach_Stu (
  TEACHER_ID NUMBER(10, 0) NOT NULL,
  STUDENT_ID NUMBER(10, 0) NOT NULL
, PRIMARY KEY  (    TEACHER_ID,    STUDENT_ID  )
, FOREIGN KEY(  TEACHER_ID) REFERENCES EJB_RELATION_MTM_TEACHER(THR_ID) ENABLE
, FOREIGN KEY(  STUDENT_ID) REFERENCES EJB_RELATION_MTM_STUDENT(STU_ID) ENABLE
);