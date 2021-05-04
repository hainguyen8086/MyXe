package com.doancuoiky.myxe.activity;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.model.LocationPoint;
import com.doancuoiky.myxe.model.NetworkAPI;
import com.doancuoiky.myxe.model.RequestHandler;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class FindGasStation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String MAP_KEY = "AIzaSyD3XSQGLl_etfNZqONMYg8cc9670kCn7y4";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;
    LocationManager locationManager;
    private boolean mLocationPermissionsGranted = false;
    LocationPoint myLocation = new LocationPoint();
    LocationPoint nearestLocation = new LocationPoint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gas_station);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Thay đổi vị trí My location button
        View locationButton = ((View) findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        rlp.setMargins(0, 0, 30, 60);

        getLocationPermission();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        if (mLocationPermissionsGranted) {
            Location location = getLastKnownLocation();
            if (location == null) {
                System.out.println("Null");
                Toast.makeText(FindGasStation.this, "Không thể xác định địa chỉ của bạn", Toast.LENGTH_SHORT).show();
            } else {
                //System.out.println(location);
                moveCamera(new LatLng(location.getLatitude(), location.getLongitude()),
                        DEFAULT_ZOOM);
                //
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(location.getLatitude(), location.getLongitude()));
                try {
                    Geocoder gcd = new Geocoder(FindGasStation.this.getApplicationContext(), Locale.getDefault());
                    List<Address> addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (addresses != null) {
                        myLocation.setName(addresses.get(0).getLocality());
                        if (myLocation.getName() == null || myLocation.getName().length() == 0) {
                            myLocation.setFullAdress(addresses.get(0).getAddressLine(0));
                            String[] p = myLocation.getFullAdress().split(",");
                            if (p.length > 0) {
                                myLocation.setName(p[0]);
                            }
                            if (myLocation.getName() == null || myLocation.getName().length() == 0) {
                                Toast.makeText(FindGasStation.this, "Không thể xác định địa chỉ của bạn", Toast.LENGTH_SHORT).show();
                            } else {
                                myLocation.setLat(location.getLatitude());
                                myLocation.setLng(location.getLongitude());
                                markerOptions.title(myLocation.getName());
                            }
                        } else {
                            myLocation.setLat(location.getLatitude());
                            myLocation.setLng(location.getLongitude());
                            myLocation.setFullAdress(addresses.get(0).getAddressLine(0));
                            markerOptions.title(myLocation.getName());
                        }
                    } else {
                        System.out.println("add null");
                        Toast.makeText(FindGasStation.this, "Không thể xác định địa chỉ của bạn", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(FindGasStation.this, "Không thể xác định địa chỉ của bạn", Toast.LENGTH_SHORT).show();
                }
                mMap.clear();
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.markicon30x48));
                mMap.addMarker(markerOptions);
            }
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            findNearestGasStation();
        }
    }

    private void moveCamera(LatLng latLng, float zoom) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //System.out.println("map init");
        //
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionsGranted = false;
        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;

                            return;
                        }
                    }
                    mLocationPermissionsGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }

    private Location getLastKnownLocation() {
        if (mLocationPermissionsGranted) {
            List<String> providers = locationManager.getProviders(true);
            Location bestLocation = null;
            for (String provider : providers) {
                Location l = locationManager.getLastKnownLocation(provider);
                System.out.println("last known location, provider: %s, location: %s" + provider);

                if (l == null) {
                    continue;
                }
                if (bestLocation == null
                        || l.getAccuracy() < bestLocation.getAccuracy()) {
                    bestLocation = l;
                }
            }
            if (bestLocation == null) {
                return null;
            }
            return bestLocation;
        }
        else {
            //System.out.println("Khong co quyen truy cap");
            return null;
        }
    }

    private void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
                initMap();
            } else {
                System.out.println("cannot get permission :(");
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            System.out.println("not permission");
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    //Tìm cây xăng gần nhất
    public void findNearestGasStation() {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + myLocation.getLat() + "," + myLocation.getLng());
        googlePlacesUrl.append("&rankby=distance");
        googlePlacesUrl.append("&type=" + "gas_station");
        googlePlacesUrl.append("&key=" + MAP_KEY);
        RequestHandler requestHandler = new RequestHandler();
        try {
            String response = requestHandler.sendHttpRequest(googlePlacesUrl.toString(), null, null);
            System.out.println("Find response = " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}