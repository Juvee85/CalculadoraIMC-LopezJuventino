package lopez.juventino.asignacion4_calculadora_imc_lopez

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etEstatura: EditText = findViewById(R.id.etEstatura)
        val etPeso: EditText = findViewById(R.id.etPeso)
        val tvResultado: TextView = findViewById(R.id.tvResultado)
        val tvRango: TextView = findViewById(R.id.tvRango)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener{
            val peso: Float = etPeso.text.toString().toFloat()
            val estatura: Float = etEstatura.text.toString().toFloat()
            val imc = calcularIMC(estatura, peso)
            val rango = obtenerCategoria(imc)
            tvResultado.visibility = View.VISIBLE
            tvRango.visibility = View.VISIBLE
            tvResultado.text = "$imc"
            tvRango.text = rango
            when (rango) {
                "Bajo Peso"-> tvRango.setBackgroundResource(R.color.greenish)
                "Normal" -> tvRango.setBackgroundResource(R.color.greenish)
                "Sobrepeso" -> tvRango.setBackgroundResource(R.color.yellow)
                "Obesidad Grado 1" -> tvRango.setBackgroundResource(R.color.orange)
                "Obesidad Grado 2" -> tvRango.setBackgroundResource(R.color.red)
                "Obesidad Grado 3" -> tvRango.setBackgroundResource(R.color.brown)
            }
        }
    }

    fun calcularIMC(estatura: Float, peso: Float): Float = peso / (estatura * estatura)

    fun obtenerCategoria(imc: Float): String {
        return when {
            imc < 18.5 ->"Bajo Peso"
            imc < 25 ->"Normal"
            imc < 30 ->"Sobrepeso"
            imc < 35 ->"Obesidad Grado 1"
            imc < 40 ->"Obesidad Grado 2"
            imc >= 40 ->"Obesidad Grado 3"
            else ->""
        }
     }
}