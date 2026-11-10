package com.duc.mes.dashboard;
import com.duc.mes.production.*;
import com.duc.mes.quality.*;
import org.springframework.web.bind.annotation.*;
import java.math.*;
import java.util.Map;
@RestController @RequestMapping("/api/v1/dashboard")
public class DashboardController {
 private final ProductionOrderRepository orders;private final ProductionReportRepository reports;private final QualityInspectionRepository quality;
 public DashboardController(ProductionOrderRepository o,ProductionReportRepository r,QualityInspectionRepository q){orders=o;reports=r;quality=q;}
 @GetMapping("/summary") public Map<String,Object> summary(){
  var all=reports.findAll();
  BigDecimal total=all.stream().map(ProductionReport::getQuantity).reduce(BigDecimal.ZERO,BigDecimal::add);
  BigDecimal good=all.stream().map(ProductionReport::getGoodQuantity).reduce(BigDecimal.ZERO,BigDecimal::add);
  BigDecimal defect=all.stream().map(ProductionReport::getDefectQuantity).reduce(BigDecimal.ZERO,BigDecimal::add);
  BigDecimal yield=total.signum()==0?BigDecimal.ZERO:good.multiply(BigDecimal.valueOf(100)).divide(total,2,RoundingMode.HALF_UP);
  return Map.of("productionOrders",orders.count(),"plannedOrders",orders.countByStatus(ProductionOrder.Status.PLANNED),
   "inProgressOrders",orders.countByStatus(ProductionOrder.Status.IN_PROGRESS),"completedOrders",orders.countByStatus(ProductionOrder.Status.COMPLETED),
   "reportedQuantity",total,"goodQuantity",good,"defectQuantity",defect,"firstPassYieldPercent",yield,
   "failedInspections",quality.countByResult(QualityInspection.Result.FAIL));
 }
}
