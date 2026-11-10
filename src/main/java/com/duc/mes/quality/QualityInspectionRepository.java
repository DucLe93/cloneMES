package com.duc.mes.quality;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface QualityInspectionRepository extends JpaRepository<QualityInspection,Long>{List<QualityInspection> findByOrderId(Long id);long countByResult(QualityInspection.Result result);}
