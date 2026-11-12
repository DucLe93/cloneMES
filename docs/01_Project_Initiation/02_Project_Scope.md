# Project Scope – SmartMES

| Field | Value |
|---|---|
| Document ID | PRJ-002 |
| Version | 0.1 |
| Status | Draft – pending validation |
| Related document | [Project Charter](01_Project_Charter.md) |
| Owner | TBD |
| Created / updated | 2026-11-12 |

## 1. Purpose

Xác định ranh giới chức năng và kỹ thuật của SmartMES, làm cơ sở quản lý yêu cầu, ước lượng, thiết kế, phát triển và nghiệm thu.

## 2. Scope statement

SmartMES hướng tới một MES backend hỗ trợ quản lý dữ liệu nền, thực thi sản xuất, ghi nhận chất lượng, theo dõi sự kiện thiết bị, dashboard và nền tảng truy xuất nguồn gốc.

Đây là phạm vi định hướng. Phạm vi MVP chính thức chỉ được baseline sau khi hoàn thành khảo sát nghiệp vụ và được người có thẩm quyền xác nhận.

## 3. Functional scope

| Module | Capability | Initial scope | Priority | Status |
|---|---|---|---|---|
| Master Data | Product / SKU | Quản lý mã, tên, đơn vị và thuộc tính sản phẩm | Must | Existing foundation; validate gaps |
| Master Data | Work Center / Line | Quản lý khu vực, line, work center và năng lực cơ bản | Must | Existing foundation; validate gaps |
| Production | Production Order | Tạo, xem, release và quản lý trạng thái lệnh | Must | Existing foundation; validate lifecycle |
| Production | Production Reporting | Ghi nhận sản lượng tốt/lỗi theo lệnh và work center | Must | Existing foundation; validate rules |
| Production | Routing / Operation | Khai báo routing, công đoạn, thứ tự và điều kiện chuyển công đoạn | Should | Roadmap / to be specified |
| Production | WIP Dispatch | Theo dõi WIP và điều phối theo công đoạn | Should | To be specified |
| Material | BOM | Khai báo cấu trúc nguyên vật liệu theo sản phẩm | Should | Roadmap / to be specified |
| Material | Material Lot | Quản lý lô vật liệu, nhập/xuất/cấp phát/tiêu thụ | Should | Foundation only; workflows TBD |
| Quality | Inspection | Incoming, In-process, Final inspection | Must | Existing foundation; validate rules |
| Quality | Defect / NCR | Ghi nhận lỗi, phân loại và xử lý không phù hợp | Should | To be specified |
| Equipment | Equipment Events | Downtime, maintenance, changeover, running events | Should | Existing foundation; validate lifecycle |
| Dashboard | Production Summary | Trạng thái lệnh, sản lượng, good/defect output | Must | Existing foundation; validate formulas |
| Traceability | Genealogy | Liên kết serial/lot với vật liệu, công đoạn và kết quả | Should | Foundation / roadmap |
| Security | Authentication / RBAC | Đăng nhập, role, permission, audit trail | Must before production use | Roadmap |
| Integration | ERP / WMS / PLC | Trao đổi dữ liệu với hệ thống/máy bên ngoài | Could / later phase | Not in initial MVP |

Priority legend: Must = bắt buộc cho MVP đề xuất; Should = quan trọng nhưng có thể chia phase; Could = cân nhắc sau. Đây là đề xuất, chưa được phê duyệt.

## 4. Process boundaries

### Proposed high-level production flow

1. Khai báo Product, BOM, Routing và Work Center.
2. Nhận hoặc tạo Production Order.
3. Kiểm tra điều kiện và Release lệnh.
4. Chuẩn bị/cấp phát vật liệu.
5. Dispatch WIP tới công đoạn.
6. Operator thực hiện và ghi nhận sản lượng.
7. Ghi nhận kiểm tra chất lượng, lỗi và rework nếu có.
8. Ghi nhận tiêu thụ vật liệu và liên kết genealogy.
9. Hoàn tất lệnh và đối soát sản lượng.
10. Dashboard và báo cáo.

**TBD:** Luồng trên chỉ là process hypothesis. Cần xác nhận trình tự, vai trò, điều kiện và ngoại lệ với Stakeholder nhà máy.

