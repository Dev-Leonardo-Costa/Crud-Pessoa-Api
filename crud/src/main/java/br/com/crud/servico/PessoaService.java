package br.com.crud.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.exceptions.OperacaoPessoaNaoSuportada;
import br.com.crud.model.Pessoa;
import br.com.crud.repositorys.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa criarPessoa(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Pessoa pessoa){
        Pessoa entitade = repository.findById(pessoa.getId())
                .orElseThrow(()-> new OperacaoPessoaNaoSuportada("Pessoa não encontrada!"));
                entitade.setNome(pessoa.getNome());
                entitade.setEmail(pessoa.getEmail());
                entitade.setEnderoco(pessoa.getEnderoco());
                entitade.setSexo(pessoa.getSexo());
                return repository.save(entitade); 
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoa = repository.findById(id)
         .orElseThrow(()-> new OperacaoPessoaNaoSuportada("Pessoa não encontrada!"));
         repository.delete(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new OperacaoPessoaNaoSuportada("Pessoa não encontrada!"));
    }

    public List<Pessoa> buscarTodos(){
      return repository.findAll();
    }

}
