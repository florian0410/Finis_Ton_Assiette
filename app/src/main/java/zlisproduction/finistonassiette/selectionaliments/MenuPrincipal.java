package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

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








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal_layout);


        /*
        Désérialisation des boutons et définition de l'écouteur
         */
        incontournables=(Button)findViewById(R.id.incontournable);
        incontournables.setOnClickListener(this);
        patesFarinesCereales=(Button)findViewById(R.id.PatesFarinesCereales);
        patesFarinesCereales.setOnClickListener(this);
        viandePoissons=(Button)findViewById(R.id.viandePoissons);
        viandePoissons.setOnClickListener(this);
        produitsLaitiers=(Button)findViewById(R.id.produitsLaitiers);
        produitsLaitiers.setOnClickListener(this);
        fruitlegumes=(Button)findViewById((R.id.fruitlegumes));
        fruitlegumes.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.incontournable:
                Intent activiteIncontournable= new Intent (MenuPrincipal.this,Incontournable.class);
                startActivity(activiteIncontournable);


                break;
            case R.id.PatesFarinesCereales:

                Intent activitePatesFarineCereales= new Intent(MenuPrincipal.this,PatesFarinesCereales.class);
                startActivity(activitePatesFarineCereales);

                break;
            case R.id.viandePoissons:

                Intent activiteviandepoisson= new Intent(MenuPrincipal.this,ViandePoisson.class);
                startActivity(activiteviandepoisson);

                break;
            case R.id.produitsLaitiers:

                Intent activiteProduitsLaitiers = new Intent(MenuPrincipal.this,ProduitLaitier.class);
                startActivity(activiteProduitsLaitiers);

                break;
            case R.id.fruitlegumes:
                Intent activiteFruitsLegumes= new Intent (MenuPrincipal.this,ProduitLaitier.class);
                startActivity(activiteFruitsLegumes);

                break;
        }
    }


}
