package school.gpsandroiddad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainMenuActivity extends Activity {

    Button btnCheckIn, btnCheckOut, btnRecord;

    TextView userMessage;

    String userID = null;
    Intent callingIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnCheckIn = (Button) findViewById(R.id.btnCheckIn);
        btnCheckOut = (Button) findViewById(R.id.btnCheckOut);
        btnRecord = (Button) findViewById(R.id.btnRecord);
        userMessage = (TextView) findViewById(R.id.txtViewUser);


        callingIntent = getIntent();
        userID = callingIntent.getStringExtra("UserID");

        if(userID != null)
        {
            userMessage.setText("Bienvenido " + userID + "!");
        }
    }


    public void OnClick(View v)
    {
        switch(v.getId()){

            case R.id.btnCheckIn:
                Intent intentCheckIn = new Intent(MainMenuActivity.this, PictureActivity.class);
                intentCheckIn.putExtra("UserID", userID);
                intentCheckIn.putExtra("isCheckInOrOut", "IN");
                startActivity(intentCheckIn);
                break;

            case R.id.btnCheckOut:
                Intent intentCheckOut = new Intent(MainMenuActivity.this, PictureActivity.class);
                intentCheckOut.putExtra("UserID", userID);
                intentCheckOut.putExtra("isCheckInOrOut", "OUT");
                startActivity(intentCheckOut);
                break;

            case R.id.btnRecord:
                Intent intentRecord = new Intent(MainMenuActivity.this, RecordActivity.class);
                intentRecord.putExtra("UserID", userID);
                startActivity(intentRecord);
                break;

            default:
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
}
