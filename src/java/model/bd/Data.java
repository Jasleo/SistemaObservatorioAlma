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

    public void crearNombreSistemaPlanetario(SistemaPlanetario s) throws SQLException {
        query = "INSERT INTO sistemaPlanetario VALUE(null,'" + s.getNombre() + "')";

        con.ejecutar(query);
    }

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

    public void crearEstrella(Estrella e) throws SQLException {
        query = "INSERT INTO estrella VALUE(null,'" + e.getNombre() + "','" + e.getIdSistemaPlanetarioFK() + "')";

        con.ejecutar(query);
    }

    public void creartTpoDeCuerpoMenor(TipoDeCuerpoMenor tcm) throws SQLException {
        query = "INSERT INTO tipoDeCuerpoMenor VALUE(null,'" + tcm.getNombre() + "')";

        con.ejecutar(query);
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

    public void crearCuerpoCeleste(CuerpoCeleste cc) throws SQLException {
        query = "INSERT INTO estrella VALUE(null,'" + cc.getNombre() + "','" + cc.getMasa() + "','" + cc.getTamaño()
                + "','" + cc.getIdEstrellaFK() + "','" + cc.getIdTiposDeCuerposMenorFK() + "')";

        con.ejecutar(query);
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

    public List<TipoDeCuerpoMenor> getTipoDeCuerpoCeleste() throws SQLException {
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

    public void crearPlaneta(Planeta p) throws SQLException {
        query = "INSERT INTO planeta VALUE(null,'" + p.getNombre() + "','" + p.getSimbologia() + "','" + p.getDiametroEcuatorial()
                + "','" + p.getMasa() + "','" + p.getRadioOrbital() + "','" + p.getPeriodoOrbital() + "','" + p.getPeriodoDeRotación() + "',"
                + "'" + p.getComposiciónAtmosfera() + "','" + p.getIdEstrellaFK() + "','" + p.getIdTipoDePlanetaFK() + "' )";

        con.ejecutar(query);
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

    public void crearSatelite(Satelite s) throws SQLException {
        query = "INSERT INTO satelite VALUE(null,'" + s.getNombre() + "','" + s.getDiametro() + "','" + s.getPeridoOrbitalDia()
                + "','" + s.getPeridoOrbitalHora() + "','" + s.getPeridoOrbitalMInuto() + "'','" + s.getIdPlanetaFK() + "'')";

        con.ejecutar(query);
    }

    public void creacionBasica(SistemaPlanetario s, Estrella e, Planeta p) throws SQLException {
        crearNombreSistemaPlanetario(s);
        e.setIdSistemaPlanetarioFK(getUltimoIdSistemaPlanetario());
        crearEstrella(e);

        p.setIdEstrellaFK(getUltimoIdEstrella());
        crearPlaneta(p);

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

    public List<Planeta> getPlaneta() throws SQLException {
        List<Planeta> list = new ArrayList<>();
        query = "SELECT * FROM Planeta;";
        rs = con.ejecutarSelect(query);

        Planeta p;

        while (rs.next()) {
            p = new Planeta();
            p.setId(rs.getInt(1));
            p.setNombre(rs.getString(2));
            list.add(p);
        }
        con.close();

        return list;
    }

    
}
