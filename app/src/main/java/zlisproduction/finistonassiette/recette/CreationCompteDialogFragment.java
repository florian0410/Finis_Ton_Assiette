package zlisproduction.finistonassiette.recette;

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
public class CreationCompteDialogFragment extends DialogFragment {

    private Compte compte = null ;
    private TextView pseudonyme;
    private TextView mot_de_passe;
    private TextView adresse_mail ;
    private TextView error_msg;
    private LayoutInflater inflater = null;
    private View vue= null;
    private NoticeDialogListener mListener= null;

    public CreationCompteDialogFragment(Compte pCompte) {

        this.compte = pCompte;

    }

    //instance de l'interface pour échanger les informations


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // définition du listener
        mListener = (NoticeDialogListener) compte;

        inflater = getActivity().getLayoutInflater();
        vue= inflater.inflate(R.layout.creationcomptedialogfragmentlayout, null);

        pseudonyme= (TextView) vue.findViewById(R.id.username);
        mot_de_passe = (TextView) vue.findViewById(R.id.password);
        adresse_mail = (TextView ) vue.findViewById(R.id.mailadress);
        error_msg = (TextView ) vue.findViewById(R.id.errormsg);

        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(vue)
                // Add action buttons
                .setPositiveButton("Envoyer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        ArrayList<String> array = new ArrayList<String>();
                        array.add(pseudonyme.getText().toString());
                        array.add(mot_de_passe.getText().toString());
                        array.add(adresse_mail.getText().toString());

                        mListener.onDialogPositiveClick(array,CreationCompteDialogFragment.this);

                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        CreationCompteDialogFragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public TextView getPseudonyme() {
        return pseudonyme;
    }

    public void setPseudonyme(TextView pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    public TextView getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(TextView mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public TextView getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(TextView adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public TextView getError_msg() {
        return error_msg;
    }

    public void setError_msg() {
        this.error_msg.setVisibility(View.VISIBLE);
    }
}
