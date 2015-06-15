package zlisproduction.finistonassiette.recette;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 12/06/2015.
 */
public class ConnexionDialogFragment extends DialogFragment {

    private Compte compte = null;
    private TextView pseudo= null;
    private TextView mdp= null;
    private View view = null;
    LayoutInflater inflater = null;

    public ConnexionDialogFragment(Compte pCompte) {

        this.compte = pCompte;
    }

    /*
     * Permet la communication entre le fragment qui a fait débuter cette boite de dialogue  et la boite de dialogue
     */

    //instance de l'interface pour échanger les informations
    NoticeDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // définition du listener
        mListener = (NoticeDialogListener) compte;

        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        inflater = getActivity().getLayoutInflater();
        view= inflater.inflate(R.layout.connexiondialogfragmentlayout, null);
        pseudo= (TextView) view.findViewById(R.id.username);
        mdp = (TextView) view.findViewById(R.id.password);

        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Envoyer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        ArrayList<String> array = new ArrayList<String>();
                        array.add(pseudo.getText().toString());
                        array.add(mdp.getText().toString());

                        mListener.onDialogPositiveClick(array,ConnexionDialogFragment.this);
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ConnexionDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
