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
public class FruitLegume extends Activity implements View.OnClickListener{
    private Button fruit;
    private Button legumes;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_legumes_layout);

        /*
        déserialisation objets
         */
       fruit=(Button)findViewById(R.id.fruit);
        fruit.setOnClickListener(this);
        legumes=(Button)findViewById((R.id.Legumes));
        legumes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fruit:
                Intent activiteFruit= new Intent(FruitLegume.this,Fruit.class);
                startActivity(activiteFruit);
                break;
            case R.id.Legumes:
                Intent activiteLegume= new Intent(FruitLegume.this,Legume.class);
                startActivity(activiteLegume);

                break;

        }
    }


}
