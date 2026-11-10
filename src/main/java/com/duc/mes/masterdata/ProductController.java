package com.duc.mes.masterdata;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/products")
public class ProductController {
 private final ProductRepository repository;
 public ProductController(ProductRepository repository){this.repository=repository;}
 public record Request(@NotBlank @Size(max=60) String code,@NotBlank @Size(max=180) String name,@Size(max=500) String description,@NotBlank @Size(max=20) String unit){}
 public record Response(Long id,String code,String name,String description,String unit,boolean active){
  static Response from(Product p){return new Response(p.getId(),p.getCode(),p.getName(),p.getDescription(),p.getUnit(),p.isActive());}
 }
 @GetMapping public List<Response> list(){return repository.findAll().stream().map(Response::from).toList();}
 @GetMapping("/{id}") public Response get(@PathVariable Long id){return Response.from(find(id));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Response create(@Valid @RequestBody Request r){
  if(repository.existsByCode(r.code()))throw new IllegalArgumentException("Product code already exists");
  return Response.from(repository.save(new Product(r.code(),r.name(),r.description(),r.unit())));
 }
 private Product find(Long id){return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Product not found: "+id));}
}