## 5. User groups – proposed

- System Administrator
- Production Planner
- Production Supervisor
- Line Leader
- Production Operator
- Material Controller / Warehouse Operator
- Quality Engineer / Quality Inspector
- Maintenance Engineer
- Management / Viewer
- ERP / External System (system actor)

Danh sách vai trò và quyền thực tế sẽ được xác định qua Stakeholder Analysis và RBAC requirements.

## 6. Data scope – initial entities

Các entity đang được README repository đề cập: Product, WorkCenter, ProductionOrder, ProductionReport, QualityInspection, EquipmentEvent và MaterialLot (foundation).

Các entity có thể cần phân tích thêm:

- Plant, ProductionLine, Area, Shift, WorkCalendar
- ProductRevision, BOM, BOMLine
- Routing, Operation, OperationResource
- WorkOrder, WIP, SerialNumber, Lot
- Material, MaterialLot, MaterialIssue, MaterialConsumption
- DefectCode, Nonconformance, Rework
- InspectionPlan, InspectionCharacteristic
- User, Role, Permission, AuditLog

Không tạo toàn bộ bảng chỉ vì có tên trong danh sách. Mỗi entity cần được chứng minh bằng yêu cầu nghiệp vụ và quy tắc dữ liệu.

## 7. Technical scope

### Included in proposed backend baseline

- Java 17 and Spring Boot.
- REST API with DTO validation.
- PostgreSQL and Spring Data JPA.
- Flyway database migrations.
- Layered modular monolith.
- Centralized exception handling.
- Logging and configuration by environment.
- Unit, integration and API tests.
- API documentation (OpenAPI).

### To be decided / later

- Frontend framework and UI.
- Authentication provider and RBAC model.
- Message broker / event streaming.
- PLC protocols such as OPC UA.
- ERP/WMS connector strategy.
- Deployment target, CI/CD, monitoring and backup strategy.

## 8. Explicit exclusions for initial MVP proposal

- Direct machine control and safety-critical control logic.
- Real-time industrial control guarantees.
- Full APS / advanced production optimization.
- Full ERP, WMS or QMS replacement.
- Payroll, HR and accounting.
- Predictive maintenance using ML.
- Production-grade multi-tenant SaaS.
- Live integration with a real customer factory before interface and security assessment.

## 9. Dependencies

- Business process definitions and sample scenarios.
- Product, BOM, routing and work center sample data.
- Defined serial/lot identification policy.
- Agreed production and quality KPIs.
- API/interface details from ERP, WMS or equipment vendors if integration is approved.
- Development/test environments and access controls.

## 10. Acceptance boundaries

Một capability chỉ được xem là in-scope and accepted khi:

- Có requirement ID và mô tả rõ.
- Có business rules và acceptance criteria.
- Có thiết kế/API/database traceable.
- Có test cases và kết quả test.
- Có xác nhận của người chịu trách nhiệm nghiệp vụ đối với UAT khi áp dụng.

## 11. Scope change control

Mọi đề xuất thay đổi phải ghi nhận:

- Change ID, requester, date.
- Business reason and expected value.
- Affected modules, requirements and documents.
- Impact on cost, effort, schedule, architecture, security and testing.
- Decision: Approved / Rejected / Deferred.
- Approver and decision date.

Không tự ý mở rộng scope chỉ vì thay đổi có thể triển khai về mặt kỹ thuật.

## 12. Open questions

- Chọn SMT + Assembly làm MVP hay một quy trình khác?
- Có quản lý Serial Number ở từng công đoạn không?
- Có cho phép split/merge Production Order hoặc lot không?
- Quy tắc rework, scrap, hold và release là gì?
- Vật liệu được cấp phát theo BOM, feeder setup hay thực tế tiêu thụ?
- Dashboard cần các KPI nào và công thức tính ra sao?
- Security/RBAC cần ở mức nào trong MVP?
- Tích hợp hệ thống ngoài là mô phỏng hay có endpoint thực tế?

## 13. Change history

| Version | Date | Description |
|---|---|---|
| 0.1 | 2026-11-12 | Initial scope proposal; pending business validation |
