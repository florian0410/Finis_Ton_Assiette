package zlisproduction.finistonassiette;

/**
 * Created by Florian.S on 21/06/2015.
 * Fonction utilisée pour la gestion des 2 fragments dans le mainActivity
 */
public class CommunicateWithFragment {
    private static boolean newActivity = false;

    public static boolean getNewActivity(){
        return newActivity;
    }
    public static void SetNewActivity(boolean pState){
        newActivity = pState;
    }
}
