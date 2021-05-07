package com.kelvin.App1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="People")
public class People implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name="id", unique=true)
    private Integer id;

    @JsonProperty("name")
    @Column(name="name")
    private String name;

    @JsonProperty("address")
    @Column(name="address")
    private String address;

    @JsonProperty("description")
    @Column(name="description")
    private String description;

}
