package cine.cartelera.cine.entities;


import cine.cartelera.cine.enums.User_Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private User_Role role = User_Role.USER;

    public void setActivo(@NotNull(message = "El estado activo no puede ser nulo") Boolean activo) {}

    public void setRol(@NotBlank(message = "El rol no puede estar vacío") String rol) {}
}
