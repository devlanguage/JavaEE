<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="1.2">
	<jsp:directive.page import="java.text.*" />  
	<jsp:directive.page import="java.lang.*" />
	<jsp:directive.page contentType="text/xml" />
	<person>
    	<jsp:scriptlet> <![CDATA[
				double compa = 1000.0,  compb = 900.0;
				for (int i = 0; i<=3; i++) {
				    compa += ( Math.random() * 100 ) - 50;
				    compb += ( Math.random() * 100 ) - 50;
	    ]]> </jsp:scriptlet>
    	<day>
        	<num>
        		<jsp:expression>i</jsp:expression>
        	</num>
        	<compa>
            	<jsp:expression>compa</jsp:expression>
        	</compa>
        	<compb>
        		<jsp:expression>compb</jsp:expression>
        	</compb>
    	</day>
    	<jsp:scriptlet> <![CDATA[ } ]]> </jsp:scriptlet>
      
      <jsp:element name="detail">
        <jsp:attribute name="name">Mike</jsp:attribute>
        <jsp:body>Hello</jsp:body>
        <jsp:element name="address">
          <jsp:attribute name="id">10201012</jsp:attribute>
          <jsp:element name="province">Shan'Xi</jsp:element>
          <jsp:element name="city">Xi'An</jsp:element>
          <jsp:element name="street">Changan Road</jsp:element>          
        </jsp:element>
      </jsp:element>
	</person>
</jsp:root>

