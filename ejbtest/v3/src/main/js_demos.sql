CREATE OR REPLACE PACKAGE pkg_js_demos AS
   PROCEDURE pro_hello(p_user VARCHAR2);
   PROCEDURE pro_create_user(p_id NUMBER,   p_name VARCHAR2);

   FUNCTION func_get_user(p_id VARCHAR2) RETURN VARCHAR2;
   FUNCTION get_today RETURN VARCHAR2;
   FUNCTION RUN_CMD(p_cmd in varchar2) return number;
END pkg_js_demos;
/

CREATE OR REPLACE PACKAGE BODY pkg_js_demos AS
   PROCEDURE pro_hello(p_user VARCHAR2) AS
   LANGUAGE java name 'js_demos.hello(java.lang.String)';
   
   PROCEDURE pro_create_user(p_id NUMBER, p_name VARCHAR2) AS
   LANGUAGE java name 'js_demos.createUser(int, java.lang.String)';
   
   FUNCTION func_get_user(p_id VARCHAR2) RETURN VARCHAR2 AS
   LANGUAGE JAVA name 'js_demos.getUser(java.lang.String) return java.lang.String';
   
   FUNCTION get_today RETURN VARCHAR2 AS
   LANGUAGE JAVA name 'js_demos.getToday() return java.lang.String';   

   FUNCTION RUN_CMD(p_cmd in varchar2) return number AS
   language java
   name 'Util.RunThis(java.lang.String) return integer';
   
END pkg_js_demos;
