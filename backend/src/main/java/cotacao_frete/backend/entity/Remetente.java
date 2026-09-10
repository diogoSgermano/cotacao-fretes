package cotacao_frete.backend.entity;


import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="remetente")
public class Remetente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_remetente")
    private Long idRemetente;

    @Column(name = "nome_remetente",nullable = false,length = 100)
    private String nomeRemetente;

    @Column(name="cnpj_remetente",nullable = false, length=14)
    private String CnpjRemetente;

    @Column(name="cep_remetente",nullable=false,length = 8)
    private Integer CepRemetente;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    @Column(nullable = false,length = 200)
    private String endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Padrao padrao;

    @Column(name="data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name="data_modificacao",nullable = false)
    private LocalDateTime dataModificacao;

    @PrePersist
    public void prePersist(){
        dataCriacao = LocalDateTime.now();
        dataModificacao = LocalDateTime.now();
        padrao = Padrao.NAO;
        status = Status.ATIVO;
    }

    @PreUpdate
    public void preUpdate() {
        dataModificacao = LocalDateTime.now();
    }

    Remetente(){}

    public Long getIdRemetente() {
        return idRemetente;
    }

    public void setIdRemetente(Long idRemetente) {
        this.idRemetente = idRemetente;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getCnpjRemetente() {
        return CnpjRemetente;
    }

    public void setCnpjRemetente(String cnpjRemetente) {
        CnpjRemetente = cnpjRemetente;
    }

    public Integer getCepRemetente() {
        return CepRemetente;
    }

    public void setCepRemetente(Integer cepRemetente) {
        CepRemetente = cepRemetente;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Remetente{" +
                "idRemetente=" + idRemetente +
                ", nomeRemetente='" + nomeRemetente + '\'' +
                ", CnpjRemetente='" + CnpjRemetente + '\'' +
                ", CepRemetente=" + CepRemetente +
                ", status=" + status +
                ", endereco='" + endereco + '\'' +
                ", padrao=" + padrao +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Remetente that)) return false;
        if (idRemetente == null || that.idRemetente == null) return false;
        return Objects.equals(idRemetente, that.idRemetente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idRemetente);
    }
}
