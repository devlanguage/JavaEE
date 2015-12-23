package com.foshanshop.ejb3.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.QueryDAO;
import com.foshanshop.ejb3.bean.Order;
import com.foshanshop.ejb3.bean.OrderItem;
import com.foshanshop.ejb3.bean.Person;
import com.foshanshop.ejb3.bean.SimplePerson;

@Stateless
@Remote ({QueryDAO.class})
public class QueryDAOBean implements QueryDAO {
    @PersistenceContext
    protected EntityManager em;

    public void initdate() {
        try {
            Query query = em.createQuery("select count(p) from Person p");
            Object result = query.getSingleResult();
            if (result == null || Integer.parseInt(result.toString()) == 0) {
                // û������ʱ�����뼸��������������
                // ===================================
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Person person = new Person("liujun", true, new Short("26"),
                        formatter.parse("1980-9-30"));
                Set<Order> orders = new HashSet<Order>();

                Order order1 = new Order(new Float("105.5"), person, new Date());
                order1.addOrderItem(new OrderItem("U��", new Float("105.5")));

                Order order2 = new Order(new Float("780"), person, new Date());
                order2.addOrderItem(new OrderItem("MP4", new Float("778")));
                order2.addOrderItem(new OrderItem("��Ȫˮ", new Float("2")));
                orders.add(order1);
                orders.add(order2);
                person.setOrders(orders);

                Person person1 = new Person("yunxiaoyi", false,
                        new Short("23"), formatter.parse("1983-10-20"));
                orders = new HashSet<Order>();
                order1 = new Order(new Float("360"), person1, new Date());
                order1.addOrderItem(new OrderItem("��ˮ", new Float("360")));

                order2 = new Order(new Float("1806"), person1, new Date());
                order2.addOrderItem(new OrderItem("�����", new Float("1800")));
                order2.addOrderItem(new OrderItem("5�ŵ��", new Float("6")));
                orders.add(order1);
                orders.add(order2);
                person1.setOrders(orders);

                // =====================================
                Person person2 = new Person("zhangming", false,
                        new Short("21"), formatter.parse("1985-11-25"));
                orders = new HashSet<Order>();

                order1 = new Order(new Float("620"), person2, new Date());
                order1.addOrderItem(new OrderItem("�ޱ�", new Float("620")));

                order2 = new Order(new Float("3"), person2, new Date());
                order2.addOrderItem(new OrderItem("����", new Float("3")));
                orders.add(order1);
                orders.add(order2);
                person2.setOrders(orders);

                em.persist(person2);
                em.persist(person1);
                em.persist(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public String ExecuteQuery(int index) {
        String result = "";
        switch(index){      
            case 1:
                result = this.NameQuery();
                break;
            case 2:
                result = this.PositionQuery();
                break;
            case 3:
                result = this.QueryOrderBy();
                break;
            case 4:
                result = this.QueryPartAttribute();
                break;
            case 5:
                result = this.QueryConstructor();
                break;
            case 6:
                result = this.QueryAggregation();
                break;
            case 7:
                result = this.QueryGroupBy();
                break;
            case 8:
                result = this.QueryGroupByHaving();
                break;
            case 9:
                result = this.QueryLeftJoin();
                break;
            case 10:
                result = this.QueryInnerJoin();
                break;   
            case 11:
                result = this.QueryInnerJoinLazyLoad();
                break; 
            case 12:
                result = this.QueryJoinFetch();
                break; 
            case 13:
                result = this.QueryEntityParameter();
                break; 
            case 14:
                result = this.QueryBatchUpdate();
                break; 
            case 15:
                result = this.QueryBatchRemove();
                break;  
            case 16:
                result = this.QueryNOTOperate();
                break; 
            case 17:
                result = this.QueryBETWEENOperate();
                break;  
            case 18:
                result = this.QueryINOperate();
                break; 
            case 19:
                result = this.QueryLIKEOperate();
                break;           
            case 20:
                result = this.QueryISNULLOperate();
                break;  
            case 21:
                result = this.QueryISEMPTYOperate();
                break; 
            case 22:
                result = this.QueryEXISTSOperate();
                break;  
            case 23:
                result = this.QueryStringOperate();
                break;  
            case 24:
                result = this.QueryMathLOperate();
                break; 
            case 25:
                result = this.QuerySubQueryOperate();
                break; 
            case 26:
                result = this.QueryNoneReturnValueStoreProcedure();
                break;     
            case 27:
                result = this.QuerySingleObjectStoreProcedure();
                break;   
            case 28:
                result = this.QueryStoreProcedure();
                break;                
            case 29:
                result = this.QueryPartColumnStoreProcedure();
                break;                 
        }        
        return result;
    }
    
    private String NameQuery(){
        //��ȡָ��personid����Ա
        Query query = em.createQuery("select p from Person p where p.personid=:Id");
        query.setParameter("Id",new Integer(1));
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** NameQuery �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                Person person= (Person)iterator.next();            
                out.append(person.getName()+ "<BR>");            
            }
        }
        return out.toString();
    }
    
    private String PositionQuery(){
        //��ȡָ��personid����Ա
        Query query = em.createQuery("select p from Person p where p.personid=?1");
        query.setParameter(1,new Integer(1));
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** PositionQuery �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                Person person= (Person)iterator.next();            
                out.append(person.getName()+ "<BR>");            
            }
        }
        return out.toString();
    }
    
