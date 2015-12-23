/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.axis2.helloxmlbeans.service.HelloXmlbeansService.java is created on 2008-2-1
 */
package org.basic.axis2.helloxmlbeans.service;

import java.util.List;

import org.basic.axis2.common.access.StockHolderManager;
import org.basic.axis2.common.bean.Share;

/**
 * 
 */
public class HelloXmlbeansService {

    static StockHolderManager manager = StockHolderManager.getInstance();

    /**
     * http://localhost:8080/axis2/services/HelloSelfService/getShare?param0=zhangsan Response:
     * 
     * <pre>
     *  &lt;ns:helloResponse&gt;
     *      &lt;ns:return&gt;hello! zhangsan&lt;/ns:return&gt;
     *  &lt;/ns:helloResponse&gt;
     * </pre>
     * 
     * @param user
     * @return
     */
    public String hello(String user) {

        return "hello! " + user;
    }

    /**
     * http://localhost:8080/axis2/services/HelloSelfService/getShare?param0=0
     * 
     * <pre>
     *  &lt;ns:getShareResponse&gt;
     *      &lt;ns:return type=&quot;org.basic.axis2.common.bean.Share&quot;&gt;
     *          &lt;ns:number&gt;1&lt;/ns:number&gt;
     *          &lt;ns:price&gt;1.2&lt;/ns:price&gt;
     *      &lt;/ns:return&gt;
     *  &lt;/ns:getShareResponse&gt;
     * 
     * </pre>
     * 
     * @param index
     * @return
     */
    public Share getShare(int index) {

        return manager.getShare(index);
    }

    /**
     * http://localhost:8080/axis2/services/HelloSelfService/getAllShareList
     * 
     * <pre>
     * 
     * &lt;getAllShareListResponse&gt;
     *      &lt;return type=&quot;org.basic.axis2.common.bean.Share&quot;&gt;
     *          &lt;number&gt;1&lt;/number&gt;
     *          &lt;price&gt;1.2&lt;/price&gt;
     *      &lt;/return&gt;
     *      &lt;return type=&quot;org.basic.axis2.common.bean.Share&quot;&gt;
     *          &lt;number&gt;2&lt;/number&gt;
     *          &lt;price&gt;1.2&lt;/price&gt;
     *      &lt;/return&gt;
     *      &lt;return type=&quot;org.basic.axis2.common.bean.Share&quot;&gt;
     *          &lt;number&gt;3&lt;/number&gt;
     *          &lt;price&gt;1.2&lt;/price&gt;
     *      &lt;/return&gt;
     * &lt;/getAllShareListResponse&gt;
     * </pre>
     * 
     * @return
     */
    public List<Share> getAllShareList() {

        return manager.getAllShareList();
    }

}
