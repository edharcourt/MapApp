package edu.stlawu.ehar.mapapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText addrText = null;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addrText = (EditText) findViewById(R.id.location);

        final Button button =
                (Button) findViewById(R.id.mapButton);

        // ACTION_VIEW display the data to the user
        button.setOnClickListener(
                // an object that we write
                // that implements the
                // View.OnClickListenerInterface
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String address = addrText.getText().toString();
                        address = address.replace(' ', '+');
                        Intent geoIntent = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=" + Uri.encode(address))
                        );
                        startActivity(geoIntent);
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
