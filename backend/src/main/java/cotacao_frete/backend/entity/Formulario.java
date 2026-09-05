package cotacao_frete.backend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "formulario")
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formulario")
    private Long idFormulario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="remetente_id",nullable = false)
    private Remetente remetente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="destinatario_id",nullable = false)
    private Destinatario destinatario;


    @Column(name="valor_nf",nullable = false,precision = 10,scale = 2)
    private BigDecimal valorNf;

    @Column(nullable = false, precision = 6,scale = 3)
    private BigDecimal peso;

    @Column(nullable = false)
    private Integer volume;

    @Column(name="tipo_material",nullable = false, length = 50)
    private String tipoMaterial;

    @Column(nullable = false,length = 30)
    private String medidas;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_frete",nullable = false)
    private TipoDeFrete tipoDeFrete;

    @Column(name="tipo_embalagem",nullable = false,length = 50)
    private String tipoEmbalagem;

    @Column(name = "data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist(){
        if(dataCriacao==null){
            dataCriacao = LocalDateTime.now();
        }
    }

    public Formulario() {
    }

    public Long getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Long idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Remetente getRemetente() {
        return remetente;
    }

    public void setRemetente(Remetente remetente) {
        this.remetente = remetente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getValorNf() {
        return valorNf;
    }

    public void setValorNf(BigDecimal valorNf) {
        this.valorNf = valorNf;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public TipoDeFrete getTipoDeFrete() {
        return tipoDeFrete;
    }

    public void setTipoDeFrete(TipoDeFrete tipoDeFrete) {
        this.tipoDeFrete = tipoDeFrete;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "idFormulario=" + idFormulario +
                ", remetente=" + (remetente != null? remetente.getIdRemetente():null) +
                ", destinatario=" + (destinatario != null? destinatario.getIdDestinatario():null) +
                ", valorNf=" + valorNf +
                ", peso=" + peso +
                ", volume=" + volume +
                ", tipoMaterial='" + tipoMaterial + '\'' +
                ", medidas='" + medidas + '\'' +
                ", tipoDeFrete=" + tipoDeFrete +
                ", tipoEmbalagem='" + tipoEmbalagem + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formulario that)) return false;
        if (idFormulario == null || that.idFormulario == null) return false;
        return Objects.equals(idFormulario, that.idFormulario);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
