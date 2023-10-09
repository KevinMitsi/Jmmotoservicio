package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.productos.Producto;
import com.example.jmmoto.model.procedimiento.Procedimiento;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.List;

public class FactoryProcedimiento implements Serializable {

    public static Procedimiento createProcedimiento(String nombre, String descripcion, String tiempoEstimado, String nivelDificultad,
                                             String fechaRealizacion, Tecnico tecnicoDueno, Moto motoIntervenida,
                                             List<String> pasos, Image foto, List<Producto> productosUtilizados) {
        Procedimiento procedimiento = new Procedimiento(nombre, descripcion, tiempoEstimado, nivelDificultad,
                fechaRealizacion, tecnicoDueno, motoIntervenida);
        procedimiento.setPasos(pasos);
        procedimiento.setFoto(foto);
        procedimiento.setProductosUtilizados(productosUtilizados);
        return procedimiento;
    }
}