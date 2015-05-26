package zlisproduction.finistonassiette.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.selectionaliments.Aliment;

/**
 * Created by Florian on 15/05/2015.
 */
public class Adapter extends BaseAdapter {

    private ArrayList<Aliment> array = new ArrayList<Aliment>();
    //permet de sérialiser désérialiser
    private LayoutInflater inflater;
    //context
    private Context contexte;

    public Adapter(ArrayList<Aliment> array, Context contexte) {
        this.array = array;
        this.contexte = contexte;
        this.inflater = LayoutInflater.from(this.contexte);
    }
    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Aliment getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aliment object = array.get(position);
        MonViewHolder holder;
        /*
        premières fois qu'on affiche la liste, il faut inflater depuis le fichier xml car les vue n'ont jamais été créées gh
         */
        if (convertView==null){
            //layout de chaque élément de la liste: le même pour tous voir fichier xml
            convertView=inflater.inflate(R.layout.listitemlayout,null);
            holder=new MonViewHolder();
            //extaction des vues
            holder.text=(TextView) convertView.findViewById(R.id.nomproduit);
            holder.icon=(ImageView) convertView.findViewById(R.id.imageproduit);
            //on met le holder dans la vue (une optimisation)
            convertView.setTag(holder);
        }
        else{
            // si la vue a déja été créee et qu'elle disparait de l'écran on a juste a la récupérer pas besoin de la désérialisé car ça a été deja fait juste avant
            holder=(MonViewHolder)convertView.getTag();
        }
        // On défini la couleur de fond à l'initialisation de la liste
        convertView.setBackgroundColor(Color.BLUE); //TODO : Simplifier cette ligne qui s'éxécute à chaque initialisation ou actualisation => Temps de chargement plus long
        // Selon l'état actuel de sélection de l'aliment, on change le fond de la case de l'aliment
        if (object.isClicked() == true) {
            convertView.setBackgroundColor(Color.GREEN);
        } else {
            convertView.setBackgroundColor(Color.BLUE);
        }

        // on récupère dans les deux cas l'objet aliment qui a disparu ou qui a été crée et on lui fixe ses paramètres
        Aliment alim=(Aliment)getItem(position);
        if (alim !=null){
            holder.text.setText(alim.getName());
            holder.icon.setImageResource(alim.getImage());
        }
        return convertView;
    }
    /*
    Contient les vues du layout
     */
    private class MonViewHolder{
        TextView text;
        ImageView icon;
    }
}
