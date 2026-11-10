package com.duc.mes.masterdata;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequestMapping("/api/v1/work-centers")
public class WorkCenterController {
 private final WorkCenterRepository repository;
 public WorkCenterController(WorkCenterRepository repository){this.repository=repository;}
 public record Request(@NotBlank String code,@NotBlank String name,String area,@NotNull @DecimalMin("0.0") BigDecimal capacityPerHour){}
 public record Response(Long id,String code,String name,String area,BigDecimal capacityPerHour,boolean active){
  static Response from(WorkCenter w){return new Response(w.getId(),w.getCode(),w.getName(),w.getArea(),w.getCapacityPerHour(),w.isActive());}
 }
 @GetMapping public List<Response> list(){return repository.findAll().stream().map(Response::from).toList();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Response create(@Valid @RequestBody Request r){
  if(repository.existsByCode(r.code()))throw new IllegalArgumentException("Work center code already exists");
  return Response.from(repository.save(new WorkCenter(r.code(),r.name(),r.area(),r.capacityPerHour())));
 }
}
