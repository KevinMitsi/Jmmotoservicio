package com.example.jmmoto.model.Factorys.Interfaces;

import com.example.jmmoto.model.cuenta.Cuenta;
import javafx.scene.image.Image;

public interface CuentaFactory {
    Cuenta createCuenta(String usuario, String password, String email);
    Cuenta createCuentaConFoto(String usuario, String password, String email, Image foto);
}
