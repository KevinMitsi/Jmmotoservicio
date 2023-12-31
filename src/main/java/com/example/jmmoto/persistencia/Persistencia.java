package com.example.jmmoto.persistencia;
import com.example.jmmoto.model.Taller;


public class Persistencia {
    public static final String RUTA_ARCHIVO_LOG = "src/main/java/com/example/jmmoto/archivo/Log.log";
    public static final String RUTA_ARCHIVO_MODELO_TALLER_BINARIO = "src/main/java/com/example/jmmoto/archivo/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_TALLER_XML = "src/main/java/com/example/jmmoto/archivo/model.xml";


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    //------------------------------------SERIALIZACI�N  y XML


    public static Taller cargarRecursoHostalBinario() {

        Taller taller = null;

        try {
            taller = (Taller) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_TALLER_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return taller;
    }

    public static void guardarRecursoDomainBinario(Taller taller) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_TALLER_BINARIO, taller);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Taller cargarRecursoDomainXML() {

        Taller taller = null;

        try {
            taller = (Taller) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_TALLER_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return taller;
    }



    public static void guardarRecursoDomainXML(Taller taller) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_TALLER_XML, taller);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}