package com.example.projetoTechAcademy.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "Clientes")

public class Cliente extends BaseEntity {

    @Override
    @Column (name= "id_cliente")
    public Integer getId() {
        return super.getId();
    }

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column
    private String tel;

    @Column
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente clientes = (Cliente) o;
        return Objects.equals(getId(), clientes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public boolean validate() {

        return super.validate() && nome != null && !nome.isEmpty() &&
                email != null && !email.isEmpty() &&
                senha != null && !senha.isEmpty();
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tel='" + tel + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
