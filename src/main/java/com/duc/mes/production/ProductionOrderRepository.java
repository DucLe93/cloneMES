package com.duc.mes.production;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductionOrderRepository extends JpaRepository<ProductionOrder,Long>{
 boolean existsByOrderNo(String orderNo); long countByStatus(ProductionOrder.Status status);
}
