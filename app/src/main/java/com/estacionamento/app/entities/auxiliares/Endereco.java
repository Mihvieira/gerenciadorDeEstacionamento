package com.estacionamento.app.entities.auxiliares;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Endereco implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @NotBlank
        private String logradouro;
        @NotBlank
        private String bairro;
        @Pattern(regexp = "\\d{8}")
        private String cep;
        @NotBlank
        private String cidade;
        @NotBlank
        private String uf;
        private String complemento;
        private String numero;

        public Endereco() {
        }

        public Endereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
                this.logradouro = logradouro;
                this.bairro = bairro;
                this.cep = cep;
                this.cidade = cidade;
                this.uf = uf;
                this.complemento = complemento;
                this.numero = numero;
        }

        public String getLogradouro() {
                return logradouro;
        }

        public String getBairro() {
                return bairro;
        }

        public String getCep() {
                return cep;
        }

        public String getCidade() {
                return cidade;
        }

        public String getUf() {
                return uf;
        }

        public String getComplemento() {
                return complemento;
        }

        public String getNumero() {
                return numero;
        }

        public void setLogradouro(String logradouro) {
                this.logradouro = logradouro;
        }

        public void setBairro(String bairro) {
                this.bairro = bairro;
        }

        public void setCep(String cep) {
                this.cep = cep;
        }

        public void setCidade(String cidade) {
                this.cidade = cidade;
        }

        public void setUf(String uf) {
                this.uf = uf;
        }

        public void setComplemento(String complemento) {
                this.complemento = complemento;
        }

        public void setNumero(String numero) {
                this.numero = numero;
        }

        @Override
        public boolean equals(Object obj) {
                if (obj == this) return true;
                if (obj == null || obj.getClass() != this.getClass()) return false;
                var that = (Endereco) obj;
                return Objects.equals(this.logradouro, that.logradouro) &&
                        Objects.equals(this.bairro, that.bairro) &&
                        Objects.equals(this.cep, that.cep) &&
                        Objects.equals(this.cidade, that.cidade) &&
                        Objects.equals(this.uf, that.uf) &&
                        Objects.equals(this.complemento, that.complemento) &&
                        Objects.equals(this.numero, that.numero);
        }


        @Override
        public int hashCode() {
                return Objects.hash(logradouro, bairro, cep, cidade, uf, complemento, numero);
        }

        @Override
        public String toString() {
                return "Endereco[" +
                        "logradouro=" + logradouro + ", " +
                        "bairro=" + bairro + ", " +
                        "cep=" + cep + ", " +
                        "cidade=" + cidade + ", " +
                        "uf=" + uf + ", " +
                        "complemento=" + complemento + ", " +
                        "numero=" + numero + ']';
        }


}
