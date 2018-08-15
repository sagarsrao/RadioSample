package wolken.com.radiosample;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class RadioButtonValueActivity extends AppCompatActivity {

    private TextView radioRecieved;
    private ImageView backNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_value);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);


        backNav = findViewById(R.id.iv_back);
        setSupportActionBar(myToolbar);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            backNav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }


        radioRecieved = findViewById(R.id.tv_radio);


        radioRecieved.setText("RECEIVED RADIO VALUE IS :: " + getIntent().getStringExtra("SEND_RADIO"));

    }


}
