package zlisproduction.finistonassiette.selectionaliments;

import android.content.Context;

import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian.S on 05/06/2015.
 *
 * Cette classe stockera 2 HashMap, la première permettra d'accéder à la catégorie
 * La seconde contenue dans la première stockera tout les aliments et leur image associées
 *
 * Optimisation : Plus tard on stockera toutes ces données dans une BDD selon le temps restant
 */
public class Aliment {

    // HashMap pour trouver la HashMap aliment selon la catégorie
    private HashMap<String,HashMap<String,Integer>> hashMapCatégories = new HashMap<>();

    // Toutes les hashmap pour chaque catégorie
    private HashMap<String, Integer> hashMapCereales= new HashMap <>();
    private HashMap<String, Integer> hashMapFarine = new HashMap<String,Integer>();
    private HashMap<String, Integer> hashMapFruit= new  HashMap<String, Integer>();
    private HashMap<String, Integer> hashMapIncontournable= new HashMap<String, Integer>();
    private HashMap<String, Integer> hashMapLegumes= new HashMap<String, Integer>();
    private HashMap<String, Integer> hashMapPates = new HashMap<String, Integer>();
    private HashMap<String, Integer> HashPoisson = new HashMap<String, Integer>();
    private HashMap<String, Integer> hashMapProduitLaitier = new HashMap<String, Integer>();
    private HashMap<String, Integer> hashMapViande = new HashMap<String, Integer>();







    public Aliment(Context pContext){
        CreateListeAliments(pContext);
    }

