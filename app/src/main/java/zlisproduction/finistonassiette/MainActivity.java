package zlisproduction.finistonassiette;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import zlisproduction.finistonassiette.adapter.NavDrawerListAdapter;
import zlisproduction.finistonassiette.model.NavDrawerItem;
import zlisproduction.finistonassiette.recette.ConstructeurDefaut;
import zlisproduction.finistonassiette.recette.ConsulterRecette;
import zlisproduction.finistonassiette.recette.Information;
import zlisproduction.finistonassiette.recette.JsonFormat;
import zlisproduction.finistonassiette.recette.Requete;
import zlisproduction.finistonassiette.selectionaliments.MenuPrincipal;
import zlisproduction.finistonassiette.selectionaliments.PatesFarinesCereales;
import zlisproduction.finistonassiette.selectionaliments.barcodescanner.ScannerMainFragment;

public class MainActivity extends FragmentActivity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;
    private Fragment fragment = null;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        // Layout pour définir l'affichage des fragments et du menu
		setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.frame_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
        }
		mTitle = mDrawerTitle = getTitle();
		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		// Récupérer les ressources image du menu slide
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);
        // Contient l'interface entière
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Contient le menu slide
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);


		navDrawerItems = new ArrayList<NavDrawerItem>();
		// Menu Principal
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		// Pas encore assigné
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Pas encore assigné
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Pas encore assigné
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        // Pas encore assigné
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // Pas encore assigné
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "50+"));

        // Recycle the typed array
		navMenuIcons.recycle();
		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
        // On affiche la première page d&finie à la position 0
		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

    // Gérer la partie menu options ( en haut à droite de la navigationBar)
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

    // Les action réalisées par ce menu options
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 *Permet de cacher le menu quand on accède aux options
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Liste des items redirigeant vers le fragment choisi dans le menuSlider
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		switch (position) {
		case 0:
			fragment = new MenuPrincipal();
			break;
		case 1:
			fragment = new ScannerMainFragment();
			break;
		case 2:

			//on efectue la requête pour consulter une recette
			//1) on récupère les aliments que l'utilisateur a choisi (simulation ici)
			ArrayList<String> result= new ArrayList<String>();
            result.add("oeuf");

            // définition des comportements pour la requête consulter recette
			Information frag =  new Information();
			frag.setRequete(new ConsulterRecette());
			//exécution de la requete à consulter
            String[] tmpResRequete = null;

			try {
				tmpResRequete =frag.getRequete().execute(result).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

            //définition du comportement pour l'analyse du resultat
			frag.setAnalyse_resultat(new JsonFormat(tmpResRequete));
			//exécution de l'analyse
            ArrayList<HashMap<String, Object>> tpsResAnalyse = null;

            try {
                tpsResAnalyse = frag.getAnalyse_resultat().demande_consulter_recette();
            } catch (JSONException e) {
                e.printStackTrace();
            }

			frag.setInstancie(new ConstructeurDefaut());

			//on passe les arguments au nouveau fragment
			Bundle args = new Bundle();
            args.putSerializable("ingredients", tpsResAnalyse);
			frag.getInstancie().setArguments(args);
			fragment= frag.getInstancie();



			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
            //fragment = new MenuPrincipal();
            break;
		}

		// remplaçement du gragment
		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.frame_container, fragment);
            // Il est important de rajouter le fragment précédent à la pile pour pouvoir le recharger si nécessaire
            ft.addToBackStack(null);
            ft.commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * Gestion des actions avant le glissement de la barre
     * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

    /**
     *Probablement les actions qui se font quand le menu a slidé
     */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

    /*
     *Méthode permettant de revenir au fragment précédent au lieu de revenir à l'activité précédent ou quitter
     */
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
