package zlisproduction.finistonassiette.recette;

import org.json.JSONObject;

/**
 * Created by Thibaut on 24/05/2015.
 */
public interface AnalyseResultat {

    /**
    Retourne la liste de toutes les recettes possédant les aliments critiques

     */
    public void demande_consulter_recette();

    public void resutat_ajouter_recette();
    public void resultat_suggestion_courses();

    /*String newFileName = "my-image";
    File imageFile = new File("/users/victor/images/image.png");
    GridFS gfsPhoto = new GridFS(db, "photo");
    GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
    gfsFile.setFilename(newFileName);
    gfsFile.save();*/
}
