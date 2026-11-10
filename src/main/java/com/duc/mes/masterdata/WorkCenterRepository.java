package com.duc.mes.masterdata;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WorkCenterRepository extends JpaRepository<WorkCenter,Long>{boolean existsByCode(String code);}
