package cotacao_frete.backend.entity;


import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.time.LocalDateTime;

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



}
