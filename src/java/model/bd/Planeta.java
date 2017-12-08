package model.bd;

public class Planeta {

    private int id;
    private String nombre;
    private String simbologia;
    private float diametroEcuatorial;
    private float masa;
    private float radioOrbital;
    private float periodoOrbital;
    private float periodoDeRotacion;
    private String composicionAtmosfera;
    private int idEstrellaFK;
    private int idTipoDePlanetaFK;

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

    public float getPeriodoDeRotacion() {
        return periodoDeRotacion;
    }

    public void setPeriodoDeRotacion(float periodoDeRotacion) {
        this.periodoDeRotacion = periodoDeRotacion;
    }

    public String getComposicionAtmosfera() {
        return composicionAtmosfera;
    }

    public void setComposicionAtmosfera(String composicionAtmosfera) {
        this.composicionAtmosfera = composicionAtmosfera;
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

}
