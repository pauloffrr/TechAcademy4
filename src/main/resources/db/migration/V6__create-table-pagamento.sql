CREATE TABLE Pagamento (
    id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor DECIMAL(12, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido)
);
