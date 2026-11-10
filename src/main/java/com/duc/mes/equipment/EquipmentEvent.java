package com.duc.mes.equipment;
import jakarta.persistence.*;
import java.time.*;
@Entity @Table(name="equipment_events")
public class EquipmentEvent {
 public enum Type{DOWNTIME,MAINTENANCE,CHANGEOVER,RUNNING}
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="work_center_id",nullable=false) private Long workCenterId;
 @Enumerated(EnumType.STRING) @Column(name="event_type",nullable=false,length=24) private Type eventType;
 @Column(length=300) private String reason; @Column(name="started_at",nullable=false) private LocalDateTime startedAt;
 @Column(name="ended_at") private LocalDateTime endedAt; @Column(name="recorded_by",nullable=false,length=100) private String recordedBy;
 protected EquipmentEvent(){}
 public EquipmentEvent(Long wc,Type type,String reason,LocalDateTime start,String by){workCenterId=wc;eventType=type;this.reason=reason;startedAt=start;recordedBy=by;}
 public void close(LocalDateTime end){if(endedAt!=null)throw new IllegalStateException("Event already closed");if(end.isBefore(startedAt))throw new IllegalArgumentException("End before start");endedAt=end;}
 public Long getId(){return id;} public Long getWorkCenterId(){return workCenterId;} public Type getEventType(){return eventType;} public String getReason(){return reason;}
 public LocalDateTime getStartedAt(){return startedAt;} public LocalDateTime getEndedAt(){return endedAt;} public long getDurationMinutes(){return endedAt==null?0:Duration.between(startedAt,endedAt).toMinutes();}
}
