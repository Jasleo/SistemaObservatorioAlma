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
    private float peridoOrbitalDia;
    private float peridoOrbitalHora;
    private float peridoOrbitalMInuto;
    private int idPlanetaFK;

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

    public float getPeridoOrbitalDia() {
        return peridoOrbitalDia;
    }

    public void setPeridoOrbitalDia(float peridoOrbitalDia) {
        this.peridoOrbitalDia = peridoOrbitalDia;
    }

    public float getPeridoOrbitalHora() {
        return peridoOrbitalHora;
    }

    public void setPeridoOrbitalHora(float peridoOrbitalHora) {
        this.peridoOrbitalHora = peridoOrbitalHora;
    }

    public float getPeridoOrbitalMInuto() {
        return peridoOrbitalMInuto;
    }

    public void setPeridoOrbitalMInuto(float peridoOrbitalMInuto) {
        this.peridoOrbitalMInuto = peridoOrbitalMInuto;
    }

    public int getIdPlanetaFK() {
        return idPlanetaFK;
    }

    public void setIdPlanetaFK(int idPlanetaFK) {
        this.idPlanetaFK = idPlanetaFK;
    }

}
