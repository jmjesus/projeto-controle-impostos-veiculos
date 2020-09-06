package br.com.bandtec.projetoimpostosveiculos;

public abstract class Veiculo {

    private String cor;
    private String modelo;
    private String placa;
    private String uf;
    private Integer anoFabricacao;
    private Double valorVenal;


    public Veiculo(String cor, String modelo, String placa, String uf, Integer anoFabricacao, Double valorVenal) {
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
        this.uf = uf;
        this.anoFabricacao = anoFabricacao;
        this.valorVenal = valorVenal;
    }

    public abstract Double getValorIpva();

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getUf() {
        return uf;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public Double getValorVenal() {
        return valorVenal;
    }
}
