package khemar.krustykrabpizza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private SharedPreferences sharedPreferences;
    public static final String prefname1 = "User Info";
    public static final String USERNAME_KEY="Name";
    EditText name;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getSharedPreferences(prefname1,MODE_PRIVATE);




        Button checkout = (Button)findViewById(R.id.submitBtn);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = (EditText)findViewById(R.id.name);
                username = name.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(USERNAME_KEY,username);
                editor.commit();
                Intent intent = new Intent(InfoActivity.this,Checkout.class);
                startActivity(intent);
            }
        });

    }


}
