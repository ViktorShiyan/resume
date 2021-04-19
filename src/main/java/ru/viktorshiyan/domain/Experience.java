package ru.viktorshiyan.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;

@Entity
@JsonPropertyOrder({"yearStart", "yearFinish", "name", "position", "place", "description"})
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String yearStart;
    private String yearFinish;
    private String name;
    private String position;
    private String place;
    @Column(length = 512)
    private String description;
}
