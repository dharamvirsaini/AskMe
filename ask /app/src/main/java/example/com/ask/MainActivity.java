package example.com.ask;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mainRecycler;
    private final String TAG = "Main Activity";
    public static int screenSize;
    public static int screenWidth;
    public static Float screenDensity;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }

        mainRecycler = (RecyclerView) findViewById(R.id.recyclerMain);
        DisplayMetrics metrics = new DisplayMetrics();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.menu);

        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenSize = metrics.heightPixels;
        screenWidth = metrics.widthPixels;
        screenDensity = metrics.density;
        File sdcard = Environment.getExternalStorageDirectory();

        File file = new File(sdcard, "f_one.json");
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONArray dataArray = new JSONArray(text.toString());


            InterpretJSON intrptr = new InterpretJSON(dataArray);
            List<Object> data = intrptr.getList();
            MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(data, this);
            mainRecycler.setAdapter(adapter);
            mainRecycler.setHasFixedSize(true);
            mainRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
