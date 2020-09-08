package br.com.meloafc.redis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa implements Serializable {

    public static final String CACHE_NAME = "Pessoa";

    @Id
    private Long id;
    private String nome;

}
