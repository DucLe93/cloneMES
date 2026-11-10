package com.duc.mes.masterdata;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=60) private String code;
 @Column(nullable=false,length=180) private String name;
 @Column(length=500) private String description;
 @Column(nullable=false,length=20) private String unit;
 @Column(nullable=false) private boolean active=true;
 @Column(name="created_at",insertable=false,updatable=false) private LocalDateTime createdAt;
 protected Product(){}
 public Product(String code,String name,String description,String unit){this.code=code;this.name=name;this.description=description;this.unit=unit;}
 public Long getId(){return id;} public String getCode(){return code;} public String getName(){return name;}
 public String getDescription(){return description;} public String getUnit(){return unit;} public boolean isActive(){return active;}
}
