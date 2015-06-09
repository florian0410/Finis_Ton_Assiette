package zlisproduction.finistonassiette.recette;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 09/06/2015.
 */
public class ConstructeurDefautAdapter extends BaseAdapter {




    ArrayList<HashMap<String, String>> data_adapter;

    public ConstructeurDefautAdapter(ArrayList<HashMap<String, String>> pData_a_afficher){

        this.data_adapter=pData_a_afficher;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView nom_recette_creee = null;
        TextView niveau_difficulte= null;
        TextView temps_cuisson= null;
        TextView preparation_recette= null;
        TextView ingredient= null;
        TextView temps_preparation = null;
        TextView type_plat= null;
        TextView auteur_recette= null;
        //si la vue est recyclé elle contient déjà le bon layout
        if (convertView != null){

            nom_recette_creee= (TextView)convertView.findViewById(R.id.nomrecette);

        }
        // si la vue n'est pas instanciée il faut la récupérer

        else{

            nom_recette_creee= (TextView) convertView.findViewById(R.id.nomrecette);

        }




        return null;
    }
}
