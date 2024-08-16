package br.ufc.quixada.usoroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.ufc.quixada.usoroomdatabase.models.person;

@Dao
public interface personDao {
    @Insert
    void insertAll(person... persons);

    @Delete
    void delete(person person);

    @Query("SELECT * FROM person")
    List<person> getAllpersons();

}
