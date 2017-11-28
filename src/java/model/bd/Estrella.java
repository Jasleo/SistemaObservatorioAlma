package model.bd;

/**
 *
 * @author dumbo
 */
public class Estrella {
    private int id;
    private String nombre;
    private int idSistemaPlanetarioFK;

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

    public int getIdSistemaPlanetarioFK() {
        return idSistemaPlanetarioFK;
    }

    public void setIdSistemaPlanetarioFK(int idSistemaPlanetarioFK) {
        this.idSistemaPlanetarioFK = idSistemaPlanetarioFK;
    }
    
    
    
}
