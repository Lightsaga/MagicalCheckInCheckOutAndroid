package school.gpsandroiddad.JSONWebAPI;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import school.gpsandroiddad.models.TablaDetalleUsuario;

/**
 * Created by Vizardespa on 05/06/2015.
 */
public class JSONParser {

    public JSONParser()
    {
        super();
    }

    public ArrayList<TablaDetalleUsuario> parseDetalleUsuario(JSONObject object)
    {
        ArrayList<TablaDetalleUsuario> arrayList=new ArrayList<TablaDetalleUsuario>();
        try {
            JSONArray jsonArray=object.getJSONArray("Value");
            JSONObject jsonObj=null;
            for(int i=0;i<jsonArray.length();i++)
            {
                jsonObj=jsonArray.getJSONObject(i);
                arrayList.add(new TablaDetalleUsuario(
                        jsonObj.getInt("IdUsuario"),
                        jsonObj.getString("NombreUsuario"),
                        jsonObj.getString("Contrasena"),
                        jsonObj.getString("NombreTrabajador"),
                        jsonObj.getString("CodigoEmpleado"),
                        jsonObj.getString("FechaIngreso")
                        ));
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser-DetaUsuario", e.getMessage());
        }
        return arrayList;
    }

    public boolean parseAutentificarUsuario(JSONObject object)
    {     boolean userAtuh=false;
        try {
            userAtuh= object.getBoolean("Value");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser-AutUsuario", e.getMessage());
        }

        return userAtuh;
    }

    public int parseObtenerIdUsuario(JSONObject object)
    {     int userAtuh=-1;
        try {
            userAtuh= object.getInt("Value");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser-ObtIdUsu", e.getMessage());
        }

        return userAtuh;
    }

    
}
