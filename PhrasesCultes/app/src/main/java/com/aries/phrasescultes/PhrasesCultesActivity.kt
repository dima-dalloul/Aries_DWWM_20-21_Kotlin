package com.aries.phrasescultes

import android.content.Intent
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
        parametres.width = LinearLayout.LayoutParams.MATCH_PARENT
        parametres.height = LinearLayout.LayoutParams.WRAP_CONTENT
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

        /*
        // FONCTIONNALITÉ : Modification dynamique du spinner, càd la liste déroulante
        // Étape 1 : construire la liste des choix de la liste déroulante
        var tableauPhrasesCultes : Array<String> = resources.getStringArray(R.array.phrases_cultes_string_array)

        // Étape 2 : transformer le tableau de String en un objet compréhensible par la liste déroulante => on utilisera un adaptateur
        var adaptateurSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, tableauPhrasesCultes)

        // Étape 3 : lier cet adaptateur au spinner (liste déroulante) en question
        val spinnerPhrasesCultes : Spinner = findViewById(R.id.spinner_phrases_cultes)
        spinnerPhrasesCultes.adapter = adaptateurSpinner
        */

        // FONCTIONNALITÉ : Navigation vers l'activity Cours 3
        // Étape 1 : récupérer une référence vers le bouton qui permet de naviguer
        var boutonVersCours3Activity : Button = findViewById(R.id.button_go_to_cours3)

        // Étape 2 : mettre un écouteur sur ce bouton afin que si on clique dessus, on puisse effectuer la navigation
        boutonVersCours3Activity.setOnClickListener {

            // Étape 3 : créer l'intention de navigation vers Activity Cours 3 et la lancer
            var intentionVersCours3 : Intent = Intent(this, Cours3Activity::class.java)
            startActivity(intentionVersCours3)
        }

        // FONCTIONNALITÉ : Affichage des phrases cultes dans la liste view
        // Étape 1 : construire la liste des phrases cultes
        var tableauPhrasesCultes : Array<String> = resources.getStringArray(R.array.phrases_cultes_string_array)

        // Étape 2 : transformer le tableau de String (contenant les phrases cultes) en un objet compréhensible par la ListView => on utilisera un adaptateur
        var adapatateurListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, tableauPhrasesCultes)

        // Étape 3 : récupérer une référence vers la ListView
        var listviewPhrasesCultes : ListView = findViewById(R.id.listview_phrases_cultes)

        // Étape 4 : lier cet adaptateur à la ListView concernée
        listviewPhrasesCultes.adapter = adapatateurListView

        // Étape 5 : Mettre en place un écouteur de clics
        listviewPhrasesCultes.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, tableauPhrasesCultes.get(position), Toast.LENGTH_SHORT).show()
        }
    }
}