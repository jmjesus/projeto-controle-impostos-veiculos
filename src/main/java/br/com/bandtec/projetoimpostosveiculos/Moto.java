package br.com.bandtec.projetoimpostosveiculos;

import java.util.Calendar;

public class Moto extends Veiculo {

    private Integer cilindradas;

    public Moto(String cor, String modelo, String placa, String uf, Integer anoFabricacao, Double valorVenal, Integer cilindradas) {
        super(cor, modelo, placa, uf, anoFabricacao, valorVenal);
        this.cilindradas = cilindradas;
    }

    @Override
    public Double getValorIpva() {
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);

        if ((anoAtual-getAnoFabricacao()) <= 10) {
            return super.getValorVenal() * 0.02;
        } else {
            return 0.0;
        }
    }

    public Integer getCilindradas() {
        return cilindradas;
    }
}
