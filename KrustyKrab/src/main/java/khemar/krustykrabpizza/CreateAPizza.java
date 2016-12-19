package khemar.krustykrabpizza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateAPizza extends AppCompatActivity {

    private Toolbar toolbar;
    private Button button;
    private RadioGroup rg,rg2;
    private RadioButton small,medium,large,extralarge,feta,mozzarella,goat,cheddar,parmesan;
    private CheckBox[] cb=new CheckBox[13];
    private SharedPreferences sharedPreferences;
    public static final String prefname = "Pizza_Stuff";
    public static final String CHEESE_KEY = "Cheese";
    public static final String SIZE_KEY = "Size";
    public static final String BACON_KEY = "Bacon";
    public static final String BEEF_KEY = "Beef";
    public static final String BROC_KEY = "Broccoli";
    public static final String GARL_KEY = "Garlic";
    public static final String PEPPER_KEY = "Green Pepper";
    public static final String PEPRONI_KEY = "Pepperoni";
    public static final String CHICK_KEY = "Chicken";
    public static final String SPINACH_KEY = "Spinach";
    public static final String HAM_KEY = "Ham";
    public static final String OLIVE_KEY = "Olives";
    public static final String MUSH_KEY = "Mushrooms";
    public static final String PINE_KEY = "Pineapples";
    public static final String SAUSAGE_KEY = "Sausage";






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
        small = (RadioButton)findViewById(R.id.small);
        medium = (RadioButton)findViewById(R.id.medium);
        large = (RadioButton)findViewById(R.id.large);
        extralarge = (RadioButton)findViewById(R.id.xlarge);
        mozzarella = (RadioButton)findViewById(R.id.mozzarella);
        goat = (RadioButton)findViewById(R.id.goat);
        feta = (RadioButton)findViewById(R.id.feta);
        cheddar = (RadioButton)findViewById(R.id.cheddar);
        parmesan = (RadioButton)findViewById(R.id.parmesan);

        rg = (RadioGroup)findViewById(R.id.cheeseGroup);
        rg2=(RadioGroup)findViewById(R.id.sizeGroup);

        sharedPreferences = getSharedPreferences(prefname,MODE_PRIVATE);

        button = (Button)findViewById(R.id.continuebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int selectedCheese = rg.getCheckedRadioButtonId();
                if(selectedCheese == mozzarella.getId()) {

                    editor.putString(CHEESE_KEY,getString(R.string.mozzarella));

                } else if(selectedCheese == goat.getId()) {

                    editor.putString(CHEESE_KEY,getString(R.string.goatch));

                } else if(selectedCheese == feta.getId()){

                    editor.putString(CHEESE_KEY,getString(R.string.fetach));

                }else if (selectedCheese == cheddar.getId()){

                    editor.putString(CHEESE_KEY,getString(R.string.Cheddar));
                }
                else if(selectedCheese == parmesan.getId()){

                    editor.putString(CHEESE_KEY,getString(R.string.parmesan));
                }
                else{
                    editor.putString(CHEESE_KEY,"");
                }

                int selectedSize = rg2.getCheckedRadioButtonId();
                if(selectedSize == small.getId()){

                    editor.putString(SIZE_KEY,getString(R.string.small));
                }else if(selectedSize == medium.getId()){

                    editor.putString(SIZE_KEY,getString(R.string.medium));

                }else if(selectedSize == large.getId()){

                    editor.putString(SIZE_KEY,getString(R.string.large));

                }else if(selectedSize == extralarge.getId()) {

                    editor.putString(SIZE_KEY,getString(R.string.xlarge));

                }
                else{
                    editor.putString(SIZE_KEY,"");
                }

                if(cb[0].isChecked()) {
                    editor.putString(BACON_KEY,getString(R.string.bacon));
                }
                else
                    editor.remove(BACON_KEY);
                if (cb[1].isChecked()){
                    editor.putString(BEEF_KEY,getString(R.string.beef));
                }
                else
                editor.remove(BEEF_KEY);
                if(cb[2].isChecked()){
                    editor.putString(BROC_KEY,getString(R.string.broccoli));
                }
                else
                editor.remove(BROC_KEY);
                if(cb[3].isChecked()){
                    editor.putString(GARL_KEY,getString(R.string.garlic));
                }
                else
                    editor.remove(GARL_KEY);
                if (cb[4].isChecked()){
                    editor.putString(PEPPER_KEY,getString(R.string.greenpepper));
                }
                else
                    editor.remove(PEPPER_KEY);
                if(cb[5].isChecked()){
                    editor.putString(PEPRONI_KEY,getString(R.string.pepperoni));
                }
                else
                    editor.remove(PEPRONI_KEY);
                if(cb[6].isChecked()){
                    editor.putString(CHICK_KEY,getString(R.string.chicken));
                }
                else
                    editor.remove(CHICK_KEY);
                if(cb[7].isChecked()){
                    editor.putString(SPINACH_KEY,getString(R.string.spinach));
                }
                else
                    editor.remove(SPINACH_KEY);
                if(cb[8].isChecked()){
                    editor.putString(HAM_KEY,getString(R.string.ham));
                }
                else
                    editor.remove(HAM_KEY);
                if(cb[9].isChecked()){
                    editor.putString(OLIVE_KEY,getString(R.string.olives));
                }
                else
                    editor.remove(OLIVE_KEY);
                if(cb[10].isChecked()){
                    editor.putString(MUSH_KEY,getString(R.string.mushroom));
                }
                else
                    editor.remove(MUSH_KEY);
                if(cb[11].isChecked()){
                    editor.putString(PINE_KEY,getString(R.string.pineapple));
                }
                else
                    editor.remove(PINE_KEY);
                if(cb[12].isChecked()){
                    editor.putString(SAUSAGE_KEY,getString(R.string.sausage));
                }
                else
                    editor.remove(SAUSAGE_KEY);

                if (editor.commit()){
                    Toast.makeText(CreateAPizza.this,"Choices have been stored!",Toast.LENGTH_SHORT).show();
                }

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
