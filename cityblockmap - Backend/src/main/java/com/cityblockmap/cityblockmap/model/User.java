package com.cityblockmap.cityblockmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_users")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)

    @ManyToMany//(cascade = CascadeType.PERSIST) // Assim que salvar o User, o JPA Já salva também o Neighborhood de forma automatica
    @JoinTable(
            name = "tb_user_neighborhood",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "neighborhood_id")
    )
    @JsonIgnore
    private List<Neighborhood> neighborhoods;
}
