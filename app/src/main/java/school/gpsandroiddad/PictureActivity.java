package school.gpsandroiddad;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


public class PictureActivity extends Activity {

    TextView txtViewCheckInOut;
    ImageButton ib;
    Button btnEnviar;
    ImageView iv;
    Intent iCamera;
    final static int cameraData = 0;
    Bitmap bmpFoto;

    GPSTrack gps;

    String userID = null; // dato a enviar
    String isCheckInOrOut; // dato a enviar
    String notasEmpleado; // dato a enviar

    Intent callingIntent = null;

    Bitmap btmapPhoto;
    byte[] bytesPhoto;  // dato a enviar

    String latitude; // dato a enviar
    String longitude; // dato a enviar

    EditText editTxtNotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        initialize();

        iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        iCamera.putExtra("android.intent.extras.CAMERA_FACING", 1);
        startActivityForResult(iCamera, cameraData);


        callingIntent = getIntent();
        userID = callingIntent.getStringExtra("UserID");

        isCheckInOrOut = callingIntent.getStringExtra("isCheckInOrOut");
        txtViewCheckInOut.setText("Tipo:      " + isCheckInOrOut);

    }

    private void initialize(){
        iv = (ImageView) findViewById(R.id.ivReturnedPicture);
        ib = (ImageButton) findViewById(R.id.ibTakePicture);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        txtViewCheckInOut = (TextView) findViewById(R.id.txtViewCheckInOut);
        editTxtNotas = (EditText) findViewById(R.id.editTxtNotas);

    }

    public void OnClick(View v)
    {
        switch(v.getId()){
            case R.id.btnEnviar:
            gps = new GPSTrack(PictureActivity.this);

                if(gps.canGetLocation())
                {
                    latitude = String.valueOf(gps.getLatitude());
                    longitude = String.valueOf(gps.getLongitude());

                    notasEmpleado = editTxtNotas.getText().toString();

                    Toast.makeText(getApplicationContext(),"Tu localización es -\nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();

                }

                else {
                    gps.showSettingsAlert();
                }

            break;
            case  R.id.ibTakePicture:
                iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                iCamera.putExtra("android.intent.extras.CAMERA_FACING", 1);
                startActivityForResult(iCamera, cameraData);
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            bmpFoto = (Bitmap) extras.get("data");


            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmpFoto.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytesPhoto = stream.toByteArray();

            btmapPhoto = BitmapFactory.decodeByteArray(bytesPhoto, 0, bytesPhoto.length);

            iv.setImageBitmap(btmapPhoto);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_picture, menu);
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
