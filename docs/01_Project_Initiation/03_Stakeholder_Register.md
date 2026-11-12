# Stakeholder Register – SmartMES

| Field | Value |
|---|---|
| Document ID | PRJ-003 |
| Version | 0.1 |
| Status | Draft – role assumptions only |
| Related document | [Project Charter](01_Project_Charter.md) |
| Owner | Project Manager / BA – TBD |
| Created / updated | 2026-11-12 |

## 1. Purpose

Xác định các cá nhân/nhóm có ảnh hưởng đến dự án hoặc chịu tác động bởi MES, ghi nhận nhu cầu, quyền quyết định, mức độ ảnh hưởng và cách thức tham gia.

**Important:** Đây là danh sách vai trò mẫu cho một dự án MES. Chưa có tên cá nhân, cơ cấu tổ chức hoặc quyền hạn thực tế nào được xác nhận.

## 2. Stakeholder register

| ID | Stakeholder / role | Main interest / concern | Influence | Expected involvement | Engagement approach | Named person / status |
|---|---|---|---|---|---|---|
| SH-01 | Project Sponsor | Business value, budget, scope, success | High | Approve charter, major scope and phase gates | Steering review | TBD |
| SH-02 | Project Manager | Schedule, resources, risks, delivery | High | Plan and coordinate project | Weekly project review | TBD |
| SH-03 | Business Owner / Plant Manager | Production performance and operational fit | High | Confirm business objectives and priorities | Workshop / sign-off | TBD |
| SH-04 | Production Manager | Production planning, order execution, output | High | Validate production workflows and KPIs | Process workshop | TBD |
| SH-05 | Production Planner | Order creation, scheduling, material readiness | Medium–High | Explain planning and order release rules | Interview / scenario walkthrough | TBD |
| SH-06 | Production Supervisor / Line Leader | WIP, line status, shift output, exceptions | High | Validate shop-floor execution and exceptions | On-site observation / workshop | TBD |
| SH-07 | Production Operator | Usability, scanning, reporting, work instructions | Medium | Validate operator tasks and UI flows | Observation / usability test | TBD |
| SH-08 | Quality Manager / Engineer | Inspection, defect, hold/release, traceability | High | Define quality rules and disposition | Quality workshop | TBD |
| SH-09 | Warehouse / Material Controller | Material lot, issue, return, consumption | Medium–High | Define material movement and genealogy | Material-flow workshop | TBD |
| SH-10 | Maintenance Engineer | Equipment state, downtime, maintenance | Medium | Define equipment event lifecycle | Interview | TBD |
| SH-11 | IT / Infrastructure | Network, deployment, backup, access, operations | High | Review technical and operational constraints | Technical review | TBD |
| SH-12 | ERP / WMS Owner | Interface, master data, transaction ownership | High | Confirm integration contract and source of truth | Interface workshop | TBD |
| SH-13 | Solution Architect / Technical Lead | Architecture, integration, quality attributes | High | Own technical design and review | Design review | TBD |
| SH-14 | Backend Developer | Implementation, code quality, testability | Medium | Estimate and implement backend | Refinement / code review | TBD |
| SH-15 | QA / Tester | Test coverage, defect quality, release confidence | Medium | Define and execute tests | Test planning / triage | TBD |
| SH-16 | End User / Management Viewer | Reports, visibility, decision support | Medium | Validate dashboard and reports | Demo / UAT | TBD |

## 3. Stakeholder analysis

### Key questions to establish

- Ai là người sở hữu quy trình sản xuất (Process Owner)?
- Ai có quyền phê duyệt yêu cầu nghiệp vụ?
- Ai quyết định Production Order được release, hold hoặc cancel?
- Ai quyết định kết quả quality inspection và disposition của sản phẩm lỗi?
- Ai sở hữu dữ liệu Product, BOM, Routing và Material?
- ERP hay MES là nguồn dữ liệu chính cho từng loại dữ liệu?
- Ai chịu trách nhiệm xác nhận UAT và ký nghiệm thu?
- Ai quản trị user, role, permission và audit log?

## 4. Engagement plan

| Stakeholder group | Topics | Suggested format | Expected output |
|---|---|---|---|
| Sponsor / Business Owner | Goals, scope, success criteria, priority | Kick-off / decision workshop | Approved objectives and scope |
| Production | Order lifecycle, routing, WIP, output, exceptions | Interview + process walkthrough | AS-IS/TO-BE, business rules |
| Quality | Inspection, defect, rework, hold/release | Workshop + sample records | Quality rules and use cases |
| Warehouse / Material | BOM, lot, issue, return, consumption | Material-flow walkthrough | Material process and traceability rules |
| Maintenance | Equipment states, downtime, maintenance | Interview | Equipment event model |
| IT / ERP / WMS | Architecture, interfaces, security, operations | Technical workshop | NFR and interface specifications |
| Operators | Actual task sequence, scanning, usability | Observation / usability session | User journeys and edge cases |
| QA | Test scope, acceptance, defect workflow | Test planning | Test strategy and UAT approach |

## 5. RACI – initial proposal

R = Responsible, A = Accountable, C = Consulted, I = Informed. Phân công dưới đây là gợi ý, phải được xác nhận theo cơ cấu thực tế.

| Activity | Sponsor | Business Owner | BA | Tech Lead | Developer | QA |
|---|---|---|---|---|---|---|
| Approve project charter | A | C | R | C | I | I |
| Define business scope | I | A | R | C | I | C |
| Elicit requirements | I | A | R | C | C | C |
| Approve business rules | I | A/R | R | C | I | C |
| Design architecture | I | C | C | A/R | C | C |
| Implement backend | I | I | C | A | R | C |
| Define test strategy | I | C | C | C | C | A/R |
| UAT sign-off | I | A | R | C | I | R |

## 6. Stakeholder communication

| Communication | Audience | Cadence | Owner | Output |
|---|---|---|---|---|
| Project status | Sponsor / Project team | Weekly | Project Manager | Status report |
| Requirement workshop | Relevant process owners | Per topic / phase | BA | Minutes, requirements, decisions |
| Design review | BA, Tech Lead, Developer, QA | Per design baseline | Tech Lead | Review notes and decisions |
| Defect triage | QA, Developer, BA, business representative | During testing | QA Lead | Defect decisions |
| UAT review | Business Owner and key users | UAT phase | BA / QA | UAT result and sign-off |

## 7. Stakeholder risks

- Không xác định được Process Owner hoặc người phê duyệt cuối cùng.
- Người tham gia khảo sát không đại diện đầy đủ cho hoạt động theo ca/kíp.
- Quy trình thực tế khác với quy trình tài liệu hoặc cách vận hành giữa các line không đồng nhất.
- IT và bộ phận nghiệp vụ không thống nhất nguồn dữ liệu chuẩn.
- Người dùng cuối tham gia UAT quá muộn.

## 8. Open items

| ID | Item | Owner | Due date | Status |
|---|---|---|---|---|
| SI-01 | Xác định Sponsor và Business Owner | TBD | TBD | Open |
| SI-02 | Xác định Process Owner cho Production | TBD | TBD | Open |
| SI-03 | Xác định đầu mối Quality và Warehouse | TBD | TBD | Open |
| SI-04 | Xác định IT/ERP/WMS contact | TBD | TBD | Open |
| SI-05 | Xác định người phê duyệt UAT | TBD | TBD | Open |

## 9. Change history

| Version | Date | Description |
|---|---|---|
| 0.1 | 2026-11-12 | Initial role-based stakeholder register; no named stakeholders confirmed |
