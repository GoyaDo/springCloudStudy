package com.elevengeek.goya.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author cj
 * @create 2020-02-04-17:19
 *
 * 这里需要注意的是采用的单向一对多关联，
 * 所以在订单明细表中是有个外键order_id进行关联的，
 * 这个字段在数据库中不要设置成不能为空，
 * 不然jpa保存时会报错提示order_id不能为空。
 *
 * @OneToMany(targetEntity = COrderDetailEntity.class,cascade = CascadeType.ALL)
 * 一对多关联，targetEntity表示子类也就是多数据的那一方，可以不用写，默认就是注解下面的订单明细类，
 * 后面 CascadeType 级联操作，这里选择所有操作
 *
 * @JoinColumn(name=”order_id”)
 * 关联的外键字段，也就是订单明细表中order_id，这个字段不能设置为不为空，不然无法正常保存，
 * jpa应该是先保存两个表的数据，然后根据关联关系在单独修改子明细的order_id列
 *
 */
@Entity
@Table(name = "c_order", schema = "cloud_order", catalog = "")
@EntityListeners(AuditingEntityListener.class)
public class COrderEntity {
    private String id;
    private String orderNo;
    private String orderStatus="0";
    private Timestamp finishDate;
    private Timestamp deleteDate;
    private Timestamp createDate;
    private String createBy="sys";
    private Timestamp updateDate;
    private String updateBy="sys";
    private double amount;
    private List<COrderDetailEntity> cOrderDetailEntityList;
    @Id
    @Column(name = "id", nullable = false, length = 32)
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Basic
    @Column(name = "order_no", nullable = false, length = 50)
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    @Basic
    @Column(name = "order_status", nullable = false, length = 1)
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Basic
    @Column(name = "finish_date", nullable = false)
    public Timestamp getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }
    @Basic
    @Column(name = "delete_date", nullable = true)
    public Timestamp getDeleteDate() {
        return deleteDate;
    }
    public void setDeleteDate(Timestamp deleteDate) {
        this.deleteDate = deleteDate;
    }
    @Basic
    @Column(name = "create_date", nullable = false)
    @CreatedDate
    public Timestamp getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    @Basic
    @Column(name = "create_by", nullable = false, length = 32)
    public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    @Basic
    @Column(name = "update_date", nullable = false)
    @LastModifiedDate
    public Timestamp getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
    @Basic
    @Column(name = "update_by", nullable = false, length = 32)
    public String getUpdateBy() {
        return updateBy;
    }
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @OneToMany(targetEntity = COrderDetailEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    public List<COrderDetailEntity> getcOrderDetailEntityList() {
        return cOrderDetailEntityList;
    }
    public void setcOrderDetailEntityList(List<COrderDetailEntity> cOrderDetailEntityList) {
        this.cOrderDetailEntityList = cOrderDetailEntityList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        COrderEntity that = (COrderEntity) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(orderNo, that.orderNo) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(finishDate, that.finishDate) &&
                Objects.equals(deleteDate, that.deleteDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updateBy, that.updateBy);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, orderNo, orderStatus, finishDate, deleteDate, createDate, createBy, updateDate, updateBy, amount);
    }
}