    private String QueryOrderBy(){
        //�Ȱ����併������Ȼ�󰴳���������������
        Query query = em.createQuery("select p from Person p order by p.age desc, p.birthday asc");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryOrderBy �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                Person person= (Person)iterator.next();            
                out.append(person.getName()+ "<BR>");            
            }
        }
        return out.toString();
    }
    
    private String QueryPartAttribute(){
        //ֱ�Ӳ�ѯ���Ǹ���Ȥ������(��)
        Query query = em.createQuery("select p.personid, p.name from Person p order by p.personid desc ");
        //�����е�Ԫ�ز�����Person,����һ��Object[]��������
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryPartAttribute �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();            
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = ( Object[]) iterator.next();
                //�����еĵ�һ��ֵ��personid
                int personid = Integer.parseInt(row[0].toString());
                String PersonName = row[1].toString(); 
                out.append("personid="+ personid+ "; Person Name="+PersonName+ "<BR>");    
            }
        }
        return out.toString();
    }
    
    private String QueryConstructor(){
        //���ǰ���Ҫ������������ΪSimplePerson�Ĺ�������������ʹ��new������
        Query query = em.createQuery("select new com.foshanshop.ejb3.bean.SimplePerson(p.name,p.sex) from Person p order by p.personid desc");
        //�����е�Ԫ����SimplePerson����
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryConstructor �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                SimplePerson simpleperson = (SimplePerson) iterator.next();
                out.append("��Ա���ܣ�"+ simpleperson.getDescription()+ "<BR>");    
            }
        }
        return out.toString();     
    }
    
    private String QueryAggregation(){
        //��ȡ�������
        Query query = em.createQuery("select max(p.age) from Person p");
        Object result = query.getSingleResult();        
        String maxAge = result.toString(); 
        //��ȡƽ������
        query = em.createQuery("select avg(p.age) from Person p");
        result = query.getSingleResult();        
        String avgAge = result.toString(); 
        //��ȡ��С����
        query = em.createQuery("select min(p.age) from Person p");
        result = query.getSingleResult();        
        String minAge = result.toString(); 
        //��ȡ������
        query = em.createQuery("select count(p) from Person p");
        result = query.getSingleResult();        
        String countperson = result.toString(); 
        //��ȡ�����ܺ�
        query = em.createQuery("select sum(p.age) from Person p");
        result = query.getSingleResult();        
        String sumage = result.toString();         
        
        StringBuffer out = new StringBuffer("*************** QueryConstructor �����ӡ ****************<BR>");
        out.append("������䣺"+ maxAge+ "<BR>");
        out.append("ƽ�����䣺"+ avgAge+ "<BR>");
        out.append("��С���䣺"+ minAge+ "<BR>");
        out.append("��������"+ countperson+ "<BR>");
        out.append("�����ܺͣ�"+ sumage+ "<BR>");        
        return out.toString(); 
    }
 
    private String QueryGroupBy(){
        //������Ů�����Ե�������
        Query query = em.createQuery("select p.sex, count(p) from Person p group by p.sex");
        //�����е�Ԫ�ز�����Person,����һ��Object[]��������
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryGroupBy �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = (Object[]) iterator.next();
                //�����еĵ�һ��ֵ��sex
                boolean sex = Boolean.parseBoolean(row[0].toString());
                //�����еĵڶ���ֵ�ǾۺϺ���COUNT����ֵ
                String sextotal = row[1].toString();
                out.append((sex ? "����":"Ů��")+ "�ܹ���"+ sextotal+ "��<BR>");
            }
        }
        return out.toString(); 
    }
    
    private String QueryGroupByHaving(){
        //������������1�˵��Ա�
        Query query = em.createQuery("select p.sex, count(p) from Person p group by p.sex having count(p) >?1");
        //���ò�ѯ�еĲ���
        query.setParameter(1, new Long(1));
        //�����е�Ԫ�ز�����Person,����һ��Object[]��������
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryGroupByHaving �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = (Object[]) iterator.next();
                //�����еĵ�һ��ֵ��sex
                boolean sex = Boolean.parseBoolean(row[0].toString());
                //�����еĵڶ���ֵ�ǾۺϺ���COUNT����ֵ
                String sextotal = row[1].toString();
                out.append((sex ? "����":"Ů��")+ "�ܹ���"+ sextotal+ "��<BR>");
            }
        }
        return out.toString(); 
    }
    
    private String QueryLeftJoin(){
        //��ȡ26���˵Ķ���,����Order���Ƿ���OrderItem
        Query query = em.createQuery("select o from Order o left join o.orderItems where o.ower.age=26 order by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryLeftJoin �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            Integer orderid = null;
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                if (orderid==null || !orderid.equals(order.getOrderid())){
                    orderid = order.getOrderid();
                    out.append("�����ţ�"+ orderid+ "<BR>");
                }
            }
        }
        return out.toString(); 
    }
 
    private String QueryInnerJoin(){
        //��ȡ26���˵Ķ���,Order�б���Ҫ��OrderItem
        Query query = em.createQuery("select o from Order o inner join o.orderItems where o.ower.age=26 order by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryInnerJoin �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            Integer orderid = null;
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                if (orderid==null || !orderid.equals(order.getOrderid())){
                    orderid = order.getOrderid();
                    out.append("�����ţ�"+ orderid+ "<BR>");
                }
            }
        }
        return out.toString(); 
    }   
 
    private String QueryInnerJoinLazyLoad(){
        // Ĭ��EJB3 QL����󲻹����������Ա���(orderItems)��Ӧ�ı�
        Query query = em.createQuery("select o from Order o inner join o.orderItems where o.ower.age=26 order by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryInnerJoinLazyLoad �����ӡ ****************<BR>");
        if (result!=null){
            if( result.size()>0){
                //��ʱ���Orderʵ����orderItems( �������Ա��� )Ϊ��
                Order order = (Order) result.get(0);
                //��Ӧ����Ҫʱ��EJB3 Runtime�Ż�ִ��һ��SQL������������ڵ�ǰOrder��OrderItems
                Set<OrderItem> list = order.getOrderItems();
                Iterator<OrderItem> iterator = list.iterator();
                if (iterator.hasNext()){
                    OrderItem orderItem =iterator.next();
                    out.append("������Ʒ����"+ orderItem.getProductname()+ "<BR>");
                }
            }
        }
        return out.toString(); 
    }   
    
    private String QueryJoinFetch(){
        //��ȡ26���˵Ķ���,Order�б���Ҫ��OrderItem
        Query query = em.createQuery("select o from Order o inner join fetch o.orderItems where o.ower.age=26 order by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryJoinFetch �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            Integer orderid = null;
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                if (orderid==null || !orderid.equals(order.getOrderid())){
                    orderid = order.getOrderid();
                    out.append("�����ţ�"+ orderid+ "<BR>");
                }
            }
        }
        return out.toString(); 
    }    
 
    private String QueryEntityParameter(){
        //��ѯĳ�˵����ж���
        Query query = em.createQuery("select o from Order o where o.ower =?1 order by o.orderid");
        Person person = new Person();
        person.setPersonid(new Integer(1));
        //���ò�ѯ�еĲ���
        query.setParameter(1,person);
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryEntityParameter �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            Integer orderid = null;
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                if (orderid==null || !orderid.equals(order.getOrderid())){
                    orderid = order.getOrderid();
                    out.append("�����ţ�"+ orderid+ "<BR>");
                }
            }
        }
        return out.toString(); 
    }   
  
    private String QueryBatchUpdate(){
        //�����ж����Ľ���10
        Query query = em.createQuery("update Order as o set o.amount=o.amount+10");
        //update�ļ�¼��
        int result = query.executeUpdate();
        StringBuffer out = new StringBuffer("*************** QueryBatchUpdate �����ӡ ****************<BR>");
        out.append("���²���Ӱ��ļ�¼����"+ result+ "��<BR>");
        return out.toString(); 
    } 
 
    private String QueryBatchRemove(){
        //�ѽ��С��100�Ķ���ɾ��,��ɾ����������,��ɾ������
        Query query = em.createQuery("delete from OrderItem item where item.order in(from Order as o where o.amount<100)");
        query.executeUpdate();        
        query = em.createQuery("delete from Order as o where o.amount<100");
        int result = query.executeUpdate();//delete�ļ�¼��
        StringBuffer out = new StringBuffer("*************** QueryBatchRemove �����ӡ ****************<BR>");
        out.append("ɾ������Ӱ��ļ�¼����"+ result+ "��<BR>");
        return out.toString(); 
    } 
    
    private String QueryNOTOperate(){
        //��ѯ����ָ����֮������ж���
        Query query = em.createQuery("select o from Order o where not(o.ower =?1) order by o.orderid");
        Person person = new Person();
        person.setPersonid(new Integer(2));
        //���ò�ѯ�еĲ���
        query.setParameter(1,person);
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryNOTOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            Integer orderid = null;
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                if (orderid==null || !orderid.equals(order.getOrderid())){
                    orderid = order.getOrderid();
                    out.append("�����ţ�"+ orderid+ "<BR>");
                }
            }
        }
        return out.toString();       
    }
 
    private String QueryBETWEENOperate(){
        //��ѯ�����300��1000֮��Ķ���
        Query query = em.createQuery("select o from Order as o where o.amount between 300 and 1000");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryBETWEENOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            Integer orderid = null;
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                if (orderid==null || !orderid.equals(order.getOrderid())){
                    orderid = order.getOrderid();
                    out.append("�����ţ�"+ orderid+ "<BR>");
                }
            }
        }
        return out.toString();       
    }
    
    private String QueryINOperate(){
        //��������Ϊ26,21��Person
        Query query = em.createQuery("select p from Person as p where p.age in(26,21)");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryINOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                Person person= (Person)iterator.next();            
                out.append(person.getName()+ "<BR>");            
            }
        }
        return out.toString();
    }
    
    private String QueryLIKEOperate(){
        //�������ַ���"li"��ͷ��Person
        Query query = em.createQuery("select p from Person as p where p.name like 'li%'");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryLIKEOperate �����ӡ ****************<BR>");
        if (result!=null){
            out.append("---------- �������ַ���\"li\"��ͷ��Person ----------<BR>");
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                Person person= (Person)iterator.next();            
                out.append(person.getName()+ "<BR>");            
            }
        }
        //���Խ��NOTһ��ʹ�ã������ѯ����name�����ַ���"ming"��β��Person
        query = em.createQuery("select p from Person as p where p.name not like '%ming'");
        result = query.getResultList();
        if (result!=null){
            out.append("---------- ��ѯ����name�����ַ���\"ming\"��β��Person ----------<BR>");
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                Person person= (Person)iterator.next();            
                out.append(person.getName()+ "<BR>");            
            }
        }           
        return out.toString();
    }
    
    private String QueryISNULLOperate(){
        //��ѯ���й����ߵ�����Order
        Query query = em.createQuery("select o from Order as o where o.ower is not null order by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryISNULLOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ��ѯ���й����ߵ�����Order -------------<BR>");
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
            }
        }
        //��ѯû�й����ߵ�����Order
        query = em.createQuery("select o from Order as o where o.ower is null order by o.orderid");
        result = query.getResultList();
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ��ѯû�й����ߵ�����Order -------------<BR>");
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
            }
        }
        
        return out.toString();       
    }
    
    private String QueryISEMPTYOperate(){
        //��ѯ���ж����������Order
        Query query = em.createQuery("select o from Order as o where o.orderItems is not empty order by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryISEMPTYOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("---------------  ��ѯ���ж����������Order -------------<BR>");
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
            }
        }
        //��ѯû�ж����������Order
        query = em.createQuery("select o from Order as o where o.orderItems is empty order by o.orderid");
        result = query.getResultList();
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ��ѯû�ж����������Order -------------<BR>");
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
            }
        }
        
        return out.toString();       
    }  
    
    private String QueryEXISTSOperate(){
        //������ڶ�����1���ͻ�ȡ����OrderItem
        Query query = em.createQuery("select oi from OrderItem as oi where exists (select o from Order o where o.orderid=1)");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryEXISTSOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ������ڶ�����1���ͻ�ȡ����OrderItem -------------<BR>");
            while( iterator.hasNext() ){
                OrderItem item = (OrderItem) iterator.next();
                out.append("���ж����Ĳ�Ʒ����"+ item.getProductname()+ "<BR>");
            }
        }
        //��������ڶ�����10���ͻ�ȡidΪ1��OrderItem
        query = em.createQuery("select oi from OrderItem as oi where oi.id=1 and not exists (select o from Order o where o.orderid=10)");
        result = query.getResultList();
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ��������ڶ�����10���ͻ�ȡidΪ1��OrderItem -------------<BR>");
            if( iterator.hasNext() ){
                OrderItem item = (OrderItem) iterator.next();
                out.append("������IDΪ1�Ķ�����Ʒ����"+ item.getProductname()+ "<BR>");
            }
        }
        
        return out.toString();       
    }
    
    private String QueryStringOperate(){
        //��ѯ������Ա������������������ַ���"_foshan"
        Query query = em.createQuery("select p.personid, concat(p.name, '_foshan') from Person as p");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryStringOperate �����ӡ ****************<BR>");
        if (result!=null){
            out.append("---------- ��ѯ������Ա������������������ַ���\"_foshan\" ----------<BR>");
            Iterator iterator = result.iterator();            
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = ( Object[]) iterator.next();
                //�����еĵ�һ��ֵ��personid
                int personid = Integer.parseInt(row[0].toString());
                String PersonName = row[1].toString(); 
                out.append("personid="+ personid+ "; Person Name="+PersonName+ "<BR>");    
            }
        }  
        
        //��ѯ������Ա,ֻȡ������ǰ�����ַ�
        query = em.createQuery("select p.personid, substring(p.name,1,3) from Person as p");
        result = query.getResultList();
        if (result!=null){
            out.append("---------- ��ѯ������Ա,ֻȡ������ǰ�����ַ� ----------<BR>");
            Iterator iterator = result.iterator();            
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = ( Object[]) iterator.next();
                //�����еĵ�һ��ֵ��personid
                int personid = Integer.parseInt(row[0].toString());
                String PersonName = row[1].toString(); 
                out.append("personid="+ personid+ "; Person Name="+PersonName+ "<BR>");    
            }
        } 
        return out.toString();
    }  
    
    private String QueryMathLOperate(){
        //��ѯ����Order�Ķ����ż��䶩���������
        Query query = em.createQuery("select o.orderid, size(o.orderItems) from Order as o group by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryMathLOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ��ѯ����Order�Ķ����ż��䶩��������� -------------<BR>");
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = ( Object[]) iterator.next(); 
                out.append("�����ţ�"+ row[0].toString()+ "; �����"+row[1].toString()+ "��<BR>");  
            }
        }
        //��ѯ����Order�Ķ����ż����ܽ��/10������
        query = em.createQuery("select o.orderid, mod(o.amount, 10) from Order as o");
        result = query.getResultList();
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ��ѯ����Order�Ķ����ż����ܽ��/10������ -------------<BR>");
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = ( Object[]) iterator.next(); 
                out.append("�����ţ�"+ row[0].toString()+ "; �ܽ��/10������:"+row[1].toString()+ "<BR>");  
            }
        }
        return out.toString();       
    }
  
    private String QuerySubQueryOperate(){
        //��ѯ����Ϊ26��Ĺ����ߵ�����Order
        Query query = em.createQuery("select o from Order as o where o.ower in(select p from Person as p where p.age =26) order by o.orderid");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QuerySubQueryOperate �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            out.append("--------------- ��ѯ����Ϊ26��Ĺ����ߵ�����Order -------------<BR>");
            while( iterator.hasNext() ){
                Order order = (Order) iterator.next();
                out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
            }
        }        
        return out.toString();       
    }
 
    /* Mysql���ݿ�AddPerson�洢���̵�DDL:
     * 
        CREATE PROCEDURE `AddPerson`()
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
             INSERT into person(`PersonName`,`sex`,`age`) values('�洢����',1,25);
        END;
     */
    private String QueryNoneReturnValueStoreProcedure(){
        //�����޷��ز����Ĵ洢����
        Query query = em.createNativeQuery("{call AddPerson()}");
        query.executeUpdate();
        StringBuffer out = new StringBuffer("*************** QueryNoneReturnValueStoreProcedure �����ӡ ****************<BR>");
        return out.toString();       
    }
 
    /* Mysql���ݿ�GetPersonName�洢���̵�DDL:
     * 
        CREATE PROCEDURE `GetPersonName`(IN Pid INTEGER(11))
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
            select personname from person where `personid`=Pid;
        END;
     */
    private String QuerySingleObjectStoreProcedure(){
        //���÷��ص���ֵ�Ĵ洢����
        Query query = em.createNativeQuery("{call GetPersonName(?)}");
        query.setParameter(1, new Integer(1));
        String result = query.getSingleResult().toString();
        StringBuffer out = new StringBuffer("*************** QuerySingleObjectStoreProcedure �����ӡ ****************<BR>");
        out.append("����ֵ(��Ա����)Ϊ��"+ result+ "<BR>");
        return out.toString();       
    }
    
    /* Mysql���ݿ�GetPersonList�洢���̵�DDL:
     * 
        CREATE PROCEDURE `GetPersonList`()
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
             select * from person;
        END;
     */
    private String QueryStoreProcedure(){
        //���÷���Personȫ�����ԵĴ洢����
        Query query = em.createNativeQuery("{call GetPersonList()}", Person.class);
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryStoreProcedure �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                Person person= (Person)iterator.next();            
                out.append(person.getName()+ "<BR>");            
            }
        }
        return out.toString();       
    }
 
    /* Mysql���ݿ�GetPersonPartProperties�洢���̵�DDL:
     * 
        CREATE PROCEDURE `GetPersonPartProperties`()
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
             SELECT personid, personname from person;
        END;
     */
    private String QueryPartColumnStoreProcedure(){
        //���÷��ؼ�¼�������еĴ洢����
        Query query = em.createNativeQuery("{call GetPersonPartProperties()}");
        List result = query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryPartColumnStoreProcedure �����ӡ ****************<BR>");
        if (result!=null){
            Iterator iterator = result.iterator();            
            while( iterator.hasNext() ){
                //ȡÿһ��
                Object[] row = ( Object[]) iterator.next();
                //�����еĵ�һ��ֵ��personid
                int personid = Integer.parseInt(row[0].toString());
                String PersonName = row[1].toString(); 
                out.append("��ԱID="+ personid+ "; ����="+PersonName+ "<BR>");    
            }
        } 
        return out.toString();       
    }

}
