package cotacao_frete.backend.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="transportadora")
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_transportadora")
    private Long idTransportadora;

    @Column(name="nome_transportadora", nullable = false,length = 100)
    private String nomeTransportadora;

    @Column(name="cnpj_transportadora",nullable = false, length=14, unique = true)
    private String cnpjTransportadora;

    @Column(name="cep_transportadora",nullable=false,length = 8)
    private String cepTransportadora;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Modal modal;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    @Column(name="data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name="data_modificacao",nullable = false)
    private LocalDateTime dataModificacao;

    @PrePersist
    public void prePersist(){
        dataCriacao = LocalDateTime.now();
        dataModificacao = LocalDateTime.now();
        status = Status.ATIVO;
    }

    @PreUpdate
    public void preUpdate() {
        dataModificacao = LocalDateTime.now();
    }

    public Long getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(Long idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public String getCnpjTransportadora() {
        return cnpjTransportadora;
    }

    public void setCnpjTransportadora(String cnpjTransportadora) {
        this.cnpjTransportadora = cnpjTransportadora;
    }

    public String getCepTransportadora() {
        return cepTransportadora;
    }

    public void setCepTransportadora(String cepTransportadora) {
        this.cepTransportadora = cepTransportadora;
    }

    public Modal getModal() {
        return modal;
    }

    public void setModal(Modal modal) {
        this.modal = modal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transportadora that)) return false;
        if (idTransportadora == null || that.idTransportadora == null) return false;
        return Objects.equals(idTransportadora, that.idTransportadora);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
