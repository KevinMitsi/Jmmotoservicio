package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.cuenta.Cuenta;
import javafx.scene.image.Image;

import java.io.Serializable;

public class FactoryCuenta implements Serializable {

    public static Cuenta createCuenta(String usuario, String password) {
        return new Cuenta(usuario, password);
    }


    public static Cuenta createCuentaConFoto(String usuario, String password,Image foto) {
        Cuenta cuenta = new Cuenta(usuario, password);
        cuenta.setFoto(foto);
        return cuenta;
    }
}
