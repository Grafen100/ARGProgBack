package com.portfolio.amo.Security.Service;

import com.portfolio.amo.Security.Entity.Administrador;
import com.portfolio.amo.Security.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Grafen Whor
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return Administrador.build(usuario);
    }
}
