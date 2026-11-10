package com.duc.mes.common;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(IllegalArgumentException.class)
 ResponseEntity<?> badRequest(IllegalArgumentException ex) {
  return ResponseEntity.badRequest().body(Map.of("timestamp",Instant.now(),"status",400,"error",ex.getMessage()));
 }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 ResponseEntity<?> validation(MethodArgumentNotValidException ex) {
  var errors=ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(e->e.getField(),e->e.getDefaultMessage(),(a,b)->a));
  return ResponseEntity.badRequest().body(Map.of("timestamp",Instant.now(),"status",400,"errors",errors));
 }
 @ExceptionHandler(DataIntegrityViolationException.class)
 ResponseEntity<?> conflict(DataIntegrityViolationException ex) {
  return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("timestamp",Instant.now(),"status",409,"error","Resource conflicts with existing data"));
 }
}
