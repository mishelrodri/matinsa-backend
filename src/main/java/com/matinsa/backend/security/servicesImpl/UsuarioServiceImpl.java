package com.matinsa.backend.security.servicesImpl;

import com.matinsa.backend.security.dto.JwtDto;
import com.matinsa.backend.security.dto.LoginUsuario;
import com.matinsa.backend.security.dto.Mensaje;
import com.matinsa.backend.security.dto.NuevoUsuario;
import com.matinsa.backend.security.entities.Rol;
import com.matinsa.backend.security.entities.Usuario;
import com.matinsa.backend.security.exceptions.CustomException;
import com.matinsa.backend.security.jwt.JwtProvider;
import com.matinsa.backend.security.repositories.UsuarioRepository;
import com.matinsa.backend.security.services.RolService;
import com.matinsa.backend.security.services.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final RolService rolService;

    private final JwtProvider jwtProvider;

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEmail) {
        return usuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail);
    }

    @Override
    public Optional<Usuario> getByTokenPassword(String tokenPassword) {
        return usuarioRepository.findByTokenPassword(tokenPassword);
    }

    @Override
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public JwtDto login(LoginUsuario loginUsuario) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.nombreUsuario(), loginUsuario.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        return new JwtDto(jwt);
    }

    @Override
    public JwtDto refresh(JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        return new JwtDto(token);
    }

    @Override
    public Mensaje save(NuevoUsuario nuevoUsuario) {
        if (usuarioRepository.existsByNombreUsuario(nuevoUsuario.nombreUsuario()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
        if (usuarioRepository.existsByEmail(nuevoUsuario.email()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "ese email de usuario ya existe");

        Optional<Rol> rolOptional = rolService.getById(nuevoUsuario.rol());
        Rol rolUsuario = rolOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No se encontró el rol con el ID"));

        Usuario usuario = new Usuario(
                nuevoUsuario.nombre(),
                nuevoUsuario.nombreUsuario(),
                nuevoUsuario.email(),
                passwordEncoder.encode(nuevoUsuario.password())
        );
        usuario.setRol(rolUsuario);

        usuarioRepository.save(usuario);

        return new Mensaje(usuario.getNombreUsuario() + " ha sido creado");
    }

}