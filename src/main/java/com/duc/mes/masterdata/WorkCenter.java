package com.duc.mes.masterdata;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="work_centers")
public class WorkCenter {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=60) private String code;
 @Column(nullable=false,length=180) private String name;
 @Column(length=120) private String area;
 @Column(name="capacity_per_hour",nullable=false,precision=12,scale=2) private BigDecimal capacityPerHour;
 @Column(nullable=false) private boolean active=true;
 protected WorkCenter(){}
 public WorkCenter(String code,String name,String area,BigDecimal capacity){this.code=code;this.name=name;this.area=area;this.capacityPerHour=capacity;}
 public Long getId(){return id;} public String getCode(){return code;} public String getName(){return name;}
 public String getArea(){return area;} public BigDecimal getCapacityPerHour(){return capacityPerHour;} public boolean isActive(){return active;}
}
