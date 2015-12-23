package junit.debug;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.PersonDAO;
import com.foshanshop.ejb3.bean.Person;

public class PersonDAOTest {

    private static PersonDAO dao;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dao = (PersonDAO)EJBFactory.getEJB("PersonDAOBean/remote");
    }

    @Test
    public void testInsertPerson() {
        assertTrue(dao.insertPerson("’≈¿ ", true, (short)22, new Date()));
    }

    @Test
    public void testGetPersonNameByID() {
        assertNotNull(dao.getPersonNameByID(1));
    }

    @Test
    public void testUpdatePerson() {
        Person person = dao.getPersonByID(1);
        person.setAge((short)67);
        assertNotNull(person);
        assertTrue(dao.updatePerson(person));
    }

    @Test
    public void testGetPersonByID() {
        assertNotNull(dao.getPersonByID(1));
    }

    @Test
    public void testGetPersonList() {
        List list = dao.getPersonList();
        assertNotNull(list);
        assertEquals(false, list.isEmpty());
    }

}
