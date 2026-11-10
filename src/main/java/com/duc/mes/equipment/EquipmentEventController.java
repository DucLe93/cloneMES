package com.duc.mes.equipment;
import com.duc.mes.masterdata.WorkCenterRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@RestController @RequestMapping("/api/v1/equipment-events")
public class EquipmentEventController {
 private final EquipmentEventRepository events;private final WorkCenterRepository centers;
 public EquipmentEventController(EquipmentEventRepository e,WorkCenterRepository c){events=e;centers=c;}
 public record Request(@NotNull Long workCenterId,@NotNull EquipmentEvent.Type eventType,String reason,@NotNull LocalDateTime startedAt,@NotBlank String recordedBy){}
 public record Response(Long id,Long workCenterId,String type,String reason,LocalDateTime startedAt,LocalDateTime endedAt,long durationMinutes){
  static Response from(EquipmentEvent e){return new Response(e.getId(),e.getWorkCenterId(),e.getEventType().name(),e.getReason(),e.getStartedAt(),e.getEndedAt(),e.getDurationMinutes());}
 }
 @GetMapping public List<Response> list(@RequestParam(required=false) Long workCenterId){return (workCenterId==null?events.findAll():events.findByWorkCenterId(workCenterId)).stream().map(Response::from).toList();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Response create(@Valid @RequestBody Request r){
  if(!centers.existsById(r.workCenterId()))throw new IllegalArgumentException("Work center not found");
  return Response.from(events.save(new EquipmentEvent(r.workCenterId(),r.eventType(),r.reason(),r.startedAt(),r.recordedBy())));
 }
 @PostMapping("/{id}/close") public Response close(@PathVariable Long id,@RequestParam LocalDateTime endedAt){
  var e=events.findById(id).orElseThrow(()->new IllegalArgumentException("Event not found"));e.close(endedAt);return Response.from(events.save(e));
 }
}
