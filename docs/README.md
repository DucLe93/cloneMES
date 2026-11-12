# SmartMES Documentation

Bộ tài liệu quản lý dự án MES trong repository `cloneMES`.

> **Trạng thái:** Draft – đang xây dựng và cần xác nhận nghiệp vụ.
> **Nguyên tắc:** Phân biệt rõ thông tin đã có căn cứ, giả định thiết kế và nội dung đang chờ Stakeholder xác nhận. Không coi ví dụ hoặc đề xuất là yêu cầu đã được phê duyệt.

## 1. Project overview

- **Project:** SmartMES (working name)
- **Repository:** [cloneMES](https://github.com/DucLe93/cloneMES)
- **Technology baseline hiện có trong README:** Java 17, Spring Boot 3.4, Spring Data JPA, PostgreSQL, Flyway.
- **Architecture baseline hiện có:** Modular monolith, layered architecture, REST API.
- **Business domain định hướng:** Manufacturing Execution System (MES), ưu tiên quy trình sản xuất linh kiện điện tử; phạm vi ngành và quy trình thực tế vẫn cần xác nhận.

## 2. Documentation map

| ID | Nhóm | Tài liệu | Trạng thái |
|---|---|---|---|
| PRJ-001 | Project Initiation | [Project Charter](01_Project_Initiation/01_Project_Charter.md) | Draft |
| PRJ-002 | Project Initiation | [Project Scope](01_Project_Initiation/02_Project_Scope.md) | Draft |
| PRJ-003 | Project Initiation | [Stakeholder Register](01_Project_Initiation/03_Stakeholder_Register.md) | Draft – roles giả định |
| GOV-001 | Governance | [Documentation Rules](DOCUMENTATION_RULES.md) | Draft |

## 3. Lifecycle và tài liệu sẽ bổ sung

1. **Initiation:** Project Charter, Scope, Stakeholder Register, RACI, Risk Register.
2. **Discovery & Analysis:** Elicitation Plan, Interview Questionnaire, AS-IS/TO-BE, BRD, Business Rules, Glossary.
3. **Specification:** Use Case, User Stories, Acceptance Criteria, SRS/FRS, NFR, RTM.
4. **Design:** Architecture Decision Records (ADR), C4, ERD, Data Dictionary, API/OpenAPI, UML.
5. **Implementation:** Coding Convention, Git Workflow, PR Template, Code Review Checklist.
6. **Verification:** Test Strategy, Test Plan, Test Cases, Defect Log, UAT, Test Summary.
7. **Release & Operations:** Deployment Plan, Release Notes, User Guide, Runbook, Maintenance Plan.

## 4. Cách sử dụng

- Đọc Project Charter trước để hiểu mục tiêu và bối cảnh.
- Dùng Project Scope để kiểm soát ranh giới dự án.
- Dùng Stakeholder Register để xác định người cần phỏng vấn và người có quyền quyết định.
- Mọi yêu cầu nghiệp vụ mới phải có mã định danh, nguồn gốc, mức ưu tiên và trạng thái xác nhận.
- Mọi thay đổi phạm vi phải được ghi nhận; cập nhật các tài liệu bị ảnh hưởng và RTM.
- Không đưa thông tin nhạy cảm của nhà máy, nhân viên hoặc khách hàng lên repository public.

## 5. Trạng thái tài liệu

| Trạng thái | Ý nghĩa |
|---|---|
| Draft | Bản nháp, chưa được xác nhận |
| In Review | Đang được rà soát |
| Approved | Đã được người có thẩm quyền phê duyệt |
| Superseded | Đã được thay thế bởi phiên bản mới |
| Archived | Lưu trữ, không còn hiệu lực |

**Lưu ý:** Các tài liệu ban đầu trong repository là baseline để thảo luận và học tập. Chỉ chuyển sang Approved sau khi xác nhận các giả định với Stakeholder.
