# Project Charter – SmartMES

| Field | Value |
|---|---|
| Document ID | PRJ-001 |
| Version | 0.1 |
| Status | Draft – pending validation |
| Project name | SmartMES |
| Repository | [DucLe93/cloneMES](https://github.com/DucLe93/cloneMES) |
| Project owner / Sponsor | TBD |
| Project manager | TBD |
| Business owner | TBD |
| Prepared by | Project team (learning / portfolio project) |
| Created date | 2026-11-12 |
| Last updated | 2026-11-12 |

## 1. Executive summary

SmartMES là dự án xây dựng một hệ thống Manufacturing Execution System (MES) nhằm hỗ trợ quản lý và giám sát việc thực thi sản xuất tại nhà máy. Dự án được triển khai theo quy trình phát triển phần mềm đầy đủ (SDLC), từ khởi tạo, khảo sát nghiệp vụ, đặc tả yêu cầu, thiết kế, phát triển, kiểm thử đến triển khai và vận hành.

Repository hiện có nền tảng backend sử dụng Java 17, Spring Boot 3.4, Spring Data JPA và PostgreSQL. README hiện mô tả định hướng modular monolith và các module master data, production, quality, equipment, dashboard cùng nền tảng traceability. Đây là baseline kỹ thuật hiện có, không đồng nghĩa mọi chức năng đã hoàn thiện hoặc đã được người dùng nghiệp vụ xác nhận.

## 2. Business problem and opportunity

### 2.1 Problem statement

**TBD – cần khảo sát.** Dự án giả định nhà máy cần tăng khả năng kiểm soát hoạt động sản xuất, theo dõi tiến độ lệnh sản xuất, ghi nhận sản lượng, quản lý chất lượng, giám sát thiết bị và truy xuất lịch sử sản phẩm.

Không xem các vấn đề trên là hiện trạng đã được xác minh tại một nhà máy cụ thể.

### 2.2 Opportunity

- Chuẩn hóa dữ liệu và quy trình thực thi sản xuất.
- Tăng khả năng quan sát trạng thái lệnh sản xuất và WIP.
- Liên kết thông tin sản xuất, chất lượng, nguyên vật liệu và thiết bị.
- Tạo nền tảng truy xuất nguồn gốc (traceability).
- Cung cấp dữ liệu phục vụ phân tích hiệu suất sản xuất.

## 3. Project objectives

Các mục tiêu dưới đây là mục tiêu định hướng; chỉ tiêu đo lường cụ thể sẽ được xác định sau khi có baseline và yêu cầu nghiệp vụ.

| ID | Objective | Measurement / acceptance evidence |
|---|---|---|
| OBJ-01 | Quản lý dữ liệu nền phục vụ sản xuất | CRUD, validation và kiểm soát dữ liệu master được kiểm thử |
| OBJ-02 | Quản lý vòng đời lệnh sản xuất | Có trạng thái, điều kiện chuyển trạng thái và lịch sử |
| OBJ-03 | Ghi nhận kết quả sản xuất | Ghi nhận sản lượng tốt/lỗi, liên kết lệnh và công đoạn phù hợp |
| OBJ-04 | Ghi nhận kiểm tra chất lượng | Lưu kết quả kiểm tra và liên kết đối tượng kiểm tra |
| OBJ-05 | Theo dõi sự kiện thiết bị | Ghi nhận downtime/maintenance và thời gian sự kiện |
| OBJ-06 | Cung cấp khả năng truy xuất | Thiết kế và kiểm thử liên kết sản phẩm, lô vật liệu, công đoạn và kết quả |
| OBJ-07 | Đảm bảo chất lượng phần mềm | Có test strategy, automated tests, API tests và UAT evidence |

## 4. High-level scope

### In scope – định hướng

- Master Data: Product/SKU, Work Center/Production Line.
- Production: Production Order, Production Report, tiến độ sản xuất.
- Quality: Incoming, In-process và Final Inspection.
- Equipment: Downtime, Maintenance, Changeover và Running Events.
- Dashboard: trạng thái lệnh, sản lượng, hàng tốt/lỗi và chỉ số chất lượng.
- Traceability: nền tảng Material Lot và mở rộng genealogy.
- Nền tảng kỹ thuật: API, persistence, database migration, logging, security và testing.

Phạm vi chi tiết, thứ tự ưu tiên và tiêu chí nghiệm thu phải được chốt trong Project Scope và các tài liệu yêu cầu.

### Out of scope – tạm thời

Các mục sau chưa thuộc cam kết của baseline đầu tiên, trừ khi được phê duyệt thay đổi phạm vi:

- Điều khiển máy móc hoặc PLC theo thời gian thực.
- Tích hợp ERP/WMS/QMS/PLC thực tế với hệ thống bên ngoài.
- Thuật toán lập lịch sản xuất tối ưu nâng cao.
- Triển khai multi-tenant hoặc multi-plant production-grade.
- Mobile application, IoT gateway và các chức năng phần cứng chuyên dụng.

## 5. Key deliverables

1. Bộ tài liệu quản trị dự án và phân tích nghiệp vụ.
2. Business process models (AS-IS/TO-BE) và Business Rules.
3. BRD, Use Case Specification, SRS/FRS, NFR và RTM.
4. System architecture, ERD, Data Dictionary, API Specification và UML.
5. Source code backend và database migrations.
6. Automated tests, test cases, defect log và UAT report.
7. Deployment guide, user guide và operational documentation.

## 6. High-level milestones

| Milestone | Deliverable / exit condition | Status |
|---|---|---|
| M0 – Initiation | Charter, Scope, Stakeholder Register được review | In progress |
| M1 – Discovery | Stakeholder interviews, AS-IS/TO-BE, glossary | Not started |
| M2 – Requirements baseline | BRD, Use Cases, SRS/FRS, NFR, RTM được xác nhận | Not started |
| M3 – System design | Architecture, ERD, API contract, design review | Not started |
| M4 – Implementation | Các module theo phạm vi được hoàn thành | Existing foundation; gap analysis required |
| M5 – Verification | Test execution, defect resolution, UAT | Not started |
| M6 – Release | Deployment, documentation, release acceptance | Not started |

Timeline và nguồn lực: **TBD** sau khi xác định phạm vi và năng lực thực hiện.

## 7. Technology baseline

| Layer | Current baseline / proposal | Status |
|---|---|---|
| Language | Java 17 | Existing repository baseline |
| Backend framework | Spring Boot 3.4 | Existing repository baseline |
| Persistence | Spring Data JPA | Existing repository baseline |
| Database | PostgreSQL | Existing repository baseline |
| Migration | Flyway | Existing repository baseline |
| Architecture | Modular monolith, layered architecture | Existing repository baseline |
| API | REST | Existing repository baseline |
| Build / runtime | Maven, Docker Compose | Described in repository README |
| Frontend | TBD | Not yet agreed |
| CI/CD | TBD | Not yet agreed |
| Authentication / RBAC | TBD | Roadmap item in current README |

## 8. Key stakeholders

Danh sách vai trò dự kiến được quản lý chi tiết trong [Stakeholder Register](03_Stakeholder_Register.md). Người cụ thể và quyền phê duyệt hiện chưa được xác định.

## 9. Assumptions and constraints

### Assumptions

- **A-01:** Dự án dùng repository cloneMES làm nơi quản lý source code và tài liệu.
- **A-02:** Java 17, Spring Boot 3.4 và PostgreSQL tiếp tục là baseline kỹ thuật.
- **A-03:** Dự án mô phỏng nghiệp vụ nhà máy; dữ liệu ban đầu là dữ liệu giả lập.
- **A-04:** Quy trình sản xuất linh kiện điện tử là hướng khảo sát ưu tiên, chưa phải phạm vi đã xác nhận.

### Constraints

- Repository hiện public; không lưu secrets hoặc dữ liệu sản xuất/khách hàng thật.
- Mọi yêu cầu tích hợp thiết bị hoặc hệ thống bên ngoài cần xác định giao thức, môi trường và khả năng truy cập trước khi cam kết.
- Không thiết kế chi tiết dựa trên giả định chưa được xác nhận mà không đánh dấu rõ.

## 10. Initial risks

| ID | Risk | Impact | Mitigation |
|---|---|---|---|
| R-01 | Phạm vi MES quá rộng | High | Chốt MVP, ưu tiên theo business value |
| R-02 | Thiếu thông tin quy trình thực tế | High | Tạo câu hỏi khảo sát và xác nhận AS-IS/TO-BE |
| R-03 | Thiết kế traceability thiếu liên kết | High | Xác định genealogy và event model sớm |
| R-04 | Tích hợp thiết bị/ERP không rõ giao thức | High | Tách integration scope, làm rõ interface |
| R-05 | Bảo mật và phân quyền chưa đầy đủ | High | Đưa security/RBAC vào NFR và design review |
| R-06 | Tài liệu không đồng bộ với code | Medium | Duy trì RTM, versioning và review theo release |

## 11. Success criteria

Dự án được xem là đạt mục tiêu khi:

- Phạm vi và yêu cầu MVP được xác nhận, có acceptance criteria.
- Quy trình cốt lõi có BPMN/Use Case và business rules rõ ràng.
- Thiết kế dữ liệu và API đáp ứng các yêu cầu đã phê duyệt.
- Chức năng trong MVP có automated tests và kết quả kiểm thử truy vết được.
- UAT đạt tiêu chí nghiệm thu đã thống nhất.
- Có hướng dẫn triển khai, vận hành và giới hạn hệ thống được công bố.

## 12. Approval

| Role | Name | Decision | Date |
|---|---|---|---|
| Sponsor / Project Owner | TBD | Pending | TBD |
| Business Owner | TBD | Pending | TBD |
| Technical Lead | TBD | Pending | TBD |

## 13. Open questions

- Nhà máy mục tiêu và loại hình sản xuất chính xác là gì?
- Quy trình cần mô phỏng là SMT, Assembly, Testing hay toàn bộ chuỗi?
- MES nhận Production Order từ ERP hay cho phép tạo trực tiếp?
- Đơn vị truy xuất là Serial Number, Lot Number hay kết hợp?
- Cần bao nhiêu nhà máy, line, work center và vai trò người dùng?
- Mức độ tích hợp với ERP/WMS/PLC trong MVP?
- Frontend sẽ dùng công nghệ nào?
- Ai là người xác nhận yêu cầu và tiêu chí nghiệm thu?

## 14. Change history

| Version | Date | Author | Description |
|---|---|---|---|
| 0.1 | 2026-11-12 | Project team | Initial draft based on current repository baseline |
