package cine.cartelera.cine.entities;


import cine.cartelera.cine.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false , unique = true)
    private String email;

    // Por defecto todos los usuarios están activos
    @Builder.Default
    private Boolean isActive = true;

    // Guardo el rol como texto
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)

    // Por defecto todos los usuarios son USER, no ADMIN
    @Builder.Default
    private UserRole role = UserRole.USER;


}
