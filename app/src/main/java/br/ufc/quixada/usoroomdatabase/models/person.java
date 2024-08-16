package br.ufc.quixada.usoroomdatabase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class person {
    // : Id, Nome, Curso e Idade
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "nome")
    public String nome;
    @ColumnInfo(name = "curso")
    public String curso;
    @ColumnInfo(name = "idade")
    public int idade;


    public person(String nome, String curso, int idade){
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
    }

    @NonNull
    @Override
    public String toString() {
        String retorno = this.uid + " | " + this.nome + " | " + this.curso + " | " + this.idade;
        return retorno ;
    }
}
