package br.com.bandtec.projetoimpostosveiculos;

public class Caminhao extends Veiculo {

    private Integer cargaToneladas;

    public Caminhao(String cor, String modelo, String placa, String uf, Integer ano, Double valorVenal, Integer cargaToneladas) {
        super(cor, modelo, placa, uf, ano, valorVenal);
        this.cargaToneladas = cargaToneladas;
    }

    @Override
    public Double getValorIpva() {
        return super.getValorVenal() * 0.01;
    }

    public Integer getCargaToneladas() {
        return cargaToneladas;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "cargaToneladas=" + cargaToneladas +
                "} " + super.toString();
    }
}
