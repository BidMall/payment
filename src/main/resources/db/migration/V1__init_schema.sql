-- 시퀀스 생성
CREATE SEQUENCE payment_seq START 1 INCREMENT 1;
CREATE SEQUENCE refund_seq START 1 INCREMENT 1;

CREATE TABLE payments (
    id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    auction_id BIGINT,
    amount DECIMAL(20, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE refunds (
    id BIGINT PRIMARY KEY,
    payment_id BIGINT NOT NULL,
    amount DECIMAL(20, 2) NOT NULL,
    reason VARCHAR(255),
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_refunds_payments FOREIGN KEY (payment_id) REFERENCES payments(id)
);

CREATE INDEX idx_payments_user_id ON payments(user_id);
CREATE INDEX idx_payments_product_id ON payments(product_id);
CREATE INDEX idx_payments_auction_id ON payments(auction_id);
CREATE INDEX idx_refunds_payment_id ON refunds(payment_id); 