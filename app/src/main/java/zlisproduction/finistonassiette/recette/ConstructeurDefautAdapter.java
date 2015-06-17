package zlisproduction.finistonassiette.recette;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.MainActivity;
import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 09/06/2015.
 */
public class ConstructeurDefautAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ArrayList<HashMap<String, String>> data_adapter;
    Context context;
    private int finalHeight;
    private int finalWidth;

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
        ImageView image_recette;
        ImageView image_chronomètre;
        ImageView image_four;
        ImageView image_assiette;
        ImageView image_icone;
        EditText edit;
        Button bouton;
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


            holder.bouton= (Button) convertView.findViewById(R.id.buttonmaillistealimentsmanquants);
            holder.nom_recette_creee=(TextView) convertView.findViewById(R.id.nomrecette);

            Typeface font = Typeface.createFromAsset(context.getAssets(), "Chantelli_Antiqua.ttf");
            holder.nom_recette_creee.setTypeface(font);

            final ViewHolder finalHolder = holder;
            holder.bouton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // requête pour s'envoyer les courses
                    //on récupère l'adresse mail:
                    String email = finalHolder.edit.getText().toString();
                    //consitution de la liste des ingrédients que l'utilisateur à déja

                    Object[] ingredients= MainActivity.result.toArray();
                    int tmpsize= ingredients.length;
                    ArrayList<String> ingr= new ArrayList<String>();
                    for (int h=0;h<tmpsize;h++){
                       ingr.add(ingredients[h].toString());
                    }
                    ingr.add(finalHolder.nom_recette_creee.getText().toString());
                    ingr.add(email);
                    Requete requete= new RequeteAlimentsManquants();
                    requete.execute(ingr);



                }
            });
            holder.edit= (EditText) convertView.findViewById(R.id.rentreradressemail);

            holder.niveau_difficulte =(TextView) convertView.findViewById(R.id.niveaudifficulte);

            holder.temps_cuisson = (TextView) convertView.findViewById(R.id.tpscuisson);

            holder.preparation_recette= (TextView) convertView.findViewById(R.id.preparation);

            holder.ingredient= (TextView) convertView.findViewById(R.id.ingredient);

            holder.temps_preparation = (TextView) convertView.findViewById(R.id.tempspreparation);

            holder.image_chronomètre =(ImageView) convertView.findViewById(R.id.imagechronomètre);

            Bitmap chronometre = BitmapFactory.decodeResource(context.getResources(), R.drawable.chronometre);
            holder.image_chronomètre.setImageBitmap(chronometre);

            holder.image_four=(ImageView) convertView.findViewById(R.id.imagefour);
            Bitmap four = BitmapFactory.decodeResource(context.getResources(), R.drawable.four);
            holder.image_four.setImageBitmap(four);

            holder.type_plat= (TextView) convertView.findViewById(R.id.typeplat);

            holder.image_assiette =(ImageView) convertView.findViewById(R.id.imagetyperepas);
            Bitmap typerepas = BitmapFactory.decodeResource(context.getResources(), R.drawable.assiette);
            holder.image_assiette.setImageBitmap(typerepas);

            holder.auteur_recette= (TextView) convertView.findViewById(R.id.donneessupplementaire);

            holder.image_icone =(ImageView) convertView.findViewById(R.id.imagedifficultee);
            Bitmap icone = BitmapFactory.decodeResource(context.getResources(), R.drawable.icone);
            holder.image_icone.setImageBitmap(icone);

            holder.image_recette= (ImageView) convertView.findViewById(R.id.image);




            convertView.setTag(holder);
        }
        // si elle à déja été instanciée
        else{

            holder = (ViewHolder) convertView.getTag();
        }


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

        String str = data_adapter.get(position).get("image");
        byte[] arr = Base64.decode(str,Base64.DEFAULT);
        Bitmap bitmap=BitmapFactory.decodeByteArray(arr, 0,arr.length);
        holder.image_recette.setImageBitmap(bitmap);

        return convertView;
    }


    /**
     * Cette méthode calcule la hauteur et la largeur de l'image view qui va contenir l'image de la recette
     * @param pHolder
     */
    public void getImageViewSize(final ViewHolder pHolder){
        ViewTreeObserver viewTreeObserver=  pHolder.image_recette.getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                pHolder.image_recette.getViewTreeObserver().removeOnPreDrawListener(this);
                setFinalHeight(pHolder.image_recette.getMeasuredHeight());
                setFinalWidth(pHolder.image_recette.getMeasuredWidth());
                return true;
            }
        });


    }
    /**
     * Retourne l'image adaptée à l' imageView
     * @param res
     * @param resId
     * @param reqWidth
     * @param reqHeight

     * @return
     */
    public static Bitmap decodeSampledBitmapFromByteArray(byte[] res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //on décode l'image
        BitmapFactory.decodeByteArray(res, 0, res.length, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(res, 0, res.length, options);
    }

    /**
     * cette fonction retourne le facteur par lequel il faut multiplier l'image pour la faire rentrer dans l'imageView
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return inSampleSize
     */
    public static int calculateInSampleSize (BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public void setmInflater(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    public int getFinalWidth() {
        return finalWidth;
    }

    public void setFinalWidth(int finalWidth) {
        this.finalWidth = finalWidth;
    }

    public int getFinalHeight() {
        return finalHeight;
    }

    public void setFinalHeight(int finalHeight) {
        this.finalHeight = finalHeight;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<HashMap<String, String>> getData_adapter() {
        return data_adapter;
    }

    public void setData_adapter(ArrayList<HashMap<String, String>> data_adapter) {
        this.data_adapter = data_adapter;
    }

}
