package com.aries.phrasescultes

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Cours3VuesBrouillonActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cours3_vues_brouillon)

        // Modification dynamique du spinner, càd la liste déroulante
        // Étape 1 : construire la liste des choix de la liste déroulante
        var valeursPhrasesCultes: Array<String> = resources.getStringArray(R.array.phrases_cultes_string_array)

        // Étape 2 : transformer le tableau de String en un objet compréhensible par la liste déroulante => on utilisera un adaptateur
        val adaptateur = ArrayAdapter(this, android.R.layout.simple_spinner_item, valeursPhrasesCultes)

        // Étape 3 : lier cet adaptateur au spinner (liste déroulante) en question
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adaptateur
    }
}