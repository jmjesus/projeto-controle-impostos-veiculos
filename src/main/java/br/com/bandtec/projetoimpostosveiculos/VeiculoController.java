package br.com.bandtec.projetoimpostosveiculos;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity buscarVeiculosEspecificos(@PathVariable String tipoVeiculo) {
        listaFiltrada = new ArrayList<>();

        if (tipoVeiculo.equals("carros") || tipoVeiculo.equals("motos") || tipoVeiculo.equals("caminhoes")) {
            for (Veiculo v : veiculos) {
                if (tipoVeiculo.equals("carros") && v instanceof Carro) {
                    listaFiltrada.add(v);
                } else if (tipoVeiculo.equals("motos") && v instanceof Moto) {
                    listaFiltrada.add(v);
                } else if (tipoVeiculo.equals("caminhoes") && v instanceof Caminhao) {
                    listaFiltrada.add(v);
                }
            }

            if (listaFiltrada.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(listaFiltrada);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity listarVeiculos() {
        if (veiculos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(veiculos);
        }
    }

//    @GetMapping("/{id}")
//    public Veiculo buscarVeiculo(@PathVariable int id) {
//        return veiculos.get(id-1);
//    }

    @PostMapping("/carros")
    public ResponseEntity registrarCarro(@RequestBody Carro c) {
        veiculos.add(c);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/motos")
    public ResponseEntity registrarMoto(@RequestBody Moto m) {
        veiculos.add(m);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/caminhoes")
    public ResponseEntity registrarCaminhao(@RequestBody Caminhao c) {
        veiculos.add(c);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarVeiculo(@PathVariable int id) {
        if (veiculos.size() >= id) {
            veiculos.remove(id-1);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
