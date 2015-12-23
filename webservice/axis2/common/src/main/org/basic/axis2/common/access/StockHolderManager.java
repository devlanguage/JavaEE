/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.axis2.common.access.StockHolderManager.java is created on 2008-2-18
 */
package org.basic.axis2.common.access;

import java.util.ArrayList;
import java.util.List;

import org.basic.axis2.common.bean.Share;
import org.basic.axis2.common.bean.StockHolder;

/**
 * 
 */
public class StockHolderManager {

    private static final StockHolderManager instance = new StockHolderManager();
    static StockHolder stockHolder = new StockHolder();
    static {
        List<Share> shares = new ArrayList<Share>();
        shares.add(new Share("1"));
        shares.add(new Share("2"));
        shares.add(new Share("3"));
        stockHolder.setShares(shares);
    }

    public final static StockHolderManager getInstance() {

        return instance;
    }

    public Share getShare(int index) {

        if (index >= stockHolder.getShares().size()) {
            return stockHolder.getShares().get(0);
        } else {
            return stockHolder.getShares().get(index);
        }
    }

    public List<Share> getAllShareList() {

        return stockHolder.getShares();
    }

}
