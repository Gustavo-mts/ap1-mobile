package br.ufc.quixada.usoroomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.ufc.quixada.usoroomdatabase.dao.personDao;
import br.ufc.quixada.usoroomdatabase.models.person;

@Database(entities = {person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract personDao personDao();
}
