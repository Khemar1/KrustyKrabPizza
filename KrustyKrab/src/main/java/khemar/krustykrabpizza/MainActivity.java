package khemar.krustykrabpizza;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv = (TextView)findViewById(R.id.welcome);
        tv.setTypeface(EasyFonts.captureIt(this));

        orderButton = (Button)findViewById(R.id.orderbutton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
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
            case 1:
                 Intent intent = new Intent(Intent.ACTION_VIEW,
                       Uri.parse("http://www.wikihow.com/Order-a-Pizza-Over-the-Phone"));
                startActivity(intent);

                return true;
            case 2:
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                       Uri.parse("https://kkrab.com/menu"));
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


}
