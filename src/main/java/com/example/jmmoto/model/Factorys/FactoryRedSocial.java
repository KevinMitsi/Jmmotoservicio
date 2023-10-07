package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.Factorys.Interfaces.RedSocialFactory;
import com.example.jmmoto.model.redsocial.RedSocial;

import java.io.Serializable;

public class FactoryRedSocial implements RedSocialFactory, Serializable {
    @Override
    public RedSocial crearRedSocial(String nombre, String url) {
        return new RedSocial(nombre, url);
    }
}