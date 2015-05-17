package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */

public class ViandePoisson extends Activity implements View.OnClickListener{

    private Button viande;
    private Button poisson;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viande_poisson_layout);
        viande=(Button)findViewById(R.id.viande);
        viande.setOnClickListener(this);
        poisson=(Button)findViewById(R.id.poissons);
        poisson.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.viande:
                Intent activite_viande= new Intent(ViandePoisson.this, Viande.class);
                startActivity(activite_viande);
                break;
            case R.id.poissons:
                Intent activite_poisson = new Intent(ViandePoisson.this,Poisson.class);
                startActivity(activite_poisson);
        }
    }


}
