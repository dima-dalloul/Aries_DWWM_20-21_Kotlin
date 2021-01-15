package com.aries.phrasescultes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.util.*

class PhrasesCultesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation de la variable liste
        var listePhrasesCultes : ArrayList<String> = arrayListOf<String>()


        listePhrasesCultes.addAll(resources.getStringArray(R.array.phrases_cultes_string_array))

        for(phrase in listePhrasesCultes) {
            Log.i("PhrasesCultesActivity", phrase)
            Toast.makeText(this, phrase, Toast.LENGTH_SHORT).show()
        }

        // VERSION LONGUE
        var toastAAfficher : Toast = Toast(this)
        toastAAfficher.duration = Toast.LENGTH_LONG
        toastAAfficher.setText("Succès")
        toastAAfficher.show()

        // VERSION COURTE
        Toast.makeText(this, "Victoire", Toast.LENGTH_SHORT).show()


        var helloWorldTextView : TextView
        helloWorldTextView = findViewById(R.id.hello_world_text_view)

        helloWorldTextView.setText(listePhrasesCultes.get(0))
        helloWorldTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_purple))
        helloWorldTextView.setTextSize(resources.getDimension(R.dimen.pageAccueilDimen))

        var random : Random = Random()
        val min = 0
        val max = listePhrasesCultes.size
        var phraseIndiceAleatoire = random.nextInt(max - min + 1)
        Log.d("PhrasesCultesActivity", ""+phraseIndiceAleatoire)
        helloWorldTextView.setText(listePhrasesCultes.get(phraseIndiceAleatoire))
    }
}