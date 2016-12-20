package khemar.krustykrabpizza;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;



public class MenuFragment extends Fragment {

    private ImageView img;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         final int[] imageResId = {
                R.drawable.meatlovers,
                R.drawable.hawaiian2,
                R.drawable.veggie
        };

        img = (ImageView)view.findViewById(R.id.imageView2);

        Button meatlovers = (Button)view.findViewById(R.id.meatloversBtn);
        meatlovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(imageResId[0]);
            }
        });

        Button hawaiin = (Button)view.findViewById(R.id.hawaiibutton);
        hawaiin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(imageResId[1]);
            }
        });

        Button veggie = (Button)view.findViewById(R.id.veggieBtn);
        veggie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(imageResId[2]);
            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(this.isVisible()){
            if(!isVisibleToUser){
                img.setImageDrawable(null);
            }

        }
    }
}
