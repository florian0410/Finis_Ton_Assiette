package zlisproduction.finistonassiette.recette;

import android.app.DialogFragment;

import java.util.ArrayList;

/**
 * Created by Thibaut on 12/06/2015.
 */
public interface NoticeDialogListener {
    /*
   * Permet la communication entre le fragment qui a fait débuter cette boite de dialogue  et la boite de dialogue
   */
    public void onDialogPositiveClick(ArrayList<String> pArray,DialogFragment dialog );
    public void onDialogNegativeClick(DialogFragment dialog);

}
