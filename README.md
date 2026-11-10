# CloneMES — Manufacturing Execution System
Backend MES starter using Java 17, Spring Boot 3.4, Spring Data JPA and PostgreSQL.

## MVP modules
- Master data: products / SKUs and work centers / production lines.
- Production: create, schedule and release production orders; report output and update order progress.
- Quality: incoming, in-process and final inspection records with PASS / FAIL / CONDITIONAL outcomes.
- Equipment: downtime, maintenance, changeover and running events.
- Dashboard: order status, total / good / defect output, first-pass-yield indicator and failed inspection count.
- Traceability foundation: material-lot database table for upcoming genealogy workflows.

## Architecture and patterns
A modular monolith keeps deployment and transactions simple while separating capabilities into masterdata, production, quality, equipment and dashboard packages.
- Layered architecture: REST API, domain model, Spring Data repository, PostgreSQL.
- Repository pattern through Spring Data interfaces.
- Aggregate/domain methods protect production-order state transitions and equipment-event closure.
- DTO records isolate API contracts from persistence entities.
- Flyway migrations version the schema.
- RestControllerAdvice centralizes API error responses.

## Domain model
Product, WorkCenter, ProductionOrder, ProductionReport, QualityInspection and EquipmentEvent. The material_lots table is prepared for material genealogy.

## Run locally
Requirements: JDK 17, Maven 3.9+, Docker Compose.
```bash
docker compose up -d
mvn spring-boot:run
```
API: http://localhost:8080
Health: http://localhost:8080/actuator/health

Environment overrides: DB_URL, DB_USERNAME, DB_PASSWORD, SERVER_PORT.

## API examples
Create product:
```http
POST /api/v1/products
Content-Type: application/json
{"code":"PCB-001","name":"Main PCB","description":"Controller board","unit":"PCS"}
```
Create work center:
```http
POST /api/v1/work-centers
{"code":"SMT-01","name":"SMT Line 1","area":"SMT","capacityPerHour":1200}
```
Create and release order:
```http
POST /api/v1/production-orders
{"orderNo":"MO-2026-0001","productId":1,"plannedQuantity":1000}
POST /api/v1/production-orders/1/release
```
Report production:
```http
POST /api/v1/production-reports
{"orderId":1,"workCenterId":1,"quantity":100,"goodQuantity":98,"defectQuantity":2,"reportedBy":"operator-01"}
```

## Endpoints
- GET/POST /api/v1/products; GET /api/v1/products/{id}
- GET/POST /api/v1/work-centers
- GET/POST /api/v1/production-orders; POST /api/v1/production-orders/{id}/release
- GET/POST /api/v1/production-reports (optional orderId filter)
- GET/POST /api/v1/quality-inspections (optional orderId filter)
- GET/POST /api/v1/equipment-events (optional workCenterId filter); POST /api/v1/equipment-events/{id}/close?endedAt=2026-11-10T10:30:00
- GET /api/v1/dashboard/summary

## Roadmap
1. BOM, routing, operations and WIP dispatch.
2. Material issue/consumption, genealogy and finished-goods lot creation.
3. Authentication, RBAC, operator shifts and audit trail.
4. Shift calendars and full OEE (availability x performance x quality).
5. SPC, non-conformance, CAPA and defect Pareto.
6. PLC / OPC-UA, ERP and barcode-scanner integration.
7. Unit, integration and API contract tests.

Initial foundation only: security, full material genealogy, advanced scheduling, OEE time model and shop-floor device integration require further implementation and validation.
