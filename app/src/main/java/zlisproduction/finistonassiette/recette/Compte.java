package zlisproduction.finistonassiette.recette;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.InstrumentationInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 12/06/2015.
 */
public class Compte extends Fragment implements View.OnClickListener, NoticeDialogListener{

    private Button bouton_connection_compte =null;
    private Button bouton_creation_compte= null;
    private Information info = null;
    ConnexionDialogFragment dialogCo=null;
    CreationCompteDialogFragment dialogCrea = null;
    View vue= null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         vue = inflater.inflate(R.layout.comptelayout, container, false);
        this.bouton_connection_compte= (Button)vue.findViewById(R.id.avec_votre_compte);
        this.bouton_connection_compte.setOnClickListener(this);
        this.bouton_creation_compte= (Button)vue.findViewById(R.id.creeruncompte);
        this.bouton_creation_compte.setOnClickListener(this);

        info = new Information();
        // Inflate the layout for this fragment
        return  vue;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case  R.id.avec_votre_compte :
                //lancement de la fenêtre de connexion
                dialogCo = new ConnexionDialogFragment(this);
                dialogCo.show(this.getFragmentManager(), "ConnexionDialogFragment");


                break;

            case R.id.creeruncompte:
                // lancement de la fenêtre pour se créer un compte
                dialogCrea = new CreationCompteDialogFragment(this);

                dialogCrea.show(this.getFragmentManager(), "CreationCompteDialogFragment");


                break;

        }

    }


    @Override
    public void onDialogPositiveClick(ArrayList<String> pArray,DialogFragment dialog) {


        //test de quelle boite de dialogue provient l'information
        switch (dialog.getTag()) {

            case "CreationCompteDialogFragment":

                info.setRequete(new RequeteCreationCompte());

                //Désactivation du fragment de dialogue
                dialog.getDialog().dismiss();


                try {
                    //on récupère le resultat
                    String[] res = info.getRequete().execute(pArray).get();

                    // on teste la valeur du resultat pour savoir si le compte à bien été créé

                    if (res[0].equals("null\n")) {
                        //On averti l'utilisateur car il y a eu une erreur par un toast
                        Toast.makeText(getActivity(), "Erreur dans la création de votre compte veuillez réessayer ", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Félicitation! Votre compte à été crée avec succès!", Toast.LENGTH_SHORT).show();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }


                break;

            case "ConnexionDialogFragment":
                info.setRequete(new RequeteConsulterCompte());
                String[] res = null;

                try {
                    //on récupère le resultat
                    res = info.getRequete().execute(pArray).get();

                    // on teste la valeur du resultat pour savoir si le compte à bien été créé
                    if (res[0].equals("null\n")) {
                        //On averti l'utilisateur car il y a eu une erreur par un toast
                        Toast.makeText(getActivity(), "Mot de passe ou pseudonyme incorrect (Avez vous bien créez un compte? )", Toast.LENGTH_SHORT).show();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                // On parse le résultat
                info.setAnalyse_resultat(new JsonFormatConsultationCompte(res));
                HashMap<String, String> tmp = info.getAnalyse_resultat().getCompteAttributes();

                info.setInstancie(new AffichageCompteUtilisateur(tmp));
                // on affiche dans l'interface
                if (info.getInstancie() != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.frame_container, info.getInstancie());
                    // Il est important de rajouter le fragment précédent à la pile pour pouvoir le recharger si nécessaire
                    ft.addToBackStack(null);
                    ft.commit();


                    break;

                }


        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
