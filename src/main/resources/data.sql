CREATE TABLE Customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    lastName VARCHAR(255),
    companyName VARCHAR(255)
);

CREATE TABLE Email (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES Customer(id)
);

INSERT INTO Customer (name, lastName, companyName) VALUES ('John', 'Doe', 'Example Corp');
INSERT INTO Email (address, customer_id) VALUES ('john.doe@example.com', 1);
INSERT INTO Email (address, customer_id) VALUES ('john.doe2@example.com', 1);
INSERT INTO Email (address, customer_id) VALUES ('john.doe3@example.com', 1);

INSERT INTO Customer (name, lastName, companyName) VALUES ('Jane', 'Smith', 'Smith LLC');
INSERT INTO Email (address, customer_id) VALUES ('jane.smith@example.com', 2);
INSERT INTO Email (address, customer_id) VALUES ('jane.smith2@example.com', 2);

INSERT INTO Customer (name, lastName, companyName) VALUES ('Alice', 'Johnson', 'Tech Solutions');
INSERT INTO Email (address, customer_id) VALUES ('alice.johnson@example.com', 3);