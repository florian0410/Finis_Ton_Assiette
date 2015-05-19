package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 16/05/2015.
 */
public class PatesFarinesCereales extends Activity implements View.OnClickListener {

    private Button pate;
    private Button farine;
    private Button cereales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pates_farine_cereales_layout);

        /*
        déserialisation objets
         */
        pate=(Button)findViewById(R.id.pate);
        pate.setOnClickListener(this);
        farine=(Button)findViewById((R.id.farine));
        farine.setOnClickListener(this);
        cereales=(Button)findViewById((R.id.cereales));
        cereales.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.pate:
                Intent activitePate= new Intent(PatesFarinesCereales.this,Pates.class);
                startActivity(activitePate);
                break;
            case R.id.farine:
                Intent activitefarine= new Intent(PatesFarinesCereales.this,Farine.class);
                startActivity(activitefarine);

                break;
            case R.id.cereales:
                Intent activiteCereales= new Intent(PatesFarinesCereales.this,Cereale.class);
                startActivity(activiteCereales);
                break;
        }
    }
}
