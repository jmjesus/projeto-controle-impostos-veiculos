package br.com.bandtec.projetoimpostosveiculos;

import java.util.Calendar;

public class Carro extends Veiculo {

    private Integer qtdPortas;

    public Carro(String cor, String modelo, String placa, String uf, Integer anoFabricacao, Double valorVenal, Integer qtdPortas) {
        super(cor, modelo, placa, uf, anoFabricacao, valorVenal);
        this.qtdPortas = qtdPortas;
    }

    @Override
    public Double getValorIpva() {
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);

        if ((anoAtual-getAnoFabricacao()) <= 10) {
            return super.getValorVenal() * 0.04;
        } else {
            return 0.0;
        }
    }

    public Integer getQtdPortas() {
        return qtdPortas;
    }
}
