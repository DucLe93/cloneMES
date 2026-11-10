package com.duc.mes.production;
import com.duc.mes.masterdata.WorkCenterRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequestMapping("/api/v1/production-reports")
public class ProductionReportController {
 private final ProductionReportRepository reports;private final ProductionOrderRepository orders;private final WorkCenterRepository centers;
 public ProductionReportController(ProductionReportRepository r,ProductionOrderRepository o,WorkCenterRepository c){reports=r;orders=o;centers=c;}
 public record Request(@NotNull Long orderId,@NotNull Long workCenterId,@NotNull @DecimalMin("0.001") BigDecimal quantity,@NotNull @DecimalMin("0.0") BigDecimal goodQuantity,@NotNull @DecimalMin("0.0") BigDecimal defectQuantity,@NotBlank String reportedBy){}
 public record Response(Long id,Long orderId,Long workCenterId,BigDecimal quantity,BigDecimal goodQuantity,BigDecimal defectQuantity,String reportedBy){
  static Response from(ProductionReport p){return new Response(p.getId(),p.getOrderId(),p.getWorkCenterId(),p.getQuantity(),p.getGoodQuantity(),p.getDefectQuantity(),p.getReportedBy());}
 }
 @GetMapping public List<Response> list(@RequestParam(required=false) Long orderId){return (orderId==null?reports.findAll():reports.findByOrderId(orderId)).stream().map(Response::from).toList();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Transactional public Response create(@Valid @RequestBody Request r){
  if(r.goodQuantity().add(r.defectQuantity()).compareTo(r.quantity())!=0)throw new IllegalArgumentException("Good + defect must equal total");
  if(!centers.existsById(r.workCenterId()))throw new IllegalArgumentException("Work center not found");
  var o=orders.findById(r.orderId()).orElseThrow(()->new IllegalArgumentException("Order not found"));o.report(r.quantity());orders.save(o);
  return Response.from(reports.save(new ProductionReport(r.orderId(),r.workCenterId(),r.quantity(),r.goodQuantity(),r.defectQuantity(),r.reportedBy())));
 }
}
