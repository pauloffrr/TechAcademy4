CREATE TABLE Produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nm_produto VARCHAR(100) NOT NULL,
    desc_produto TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    id_categoria INT NOT NULL,
    imagem_url VARCHAR(500),
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
);