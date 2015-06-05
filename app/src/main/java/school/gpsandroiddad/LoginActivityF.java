package school.gpsandroiddad;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
         new AsyncLogin().execute("MToledo","123");
     }
    }

    protected class AsyncLogin extends AsyncTask<String, JSONObject, Boolean> {

        String userName=null;
        @Override
        protected Boolean doInBackground(String... params) {

            RestAPI api = new RestAPI();
            boolean userAuth = false;
            try {

                // Call the User Authentication Method in API
                JSONObject jsonObj = api.AutentificarUsuario(params[0],
                        params[1]);

                //Parse the JSON Object to boolean
                JSONParser parser = new JSONParser();
                userAuth = parser.parseAutentificarUsuario(jsonObj);
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
        protected void onPostExecute(Boolean result) {
            // TODO Auto-generated method stub

            //Check user validity
            if (result) {
                /*Intent i = new Intent(LoginActivity.this,
                        UserDetailsActivity.class);
                i.putExtra("username",userName);
                startActivity(i);*/
                Toast.makeText(context, "Tryndamere!!! ",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(context, "Not valid username/password ",Toast.LENGTH_SHORT).show();
            }

        }

    }

}
