package com.spring.security.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authoritie_name")
    private String authoritieName;

    @ManyToMany(mappedBy = "authorities")
    private List<User> users = new ArrayList<>();

}
