package model.bd;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 *
 * @author dumbo
 */
public class Satelite {

    private int id;
    private String nombre;
    private float diametro;
    private Timestamp peridoOrbitalDia;
    private Timestamp peridoOrbitalHora;
    private Timestamp peridoOrbitalMInuto;
    private int idPlanetaFK;
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

    public float getDiametro() {
        return diametro;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public Timestamp getPeridoOrbitalDia() {
        return peridoOrbitalDia;
    }

    public void setPeridoOrbitalDia(Timestamp peridoOrbitalDia) {
        this.peridoOrbitalDia = peridoOrbitalDia;
    }

    public Timestamp getPeridoOrbitalHora() {
        return peridoOrbitalHora;
    }

    public void setPeridoOrbitalHora(Timestamp peridoOrbitalHora) {
        this.peridoOrbitalHora = peridoOrbitalHora;
    }

    public Timestamp getPeridoOrbitalMInuto() {
        return peridoOrbitalMInuto;
    }

    public void setPeridoOrbitalMInuto(Timestamp peridoOrbitalMInuto) {
        this.peridoOrbitalMInuto = peridoOrbitalMInuto;
    }

    public int getIdPlanetaFK() {
        return idPlanetaFK;
    }

    public void setIdPlanetaFK(int idPlanetaFK) {
        this.idPlanetaFK = idPlanetaFK;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
    
    

}
