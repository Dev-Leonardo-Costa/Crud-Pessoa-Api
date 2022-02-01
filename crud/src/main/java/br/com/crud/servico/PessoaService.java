package br.com.crud.servico;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.crud.model.Pessoa;

@Service
public class PessoaService {
    
    private final AtomicLong idEncremente = new AtomicLong();

    public Pessoa findById(String id) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(idEncremente.incrementAndGet());
        pessoa.setNome("Leonardo Costa");
        pessoa.setEmail("leo@gmail.com");
        pessoa.setEnderoco("Rua major celestino 1085");
        pessoa.setSexo("masculino");
        return pessoa;
    }
}
