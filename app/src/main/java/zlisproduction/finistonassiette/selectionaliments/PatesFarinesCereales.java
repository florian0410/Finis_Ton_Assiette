package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 16/05/2015.
 */
public class PatesFarinesCereales extends Activity implements View.OnClickListener {

    private Button pate;
    private Button farine;
    private Button cereales;
    /*
    identifiant des requêtes
     */
    public final static  int REQUEST_CODE_PATES=1;
    public final  static  int REQUEST_CODE_FARINE=2;
    public final  static  int REQUEST_CODE_CEREALES=3;

    // L'identifiant de la chaîne de caractères qui contient le résultat de l'intent

    public final static String RESULT_PATES = "resultatPates";
    public final static String RESULT_FARINES="resultatFarine";
    public final static String RESULT_CEREALES="resultatCereales";


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
                startActivityForResult(activitePate, REQUEST_CODE_PATES);
                break;
            case R.id.farine:
                Intent activitefarine= new Intent(PatesFarinesCereales.this,Farine.class);
                startActivityForResult(activitefarine, REQUEST_CODE_FARINE);

                break;
            case R.id.cereales:
                Intent activiteCereales= new Intent(PatesFarinesCereales.this,Cereale.class);
                startActivityForResult(activiteCereales, REQUEST_CODE_CEREALES);

                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

}
