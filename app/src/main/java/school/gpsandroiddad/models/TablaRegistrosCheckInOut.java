package school.gpsandroiddad.models;

/**
 * Created by Vizardespa on 05/06/2015.
 */
public class TablaRegistrosCheckInOut {

    int IdRegistroCheckInOut;
    int IdUsuario;
    String NombreTrabajador;
    String CodigoEmpleado;
    String TipoCheck;
    String Fecha;
    String Latitud;
    String Longitud;
    String Notas;

    public TablaRegistrosCheckInOut(int idRegistroCheckInOut, int idUsuario, String nombreTrabajador, String codigoEmpleado,
            String tipoCheck, String fecha, String latitud, String longitud, String notas) {
        super();
        this.IdRegistroCheckInOut = idRegistroCheckInOut;
        this.IdUsuario= idUsuario;
        this.NombreTrabajador= nombreTrabajador;
        this.CodigoEmpleado= codigoEmpleado;
        this.TipoCheck= tipoCheck;
        this.Fecha= fecha;
        this.Latitud= latitud;
        this.Longitud= longitud;
        this.Notas= notas;
    }

    public TablaRegistrosCheckInOut() {
        super();
        this.IdRegistroCheckInOut = 0;
        this.IdUsuario= 0;
        this.NombreTrabajador= null;
        this.CodigoEmpleado= null;
        this.TipoCheck= null;
        this.Fecha= null;
        this.Latitud= null;
        this.Longitud= null;
        this.Notas= null;
    }

    public int getIdRegistroCheckInOut()
    {
        return IdRegistroCheckInOut;
    }
    public void setIdRegistroCheckInOut(int idRegistroCheckInOut)
    {
        this.IdRegistroCheckInOut= idRegistroCheckInOut;
    }

    public int getIdIdUsuario()
    {
        return IdUsuario;
    }
    public void setIdUsuario(int idUsuario)
    {
        this.IdUsuario= idUsuario;
    }

    public String getNombreTrabajador()
    {
        return NombreTrabajador;
    }
    public void setNombreTrabajador(String nombreTrabajador)
    {
        this.NombreTrabajador= nombreTrabajador;
    }

    public String getCodigoEmpleado()
    {
        return CodigoEmpleado;
    }
    public void seCodigoEmpleado(String codigoEmpleado)
    {
        this.CodigoEmpleado= codigoEmpleado;
    }

    public String getTipoCheck()
    {
        return TipoCheck;
    }
    public void setTipoCheck(String tipoCheck)
    {
        this.TipoCheck= tipoCheck;
    }

    public String getFecha()
    {
        return Fecha;
    }
    public void setFecha(String fecha)
    {
        this.Fecha= fecha;
    }

    public String getLatitud()
    {
        return Latitud;
    }
    public void setLatitud(String latitud)
    {
        this.Latitud= latitud;
    }

    public String getLongitud()
    {
        return Longitud;
    }
    public void setLongitud(String longitud)
    {
        this.Longitud= longitud;
    }

    public String getNotas()
    {
        return Notas;
    }
    public void setNotas(String notas)
    {
        this.Notas= notas;
    }

}
