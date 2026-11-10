package com.duc.mes.equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EquipmentEventRepository extends JpaRepository<EquipmentEvent,Long>{List<EquipmentEvent> findByWorkCenterId(Long id);}
