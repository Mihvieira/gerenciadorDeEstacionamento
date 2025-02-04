package com.estacionamento.app.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.entities.auxiliares.DadosPessoais;
import com.estacionamento.app.entities.auxiliares.Endereco;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;
import com.estacionamento.app.repository.EstacionamentoRepository;
import com.estacionamento.app.repository.RegistroRepository;
import com.estacionamento.app.repository.VagaRepository;
import com.estacionamento.app.repository.VeiculoRepository;
import com.estacionamento.app.service.RegistroService;
import com.estacionamento.app.service.VagaService;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private RegistroRepository registroRepository;
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;


    @Override
    public void run(String... args) throws Exception {
        Vaga vaga1 = new Vaga("A", TipoVeiculo.CARRO);
        Vaga vaga2 = new Vaga("B", TipoVeiculo.CARRO);
        Vaga vaga3 = new Vaga("C", TipoVeiculo.MOTO);
        vagaRepository.saveAll(Arrays.asList(vaga1, vaga2, vaga3));
        Endereco endereco = new Endereco("rua tal", "privareva", "766666", "exemplo", "RO", null, "12-B");
        DadosPessoais dados = new DadosPessoais("empresaNome", "123456", endereco, "123");
        Estacionamento estacionamento = new Estacionamento(dados, 10, 10);
        estacionamentoRepository.save(estacionamento);
        Veiculo veiculo1 = new Veiculo(TipoVeiculo.CARRO, "azul","a123", "Exemplo");
        Veiculo veiculo2 = new Veiculo(TipoVeiculo.CARRO, "azul", "a124", "Exemplo");
        Veiculo veiculo3 = new Veiculo(TipoVeiculo.CARRO, "azul", "a125", "Exemplo");
        Veiculo veiculo4 = new Veiculo(TipoVeiculo.MOTO, "azul", "a126", "Exemplo");
        veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2, veiculo3, veiculo4));    
        
    }

}
