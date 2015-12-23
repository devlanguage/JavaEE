package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.TransException;
import com.foshanshop.ejb3.TransactionDAO;
import com.foshanshop.ejb3.bean.Product;

@Stateless
@Remote ({TransactionDAO.class})
public class TransactionDAOBean implements TransactionDAO {

    @PersistenceContext
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertProduct(String name, Float price, boolean error) {
        try {
            for(int i=0;i<3; i++){
                Product product = new Product(name+i,price*(i+1));
                em.persist(product);                
            }
            if (error) new Float("kkk"); //����һ������ 
            
        } catch (Exception e) {
            throw new RuntimeException ("Ӧ���׳�����ʱ����,Ϊ��ʹ����ع����ⲿ��Ҫ��try/catch��Χ"); 
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void ModifyProductName(String newname, boolean error) throws Exception {
        Query query = em.createQuery("select p from Product p");
        List result = query.getResultList();        
        if (result!=null){
            for(int i=0;i<result.size();i++){
                Product product = (Product)result.get(i); 
                product.setName(newname+ i);
                em.merge(product);           
            }
            if (error && result.size()>0) throw new TransException ("�׳�Ӧ������");
        }        
    }
}
