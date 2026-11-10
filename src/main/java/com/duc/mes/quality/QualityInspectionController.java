package com.duc.mes.quality;
import com.duc.mes.production.ProductionOrderRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/quality-inspections")
public class QualityInspectionController {
 private final QualityInspectionRepository repo;private final ProductionOrderRepository orders;
 public QualityInspectionController(QualityInspectionRepository r,ProductionOrderRepository o){repo=r;orders=o;}
 public record Request(Long orderId,Long lotId,@NotNull QualityInspection.Type inspectionType,@NotNull QualityInspection.Result result,String defectCode,String notes,@NotBlank String inspectedBy){}
 public record Response(Long id,Long orderId,Long lotId,String type,String result,String defectCode,String notes,String inspectedBy){
  static Response from(QualityInspection q){return new Response(q.getId(),q.getOrderId(),q.getLotId(),q.getInspectionType().name(),q.getResult().name(),q.getDefectCode(),q.getNotes(),q.getInspectedBy());}
 }
 @GetMapping public List<Response> list(@RequestParam(required=false) Long orderId){return (orderId==null?repo.findAll():repo.findByOrderId(orderId)).stream().map(Response::from).toList();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Response create(@Valid @RequestBody Request r){
  if(r.orderId()==null&&r.lotId()==null)throw new IllegalArgumentException("Inspection must reference an order or lot");
  if(r.orderId()!=null&&!orders.existsById(r.orderId()))throw new IllegalArgumentException("Order not found");
  return Response.from(repo.save(new QualityInspection(r.orderId(),r.lotId(),r.inspectionType(),r.result(),r.defectCode(),r.notes(),r.inspectedBy())));
 }
}
