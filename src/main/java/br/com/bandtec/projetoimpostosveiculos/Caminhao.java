package br.com.bandtec.projetoimpostosveiculos;

import java.util.Calendar;

public class Caminhao extends Veiculo {

    private Integer cargaToneladas;

    public Caminhao(String cor, String modelo, String placa, String uf, Integer anoFabricacao, Double valorVenal, Integer cargaToneladas) {
        super(cor, modelo, placa, uf, anoFabricacao, valorVenal);
        this.cargaToneladas = cargaToneladas;
    }

    @Override
    public Double getValorIpva() {
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);

        if ((anoAtual - getAnoFabricacao()) <= 10) {
            return super.getValorVenal() * 0.01;
        } else {
            return 0.0;
        }
    }

    public Integer getCargaToneladas() {
        return cargaToneladas;
    }
}