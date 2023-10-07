package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.Factorys.Interfaces.CuentaFactory;
import com.example.jmmoto.model.cuenta.Cuenta;
import javafx.scene.image.Image;

import java.io.Serializable;

public class FactoryCuenta implements CuentaFactory, Serializable {
    @Override
    public Cuenta createCuenta(String usuario, String password, String email) {
        return new Cuenta(usuario, password, email);
    }

    @Override
    public Cuenta createCuentaConFoto(String usuario, String password, String email, Image foto) {
        Cuenta cuenta = new Cuenta(usuario, password, email);
        cuenta.setFoto(foto);
        return cuenta;
    }
}
