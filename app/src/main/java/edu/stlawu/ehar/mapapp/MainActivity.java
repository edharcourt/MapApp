package edu.stlawu.ehar.mapapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText addrText =
                (EditText) findViewById(R.id.location);

        final Button button =
                (Button) findViewById(R.id.mapButton);

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
                                Uri.parse("geo:0,0?q=" + address)
                        );
                        startActivity(geoIntent);
                    }
                }
        );
    }
}
