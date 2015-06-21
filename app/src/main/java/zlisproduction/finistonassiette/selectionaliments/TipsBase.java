package zlisproduction.finistonassiette.selectionaliments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian.S on 20/06/2015.
 */
public class TipsBase {
    private String[] tipsArray;
    private Context context = null;

    public TipsBase(Context pContext){
        context = pContext;
        tipsArray = context.getResources().getStringArray(R.array.tipsArray);
    }


    public void ShowRandomTips(){
        Random random = new Random();
        int index = random.nextInt(tipsArray.length);
        //Toast.makeText(context, tipsArray[index], Toast.LENGTH_LONG).show();

        AlertDialog popupBuilder = new AlertDialog.Builder(context).create();
        TextView myMsg = new TextView(context);
        myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
        popupBuilder.setTitle(context.getString(R.string.tips));
        popupBuilder.setMessage(tipsArray[index]);
        popupBuilder.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Possibilité de rajouter des actions
            }
        });
            popupBuilder.setIcon(R.mipmap.ic_launcher);
            popupBuilder.show();
        }
    }
