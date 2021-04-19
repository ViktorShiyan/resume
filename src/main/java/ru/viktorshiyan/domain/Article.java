package ru.viktorshiyan.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String Title;
    private String Text;

    @ManyToOne
    private Person owner;

}
