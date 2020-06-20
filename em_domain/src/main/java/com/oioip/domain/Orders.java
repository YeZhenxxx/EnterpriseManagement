package com.oioip.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 *
 * 会员实体类
 */
public class Orders {
    private String id;  //主键 无意义
    private String orderNum;  //订单编号
    private Date orderTime;  //下单时间
    private Member member;  //订单联系人信息
    private List<Traveller> travellers;// 订单游客信息
    private String orderTimeStr;
    private Integer peopleCount;  //出行人数
    private String orderDesc;   //订单描述(其他信息)
    private Integer payType;  //支付方式(0支付宝 1微信 2其他)
    private String payTypeStr;
    private Product product;
    private Integer orderStatus;  //订单状态(0未支付  1已支付)
    private String orderStatusStr;
    private String productId; //产品ID外键
    private String memberid;  //会员(联系人)ID 外键


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public String getOrderTimeStr() {
        if (orderTime!=null){
            SimpleDateFormat sf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            orderTimeStr=sf.format(orderTime);
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType!=null){
            switch (payType){
                case 0:
                    payTypeStr="支付宝";
                    break;
                case 1:
                    payTypeStr="微信";
                    break;
                default:
                    payTypeStr="其他";
                    break;
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if (orderStatus!=null){
            if (orderStatus==0){
                orderStatusStr="未支付";
            }else if (orderStatus==1){
                orderStatusStr="已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", member=" + member +
                ", travellers=" + travellers +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", product=" + product +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", productId='" + productId + '\'' +
                ", memberid='" + memberid + '\'' +
                '}';
    }
}
