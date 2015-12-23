package org.basic.ddd.bloodloss;

import java.math.BigDecimal;

import org.basic.ddd.bloodloss.exceptions.AccountNotExistedException;
import org.basic.ddd.bloodloss.exceptions.AccountUnderflowException;
import org.basic.ddd.bloodloss.facade.TransferFacade;
import org.basic.ddd.bloodloss.model.Account;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBloodLoss {
    static {
        org.apache.log4j.PropertyConfigurator.configure(MainBloodLoss.class.getClassLoader().getResource("log4j_ddd.properties"));
    }

    public static void main(String[] args) {
        String configFilePathPrefix = MainBloodLoss.class.getName()
                .substring(0, MainBloodLoss.class.getName().lastIndexOf(".")).replaceAll("\\.", "/");

        String[] configPaths = {
                configFilePathPrefix.substring(0, configFilePathPrefix.lastIndexOf("/")) + "/context-datasource.xml",
//                configFilePathPrefix + "/resources/context-persistence-hibernate.xml",
                configFilePathPrefix + "/resources/context-persistence-ibatis.xml",
                configFilePathPrefix + "/resources/context-services.xml",
                configFilePathPrefix + "/resources/context-facades.xml" };
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configPaths);

        TransferFacade transferFacade = (TransferFacade) context.getBean("transferFacade", TransferFacade.class);
        transferFacade.clearAccount();
        Account fromAccount = transferFacade.createAccount("A", new BigDecimal("3250"));
        Account toAccount = transferFacade.createAccount("B", new BigDecimal("55.5"));

        try {
            transferFacade.transfer(fromAccount.getAccountId(), toAccount.getAccountId(), new BigDecimal("4000"));
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
