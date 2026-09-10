package cotacao_frete.backend.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="destinatario")
public class Destinatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_destinatario")
    private Long idDestinatario;

    @Column(name = "nome_destinatario",nullable = false,length = 100)
    private String nomeDestinatario;

    @Column(name="cnpj_destinatario",nullable = false, length=14)
    private String CnpjDestinatario;

    @Column(name="cep_destinatario",nullable=false,length = 8)
    private Integer CepDestinatario;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    @Column(nullable = false,length = 200)
    private String endereco;

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

    Destinatario(){}

    public Long getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Long idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getCnpjDestinatario() {
        return CnpjDestinatario;
    }

    public void setCnpjDestinatario(String cnpjDestinatario) {
        CnpjDestinatario = cnpjDestinatario;
    }

    public Integer getCepDestinatario() {
        return CepDestinatario;
    }

    public void setCepDestinatario(Integer cepDestinatario) {
        CepDestinatario = cepDestinatario;
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
        return "Destinatario{" +
                "idDestinatario=" + idDestinatario +
                ", nomeDestinatario='" + nomeDestinatario + '\'' +
                ", CnpjDestinatario='" + CnpjDestinatario + '\'' +
                ", CepDestinatario=" + CepDestinatario +
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
        if (!(o instanceof Destinatario that)) return false;
        if (idDestinatario == null || that.idDestinatario == null) return false;
        return Objects.equals(idDestinatario, that.idDestinatario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idDestinatario);
    }
}
