package cotacao_frete.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "historico_fretes")
public class HistoricoDeFretes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historico_frete")
    private Long idHistoricoFrete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transportadora_id", nullable = false)
    private Transportadora transportadora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tabela_comparativa_id", nullable = false)
    private TabelaComparativa tabelaComparativa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;

    private LocalDateTime dataCriacao;

    public HistoricoDeFretes() {
    }

    public HistoricoDeFretes(Long idHistoricoFrete, Transportadora transportadora,
                             TabelaComparativa tabelaComparativa,
                             Formulario formulario, LocalDateTime dataCriacao) {
        this.idHistoricoFrete = idHistoricoFrete;
        this.transportadora = transportadora;
        this.tabelaComparativa = tabelaComparativa;
        this.formulario = formulario;
        this.dataCriacao = dataCriacao;
    }

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
    }

    public Long getidHistoricoFrete() {
        return idHistoricoFrete;
    }

    public void setidHistoricoFrete(Long idHistoricoFrete) {
        this.idHistoricoFrete = HistoricoDeFretes.this.idHistoricoFrete;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public TabelaComparativa getTabelaComparativa() {
        return tabelaComparativa;
    }

    public void setTabelaComparativa(TabelaComparativa tabelaComparativa) {
        this.tabelaComparativa = tabelaComparativa;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoricoDeFretes that = (HistoricoDeFretes) o;

        return Objects.equals(idHistoricoFrete, that.idHistoricoFrete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistoricoFrete);
    }

    @Override
    public String toString() {
        return "HistoricoDeFretes{" +
                "idHistoricoFrete=" + idHistoricoFrete +
                ", transportadora=" + transportadora +
                ", tabelaComparativa=" + tabelaComparativa +
                ", formulario=" + formulario +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}