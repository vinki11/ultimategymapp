package vincent.ultimategymapp.database;

import android.provider.BaseColumns;

/**
 * Created by Vincent on 2016-09-05.
 */
public final class DatabaseModel {

    // To prWorkout someone from accidentally instantiating the contract class
    public DatabaseModel() {
    }

    public static final String AS_INT_PK = " INTEGER PRIMARY KEY AUTOINCREMENT ";
    public static final String AS_TEXT = " TEXT ";
    public static final String AS_INT = " INTEGER ";
    public static final String AS_BLOB = " BLOB ";

    //Tables des workouts
    public static abstract class Workout implements BaseColumns {
        public static final String TABLE_NAME = "Workout";
        public static final String ID = "id";
        public static final String NOM = "nom";
        public static final String NOMBRE_SEMAINE = "nb_semaine";
        public static final String ACTIF = "actif";
        public static final String CREATE_TABLE = "CREATE TABLE " + Workout.TABLE_NAME
                + " ("
                + Workout.ID + AS_INT_PK + ", "
                + Workout.NOM + AS_TEXT + ", "
                + Workout.NOMBRE_SEMAINE + AS_INT + ", "
                + Workout.ACTIF + AS_INT
                + "); ";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Workout.TABLE_NAME + "; ";
    }

    //Tables des jours
    public static abstract class Jour implements BaseColumns {
        public static final String TABLE_NAME = "Jour";
        public static final String ID = "id";
        public static final String NOM = "nom";
        public static final String CREATE_TABLE = "CREATE TABLE " + Jour.TABLE_NAME
                + " ("
                + Jour.ID + AS_INT_PK + ", "
                + Jour.NOM + AS_TEXT
                + "); ";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Jour.TABLE_NAME + "; ";
    }

    //Tables des jours_workout
    public static abstract class Jour_workout implements BaseColumns {
        public static final String TABLE_NAME = "Jour_Workout";
        public static final String ID_WORKOUT = "id_workout";
        public static final String ID_JOUR = "id_jour";
        public static final String ORDRE = "ordre";
        public static final String CREATE_TABLE = "CREATE TABLE " + Jour_workout.TABLE_NAME
                + " ("
                + Jour_workout.ID_WORKOUT + AS_INT + ", "
                + Jour_workout.ID_JOUR + AS_INT + ", "
                + Jour_workout.ORDRE + AS_INT
                + "); ";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Jour_workout.TABLE_NAME + "; ";
    }

}

