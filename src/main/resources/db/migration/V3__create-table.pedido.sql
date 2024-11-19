CREATE TABLE Pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    data_pedido DATE NOT NULL,
    status_pedido VARCHAR(50),
    valor_total DECIMAL(10, 2),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);
