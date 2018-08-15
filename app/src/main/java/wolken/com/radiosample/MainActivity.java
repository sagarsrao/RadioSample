package wolken.com.radiosample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LinearLayout linearLayout = null;


    private Button sendButton;
    private boolean isChecking = true;

    private int mcheckedId = 1;

    RadioButton radioButton1;
    private static final String TAG = MainActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.activity_main);
        sendButton = findViewById(R.id.button_send);

        final RadioGroup mRadioGroup = new RadioGroup(this);
        final String[] title = {"SAGAR","IS","HEAVY","BRILLIANT","THIS","GUY","CAN","MAKE","IMPOSSIBLE","A","POSSIBLE","SAGAR","IS"};
        RadioButton radioButton = null;

        final List<RadioButton> radioButtonList = new ArrayList<>();
        for(int i=0;i<title.length;i++){
            radioButton = new RadioButton(this);
            radioButton.setId(i);
            radioButton.setText(title[i]);
            radioButton.setTag(title[i]);
            radioButtonList.add(radioButton);
            mRadioGroup.addView(radioButton);
        }
        linearLayout.addView(mRadioGroup);



        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {




                if(checkedId != -1 && isChecking){

                    isChecking = false;
                    mcheckedId = checkedId;
                    mRadioGroup.check(mRadioGroup.getCheckedRadioButtonId());
                    radioButton1 = mRadioGroup.findViewById(mRadioGroup.getCheckedRadioButtonId());

                    Toast.makeText(MainActivity.this, "CheckedItem"+mRadioGroup.getCheckedRadioButtonId()+"CheckedItemName:"+radioButton1.getText().toString(), Toast.LENGTH_SHORT).show();

                }
                isChecking = true;
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RadioButtonValueActivity.class);
                intent.putExtra("SEND_RADIO",radioButton1.getText().toString());
                startActivity(intent);
            }
        });

    }


}
