package br.com.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.model.Pessoa;
import br.com.crud.servico.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService services;

    @GetMapping
    public List<Pessoa> buscarTodasPessoas(){
        return services.buscarTodos();
    }
    
    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable("id") Long id ){
        return services.buscarPorId(id);
    }
    
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa){
        return services.criarPessoa(pessoa);
    }

   @PutMapping
   public Pessoa atualizar(@RequestBody Pessoa pessoa){
       return services.atualizarPessoa(pessoa);
   }
   
   @DeleteMapping("{id}")
   public ResponseEntity<?> deleta(@PathVariable("id") Long id){
      services.deletarPessoa(id);
      return ResponseEntity.ok().build();
   }
}
