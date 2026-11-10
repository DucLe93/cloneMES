package com.duc.mes.production;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductionReportRepository extends JpaRepository<ProductionReport,Long>{List<ProductionReport> findByOrderId(Long orderId);}
