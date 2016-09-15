package vincent.ultimategymapp.database;

import android.provider.BaseColumns;

/**
 * Created by Vincent on 2016-09-05.
 */
public final class DatabaseModel {

    // To prprogram someone from accidentally instantiating the contract class
    public DatabaseModel() {
    }

    public static final String AS_INT_PK = " INTEGER PRIMARY KEY AUTOINCREMENT ";
    public static final String AS_TEXT = " TEXT ";
    public static final String AS_INT = " INTEGER ";
    public static final String AS_BLOB = " BLOB ";

    //Tables des programs
    public static abstract class Program implements BaseColumns {
        public static final String TABLE_NAME = "Program";
        public static final String ID = "id";
        public static final String NOM = "nom";
        public static final String NOMBRE_SEMAINE = "nb_semaine";
        public static final String ACTIF = "actif";
        public static final String CREATE_TABLE = "CREATE TABLE " + Program.TABLE_NAME
                + " ("
                + Program.ID + AS_INT_PK + ", "
                + Program.NOM + AS_TEXT + ", "
                + Program.NOMBRE_SEMAINE + AS_INT + ", "
                + Program.ACTIF + AS_INT
                + "); ";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Program.TABLE_NAME + "; ";
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

    //Tables des jours_program
    public static abstract class Jour_Program implements BaseColumns {
        public static final String TABLE_NAME = "Jour_program";
        public static final String ID_PROGRAM = "ID_PROGRAM";
        public static final String ID_JOUR = "id_jour";
        public static final String ORDRE = "ordre";
        public static final String CREATE_TABLE = "CREATE TABLE " + Jour_Program.TABLE_NAME
                + " ("
                + Jour_Program.ID_PROGRAM + AS_INT + ", "
                + Jour_Program.ID_JOUR + AS_INT + ", "
                + Jour_Program.ORDRE + AS_INT
                + "); ";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Jour_Program.TABLE_NAME + "; ";
    }

}

