CREATE TABLE Item (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    desc_produto TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    id_categoria INT NOT NULL,
    imagem_url VARCHAR(255),
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
);
