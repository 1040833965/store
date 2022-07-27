package com.cy.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/27 11:00
 * @Description:
 */
@SuppressWarnings({"all"})
public class Order extends BaseEntity implements Serializable{
    private int oid ; //COMMENT '订单id',
    private int uid; //'用户id',
    private String recv_name; // '收货人姓名',
    private String recv_phone; // '收货人电话',
    private String recv_province; //'收货人所在省',
    private String recv_city; // '收货人所在市',
    private String recv_area; // '收货人所在区',
    private String recv_address; // '收货详细地址',
    private Long total_price; // '总价',
    private Integer status; // '状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成',
    private Integer order_time;// '下单时间',
    private Date pay_time; // '支付时间',


    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", recv_name='" + recv_name + '\'' +
                ", recv_phone='" + recv_phone + '\'' +
                ", recv_province='" + recv_province + '\'' +
                ", recv_city='" + recv_city + '\'' +
                ", recv_area='" + recv_area + '\'' +
                ", recv_address='" + recv_address + '\'' +
                ", total_price=" + total_price +
                ", status=" + status +
                ", order_time=" + order_time +
                ", pay_time=" + pay_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getOid() != order.getOid()) return false;
        if (getUid() != order.getUid()) return false;
        if (getRecv_name() != null ? !getRecv_name().equals(order.getRecv_name()) : order.getRecv_name() != null)
            return false;
        if (getRecv_phone() != null ? !getRecv_phone().equals(order.getRecv_phone()) : order.getRecv_phone() != null)
            return false;
        if (getRecv_province() != null ? !getRecv_province().equals(order.getRecv_province()) : order.getRecv_province() != null)
            return false;
        if (getRecv_city() != null ? !getRecv_city().equals(order.getRecv_city()) : order.getRecv_city() != null)
            return false;
        if (getRecv_area() != null ? !getRecv_area().equals(order.getRecv_area()) : order.getRecv_area() != null)
            return false;
        if (getRecv_address() != null ? !getRecv_address().equals(order.getRecv_address()) : order.getRecv_address() != null)
            return false;
        if (getTotal_price() != null ? !getTotal_price().equals(order.getTotal_price()) : order.getTotal_price() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(order.getStatus()) : order.getStatus() != null) return false;
        if (getOrder_time() != null ? !getOrder_time().equals(order.getOrder_time()) : order.getOrder_time() != null)
            return false;
        if (getPay_time() != null ? !getPay_time().equals(order.getPay_time()) : order.getPay_time() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getOid();
        result = 31 * result + getUid();
        result = 31 * result + (getRecv_name() != null ? getRecv_name().hashCode() : 0);
        result = 31 * result + (getRecv_phone() != null ? getRecv_phone().hashCode() : 0);
        result = 31 * result + (getRecv_province() != null ? getRecv_province().hashCode() : 0);
        result = 31 * result + (getRecv_city() != null ? getRecv_city().hashCode() : 0);
        result = 31 * result + (getRecv_area() != null ? getRecv_area().hashCode() : 0);
        result = 31 * result + (getRecv_address() != null ? getRecv_address().hashCode() : 0);
        result = 31 * result + (getTotal_price() != null ? getTotal_price().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getOrder_time() != null ? getOrder_time().hashCode() : 0);
        result = 31 * result + (getPay_time() != null ? getPay_time().hashCode() : 0);
        return result;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRecv_name() {
        return recv_name;
    }

    public void setRecv_name(String recv_name) {
        this.recv_name = recv_name;
    }

    public String getRecv_phone() {
        return recv_phone;
    }

    public void setRecv_phone(String recv_phone) {
        this.recv_phone = recv_phone;
    }

    public String getRecv_province() {
        return recv_province;
    }

    public void setRecv_province(String recv_province) {
        this.recv_province = recv_province;
    }

    public String getRecv_city() {
        return recv_city;
    }

    public void setRecv_city(String recv_city) {
        this.recv_city = recv_city;
    }

    public String getRecv_area() {
        return recv_area;
    }

    public void setRecv_area(String recv_area) {
        this.recv_area = recv_area;
    }

    public String getRecv_address() {
        return recv_address;
    }

    public void setRecv_address(String recv_address) {
        this.recv_address = recv_address;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Integer order_time) {
        this.order_time = order_time;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }
}
