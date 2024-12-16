package com.api.dulcemaria.helpers.usuarios;

import com.api.dulcemaria.contracts.usuarios.CreateUsuarioRequest;
import com.api.dulcemaria.contracts.usuarios.GetUsuarioResponse;
import com.api.dulcemaria.models.Usuario;

public interface IUsuarioMapping {
    Usuario convertToUsuario(CreateUsuarioRequest request);
    GetUsuarioResponse convetToGetUsuarioResponse(Usuario usuario);
}
