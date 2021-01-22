package com.aries.phrasescultes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import java.util.*

class PhrasesCultesActivity : AppCompatActivity() {
    val TAG = "PhrasesCultesActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation de la variable liste
        var listePhrasesCultes : ArrayList<String> = arrayListOf<String>()

        // Ajout de toutes les phrases cultes dans la liste Phrase Cultes
        listePhrasesCultes.addAll(resources.getStringArray(R.array.phrases_cultes_string_array))

        // Affichage des phrases cultes dans le Logcat
        for(phrase in listePhrasesCultes) {
            Log.i(TAG, phrase)
            //Toast.makeText(this, phrase, Toast.LENGTH_SHORT).show()
        }

        // VERSION LONGUE pour les Toast
        var toastAAfficher : Toast = Toast(this)
        toastAAfficher.duration = Toast.LENGTH_LONG
        toastAAfficher.setText("Succès")
        toastAAfficher.show()

        // VERSION COURTE pour les Toast
        Toast.makeText(this, "Victoire", Toast.LENGTH_SHORT).show()

        // Modification dynamique d'un TextView
        var helloWorldTextView : TextView
        helloWorldTextView = findViewById(R.id.hello_world_text_view)
        
        // Modification de la largeur de la TextView
        val parametres = helloWorldTextView?.layoutParams as LinearLayout.LayoutParams
        // EQUIVALENT A: val parametres : LinearLayout.LayoutParams = helloWorldTextView?.layoutParams
        parametres.width = ConstraintLayout.LayoutParams.MATCH_PARENT
        parametres.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
        helloWorldTextView.layoutParams = parametres

        // Modification du texte (et de la taille et de la couleur du texte) de la TextView
        helloWorldTextView.setText(listePhrasesCultes.get(0))
        helloWorldTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_purple))
        helloWorldTextView.setTextSize(resources.getDimension(R.dimen.pageAccueilDimen))

        // FONCTIONNALITÉ : Affichage d'une phrase culte aléatoire dans le TextView
        var random : Random = Random()
        val min = 0
        val max = listePhrasesCultes.size
        var phraseIndiceAleatoire = random.nextInt(max - min + 1)
        Log.d(TAG, ""+phraseIndiceAleatoire)
        helloWorldTextView.setText(listePhrasesCultes.get(phraseIndiceAleatoire))

        // FONCTIONNALITÉ : Création d'un écho
        // Récupération d'accès sur le Bouton, l'EditText et le TextView
        val echoTextView : TextView = findViewById(R.id.echoTextView)
        val echoEditText = findViewById<EditText>(R.id.echoInputUtilisateur)
        val echoBouton = findViewById<Button>(R.id.echoBouton)

        // On met un écouteur sur le bouton Echo
        echoBouton.setOnClickListener{
            Toast.makeText(this, "Echo", Toast.LENGTH_SHORT).show()

            // On récupère le texte écrit par l'utilisateur
            var texteDeLaPartDeLUtilisateur = echoEditText.text

            Log.i(TAG, "l'Utilisateur a écrit : " + texteDeLaPartDeLUtilisateur)

            // On affiche le texte écrit par l'utilisateur dans la TextView correspondante
            echoTextView.setText(texteDeLaPartDeLUtilisateur)
            echoTextView.setTextColor(ContextCompat.getColor(this, R.color.pink))
            echoTextView.setTextSize(resources.getDimension(R.dimen.pageAccueilDimen))
        }
    }
}