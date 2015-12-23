package org.basic.ddd.anemic;

import java.math.BigDecimal;

import org.basic.ddd.anemic.application.TransferFacade;
import org.basic.ddd.anemic.domain.model.Account;
import org.basic.ddd.anemic.domain.model.AccountUnderflowException;
import org.basic.ddd.anemic.domain.service.AccountNotExistedException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnemic {
    public static void main(String[] args) {
        String configFilePathPrefix = MainAnemic.class.getName()
                .substring(0, MainAnemic.class.getName().lastIndexOf(".")).replaceAll("\\.", "/");
                
        String[] configPaths = { 
                configFilePathPrefix.substring(0, configFilePathPrefix.lastIndexOf("/"))+"/context-datasource.xml",
                configFilePathPrefix+"/resources/context-persistence-hibernate.xml",
                configFilePathPrefix+"/resources/context-services.xml",
                configFilePathPrefix+"/resources/context-facades.xml" };
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configPaths);

        TransferFacade transferFacade = (TransferFacade) context.getBean("transferFacade", TransferFacade.class);
        Account fromAccount = transferFacade.createAccount("A", new BigDecimal("3250"));
        Account toAccount = transferFacade.createAccount("B", new BigDecimal("55.5"));

        try {
            transferFacade.transfer(fromAccount.getAccountId(), toAccount.getAccountId(), new BigDecimal("2000"));
        } catch (AccountNotExistedException e) {
            e.printStackTrace();
        } catch (AccountUnderflowException e) {
            e.printStackTrace();
        }

        System.out.println(fromAccount.getAccountId() + " has balance: "
                + transferFacade.getBalance(fromAccount.getAccountId()));
        System.out.println(toAccount.getAccountId() + " has balance: "
                + transferFacade.getBalance(toAccount.getAccountId()));
    }
}
