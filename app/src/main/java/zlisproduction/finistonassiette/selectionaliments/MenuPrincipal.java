package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
    public class MenuPrincipal extends Activity implements View.OnClickListener {
    /*
    déclaration des boutons
     */
    private Button incontournables;
    private Button patesFarinesCereales;
    private Button viandePoissons;
    private Button produitsLaitiers;
    private Button fruitlegumes;


    public static final String PATES_FARINE_CEREALE="zlisproduction.finistonassiette.selectionaliments.PATES_FARINE_CEREALE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal_layout);
        /*
        Désérialisation des boutons
         */
        incontournables=(Button)findViewById(R.id.incontournable);
        incontournables.setOnClickListener(this);
        patesFarinesCereales=(Button)findViewById(R.id.PatesFarinesCereales);
        patesFarinesCereales.setOnClickListener(this);
        viandePoissons=(Button)findViewById(R.id.viandePoissons);
        produitsLaitiers=(Button)findViewById(R.id.produitsLaitiers);
        fruitlegumes=(Button)findViewById((R.id.fruitlegumes));


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.incontournable:

                break;
            case R.id.PatesFarinesCereales:

                Intent activitePatesFarineCereales= new Intent(MenuPrincipal.this,PatesFarinesCereales.class);
                startActivity(activitePatesFarineCereales);

                break;
            case R.id.viandePoissons:

                break;
            case R.id.produitsLaitiers:

                break;
            case R.id.fruitlegumes:

                break;
        }
    }

}
