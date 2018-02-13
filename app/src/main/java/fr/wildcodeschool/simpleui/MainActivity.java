package fr.wildcodeschool.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button accept = findViewById(R.id.accept);
        final TextView firstname = findViewById(R.id.firstname);
        final TextView lastname = findViewById(R.id.lastname);
        final TextView success = findViewById(R.id.congrats);

        CheckBox checkboxWilder = findViewById(R.id.checkbox_wilder);
        checkboxWilder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                firstname.setEnabled(checked);
                lastname.setEnabled(checked);
                accept.setEnabled(checked);
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstnameContent = firstname.getText().toString();
                String lastnameContent = lastname.getText().toString();
                if (firstnameContent.isEmpty() || lastnameContent.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_LONG).show();
                    success.setVisibility(View.GONE);
                } else {
                    String congrats = getResources().getString(R.string.congratulation);
                    success.setText(String.format(congrats, firstnameContent, lastnameContent));
                    success.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
