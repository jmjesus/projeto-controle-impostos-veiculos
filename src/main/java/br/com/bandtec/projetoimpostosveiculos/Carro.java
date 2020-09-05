package br.com.bandtec.projetoimpostosveiculos;

public class Carro extends Veiculo {

    private Integer qtdPortas;

    public Carro(String cor, String modelo, String placa, String uf, Integer ano, Double valorVenal, Integer qtdPortas) {
        super(cor, modelo, placa, uf, ano, valorVenal);
        this.qtdPortas = qtdPortas;
    }

    @Override
    public Double getValorIpva() {
        return super.getValorVenal() * 0.04;
    }

    public Integer getQtdPortas() {
        return qtdPortas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "qtdPortas=" + qtdPortas +
                "} " + super.toString();
    }
}
