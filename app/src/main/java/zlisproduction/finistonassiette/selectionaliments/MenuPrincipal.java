package zlisproduction.finistonassiette.selectionaliments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
    public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {
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
        Désérialisation des boutons
         */
        incontournables=(Button)findViewById(R.id.incontournable);
        patesFarinesCereales=(Button)findViewById(R.id.PatesFarinesCereales);
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
