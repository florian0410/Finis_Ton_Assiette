package zlisproduction.finistonassiette.recette;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.sax.TextElementListener;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 09/06/2015.
 */
public class ConstructeurDefautAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ArrayList<HashMap<String, String>> data_adapter;
    Context context;

    public ConstructeurDefautAdapter(ArrayList<HashMap<String, String>> pData_a_afficher,Context pContext){

        this.data_adapter=pData_a_afficher;
        this.context= pContext;
    }

    private class ViewHolder{

        // Contient les view du layout
        TextView nom_recette_creee;
        TextView niveau_difficulte;
        TextView temps_cuisson;
        TextView preparation_recette;
        TextView ingredient ;
        TextView temps_preparation ;
        TextView type_plat ;
        TextView auteur_recette;
    }

    @Override
    public int getCount() {
        return data_adapter.size() ;
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

        ViewHolder holder= null;
        //layout inflater

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        // si la vue n'a jamais été instanciée
        if (convertView == null){

            convertView= mInflater.inflate(R.layout.constructeurdefautitemlayout, null);

            holder= new ViewHolder();

            holder.nom_recette_creee=(TextView) convertView.findViewById(R.id.nomrecette);
            Typeface font = Typeface.createFromAsset(context.getAssets(), "Chantelli_Antiqua.ttf");
            holder.nom_recette_creee.setTypeface(font);

            holder.niveau_difficulte =(TextView) convertView.findViewById(R.id.niveaudifficulte);

            holder.temps_cuisson = (TextView) convertView.findViewById(R.id.tpscuisson);

            holder.preparation_recette= (TextView) convertView.findViewById(R.id.preparation);

            holder.ingredient= (TextView) convertView.findViewById(R.id.ingredient);

            holder.temps_preparation = (TextView) convertView.findViewById(R.id.tempspreparation);

            holder.type_plat= (TextView) convertView.findViewById(R.id.typeplat);

            holder.auteur_recette= (TextView) convertView.findViewById(R.id.donneessupplementaire);


            convertView.setTag(holder);
        }
        // si elle à déja été instanciée
        else{

            holder = (ViewHolder) convertView.getTag();
        }
        //http://theopentutorials.com/post/uncategorized/android-custom-listview-with-image-and-text-using-baseadapter/
        // on adapte le texte

        holder.nom_recette_creee.setText(data_adapter.get(position).get("nom_recette_creee"));

        holder.niveau_difficulte.setText(data_adapter.get(position).get("niveau_difficulte"));

        holder.temps_cuisson.setText(data_adapter.get(position).get("temps_cuisson"));

        StringBuilder preparRecette= new StringBuilder();
        Object tmpObj=data_adapter.get(position).get("preparation_recette");
        String[] tmpStr= (String[]) tmpObj;
        for(String str :tmpStr){
            preparRecette.append(str+"\n");
        }
        holder.preparation_recette.setText(preparRecette);

        holder.temps_preparation.setText(data_adapter.get(position).get("temps_preparation"));

        StringBuilder stringBuilder= new StringBuilder();
        tmpObj=  data_adapter.get(position).get("ingredient");
        tmpStr = (String[]) tmpObj;
        for (String string : tmpStr){
            stringBuilder.append("- "+string+"\n");
        }
        holder.ingredient.setText(stringBuilder);

        holder.type_plat.setText(data_adapter.get(position).get("type_plat"));

        holder.auteur_recette.setText(data_adapter.get(position).get("auteur_recette"));

        return convertView;
    }
}
