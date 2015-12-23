package org.ejbtest.account.persistence.query;

import javax.persistence.ColumnResult;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.TableGenerator;
import javax.persistence.TemporalType;

@javax.persistence.Entity(name = "PO_Department")
@javax.persistence.Table(name = "EJB_QUERY_Department")
@SqlResultSetMappings( {
    @SqlResultSetMapping(name = "list_departments_mapping_by_columns", 
       columns = { @ColumnResult(name = "dep_id"),
            @ColumnResult(name = "dep_name"),
            @ColumnResult(name = "start_date"),
            @ColumnResult(name = "end_date")
       }, //org.hibernate.engine.query.sql.NativeSQLQueryScalarReturn: Hibernate 3.2.6 doesn't support the Native Scalar Query.
       entities = {            
       }  //org.hibernate.engine.query.sql.NativeSQLQueryNonScalarReturn
    ),
    @SqlResultSetMapping(name = "list_departments_mapping_by_entities", 
            entities = {@EntityResult(entityClass = Department.class)
            } //org.hibernate.engine.query.sql.NativeSQLQueryNonScalarReturn
         ) 
    
})
@NamedNativeQueries({
    @NamedNativeQuery(name="nnq_listDepartmentObjects", query="select * from ejb_query_department", resultClass=Department.class),
    //Throw exception: Pure native scalar queries are not yet supported, if resultSetMapping is not set
    //Hibernate 3.2.6 doesn't support the Native Scalar Query becasue related SqlResultSetMapping Doesn't contain Type Paramter.
    //ResultsetMappingSecondPass:: public void doSecondPass(Map persistentClasses)     
//    for ( ColumnResult column : ann.columns() ) {
//        definition.addQueryReturn( new NativeSQLQueryScalarReturn( column.name(), null ) );
//    }
    @NamedNativeQuery(name="nnq_listDepartmentsByRows",
         query="select * from ( " +
		"  select row_.*, rownum as rownum_1" +
		"   from (  select dep_id, dep_name, end_date, start_date from ejb_query_department" +
		"   ) row_ where rownum <= 10" + 
		"  ) where rownum_1 > 5)", resultSetMapping = "list_departments_mapping_by_columns"),
    @NamedNativeQuery(name = "nnq_listDepartmentColumns", query = "select dep_id, dep_name,start_date,end_date from ejb_query_department", resultSetMapping = "list_departments_mapping_by_columns")
})
public class Department {
    @javax.persistence.Id
    @javax.persistence.Column(name = "dep_id", precision = 5, scale = 0)
    @GeneratedValue(generator = "department_id_generator", strategy = GenerationType.TABLE)
    @TableGenerator(name = "department_id_generator", table="EJB_Query_Table_Id_Generator", pkColumnName = "GEN_NAME", pkColumnValue = "EJB_Query_Department_ID", valueColumnName = "GEN_VALUE", allocationSize = 1)
    private int depId;
    @javax.persistence.Column(name = "dep_name", length = 200)
    private String depName;
    @javax.persistence.Column(name = "start_date")
    @javax.persistence.Temporal(TemporalType.TIMESTAMP)
    private java.util.Date startDate;
    @javax.persistence.Column(name = "end_date")
    @javax.persistence.Temporal(TemporalType.DATE)
    private java.util.Date endDate;

    public Department(){}
    public Department(String depName) {
        this.depName = depName;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

}
