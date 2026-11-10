package com.duc.mes.production;
import com.duc.mes.masterdata.ProductRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@RestController @RequestMapping("/api/v1/production-orders")
public class ProductionOrderController {
 private final ProductionOrderRepository orders;private final ProductRepository products;
 public ProductionOrderController(ProductionOrderRepository o,ProductRepository p){orders=o;products=p;}
 public record CreateRequest(@NotBlank String orderNo,@NotNull Long productId,@NotNull @DecimalMin("0.001") BigDecimal plannedQuantity,LocalDateTime plannedStart,LocalDateTime plannedEnd){}
 public record Response(Long id,String orderNo,Long productId,BigDecimal plannedQuantity,BigDecimal producedQuantity,String status,LocalDateTime plannedStart,LocalDateTime plannedEnd){
  static Response from(ProductionOrder o){return new Response(o.getId(),o.getOrderNo(),o.getProductId(),o.getPlannedQuantity(),o.getProducedQuantity(),o.getStatus().name(),o.getPlannedStart(),o.getPlannedEnd());}
 }
 @GetMapping public List<Response> list(){return orders.findAll().stream().map(Response::from).toList();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Response create(@Valid @RequestBody CreateRequest r){
  if(orders.existsByOrderNo(r.orderNo()))throw new IllegalArgumentException("Order number already exists");
  if(!products.existsById(r.productId()))throw new IllegalArgumentException("Product not found");
  if(r.plannedStart()!=null&&r.plannedEnd()!=null&&r.plannedEnd().isBefore(r.plannedStart()))throw new IllegalArgumentException("Planned end must follow start");
  return Response.from(orders.save(new ProductionOrder(r.orderNo(),r.productId(),r.plannedQuantity(),r.plannedStart(),r.plannedEnd())));
 }
 @PostMapping("/{id}/release") public Response release(@PathVariable Long id){
  var o=orders.findById(id).orElseThrow(()->new IllegalArgumentException("Order not found"));o.release();return Response.from(orders.save(o));
 }
}