    public void CreateListeAliments(Context pContext){
        hashMapCatégories.put(pContext.getString(R.string.Céréales),hashMapCereales);
        hashMapCatégories.put(pContext.getString(R.string.Farine),hashMapFarine);
        hashMapCatégories.put(pContext.getString(R.string.Fruit),hashMapFruit);
        hashMapCatégories.put(pContext.getString(R.string.Incontournable),hashMapIncontournable);
        hashMapCatégories.put(pContext.getString(R.string.Legume),hashMapIncontournable);
        hashMapCatégories.put(pContext.getString(R.string.Pates),hashMapPates);
        hashMapCatégories.put(pContext.getString(R.string.Poisson),HashPoisson);
        hashMapCatégories.put(pContext.getString(R.string.Produits_Laitier),hashMapProduitLaitier);
        hashMapCatégories.put(pContext.getString(R.string.Viande),hashMapViande);



        // Céréales
        hashMapCereales.put(pContext.getString(R.string.Blé), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Boulghour), R.drawable.ic_boulgourtransparentlast);
        hashMapCereales.put(pContext.getString(R.string.Farine_de_froment), R.drawable.ic_farine_fromenttransparent);
        hashMapCereales.put(pContext.getString(R.string.Lasagnes), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Müesli), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Pâtes_de_riz), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Quinoa), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Riz_complet), R.drawable.ic_rizcomplettransparent);
        hashMapCereales.put(pContext.getString(R.string.Sarrasin), R.drawable.ic_beurretransparent);
        // Farine
        hashMapFarine.put(pContext.getString(R.string.Farine_de_blé), R.drawable.ic_farine_transparent);
        hashMapFarine.put(pContext.getString(R.string.Farine_de_Froment), R.drawable.ic_farine_fromenttransparent);
        // Fruit
        hashMapFruit.put(pContext.getString(R.string.Abricots), R.drawable.ic_amande_en_poudretransparente);
        hashMapFruit.put(pContext.getString(R.string.Amandes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Ananas), R.drawable.ic_ananastransparent);
        hashMapFruit.put(pContext.getString(R.string.Banane), R.drawable.ic_bananetransparent);
        hashMapFruit.put(pContext.getString(R.string.Cassis), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Cerises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Châtaignes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Citron), R.drawable.ic_citrontransparent);
        hashMapFruit.put(pContext.getString(R.string.Citron_vert), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Clémentine), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Coing), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Dattes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Figues), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Fraises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Framboises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Fruit_de_la_passion), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Fruits_confits), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Goyave), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Groseilles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Kiwi), R.drawable.ic_kiwitransparent);
        hashMapFruit.put(pContext.getString(R.string.Litchies), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Mangue), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Melon), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Mirabelles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Myrtilles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Noisettes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Orange), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Pamplemousse), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Papaye), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Pêche), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Pastèque), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Pistaches), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Poire), R.drawable.ic_poirestransparent);
        hashMapFruit.put(pContext.getString(R.string.Pomme), R.drawable.ic_pommetransparent);
        hashMapFruit.put(pContext.getString(R.string.Prunes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(pContext.getString(R.string.Raisin_blanc), R.drawable.ic_raisin_blanc);
        hashMapFruit.put(pContext.getString(R.string.Raisin_noir), R.drawable.ic_raisintransparent);
        hashMapFruit.put(pContext.getString(R.string.Rhubarde), R.drawable.ic_beurretransparent);
        // Incontournable
        hashMapIncontournable.put(pContext.getString(R.string.Ail), R.drawable.ic_ailtransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Beurre_margarine), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Chocolat), R.drawable.ic_chocolattransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Crème_fraiche), R.drawable.ic_cremefraichetransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Eau), R.drawable.ic_eautransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Farine_de_blé), R.drawable.ic_farine_transparent);
        hashMapIncontournable.put(pContext.getString(R.string.Gruyére_emmental), R.drawable.ic_gruyeretransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Huile_d_olive), R.drawable.ic_huileolivetransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Huile_de_tournesol), R.drawable.ic_huile_tournesol_transparente);
        hashMapIncontournable.put(pContext.getString(R.string.Lait), R.drawable.ic_bouteillelaittransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Miel), R.drawable.ic_pot_mieltransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Oeuf), R.drawable.ic_oeufs_tourgris_transparent);
        hashMapIncontournable.put(pContext.getString(R.string.Oignon), R.drawable.ic_oignontransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Pâte_brisée), R.drawable.ic_pates_briseetransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Pâte_feuilletée), R.drawable.ic_patefeuilletetransparentegrand);
        hashMapIncontournable.put(pContext.getString(R.string.Pâtes), R.drawable.ic_paquetpatestransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Poivre), R.drawable.ic_poivretransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Pomme_de_terre), R.drawable.ic_pommedeterre2transparent);
        hashMapIncontournable.put(pContext.getString(R.string.Riz_blanc), R.drawable.ic_bolriztransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Sel), R.drawable.ic_seltransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Sucre), R.drawable.ic_sucretransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Tomate), R.drawable.ic_tomatetransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Vinaigre_balsamique), R.drawable.ic_vinaigretransparent);
        hashMapIncontournable.put(pContext.getString(R.string.Yaourt_nature), R.drawable.ic_yaourttransparent);
        hashMapIncontournable.put(pContext.getString(R.string.sucre_glace), R.drawable.ic_sucre_glacetransparent);
        hashMapIncontournable.put(pContext.getString(R.string.moutarde), R.drawable.ic_moutardetransparente);
        //Légume
        hashMapLegumes.put(pContext.getString(R.string.Artichaut), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(pContext.getString(R.string.Aubergine),R.drawable.ic_auberginetransparent);
        hashMapLegumes.put(pContext.getString(R.string.Avocat), R.drawable.ic_avocattransparent);
        hashMapLegumes.put(pContext.getString(R.string.Betterave),R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Brocoli), R.drawable.ic_brocolistransparent);
        hashMapLegumes.put(pContext.getString(R.string.Carotte), R.drawable.ic_carottetransparent);
        hashMapLegumes.put(pContext.getString(R.string.chou_blanc_ou_vert), R.drawable.ic_choutransparent);
        hashMapLegumes.put(pContext.getString(R.string.chou_fleur), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Choux_de_Bruxelles), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Coeur_de_palmier), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Concombre), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Courgette), R.drawable.ic_1courgettetransparent);
        hashMapLegumes.put(pContext.getString(R.string.Épinards), R.drawable.ic_epinardstransparent);
        hashMapLegumes.put(pContext.getString(R.string.Fenouil), R.drawable.ic_fenouiltransparent);
        hashMapLegumes.put(pContext.getString(R.string.Flageolets), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Germes_de_soja), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Haricots_verts), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Lentilles), R.drawable.ic_lentillestransparent);
        hashMapLegumes.put(pContext.getString(R.string.Maïs), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Navet), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Olives_noires), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Olives_vertes), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Patate_douce), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Petits_pois), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Poireau), R.drawable.ic_poireauxtransparent);
        hashMapLegumes.put(pContext.getString(R.string.Pois_cassés), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Pois_chiches), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Pois_gourmands), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Poivron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Potimarron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Potiron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.Radis), R.drawable.ic_radistransparent);
        hashMapLegumes.put(pContext.getString(R.string.Salade_verte), R.drawable.ic_salade_vertetransparent);
        hashMapLegumes.put(pContext.getString(R.string.Tomate_verte), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(pContext.getString(R.string.asperge), R.drawable.ic_aspergestransparent);
        hashMapLegumes.put(pContext.getString(R.string.echalotte), R.drawable.ic_echalotetransparent);
        hashMapLegumes.put(pContext.getString(R.string.menthe), R.drawable.ic_menthetransparente);
        //Pâtes
        hashMapPates.put(pContext.getString(R.string.Coquillettes), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Spaghetti), R.drawable.ic_spaghettitransparent);
        hashMapPates.put(pContext.getString(R.string.Farfalle), R.drawable.ic_farfalestransparent);
        hashMapPates.put(pContext.getString(R.string.Penne_Rigate), R.drawable.ic_pennetransparent);
        hashMapPates.put(pContext.getString(R.string.Linguine), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Tagliatelle), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Macaroni), R.drawable.ic_macaronitransparent);
        hashMapPates.put(pContext.getString(R.string.Nouilles), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Fusilli), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Capellini), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Torti), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Vermicelli), R.drawable.ic_beurretransparent);
        hashMapPates.put(pContext.getString(R.string.Lasagnes), R.drawable.ic_lasagnestransparent);
        hashMapPates.put(pContext.getString(R.string.pates_deja_cuites), R.drawable.ic_lasagnestransparent);
        // Poisson
        HashPoisson.put(pContext.getString(R.string.Cabillaud), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Calamars), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Colin), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Crevettes), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Daurade), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Flétan), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Gambas), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Haddock), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Hareng), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Lieu), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Maquerau), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Merlu), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Moules), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Oeufs_de_lump), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Saint_Jacques), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Sardines), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Saumon), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Saumon_fumé), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Sole), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Surimi), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Thon_en_boite), R.drawable.ic_beurretransparent);
        HashPoisson.put(pContext.getString(R.string.Truite), R.drawable.ic_beurretransparent);
        // Produit Laiter
        hashMapProduitLaitier.put(pContext.getString(R.string.Brie), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Camembert), R.drawable.ic_camembertplanchetransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Cantal), R.drawable.ic_emmentaltransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Chévre_Brebis), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Comté), R.drawable.ic_compttransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Feta), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Fromage_blanc), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Lait_de_coco), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Lait_de_soja), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Mascarpone), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Mont_d_Or), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Mozarella), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Parmesan), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Petits_suisses), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Raclette), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Roquefort), R.drawable.ic_rocqueforttransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.Saint_Marcelin), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(pContext.getString(R.string.gouda), R.drawable.ic_goudatransparent);
        // Viande
        hashMapViande.put(pContext.getString(R.string.Agneau), R.drawable.ic_cotes_agneautransparent);
        hashMapViande.put(pContext.getString(R.string.Boeuf), R.drawable.ic_steaktransparent);
        hashMapViande.put(pContext.getString(R.string.Boudin_blanc), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Boudin_noir), R.drawable.ic_boudin_noirtransparent);
        hashMapViande.put(pContext.getString(R.string.Caille), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Dinde), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Escargots), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Foie_gras), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Jambon_blanc), R.drawable.ic_jambontransparent);
        hashMapViande.put(pContext.getString(R.string.Jambon_cru), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Jambon_fumé), R.drawable.ic_jambon_fumtransparent);
        hashMapViande.put(pContext.getString(R.string.Lapin), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Lard_Lardons), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Merguez), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Mouton), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Oeufs_à_la_caille), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Os_à_moëlle), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Porc), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Poulet), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Quenelles), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.Saucisse), R.drawable.ic_saucissetransparente);
        hashMapViande.put(pContext.getString(R.string.Veau), R.drawable.ic_beurretransparent);
        hashMapViande.put(pContext.getString(R.string.saucisson), R.drawable.ic_saucissontransparent);
        hashMapViande.put(pContext.getString(R.string.dinde), R.drawable.ic_dindetransparente);

    }

    public HashMap<String, Integer> getHashMapAlimentFromCategorie(String pCategorie) {
        return hashMapCatégories.get(pCategorie);
    }

}

