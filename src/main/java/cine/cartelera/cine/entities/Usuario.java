package cine.cartelera.cine.entities;

import cine.cartelera.cine.enums.User_Role;
import jakarta.persistence.*;
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

    @Column(nullable = false, unique = true)
    private String email;

    @Builder.Default
    private Boolean isActive = true;


    @Enumerated(EnumType.STRING)
    @Column(name = "role" , nullable = false)
    private User_Role role;

    // Setter correcto para isActive
    public void setIsActive(@NotNull(message = "El estado activo no puede ser nulo") Boolean isActive) {
        this.isActive = isActive;
    }

    // Setter correcto para role
    public void setRole(@NotNull(message = "El rol no puede ser nulo") User_Role role) {
        this.role = role;
    }

    public void ifPresent(Object usuario) {
    }

}
