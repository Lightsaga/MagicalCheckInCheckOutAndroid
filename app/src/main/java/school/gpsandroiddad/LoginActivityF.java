package school.gpsandroiddad;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import school.gpsandroiddad.JSONWebAPI.JSONParser;
import school.gpsandroiddad.JSONWebAPI.RestAPI;


public class LoginActivityF extends Activity {

    Button btnLogIn;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity_f);

        context=this;
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnClick(View v)
    {
        if (v.getId() == R.id.btnLogIn)
        {
         /*Toast hola = new Toast(this);
         hola.setText("Magic");
         hola.show();*/
            EditText usuario = (EditText) findViewById(R.id.edtUsuario);
            EditText contrasena = (EditText) findViewById(R.id.edtContra);
            new AsyncLogin().execute(usuario.getText().toString(),contrasena.getText().toString());
        }
    }

    protected class AsyncLogin extends AsyncTask<String, JSONObject, Integer> {

        String userName=null;
        @Override
        protected Integer doInBackground(String... params) {

            RestAPI api = new RestAPI();
            int userAuth = -1;
            try {

                // Call the User Authentication Method in API
                JSONObject jsonObj = api.ObtenerIdUsuario(params[0],
                        params[1]);

                //Parse the JSON Object to boolean
                JSONParser parser = new JSONParser();
                userAuth = parser.parseObtenerIdUsuario(jsonObj);
                userName=params[0];
            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncLogin", e.getMessage());

            }
            return userAuth;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            Toast.makeText(context, "Please Wait...",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Integer result) {
            // TODO Auto-generated method stub

            //Check user validity
            if (result!=-1) {
                Intent i = new Intent(LoginActivityF.this,
                        MainMenuActivity.class);
                i.putExtra("UserID",result.toString());
                startActivity(i);
                //Toast.makeText(context, "Tryndamere!!! "+result,Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(context, "Usuario o Contrasena no Validos",Toast.LENGTH_SHORT).show();
            }

        }

    }

}