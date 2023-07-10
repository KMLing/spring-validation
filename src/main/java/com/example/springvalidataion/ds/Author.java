package com.example.springvalidataion.ds;


import com.example.springvalidataion.validators.NotAdmin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotAdmin(message="{author.name.validator.admin}")
    @NotEmpty(message ="{author.name.validator.msg}")
    private String name;

    @NotEmpty(message = "Genre must not be empty.")
    private String genre;


}
