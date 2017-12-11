package model.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private final Conexion con;
    private ResultSet rs;
    private String query;

    public Data() throws SQLException, ClassNotFoundException {

        con = new Conexion(
                "localhost",
                "bdAlmaAstrologia",//nombre BD
                "root",
                "12345"//Password
        );

    }

    public Usuario getUsuario(String nombre, String contraseña) throws SQLException {
        Usuario u = null;

        rs = con.ejecutarSelect("SELECT * FROM usuario WHERE nombre = '" + nombre + "' "
                + "AND contraseña = '" + contraseña + "' ");

        if (rs.next()) {
            u = new Usuario();

            u.setId(rs.getInt(1));
            u.setNombre(rs.getString(2));
            u.setContraseña(rs.getString(3));
        }

        con.close();
        return u;
    }

    //CREAR DATOS
    public void crearNombreSistemaPlanetario(SistemaPlanetario s) throws SQLException {
        query = "INSERT INTO sistemaPlanetario VALUE(null,'" + s.getNombre() + "')";

        con.ejecutar(query);
    }

    public void crearEstrella(Estrella e) throws SQLException {
        query = "INSERT INTO estrella VALUE(null,'" + e.getNombre() + "','" + e.getIdSistemaPlanetarioFK() + "')";

        con.ejecutar(query);
    }

    public void creartTpoDeCuerpoMenor(TipoDeCuerpoMenor tcm) throws SQLException {
        query = "INSERT INTO tipoDeCuerpoMenor VALUE(null,'" + tcm.getNombre() + "')";

        con.ejecutar(query);
    }

    public void crearCuerpoCeleste(CuerpoCeleste cc) throws SQLException {
        query = "INSERT INTO estrella VALUE(null,'" + cc.getNombre() + "','" + cc.getMasa() + "','" + cc.getTamano()
                + "','" + cc.getIdEstrellaFK() + "','" + cc.getIdTipoDeCuerpoMenorFK() + "')";

        con.ejecutar(query);
    }

    public void crearTipoDePlaneta(TipoDePlaneta tp) throws SQLException {
        query = "INSERT INTO tipoDePlaneta VALUE(null,'" + tp.getNombre() + "')";

        con.ejecutar(query);
    }

    public void crearPlaneta(Planeta p) throws SQLException {
        query = "INSERT INTO planeta VALUE(null,'" + p.getNombre() + "','" + p.getSimbologia() + "','" + p.getDiametroEcuatorial()
                + "','" + p.getMasa() + "','" + p.getRadioOrbital() + "','" + p.getPeriodoOrbital() + "','" + p.getPeriodoDeRotacion() + "',"
                + "'" + p.getComposicionAtmosfera() + "','" + p.getIdEstrellaFK() + "','" + p.getIdTipoDePlanetaFK() + "' )";

        con.ejecutar(query);
    }

    public void crearSatelite(Satelite s) throws SQLException {
        query = "INSERT INTO satelite VALUE(null,'" + s.getNombre() + "','" + s.getDiametro() + "','" + s.getPeridoOrbitalDia()
                + "','" + s.getPeridoOrbitalHora() + "','" + s.getPeridoOrbitalMInuto() + "'','" + s.getIdPlanetaFK() + "'')";

        con.ejecutar(query);
    }

    // READ 
    public List<SistemaPlanetario> getSistemaPlanetario() throws SQLException {
        List<SistemaPlanetario> list = new ArrayList<>();

        query = "SELECT * FROM sistemaPlanetario;";
        rs = con.ejecutarSelect(query);

        SistemaPlanetario est;

        while (rs.next()) {
            est = new SistemaPlanetario();
            est.setId(rs.getInt(1));
            est.setNombre(rs.getString(2));
            list.add(est);
        }
        con.close();

        return list;
    }

    public List<Estrella> getEstrella() throws SQLException {
        List<Estrella> list = new ArrayList<>();

        query = "SELECT * FROM estrella;";
        rs = con.ejecutarSelect(query);

        Estrella est;

        while (rs.next()) {
            est = new Estrella();
            est.setId(rs.getInt(1));
            est.setNombre(rs.getString(2));
            est.setIdSistemaPlanetarioFK(3);
            list.add(est);
        }
        con.close();

        return list;
    }

    public List<TipoDeCuerpoMenor> getTipoDeCuerpoMenor() throws SQLException {
        List<TipoDeCuerpoMenor> list = new ArrayList<>();

        query = "SELECT * FROM tipoDeCuerpoMenor;";
        rs = con.ejecutarSelect(query);

        TipoDeCuerpoMenor tcm;

        while (rs.next()) {
            tcm = new TipoDeCuerpoMenor();
            tcm.setId(rs.getInt(1));
            tcm.setNombre(rs.getString(2));
            list.add(tcm);
        }
        con.close();

        return list;
    }

    public List<CuerpoCeleste> getCuerpoCelestes() throws SQLException {
        List<CuerpoCeleste> list = new ArrayList<>();
        query = "SELECT * FROM cuerpoCeleste;";
        rs = con.ejecutarSelect(query);

        CuerpoCeleste cc;

        while (rs.next()) {
            cc = new CuerpoCeleste();
            cc.setId(rs.getInt(1));
            cc.setNombre(rs.getString(2));
            cc.setMasa(rs.getFloat(3));
            cc.setTamano(rs.getFloat(4));
            cc.setIdEstrellaFK(rs.getInt(5));
            cc.setIdTipoDeCuerpoMenorFK(rs.getInt(6));
            list.add(cc);
        }
        con.close();

        return list;
    }

    public List<TipoDePlaneta> getTipoDePlaneta() throws SQLException {
        List<TipoDePlaneta> list = new ArrayList<>();
        query = "SELECT * FROM tipoDePlaneta;";
        rs = con.ejecutarSelect(query);

        TipoDePlaneta tp;

        while (rs.next()) {
            tp = new TipoDePlaneta();
            tp.setId(rs.getInt(1));
            tp.setNombre(rs.getString(2));
            list.add(tp);
        }
        con.close();

        return list;
    }

    public List<Planeta> getPlaneta() throws SQLException {
        List<Planeta> list = new ArrayList<>();
        query = "SELECT * FROM planeta;";
        rs = con.ejecutarSelect(query);

        Planeta p;

        while (rs.next()) {
            p = new Planeta();
            p.setId(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setSimbologia(rs.getString(3));
            p.setDiametroEcuatorial(rs.getFloat(4));
            p.setMasa(rs.getFloat(5));
            p.setRadioOrbital(rs.getFloat(6));
            p.setPeriodoOrbital(rs.getFloat(7));
            p.setPeriodoDeRotacion(rs.getFloat(8));
            p.setComposicionAtmosfera(rs.getString(9));
            p.setIdEstrellaFK(rs.getInt(10));
            p.setIdTipoDePlanetaFK(rs.getInt(11));

            list.add(p);
        }
        con.close();

        return list;
    }

    public List<Satelite> getSatelite() throws SQLException {
        List<Satelite> list = new ArrayList<>();
        query = "SELECT * FROM satelite;";
        rs = con.ejecutarSelect(query);

        Satelite s;

        while (rs.next()) {
            s = new Satelite();
            s.setId(rs.getInt(1));
            s.setNombre(rs.getString(2));
            s.setDiametro(rs.getFloat(3));
            s.setPeridoOrbitalDia(rs.getFloat(4));
            s.setPeridoOrbitalHora(rs.getFloat(5));
            s.setPeridoOrbitalMInuto(rs.getFloat(6));
            s.setIdPlanetaFK(rs.getInt(7));

            list.add(s);
        }
        con.close();

        return list;
    }

    //READ nombre
    public String getPlanetaBy(String idPlaneta) throws SQLException {
        query = "SELECT nombre FROM planeta WHERE id = " + idPlaneta + ";";
        String nombre = null;
        rs = con.ejecutarSelect(query);

        if (rs.next()) {
            nombre = rs.getString(1);
        }

        con.close();
        return nombre;
    }

    public String getSistemaPlanetarioBy(String idSistemaPlanetario) throws SQLException {
        query = "SELECT nombre FROM sistemaPlanetario WHERE id = " + idSistemaPlanetario + ";";
        String nombre = null;
        rs = con.ejecutarSelect(query);

        if (rs.next()) {
            nombre = rs.getString(1);
        }

        con.close();
        return nombre;
    }

    public String getEstrellaBy(String idEstrella) throws SQLException {
        query = "SELECT nombre FROM estrella WHERE id = " + idEstrella + ";";
        String nombre = null;
        rs = con.ejecutarSelect(query);

        if (rs.next()) {
            nombre = rs.getString(1);
        }

        con.close();
        return nombre;
    }

    public String getCuerpoCelesteBy(String idCuerpoCeleste) throws SQLException {
        query = "SELECT nombre FROM cuerpoCeleste WHERE id = " + idCuerpoCeleste + ";";
        String nombre = null;
        rs = con.ejecutarSelect(query);

        if (rs.next()) {
            nombre = rs.getString(1);
        }

        con.close();
        return nombre;
    }

    public String getTipoDeCuerpoMenorBy(String idTipoDeCuerpoMenor) throws SQLException {
        query = "SELECT nombre FROM tipoDeCuerpoMenor WHERE id = " + idTipoDeCuerpoMenor + ";";
        String nombre = null;
        rs = con.ejecutarSelect(query);

        if (rs.next()) {
            nombre = rs.getString(1);
        }

        con.close();
        return nombre;
    }

    public String getTipoDePlanetaBy(String idTipoDePlaneta) throws SQLException {
        query = "SELECT nombre FROM tipoDePlaneta WHERE id = " + idTipoDePlaneta + ";";
        String nombre = null;
        rs = con.ejecutarSelect(query);

        if (rs.next()) {
            nombre = rs.getString(1);
        }

        con.close();
        return nombre;
    }

    public String getSateliteBy(String idSatelite) throws SQLException {
        query = "SELECT nombre FROM satelite WHERE id = " + idSatelite + ";";
        String nombre = null;
        rs = con.ejecutarSelect(query);

        if (rs.next()) {
            nombre = rs.getString(1);
        }

        con.close();
        return nombre;
    }

    // UPDATE
    public void updateNombreSistemaPlanetario(int idSistema, SistemaPlanetario s) throws SQLException {
        query = "UPDATE  sistemaPlanetario SET nombre = '" + s.getNombre() + "' WHERE id = " + idSistema + "";

        con.ejecutar(query);
    }

    public void updateTipoDePlaneta(int idTipoDePlaneta, TipoDePlaneta tp) throws SQLException {
        query = "UPDATE  tipoDePlaneta SET nombre = '" + tp.getNombre() + "' WHERE id = " + idTipoDePlaneta + "";

        con.ejecutar(query);
    }

    public void updateEstrella(int idEstrella, Estrella est) throws SQLException {
        query = "UPDATE  estrella SET nombre = '" + est.getNombre() + "', idSistemaPlanetarioFK = '" + est.getIdSistemaPlanetarioFK() + "'"
                + " WHERE id = " + idEstrella + "";

        con.ejecutar(query);
    }

    public void updateTpoDeCuerpoMenor(int idTipoDeCuerpoMenor, TipoDeCuerpoMenor tcm) throws SQLException {
        query = "UPDATE  updateTpoDeCuerpoMenor SET nombre = '" + tcm.getNombre() + "' WHERE id = " + idTipoDeCuerpoMenor + "";

        con.ejecutar(query);
    }

    public void updateCuerpoCeleste(int idCuerpoCeleste, CuerpoCeleste cc) throws SQLException {
        query = "UPDATE cuerpoCeleste SET nombre = '" + cc.getNombre() + "' ,"
                + " masa = '" + cc.getMasa() + "' , tamano = '" + cc.getTamano() + "', idEstrellaFK = '" + cc.getIdEstrellaFK() + ""
                + "', idTipoDeCuerpoMenorFK = '" + cc.getIdTipoDeCuerpoMenorFK() + "' "
                + "WHERE id = " + idCuerpoCeleste + "";

        con.ejecutar(query);
    }

    public void updatePlaneta(int idPlaneta, Planeta p) throws SQLException {
        query = "UPDATE cuerpoCeleste SET nombre = '" + p.getNombre() + "' ,"
                + " simbologia = '" + p.getSimbologia() + "' , diametroEcuatorial = '" + p.getDiametroEcuatorial() + "', masa = '" + p.getMasa() + ""
                + "', radioOrbital = '" + p.getRadioOrbital() + "' , periodoOrbital = '" + p.getPeriodoOrbital()
                + "'  , periodoDeRotacion = '" + p.getPeriodoDeRotacion() + "' , composicionAtmosfera = '" + p.getComposicionAtmosfera() + ""
                + "' , idEstrellaFK = '" + p.getIdEstrellaFK() + "' , idTipoDePLanetaFK = '" + p.getIdTipoDePlanetaFK() + "' "
                + "WHERE id = " + idPlaneta + "";

        con.ejecutar(query);
    }

    public void updateSatelite(int idSatelite, Satelite s) throws SQLException {
        query = "UPDATE  satelite SET nombre = '" + s.getNombre() + "', diametro = '" + s.getDiametro() + "' "
                + ", peridoOrbitalDia = '" + s.getPeridoOrbitalDia() + "' , peridoOrbitalHora = '" + s.getPeridoOrbitalDia() + "' "
                + ", peridoOrbitalMInuto = '" + s.getPeridoOrbitalMInuto() + "' , idPlanetaFK = '" + s.getIdPlanetaFK() + "'"
                + " WHERE id = " + idSatelite + "";

        con.ejecutar(query);
    }

    // Delete
    public void eliminarNombreSistemaPlanetario(int idSistemaPlanetario) throws SQLException {
        query = "DELETE FROM sistemaPlanetario WHERE id = " + idSistemaPlanetario + "";
        con.ejecutar(query);
    }

    public void eliminarEstrella(int idEstrella) throws SQLException {
        query = "DELETE FROM estrella WHERE id = " + idEstrella + "";
        con.ejecutar(query);
    }

    public void eliminarTipoDeCuerpoMenor(int idTipoDeCuerpoMenor) throws SQLException {
        query = "DELETE FROM tipoDeCuerpoMenor WHERE id = " + idTipoDeCuerpoMenor + "";
        con.ejecutar(query);
    }

    public void eliminarCuerpoCeleste(int idCuerpoCeleste) throws SQLException {
        query = "DELETE FROM cuerpoCeleste WHERE id = " + idCuerpoCeleste + "";
        con.ejecutar(query);
    }

    public void eliminarTipoDePlaneta(int idTipoDePlaneta) throws SQLException {
        query = "DELETE FROM tipoDePlaneta WHERE id = " + idTipoDePlaneta + "";
        con.ejecutar(query);
    }

    public void eliminarPlaneta(int idPlaneta) throws SQLException {
        query = "DELETE FROM planeta WHERE id = " + idPlaneta + "";
        con.ejecutar(query);
    }

    public void eliminarSatelite(int idSatelite) throws SQLException {
        query = "DELETE FROM satelite WHERE id = " + idSatelite + "";
        con.ejecutar(query);
    }

    //OTRAS CONSULTAS
    private int getUltimoIdSistemaPlanetario() throws SQLException {
        int ultimaId = 0;
        String lastId = "SELECT MAX(id) FROM sistemaPlanetario;";
        rs = con.ejecutarSelect(lastId);

        SistemaPlanetario s = new SistemaPlanetario();
        if (rs.next()) {
            s.setId(rs.getInt(1));
            ultimaId = s.getId();
        }
        con.close();
        return ultimaId;
    }

    private int getUltimoIdsatelite() throws SQLException {
        int ultimaId = 0;
        String lastId = "SELECT MAX(id) FROM satelite;";
        rs = con.ejecutarSelect(lastId);

        Satelite s = new Satelite();
        if (rs.next()) {
            s.setId(rs.getInt(1));
            ultimaId = s.getId();
        }
        con.close();
        return ultimaId;
    }

    private int getUltimoIdEstrella() throws SQLException {
        int ultimaId = 0;
        String lastId = "SELECT MAX(id) FROM estrella;";
        rs = con.ejecutarSelect(lastId);

        Estrella e = new Estrella();
        if (rs.next()) {
            e.setId(rs.getInt(1));
            ultimaId = e.getId();
        }
        con.close();
        return ultimaId;
    }

    private int getUltimoIdTpoDeCuerpoMenor() throws SQLException {
        int ultimaId = 0;
        String lastId = "SELECT MAX(id) FROM tipoDeCuerpoMenor;";
        rs = con.ejecutarSelect(lastId);

        TipoDeCuerpoMenor tcm = new TipoDeCuerpoMenor();
        if (rs.next()) {
            tcm.setId(rs.getInt(1));
            ultimaId = tcm.getId();
        }
        con.close();
        return ultimaId;
    }

    public List<SistemaEstrellaPlanetaSelect> getSistemaEstrellaPlanetaSelect() throws SQLException {

        String query = "SELECT sistemaPlanetario.nombre, estrella.nombre, tipoDePlaneta.nombre,"
                + "planeta.nombre, planeta.simbologia, planeta.diametroEcuatorial, planeta,masa ,"
                + "planeta.radioOrbital, planeta.periodoOrbital, planeta.periodoDeRotación, planeta.composiciónAtmosfera"
                + "FROM "
                + "INNER JOIN sistemaPlanetario ON estrella.idSistemaPlanetarioFK = sistemaPlanetario.id ;"
                + "INNER JOIN planeta ON planeta.idEstrellaFK = estrella.id ;"
                + "INNER JOIN tipoDePlaneta ON planeta.idTipoDePLanetaFK = tipoDePlaneta.id ;";

        rs = con.ejecutarSelect(query);

        List<SistemaEstrellaPlanetaSelect> listSistemaPlanterioBasico = new ArrayList<>();
        SistemaEstrellaPlanetaSelect seps;

        while (rs.next()) {
            seps = new SistemaEstrellaPlanetaSelect();

            seps.setNombre(rs.getString(1));
            seps.setNombreEstrella(rs.getString(2));
            seps.setNombreTipoPlaneta(rs.getString(3));
            seps.setNombrePlaneta(rs.getString(4));
            seps.setSimbologiaPlaneta(rs.getString(5));
            seps.setDiametroEcuatorialPlaneta(rs.getFloat(6));
            seps.setDiametroEcuatorialPlaneta(rs.getFloat(7));
            seps.setMasaPlaneta(rs.getFloat(8));
            seps.setRadioOrbitalPlaneta(rs.getFloat(9));
            seps.setPeriodoOrbitalPlaneta(rs.getFloat(10));
            seps.setPeriodoDeRotaciónPlaneta(rs.getFloat(11));
            seps.setComposiciónAtmosfera(rs.getString(12));

            listSistemaPlanterioBasico.add(seps);
        }
        con.close();
        return listSistemaPlanterioBasico;
    }

    public void creacionBasica(SistemaPlanetario s, Estrella e, Planeta p) throws SQLException {
        crearNombreSistemaPlanetario(s);
        e.setIdSistemaPlanetarioFK(getUltimoIdSistemaPlanetario());
        crearEstrella(e);

        p.setIdEstrellaFK(getUltimoIdEstrella());
        crearPlaneta(p);

    }
}
