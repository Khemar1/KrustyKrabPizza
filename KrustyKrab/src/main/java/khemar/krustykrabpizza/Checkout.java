package khemar.krustykrabpizza;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static khemar.krustykrabpizza.CreateAPizza.BACON_KEY;
import static khemar.krustykrabpizza.CreateAPizza.BEEF_KEY;
import static khemar.krustykrabpizza.CreateAPizza.BROC_KEY;
import static khemar.krustykrabpizza.CreateAPizza.CHEESE_KEY;
import static khemar.krustykrabpizza.CreateAPizza.CHICK_KEY;
import static khemar.krustykrabpizza.CreateAPizza.GARL_KEY;
import static khemar.krustykrabpizza.CreateAPizza.HAM_KEY;
import static khemar.krustykrabpizza.CreateAPizza.MUSH_KEY;
import static khemar.krustykrabpizza.CreateAPizza.OLIVE_KEY;
import static khemar.krustykrabpizza.CreateAPizza.PEPPER_KEY;
import static khemar.krustykrabpizza.CreateAPizza.PEPRONI_KEY;
import static khemar.krustykrabpizza.CreateAPizza.PINE_KEY;
import static khemar.krustykrabpizza.CreateAPizza.SAUSAGE_KEY;
import static khemar.krustykrabpizza.CreateAPizza.SIZE_KEY;
import static khemar.krustykrabpizza.CreateAPizza.SPINACH_KEY;
import static khemar.krustykrabpizza.CreateAPizza.prefname;
import static khemar.krustykrabpizza.InfoActivity.USERNAME_KEY;
import static khemar.krustykrabpizza.InfoActivity.prefname1;

public class Checkout extends AppCompatActivity {

    private SharedPreferences sharedPreferences2,sharedpreferences;
    private String name;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
                edit().clear().apply();




        sharedPreferences2 = getSharedPreferences(prefname,MODE_PRIVATE);
        sharedpreferences = getSharedPreferences(prefname1,MODE_PRIVATE);
        ListView list = (ListView)findViewById(R.id.listview);
        String pizzainfo[] ={"Size:\n\n "+sharedPreferences2.getString(SIZE_KEY,""),
                            "Cheese:\n\n "+sharedPreferences2.getString(CHEESE_KEY,""),
                            "Toppings: \n\n"+
                            sharedPreferences2.getString(HAM_KEY,"")+"\n"
                            +sharedPreferences2.getString(BROC_KEY,"")+"\n"
                            +sharedPreferences2.getString(GARL_KEY,"")+"\n"
                            +sharedPreferences2.getString(BACON_KEY,"")+"\n"
                            +sharedPreferences2.getString(BEEF_KEY,"")+"\n"
                            +sharedPreferences2.getString(PEPPER_KEY,"")+"\n"
                            +sharedPreferences2.getString(PEPRONI_KEY,"")+"\n"
                            +sharedPreferences2.getString(CHICK_KEY,"")+"\n"
                            +sharedPreferences2.getString(SPINACH_KEY,"")+"\n"
                            +sharedPreferences2.getString(OLIVE_KEY,"")+"\n"
                            +sharedPreferences2.getString(PINE_KEY,"")+"\n"
                            +sharedPreferences2.getString(SAUSAGE_KEY,"")+"\n"
                            +sharedPreferences2.getString(MUSH_KEY,"")
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pizzainfo);


        // Assign adapter to ListView
        list.setAdapter(adapter);
        name = sharedpreferences.getString(USERNAME_KEY,"");

        Button confirm = (Button)findViewById(R.id.confirmBtn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Checkout.this,"Thank you! "+name+"\nYour order has been placed",Toast.LENGTH_LONG).show();
            }
        });

    }
}
