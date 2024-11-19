CREATE TABLE ItemPedido (
    id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_item INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),
    FOREIGN KEY (id_item) REFERENCES Item(id_item)
);
