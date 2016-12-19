package khemar.krustykrabpizza;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class CreateAPizza extends AppCompatActivity {

    private Toolbar toolbar;
    private Button button;
    private RadioGroup rg;
    private RadioGroup rg2;
    private CheckBox[] cb=new CheckBox[13];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apizza);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cb[0] = (CheckBox)findViewById(R.id.bacon);
        cb[1] = (CheckBox)findViewById(R.id.beef);
        cb[2] = (CheckBox)findViewById(R.id.broccoli);
        cb[3] = (CheckBox)findViewById(R.id.garlic);
        cb[4] = (CheckBox)findViewById(R.id.greenpepper);
        cb[5] = (CheckBox)findViewById(R.id.pepperoni);
        cb[6] = (CheckBox)findViewById(R.id.chicken);
        cb[7] = (CheckBox)findViewById(R.id.spinach);
        cb[8] = (CheckBox)findViewById(R.id.ham);
        cb[9] = (CheckBox)findViewById(R.id.olives);
        cb[10] = (CheckBox)findViewById(R.id.mushroom);
        cb[11] = (CheckBox)findViewById(R.id.pineapple);
        cb[12] = (CheckBox)findViewById(R.id.sausage);

        button = (Button)findViewById(R.id.continuebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAPizza.this, InfoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Help:
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.wikihow.com/Order-a-Pizza-Over-the-Phone"));
                startActivity(intent);
                return true;
            case R.id.pizza:
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://kkrab.com/menu"));
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
