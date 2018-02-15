package fr.wildcodeschool.simpleui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonAccept = findViewById(R.id.button_accept);
        final EditText editFirstname = findViewById(R.id.edit_firstname);
        final EditText editLastname = findViewById(R.id.edit_lastname);
        final TextView textSuccess = findViewById(R.id.text_congrats);

        CheckBox checkboxWilder = findViewById(R.id.checkbox_wilder);
        checkboxWilder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                editFirstname.setEnabled(checked);
                editLastname.setEnabled(checked);
                buttonAccept.setEnabled(checked);
            }
        });

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = editFirstname.getText().toString();
                String lastname = editLastname.getText().toString();
                if (firstname.isEmpty() || lastname.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_LONG).show();
                    textSuccess.setVisibility(View.GONE);
                } else {
                    String congrats = getResources().getString(R.string.congratulation);
                    textSuccess.setText(String.format(congrats, firstname, lastname));
                    textSuccess.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
