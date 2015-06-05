package school.gpsandroiddad.models;

/**
 * Created by Vizardespa on 05/06/2015.
 */
public class TablaDetalleUsuario {

    int IdUsuario;
    String NombreUsuario;
    String Contrasena;
    String NombreTrabajador;
    String CodigoEmpleado;
    String FechaIngreso;

    public TablaDetalleUsuario(int idUsuario, String nombreUsuario, String contrasena,
                                    String nombreTrabajador, String codigoEmpleado, String fechaIngreso) {
        super();
        this.IdUsuario= idUsuario;
        this.NombreUsuario= nombreUsuario;
        this.Contrasena= contrasena;
        this.NombreTrabajador= nombreTrabajador;
        this.CodigoEmpleado= codigoEmpleado;
        this.FechaIngreso= fechaIngreso;

    }

    public TablaDetalleUsuario() {
        super();
        this.IdUsuario= 0;
        this.NombreUsuario= null;
        this.Contrasena= null;
        this.NombreTrabajador= null;
        this.CodigoEmpleado= null;
        this.FechaIngreso= null;
    }

    public int getIdUsuario()
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



}
