package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pates_farine_cereales_layout);
        /*
        déserialisation objets
         */
        pate=(Button)findViewById(R.id.pate);
        farine=(Button)findViewById((R.id.farine));
        cereales=(Button)findViewById((R.id.cereales));

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.pate:
                break;
            case R.id.farine:
                break;
            case R.id.cereales:
                break;
        }
    }
}
