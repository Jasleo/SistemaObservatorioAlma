package model.bd;

/**
 *
 * @author dumbo
 */
public class CuerpoCeleste {
    private int id;
    private String nombre;
    private float masa;
    private float tamano;
    private int idEstrellaFK;
    private int idTipoDeCuerpoMenorFK;

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

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    public float getTamano() {
        return tamano;
    }

    public void setTamano(float tamano) {
        this.tamano = tamano;
    }

    public int getIdEstrellaFK() {
        return idEstrellaFK;
    }

    public void setIdEstrellaFK(int idEstrellaFK) {
        this.idEstrellaFK = idEstrellaFK;
    }

    public int getIdTipoDeCuerpoMenorFK() {
        return idTipoDeCuerpoMenorFK;
    }

    public void setIdTipoDeCuerpoMenorFK(int idTipoDeCuerpoMenorFK) {
        this.idTipoDeCuerpoMenorFK = idTipoDeCuerpoMenorFK;
    }

}
