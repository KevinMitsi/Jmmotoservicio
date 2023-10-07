package com.example.jmmoto.model.Factorys.Interfaces;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.procedimiento.Procedimiento;
import com.example.jmmoto.model.productos.Producto;
import javafx.scene.image.Image;

import java.util.List;

public interface ProcedimientoFactory {
    Procedimiento createProcedimiento(String nombre, String descripcion, String tiempoEstimado, String nivelDificultad,
                                      String fechaRealizacion, Tecnico tecnicoDueno, Moto motoIntervenida,
                                      List<String> pasos, Image foto, List<Producto> productosUtilizados);
}