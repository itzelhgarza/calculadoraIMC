package mx.edu.itson.asignacion4_calculadoraimc_garza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    //Variables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight : EditText = findViewById(R.id.weight)
        val height : EditText = findViewById(R.id.height)
        val imc : TextView = findViewById(R.id.imc)
        val range : TextView = findViewById(R.id.range)
        val calcular:Button =findViewById(R.id.calcular)


        calcular.setOnClickListener{
            var num_w:Double = weight.text.toString().toDouble()
            var num_h:Double = height.text.toString().toDouble()
            imc.setText(calcularIMC(num_w,num_h).toString())
            range.setText(categoria(calcularIMC(num_w,num_h)))

        }
    }

    fun calcularIMC(num_w:Double,num_h:Double): Double{
        return num_w/(num_h*num_h)
    }
    fun categoria(num:Double): String{
        if(num<=18.5){
            return "Bajo peso"
        }else if(num>18.5&&num<=24.9){
            return "Normal"
        }else if(num>24.9&&num<=29.9){
            return "Sobrepeso"
        }else if(num>29.9&&num<=34.9){
            return "Obesidad grado 1"
        }else if(num>34.9&&num<=39.9){
            return "Obesidad grado 2"
        }else{
            return "Obesidad grado 3"
        }
    }
}