package com.aries.helloDroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Main Activity", "Je suis dans le OnCreate")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.w("Main Activity", "Oh non ! L'activité est en cours de destruction!")
    }

    override fun onStart() {
        super.onStart()

        Log.v("Main Activity", resources.getString(R.string.app_name))
        Log.v("Main Activity", resources.getString(android.R.string.ok) )
    }

    override fun onStop() {
        super.onStop()

        Log.d("Main Activity", "STOPPPP")

    }

    override fun onResume() {
        super.onResume()

        Log.d("Main Activity", "Reprise d'activité")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Main Activity", "PAUSE CAFÉ")
    }


    override fun onRestart() {
        super.onRestart()

        Log.v("Main Activity", "Restart")
    }
}