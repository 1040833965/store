package com.cy.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/24 19:49
 * @Description: 商品类的实体类
 */
@SuppressWarnings({"all"})
public class Product extends BaseEntity implements Serializable {
    private Integer id;
    private Integer categoryId;// '分类id',
    private String itemType; // '商品系列',
    private String title; //'商品标题',
    private String sellPoint;//'商品卖点',
    private Long price; // '商品单价',
    private Integer num; //'库存数量',
    private String image;// '图片路径',
    private Integer status; // '商品状态  1：上架   2：下架   3：删除',
    private Integer priority; // '显示优先级'


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", itemType='" + itemType + '\'' +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
        if (getCategoryId() != null ? !getCategoryId().equals(product.getCategoryId()) : product.getCategoryId() != null)
            return false;
        if (getItemType() != null ? !getItemType().equals(product.getItemType()) : product.getItemType() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(product.getTitle()) : product.getTitle() != null) return false;
        if (getSellPoint() != null ? !getSellPoint().equals(product.getSellPoint()) : product.getSellPoint() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(product.getPrice()) : product.getPrice() != null) return false;
        if (getNum() != null ? !getNum().equals(product.getNum()) : product.getNum() != null) return false;
        if (getImage() != null ? !getImage().equals(product.getImage()) : product.getImage() != null) return false;
        if (getStatus() != null ? !getStatus().equals(product.getStatus()) : product.getStatus() != null) return false;
        if (getPriority() != null ? !getPriority().equals(product.getPriority()) : product.getPriority() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCategoryId() != null ? getCategoryId().hashCode() : 0);
        result = 31 * result + (getItemType() != null ? getItemType().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getSellPoint() != null ? getSellPoint().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getPriority() != null ? getPriority().hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
