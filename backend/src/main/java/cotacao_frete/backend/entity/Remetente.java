package cotacao_frete.backend.entity;


import jakarta.persistence.*;
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

    @Column(name="cnpj_remetente",nullable = false, length=14, unique = true)
    private String cnpjRemetente;

    @Column(name="cep_remetente",nullable=false,length = 8)
    private String cepRemetente;

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

    public Remetente(Long idRemetente, String nomeRemetente, String cnpjRemetente, String cepRemetente, Status status, String endereco, Padrao padrao, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.idRemetente = idRemetente;
        this.nomeRemetente = nomeRemetente;
        this.cnpjRemetente = cnpjRemetente;
        this.cepRemetente = cepRemetente;
        this.status = status;
        this.endereco = endereco;
        this.padrao = padrao;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCepRemetente() {
        return cepRemetente;
    }

    public void setCepRemetente(String cepRemetente) {
        this.cepRemetente = cepRemetente;
    }

    public String getCnpjRemetente() {
        return cnpjRemetente;
    }

    public void setCnpjRemetente(String cnpjRemetente) {
        this.cnpjRemetente = cnpjRemetente;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public Long getIdRemetente() {
        return idRemetente;
    }

    public void setIdRemetente(Long idRemetente) {
        this.idRemetente = idRemetente;
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
