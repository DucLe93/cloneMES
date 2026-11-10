package com.duc.mes.quality;
import jakarta.persistence.*;
@Entity @Table(name="quality_inspections")
public class QualityInspection {
 public enum Result{PASS,FAIL,CONDITIONAL} public enum Type{INCOMING,IN_PROCESS,FINAL}
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="order_id") private Long orderId; @Column(name="lot_id") private Long lotId;
 @Enumerated(EnumType.STRING) @Column(name="inspection_type",nullable=false,length=30) private Type inspectionType;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
 @Column(name="defect_code",length=60) private String defectCode; @Column(length=1000) private String notes;
 @Column(name="inspected_by",nullable=false,length=100) private String inspectedBy;
 protected QualityInspection(){}
 public QualityInspection(Long o,Long l,Type t,Result r,String code,String notes,String by){orderId=o;lotId=l;inspectionType=t;result=r;defectCode=code;this.notes=notes;inspectedBy=by;}
 public Long getId(){return id;} public Long getOrderId(){return orderId;} public Long getLotId(){return lotId;} public Type getInspectionType(){return inspectionType;} public Result getResult(){return result;}
 public String getDefectCode(){return defectCode;} public String getNotes(){return notes;} public String getInspectedBy(){return inspectedBy;}
}
