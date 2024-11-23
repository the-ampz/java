package br.com.fiap.energysaving.model;

import br.com.fiap.energysaving.dto.user.UpdateUserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "T_AMPZ_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    private String name;

    private String email;

    private String password;

    private LocalDate birthdate;

    // Relacionamento com EnderecoUser
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoUser> enderecos;

    public User(String name, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthdate = birthDate;
    }

    public void update(UpdateUserDTO userDTO){
        if(userDTO.name() != null) this.name = userDTO.name();
        if(userDTO.email() != null) this.email = userDTO.email();
        if(userDTO.password() != null) this.password = userDTO.password();
        if(userDTO.birthDate() != null) this.birthdate = userDTO.birthDate();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
