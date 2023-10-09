package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.marcamoto.MarcaMoto;

import java.io.Serializable;
import java.util.ArrayList;


public class FactoryMarca implements Serializable {

    public static MarcaMoto createMarcaMoto(String nombre, String paisOrigen, String especializacion, String publicoObjetivo, String sitioweb) {
        MarcaMoto marcaMoto = new MarcaMoto(nombre, paisOrigen, especializacion, publicoObjetivo, sitioweb);
        marcaMoto.setId(String.valueOf(marcaMoto.hashCode()));
        marcaMoto.setMotosMarca(new ArrayList<>());
        marcaMoto.setLogo(null);
        return marcaMoto;
    }
}