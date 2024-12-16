package com.api.dulcemaria.services;

import com.api.dulcemaria.contracts.usuarios.CreateUsuarioRequest;
import com.api.dulcemaria.contracts.usuarios.GetUsuarioResponse;
import com.api.dulcemaria.helpers.usuarios.IUsuarioMapping;
import com.api.dulcemaria.models.Usuario;
import com.api.dulcemaria.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository _usuarioRepository;

    @Autowired
    IUsuarioMapping _mapping;

    public GetUsuarioResponse buscarUsuarioPorIdentificador(String identificador) {
        Optional<Usuario> usuario = _usuarioRepository.findByIdentificador(identificador);
        return usuario.map(value -> _mapping.convetToGetUsuarioResponse(value)).orElse(null);
    }

    public GetUsuarioResponse registrarUsuario(CreateUsuarioRequest request) {
        Usuario usuario = _mapping.convertToUsuario(request);
        Optional<Usuario> existeUsuario = _usuarioRepository.findByIdentificador(usuario.getIdentificador());

        if(existeUsuario.isPresent()){
            return null;
        }
        return _mapping.convetToGetUsuarioResponse(_usuarioRepository.save(usuario));
    }
}
