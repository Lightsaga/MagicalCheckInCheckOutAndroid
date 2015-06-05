package school.gpsandroiddad;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

/**
 * Created by Jorge on 6/4/2015.
 */
public class GPSTrack extends Service implements LocationListener{

   private final Context context;

    boolean isGPSEnabled = false;
    boolean canGetLocation = false;
    boolean isNetworkEnabled = false;

    Location location;

    double latitude;
    double longitude;

    private static final long MIN_DIST_CHANGE_UPDATE = 10;
    private static final long MIN_TIME_UPDATE = 60000;

    protected LocationManager locationManager;

    public GPSTrack(Context context)
    {
        this.context = context;
        getLocation();
    }

    public Location getLocation()
    {
            try
            {
                locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
                isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                if(!isGPSEnabled && !isNetworkEnabled)
                {

                }
                else
                {
                    this.canGetLocation = true;

                    if(isNetworkEnabled)
                    {
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_UPDATE,MIN_DIST_CHANGE_UPDATE, this);

                        if(locationManager != null)
                        {
                            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                            if(location != null)
                            {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }

                    if(isGPSEnabled)
                    {
                        if(location == null)
                        {
                            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME_UPDATE, MIN_DIST_CHANGE_UPDATE, this);

                            if(locationManager != null)
                            {
                                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                                if(location != null)
                                {
                                    latitude = location.getLatitude();
                                    longitude = location.getLongitude();
                                }
                            }
                        }
                    }


                }
            }
            catch (Exception e)
            {

            }
        return location;
    }

    public void stopUsingGPS()
    {
        if(locationManager != null)
        {
           locationManager.removeUpdates((GPSTrack.this));
        }
    }

    public double getLatitude()
    {
        if(location != null)
        {
            latitude = location.getLatitude();
        }
        return latitude;
    }
    public double getLongitude()
    {
        if(location != null)
        {
            longitude = location.getLongitude();
        }
        return longitude;
    }

    public boolean canGetLocation()
    {
        return this.canGetLocation;
    }

    public void showSettingsAlert()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setTitle("GPS Esta activando");

        alertDialog.setMessage("GPS no esta habilitado. Desea ir a settings? ");

        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
