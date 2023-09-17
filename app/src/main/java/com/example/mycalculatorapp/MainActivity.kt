package com.example.mycalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycalculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bntClear.setOnClickListener {
            binding.tvInput.text = ""
            binding.tvOutput.text = ""
        }

        binding.bntOpen.setOnClickListener {
            binding.tvInput.append("(")
        }

        binding.bntClose.setOnClickListener {
            binding.tvInput.append(")")
        }

        binding.bntAdd.setOnClickListener {
            binding.tvInput.append("+")
        }

        binding.btnOne.setOnClickListener {
            binding.tvInput.append("1")
        }

        binding.btnTwo.setOnClickListener {
            binding.tvInput.append("2")
        }

        binding.btnThree.setOnClickListener {
            binding.tvInput.append("3")
        }

        binding.bntMinus.setOnClickListener {
            binding.tvInput.append("-")
        }

        binding.bntFour.setOnClickListener {
            binding.tvInput.append("4")
        }

        binding.bntFive.setOnClickListener {
            binding.tvInput.append("5")
        }

        binding.bntSix.setOnClickListener {
            binding.tvInput.append("6")
        }

        binding.bntMul.setOnClickListener {
            binding.tvInput.append("x")
        }

        binding.bntSeven.setOnClickListener {
            binding.tvInput.append("7")
        }

        binding.bntEight.setOnClickListener {
            binding.tvInput.append("8")
        }

        binding.btnNine.setOnClickListener {
            binding.tvInput.append("9")
        }

        binding.bntDiv.setOnClickListener {
            binding.tvInput.append("÷")
        }

        binding.bntDelete.setOnClickListener {
            val length = binding.tvInput.length()
            if (length > 0){
                binding.tvInput.text = binding.tvInput.text.subSequence(0, length -1)
            }
        }

        binding.bntZero.setOnClickListener {
            binding.tvInput.append("0")
        }

        binding.bntDot.setOnClickListener {
            binding.tvInput.append(".")
        }

        binding.bntEqual.setOnClickListener {

            showResult()
        }
    }

    private fun showResult(){
        try {
            val exception = binding.tvInput.text.toString()
            val result = ExpressionBuilder(exception).build()
            val value = result.evaluate()

            binding.tvOutput.text = DecimalFormat("0.##").format(value).toString()
        }
        catch (e : Exception) {
            binding.tvOutput.text = "Error"
        }
    }
}