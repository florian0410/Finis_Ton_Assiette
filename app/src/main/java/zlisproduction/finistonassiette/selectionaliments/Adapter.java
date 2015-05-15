package zlisproduction.finistonassiette.selectionaliments;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Florian on 15/05/2015.
 */
public class Adapter extends BaseAdapter {
    //l'adapter contient la liste des données (par définition puisqu'il les gère)
    private ArrayList<Aliment> array =new ArrayList<Aliment>();
    //permet de sérialiser désérialiser
    private LayoutInflater inflater;
    //context
    private Context contexte;

    public Adapter(ArrayList<Aliment> array, Context contexte) {
        this.array = array;
        this.contexte = contexte;
        this.inflater = LayoutInflater.from(this.contexte);

    }
}
