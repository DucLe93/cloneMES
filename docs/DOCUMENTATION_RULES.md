# Documentation Rules

- **Language:** Vietnamese là ngôn ngữ diễn giải chính; giữ thuật ngữ chuyên ngành tiếng Anh trong ngoặc khi cần.
- **Format:** Markdown cho tài liệu quản trị/nghiệp vụ; OpenAPI YAML cho API; Mermaid hoặc draw.io cho sơ đồ; CSV/XLSX khi cần bảng dữ liệu lớn.
- **Document ID:** `<DOMAIN>-<NNN>`, ví dụ `PRJ-001`, `REQ-001`, `UC-001`, `API-001`, `TC-001`.
- **Version:** Bắt đầu từ 0.1 cho draft; tăng phiên bản khi thay đổi nội dung có ý nghĩa.
- **Owner:** Mỗi tài liệu phải có người chịu trách nhiệm cập nhật.
- **Approval:** Ghi người xác nhận, ngày xác nhận và trạng thái. Không tự đánh dấu Approved.
- **Traceability:** Liên kết Business Objective → Requirement → Use Case/Design → API/Implementation → Test Case.
- **Change history:** Ghi thay đổi đáng kể ở cuối tài liệu hoặc trong Git commit.
- **Evidence labels:**
  - **Known:** Có căn cứ từ repository hoặc quyết định đã xác nhận.
  - **Assumption:** Giả định tạm thời để có thể tiếp tục phân tích.
  - **TBD:** Chưa có thông tin; cần khảo sát.
  - **Proposed:** Đề xuất, chưa được phê duyệt.

## Document header template

```markdown
# <Document Title>

| Field | Value |
|---|---|
| Document ID | <ID> |
| Version | 0.1 |
| Status | Draft |
| Owner | <Role / Name> |
| Created date | YYYY-MM-DD |
| Last updated | YYYY-MM-DD |
| Reviewer | TBD |
| Approver | TBD |

## Purpose
## Scope
## Definitions
## Main content
## Open questions
## Change history
```

## Privacy and repository visibility

Repository hiện ở chế độ public. Chỉ commit dữ liệu giả lập hoặc dữ liệu đã được ẩn danh. Không commit credentials, access tokens, thông tin cá nhân, dữ liệu sản xuất thật, BOM/giá thành hoặc thông tin độc quyền của doanh nghiệp.
