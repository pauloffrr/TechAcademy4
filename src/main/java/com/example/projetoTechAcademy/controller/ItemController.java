package com.example.projetoTechAcademy.controller;


import com.example.projetoTechAcademy.dto.ItemRequestDTO;
import com.example.projetoTechAcademy.model.Item;
import com.example.projetoTechAcademy.model.Pedido;
import com.example.projetoTechAcademy.model.ProdutoPedido;
import com.example.projetoTechAcademy.model.ProdutoPedidoPK;
import com.example.projetoTechAcademy.repository.ItemRepository;
import com.example.projetoTechAcademy.repository.PedidoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/Itens")
public class ItemController {

        @Autowired
        private ItemRepository repository;

        @Autowired
        private PedidoRepositoy pedidoRepositoy;

        @GetMapping
        public List<Item> findAll() {
            return  this.repository.findAll();
        }

        @GetMapping("/{id}")
        public Item findById(@PathVariable Integer id){
            return this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Item não foi encontrada"));
        }

        @PostMapping
        public Item save(@RequestBody ItemRequestDTO dto) {

            Item item = new Item();
            item.setNome(dto.nomeItem());
            item.setDescProduto(dto.descProduto());
            item.setPreco(dto.preco());
            item.setImagemUrl(dto.imagemUrl());

            return this.repository.save(item);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            Item item = this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Item não foi encontrada"));

            this.repository.delete(item);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody ItemRequestDTO dto) {
            if (dto.nomeItem().isEmpty()) {
                return ResponseEntity.status(428).build();
            }

            Item item = this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Item não foi encontrada"));

            item.setNome(dto.nomeItem());
            item.setDescProduto(dto.descProduto());
            item.setPreco(dto.preco());
            item.setImagemUrl(dto.imagemUrl());

            this.repository.save(item);
            return ResponseEntity.ok(item);
        }

    @PostMapping("/{id}/add-pedido")
    public ResponseEntity<Item> addPedido(@PathVariable Integer id,
                                          @RequestBody Integer pedidoId) {

        Item item = repository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        Pedido pedido = pedidoRepositoy.findById(pedidoId).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        ProdutoPedidoPK pk = new ProdutoPedidoPK();
        pk.setIdItem(item.getIdItem());
        pk.setIdPedido(pedido.getIdPedido());

        ProdutoPedido produtoPedido = new ProdutoPedido();
        produtoPedido.setId(pk);
        produtoPedido.setPedido(pedido);
        produtoPedido.setItem(item);

        item.addPedido(produtoPedido);


        repository.save(item);

        return ResponseEntity.ok(item);

    }
    @PutMapping("/{id}/aplicar-desconto")
    public ResponseEntity<Item> aplicarDesconto(@PathVariable Integer id, @RequestParam BigDecimal percentualDesconto) {
        Item item = repository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));

        // Aplicando o desconto no item (isso recalcula o preço e atualiza o desconto)
        item.aplicarDesconto(percentualDesconto);

        // Salvando o item atualizado (com o preço recalculado)
        repository.save(item);

        return ResponseEntity.ok(item);
    }


}

