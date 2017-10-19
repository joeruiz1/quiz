/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author LabingXEON
 */
public class UnidadAbstracta {
    private int  idUnidad;
    private int id;
    private int idTabla;

    public UnidadAbstracta(int idUnidad, int id, int idTabla) {
        this.idUnidad = idUnidad;
        this.id = id;
        this.idTabla = idTabla;
    }

    public UnidadAbstracta() {
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }
    
    
}
