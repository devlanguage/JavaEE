package com.foshanshop.ejb3;

public interface TransactionDAO {
    public void insertProduct(String name, Float price, boolean error);
    public void ModifyProductName(String newname, boolean error) throws Exception ; 
}
