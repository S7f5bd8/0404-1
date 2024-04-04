package kr.ac.kopo.a0314

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnPlus : Button
    lateinit var btnMinus : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var btnMod : Button
    lateinit var textResult : TextView
    var result : Float? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //위젯 객체의 참조값을 필드로 선언된  참조변수에 대입
        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)
        btnPlus = findViewById<Button>(R.id.btnPlus)
        btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnDivide = findViewById<Button>(R.id.btnDivide)
        btnMod = findViewById<Button>(R.id.btnmod)
        textResult = findViewById<TextView>(R.id.textResult)

        btnPlus.setOnClickListener(btnListener)
        btnMinus.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)
        btnMod.setOnClickListener(btnListener)

    }

    var btnListener = OnClickListener{
        val num1Str = edit1.text.toString()
        val num2Str = edit2.text.toString()

        if(num1Str == "" || num2Str == ""){
            Toast.makeText(baseContext, "입력을 하지 않았습니다.", Toast.LENGTH_LONG).show()
            return@OnClickListener
        }

        var num1 = num1Str.toFloat()
        var num2 = num2Str.toFloat()

        when(it.id){
            R.id.btnPlus -> result = num1 + num2
            R.id.btnMinus -> result = num1 - num2
            R.id.btnMultiply -> result = num1 * num2
            R.id.btnDivide -> {
                if(num2.toDouble() == 0.0){
                    Toast.makeText(baseContext, "0으로 나눌 시 나머지 없음", Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1 / num2
            }
            R.id.btnmod -> result = num1 % num2
        }
        textResult.text = "계산 결과: " + result
    }
}