package com.estacionamento.app.config;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.entities.Registro;
import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.entities.auxiliares.DadosPessoais;
import com.estacionamento.app.entities.auxiliares.Endereco;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;
import com.estacionamento.app.repository.EstacionamentoRepository;
import com.estacionamento.app.repository.RegistroRepository;
import com.estacionamento.app.repository.VagaRepository;
import com.estacionamento.app.repository.VeiculoRepository;

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
        Endereco endereco = new Endereco("rua tal", "privareva", "766666", "exemplo", "RO", null, "12-B");
        DadosPessoais dados = new DadosPessoais("empresaNome", "123456", "123");
        Estacionamento estacionamento = new Estacionamento(dados, endereco, 10, 10, 10.00);
        estacionamentoRepository.save(estacionamento);
        Vaga vaga1 = new Vaga("A", TipoVeiculo.CARRO, estacionamento);
        Vaga vaga2 = new Vaga("B", TipoVeiculo.CARRO, estacionamento);
        Vaga vaga3 = new Vaga("C", TipoVeiculo.MOTO, estacionamento);
        vagaRepository.saveAll(Arrays.asList(vaga1, vaga2, vaga3));
        
        Veiculo veiculo1 = new Veiculo(TipoVeiculo.CARRO, "azul","a123", "Exemplo");
        Veiculo veiculo2 = new Veiculo(TipoVeiculo.CARRO, "azul", "a124", "Exemplo");
        Veiculo veiculo3 = new Veiculo(TipoVeiculo.CARRO, "azul", "a125", "Exemplo");
        Veiculo veiculo4 = new Veiculo(TipoVeiculo.MOTO, "azul", "a126", "Exemplo");
        veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2, veiculo3, veiculo4));
        Registro reg1 = new Registro(vaga1, veiculo1, OffsetDateTime.now());
        registroRepository.save(reg1);  
        
    }

}
