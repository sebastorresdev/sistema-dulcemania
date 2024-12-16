package com.api.dulcemaria.helpers.usuarios;

import com.api.dulcemaria.contracts.usuarios.CreateUsuarioRequest;
import com.api.dulcemaria.contracts.usuarios.GetUsuarioResponse;
import com.api.dulcemaria.models.Rol;
import com.api.dulcemaria.models.Usuario;
import com.api.dulcemaria.repositories.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapping implements IUsuarioMapping{

    @Autowired
    private IRolRepository _rolRepository;

    @Override
    public Usuario convertToUsuario(CreateUsuarioRequest request) {

        Rol rol = _rolRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("No se encontro el rol con ID:" + 2));;

        Usuario usuario = new Usuario();
        usuario.setClave("123456");
        usuario.setEmail(request.email());
        usuario.setIdentificador(request.identificador());
        usuario.setNombreCompleto(request.nombreCompleto());
        usuario.setRol(rol);

        return usuario;
    }

    @Override
    public GetUsuarioResponse convetToGetUsuarioResponse(Usuario usuario) {
        return new GetUsuarioResponse(
                usuario.getNombreCompleto(),
                usuario.getEmail(),
                usuario.getIdentificador()
        );
    }
}
