package com.mybatis.pojo;

/**
 * @Classname PriceInfo
 * @Description TODO 商品价格字典
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-06-14 15:19
 * @Version 1.0
 **/
public class PriceInfo {
    private Integer pid;
    private String itemCode;
    private String itemName;
    private String price;
    private Integer isStop;

    @Override
    public String toString() {
        return "商品价格字典[id " + pid + ", " +
                "商品编码 " + itemCode + ", " +
                "商品名称 " + itemName + ", " +
                "单价 " + price + "]";
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getIsStop() {
        return isStop;
    }

    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
    }
}
