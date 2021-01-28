package com.aries.phrasescultes

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class EchoActivity: AppCompatActivity() {
    val TAG = "EchoActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.echo_layout)

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