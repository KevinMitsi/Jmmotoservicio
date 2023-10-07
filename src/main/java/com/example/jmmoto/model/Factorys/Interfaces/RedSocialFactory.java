package com.example.jmmoto.model.Factorys.Interfaces;
import com.example.jmmoto.model.redsocial.RedSocial;

public interface RedSocialFactory {
    RedSocial crearRedSocial(String nombre, String url);
}