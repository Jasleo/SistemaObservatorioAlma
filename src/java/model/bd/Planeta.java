package model.bd;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 *
 * @author dumbo
 */
public class Planeta {

    private int id;
    private String nombre;
    private String simbologia;
    private float diametroEcuatorial;
    private float masa;
    private float radioOrbital;
    private float periodoOrbital;
    private float periodoDeRotación;
    private String composiciónAtmosfera;
    private int idEstrellaFK;
    private int idTipoDePlanetaFK;
    private Blob imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbologia() {
        return simbologia;
    }

    public void setSimbologia(String simbologia) {
        this.simbologia = simbologia;
    }

    public float getDiametroEcuatorial() {
        return diametroEcuatorial;
    }

    public void setDiametroEcuatorial(float diametroEcuatorial) {
        this.diametroEcuatorial = diametroEcuatorial;
    }

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    public float getRadioOrbital() {
        return radioOrbital;
    }

    public void setRadioOrbital(float radioOrbital) {
        this.radioOrbital = radioOrbital;
    }

    public float getPeriodoOrbital() {
        return periodoOrbital;
    }

    public void setPeriodoOrbital(float periodoOrbital) {
        this.periodoOrbital = periodoOrbital;
    }

    public float getPeriodoDeRotación() {
        return periodoDeRotación;
    }

    public void setPeriodoDeRotación(float periodoDeRotación) {
        this.periodoDeRotación = periodoDeRotación;
    }

    public String getComposiciónAtmosfera() {
        return composiciónAtmosfera;
    }

    public void setComposiciónAtmosfera(String composiciónAtmosfera) {
        this.composiciónAtmosfera = composiciónAtmosfera;
    }

    public int getIdEstrellaFK() {
        return idEstrellaFK;
    }

    public void setIdEstrellaFK(int idEstrellaFK) {
        this.idEstrellaFK = idEstrellaFK;
    }

    public int getIdTipoDePlanetaFK() {
        return idTipoDePlanetaFK;
    }

    public void setIdTipoDePlanetaFK(int idTipoDePlanetaFK) {
        this.idTipoDePlanetaFK = idTipoDePlanetaFK;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    

    
    
}
