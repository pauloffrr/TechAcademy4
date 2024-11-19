CREATE TABLE Audit_preco_item (
    id_audit INT AUTO_INCREMENT PRIMARY KEY,
    id_item INT NOT NULL,
    preco_anterior DECIMAL(10, 2) NOT NULL,
    preco_novo DECIMAL(10, 2) NOT NULL,
    data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    alterado_por VARCHAR(100),
    FOREIGN KEY (id_item) REFERENCES Item(id_item)
);