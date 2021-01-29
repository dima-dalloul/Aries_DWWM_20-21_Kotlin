package com.aries.phrasescultes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Cours3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.linear_layout_cours3)

        // Étape 1 : récupérer les références vers les 2 Edit texts et les 2 boutons
        val prenomEditText : EditText = findViewById(R.id.cours3_edittext_prenom)
        val nomEditText: EditText = findViewById(R.id.cours3_edittext_nom)
        val boutonAjouter : Button = findViewById(R.id.bouton_ajouter_cours3)
        val boutonAnnuler : Button = findViewById(R.id.bouton_annuler_cours3)

        // Étape 2 : Mettre des écouteurs sur les 2 boutons
        boutonAjouter.setOnClickListener {
            // Si on clique sur Ajouter, alors on fera un Toast affichant le prénom et le nom entrés par  l'utilisateur
            var prenom = prenomEditText.text
            var nom = nomEditText.text

            Toast.makeText(this, "Coucou " + prenom + " " + nom, Toast.LENGTH_LONG).show()
        }

        boutonAnnuler.setOnClickListener {
            // Si on clique sur Ajouter, alors on fera un retour en arrière
            super.onBackPressed()
        }
    }
}