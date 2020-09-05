package br.com.bandtec.projetoimpostosveiculos;

public class Moto extends Veiculo {

    private Integer cilindradas;

    public Moto(String cor, String modelo, String placa, String uf, Integer ano, Double valorVenal, Integer cilindradas) {
        super(cor, modelo, placa, uf, ano, valorVenal);
        this.cilindradas = cilindradas;
    }

    @Override
    public Double getValorIpva() {
        return super.getValorVenal() * 0.02;
    }

    public Integer getCilindradas() {
        return cilindradas;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindradas=" + cilindradas +
                "} " + super.toString();
    }
}
