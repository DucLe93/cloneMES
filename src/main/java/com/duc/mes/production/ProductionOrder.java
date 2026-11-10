package com.duc.mes.production;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity @Table(name="production_orders")
public class ProductionOrder {
 public enum Status{PLANNED,RELEASED,IN_PROGRESS,COMPLETED,CANCELLED}
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="order_no",nullable=false,unique=true,length=60) private String orderNo;
 @Column(name="product_id",nullable=false) private Long productId;
 @Column(name="planned_quantity",nullable=false,precision=14,scale=3) private BigDecimal plannedQuantity;
 @Column(name="produced_quantity",nullable=false,precision=14,scale=3) private BigDecimal producedQuantity=BigDecimal.ZERO;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=24) private Status status=Status.PLANNED;
 @Column(name="planned_start") private LocalDateTime plannedStart;
 @Column(name="planned_end") private LocalDateTime plannedEnd;
 protected ProductionOrder(){}
 public ProductionOrder(String no,Long productId,BigDecimal qty,LocalDateTime start,LocalDateTime end){orderNo=no;this.productId=productId;plannedQuantity=qty;plannedStart=start;plannedEnd=end;}
 public void release(){if(status!=Status.PLANNED)throw new IllegalStateException("Only planned orders can be released");status=Status.RELEASED;}
 public void report(BigDecimal qty){if(status!=Status.RELEASED&&status!=Status.IN_PROGRESS)throw new IllegalStateException("Order is not released");if(qty.signum()<=0)throw new IllegalArgumentException("Quantity must be positive");producedQuantity=producedQuantity.add(qty);status=producedQuantity.compareTo(plannedQuantity)>=0?Status.COMPLETED:Status.IN_PROGRESS;}
 public Long getId(){return id;} public String getOrderNo(){return orderNo;} public Long getProductId(){return productId;}
 public BigDecimal getPlannedQuantity(){return plannedQuantity;} public BigDecimal getProducedQuantity(){return producedQuantity;} public Status getStatus(){return status;}
 public LocalDateTime getPlannedStart(){return plannedStart;} public LocalDateTime getPlannedEnd(){return plannedEnd;}
}
