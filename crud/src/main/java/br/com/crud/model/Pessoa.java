package br.com.crud.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pessoa implements Serializable{
    
    private static final long serialVersionUDT = 1L;

    private long id;
    private String nome;
    private String email;
    private String enderoco;
    private String sexo;

}
