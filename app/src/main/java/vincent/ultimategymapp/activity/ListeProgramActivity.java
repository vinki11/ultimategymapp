package vincent.ultimategymapp.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import vincent.ultimategymapp.R;
import vincent.ultimategymapp.database.*;
import vincent.ultimategymapp.adapter.TrainingAdapter;
import vincent.ultimategymapp.listener.RecyclerViewItemClickListener;
import vincent.ultimategymapp.model.Training;

public class ListeProgramActivity extends AppCompatActivity implements RecyclerViewItemClickListener.OnItemClickListener{


    RecyclerView listeTraining;

    private TrainingAdapter adapter;
    private DrawerLayout drawerLayout;
    public static boolean updated = false;

    public static ActionMode actionMode;
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            updated = false;
            getMenuInflater().inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_program);

        //Initialisation de Database Helper
        DatabaseHelper dbh = new DatabaseHelper(this);

        //Assignation d'une database qui va etre readable et writable
        SQLiteDatabase db = dbh.getWritableDatabase();

        // Initialisation de la liste
        listeTraining = (RecyclerView) findViewById(R.id.listeTraining);

        // Taille fixe pour améliorer les performances
        if (listeTraining != null)
            listeTraining.setHasFixedSize(true);

        // Initialisation du layoutManager
        listeTraining.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TrainingAdapter(this);
        listeTraining.setAdapter(adapter);

        listeTraining.addOnItemTouchListener(new RecyclerViewItemClickListener(this, this));
        registerForContextMenu(listeTraining);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_liste_program, menu);
        return true;
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /**
     * ============================================================================================
     * ItemClickListener implementations
     * ============================================================================================
     */
    @Override
    public void onItemClick(View childView, int position) {
        if (actionMode == null) {
            Training tempSelected = adapter.getItemsTraining().get(position);

        }
    }

    @Override
    public void onItemLongPress(View childView, int position) {
    }
}
