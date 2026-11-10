package com.duc.mes.production;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="production_reports")
public class ProductionReport {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="order_id",nullable=false) private Long orderId;
 @Column(name="work_center_id",nullable=false) private Long workCenterId;
 @Column(nullable=false,precision=14,scale=3) private BigDecimal quantity;
 @Column(name="good_quantity",nullable=false,precision=14,scale=3) private BigDecimal goodQuantity;
 @Column(name="defect_quantity",nullable=false,precision=14,scale=3) private BigDecimal defectQuantity;
 @Column(name="reported_by",nullable=false,length=100) private String reportedBy;
 protected ProductionReport(){}
 public ProductionReport(Long o,Long w,BigDecimal q,BigDecimal g,BigDecimal d,String by){orderId=o;workCenterId=w;quantity=q;goodQuantity=g;defectQuantity=d;reportedBy=by;}
 public Long getId(){return id;} public Long getOrderId(){return orderId;} public Long getWorkCenterId(){return workCenterId;}
 public BigDecimal getQuantity(){return quantity;} public BigDecimal getGoodQuantity(){return goodQuantity;} public BigDecimal getDefectQuantity(){return defectQuantity;} public String getReportedBy(){return reportedBy;}
}
