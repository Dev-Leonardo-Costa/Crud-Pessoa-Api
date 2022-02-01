package br.com.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity@Table(name = "PESSOA")
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "NOME", length = 50, nullable = false )
    private String nome;
    @Column(name = "EMAIL", length = 50, nullable = false )
    private String email;
    @Column(name = "ENDERECO", length = 50, nullable = false )
    private String enderoco;
    @Column(name = "SEXO", length = 50, nullable = false )
    private String sexo;

}
