package au.edu.swin.sdmd.timetableapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val factor1 : Int = Random.nextInt(1, 13)
        val factor2 : Int = Random.nextInt(1, 13)

        val factor1View = findViewById<TextView>(R.id.factor1)
        val factor2View = findViewById<TextView>(R.id.factor2)
        factor1View.setText(factor1.toString())
        factor2View.setText(factor2.toString())

        val showResult = findViewById<Button>(R.id.resultButton)
        showResult.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("factor1", factor1)
            intent.putExtra("factor2", factor2)
            startActivity(intent)
        }


    }
}