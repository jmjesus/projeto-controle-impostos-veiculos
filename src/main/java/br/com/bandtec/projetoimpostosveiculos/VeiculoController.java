package br.com.bandtec.projetoimpostosveiculos;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private List<Veiculo> veiculos;
    private List<Veiculo> listaFiltrada;

    public VeiculoController() {
        veiculos = new ArrayList<>();
        veiculos.add(new Carro("Amarelo", "Corsa", "ABC-1234", "SP", 2016, 25000.0, 4));
        veiculos.add(new Carro("Preto", "Civic", "DEF-5678", "RJ", 2020, 105000.0, 4));
        veiculos.add(new Carro("Vermelho", "Mini Cooper", "GHI-4321", "MG", 2010, 45000.0, 2));
        veiculos.add(new Moto("Preta", "Pop 100", "KMC-2315", "AM", 2008, 2600.0, 97));
        veiculos.add(new Moto("Branca", "XJ6", "LRZ-7145", "PB", 2015, 29500.0, 600));
        veiculos.add(new Moto("Vermelha", "CG 150", "FJK-1536", "AL", 2018, 7500.0, 149));
        veiculos.add(new Caminhao("Azul", "Accelo 815", "CAR-9077","RS", 2015, 180000.0, 13));
        veiculos.add(new Caminhao("Branco", "VM 260", "EOJ-5130", "SC", 2017, 118000.0, 35));
        veiculos.add(new Caminhao("Cinza", "R440", "YTR-3145", "GO", 2012, 340000.0, 33));
    }

    @GetMapping("/{tipoVeiculo}")
    public List<Veiculo> buscarVeiculosEspecificos(@PathVariable String tipoVeiculo) {
        listaFiltrada = new ArrayList<>();

        for (Veiculo v : veiculos) {
            if (tipoVeiculo.equals("carros") && v instanceof Carro) {
                listaFiltrada.add(v);
            } else if (tipoVeiculo.equals("motos") && v instanceof Moto) {
                listaFiltrada.add(v);
            } else if (tipoVeiculo.equals("caminhoes") && v instanceof Caminhao) {
                listaFiltrada.add(v);
            }
        }

        return listaFiltrada;
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

//    @GetMapping("/{id}")
//    public Veiculo buscarVeiculo(@PathVariable int id) {
//        return veiculos.get(id-1);
//    }

    @PostMapping("/carros")
    public void registrarCarro(@RequestBody Carro c) {
        veiculos.add(c);
    }

    @PostMapping("/motos")
    public void registrarMoto(@RequestBody Moto m) {
        veiculos.add(m);
    }

    @PostMapping("/caminhoes")
    public void registrarCaminhao(@RequestBody Caminhao c) {
        veiculos.add(c);
    }

    @DeleteMapping("/{id}")
    public void deletarVeiculo(@PathVariable int id) {
        veiculos.remove(id-1);
    }
}
