CREATE TABLE Form_Pagamento (
    id_form_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    tipo_pagamento VARCHAR(50) NOT NULL CHECK (tipo_pagamento IN ('Cartão de Crédito', 'Cartão de Débito', 'Boleto', 'Pix', 'Transferência Bancária')),
    descricao TEXT,
    ativo BOOLEAN DEFAULT TRUE
);
