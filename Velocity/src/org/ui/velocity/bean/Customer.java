/**
 * The file org.ui.velocity.bean.Customer.java was created by yongjie.gong on 2008-6-4
 */
package org.ui.velocity.bean;

/**
 * @author feiye
 * 
 */
public class Customer {

    private int id = (int) (Math.random() * 10e4);
    private String name = "ZhangSan-" + id;
    private boolean purchased = true;
    // 1.商品推销 2.商品广告，广告片
    private String promo;

    public String getPromo() {

        return promo;
    }

    public void setPromo(String promo) {

        this.promo = promo;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean isPurchased() {

        return purchased;
    }

    public void setPurchased(boolean purchased) {

        this.purchased = purchased;
    }

    @Override
    public String toString() {

        return new StringBuffer(this.getClass().getSimpleName()).append(":[id=").append(this.id).append(", name=")
                .append(this.name).append("]").toString();
    }
}
