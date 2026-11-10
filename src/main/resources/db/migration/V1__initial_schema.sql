CREATE TABLE products (
 id BIGSERIAL PRIMARY KEY, code VARCHAR(60) NOT NULL UNIQUE, name VARCHAR(180) NOT NULL,
 description VARCHAR(500), unit VARCHAR(20) NOT NULL, active BOOLEAN NOT NULL DEFAULT TRUE,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE work_centers (
 id BIGSERIAL PRIMARY KEY, code VARCHAR(60) NOT NULL UNIQUE, name VARCHAR(180) NOT NULL,
 area VARCHAR(120), capacity_per_hour NUMERIC(12,2) NOT NULL DEFAULT 0, active BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE production_orders (
 id BIGSERIAL PRIMARY KEY, order_no VARCHAR(60) NOT NULL UNIQUE, product_id BIGINT NOT NULL REFERENCES products(id),
 planned_quantity NUMERIC(14,3) NOT NULL, produced_quantity NUMERIC(14,3) NOT NULL DEFAULT 0,
 status VARCHAR(24) NOT NULL, planned_start TIMESTAMP, planned_end TIMESTAMP,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE production_reports (
 id BIGSERIAL PRIMARY KEY, order_id BIGINT NOT NULL REFERENCES production_orders(id),
 work_center_id BIGINT NOT NULL REFERENCES work_centers(id), quantity NUMERIC(14,3) NOT NULL,
 good_quantity NUMERIC(14,3) NOT NULL, defect_quantity NUMERIC(14,3) NOT NULL,
 reported_by VARCHAR(100) NOT NULL, reported_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE material_lots (
 id BIGSERIAL PRIMARY KEY, lot_no VARCHAR(80) NOT NULL UNIQUE, product_id BIGINT NOT NULL REFERENCES products(id),
 quantity NUMERIC(14,3) NOT NULL, supplier VARCHAR(180), received_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE quality_inspections (
 id BIGSERIAL PRIMARY KEY, order_id BIGINT REFERENCES production_orders(id), lot_id BIGINT REFERENCES material_lots(id),
 inspection_type VARCHAR(30) NOT NULL, result VARCHAR(20) NOT NULL, defect_code VARCHAR(60),
 notes VARCHAR(1000), inspected_by VARCHAR(100) NOT NULL, inspected_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE equipment_events (
 id BIGSERIAL PRIMARY KEY, work_center_id BIGINT NOT NULL REFERENCES work_centers(id),
 event_type VARCHAR(24) NOT NULL, reason VARCHAR(300), started_at TIMESTAMP NOT NULL,
 ended_at TIMESTAMP, recorded_by VARCHAR(100) NOT NULL
);
CREATE INDEX idx_orders_status ON production_orders(status);
CREATE INDEX idx_reports_order ON production_reports(order_id);
CREATE INDEX idx_inspections_order ON quality_inspections(order_id);
CREATE INDEX idx_events_workcenter ON equipment_events(work_center_id);
