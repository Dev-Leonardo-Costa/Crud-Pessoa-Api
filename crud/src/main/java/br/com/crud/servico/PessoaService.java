package br.com.crud.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.crud.model.Pessoa;

@Service
public class PessoaService {
    
    private final AtomicLong idEncremente = new AtomicLong();

    public Pessoa buscarPorId(String id) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(idEncremente.incrementAndGet());
        pessoa.setNome("Leonardo Costa");
        pessoa.setEmail("leo@gmail.com");
        pessoa.setEnderoco("Rua major celestino 1085");
        pessoa.setSexo("masculino");
        return pessoa;
    }

    public List<Pessoa> buscarTodos(){
       List<Pessoa> pessoas = new ArrayList<>();
       for(int i = 0; i < 8; i++){
            Pessoa pessoa = mockPessoa(i);
            pessoas.add(pessoa);
       } 
       return pessoas;
    }

    private Pessoa mockPessoa(int i) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(idEncremente.incrementAndGet());
        pessoa.setNome("Leonardo Costa"+ i);
        pessoa.setEmail("leo@gmail.com"+ i);
        pessoa.setEnderoco("Rua major celestino 1085"+ i);
        pessoa.setSexo("masculino");
        return pessoa;
    }
}
