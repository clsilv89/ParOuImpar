package com.caiosilva.parouimpar

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.caiosilva.parouimpar.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isPar: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.textView0.setOnClickListener {
            checarResultados(0, aoEscolherNumero(isPar))
        }
        binding.textView1.setOnClickListener {
            checarResultados(1, aoEscolherNumero(isPar))
        }
        binding.textView2.setOnClickListener {
            checarResultados(2, aoEscolherNumero(isPar))
        }
        binding.textView3.setOnClickListener {
            checarResultados(3, aoEscolherNumero(isPar))
        }
        binding.textView4.setOnClickListener {
            checarResultados(4, aoEscolherNumero(isPar))
        }
        binding.textView5.setOnClickListener {
            checarResultados(5, aoEscolherNumero(isPar))
        }
        binding.buttonPar.setOnClickListener {
            isPar = true
        }
        binding.buttonImpar.setOnClickListener {
            isPar = false
        }
    }

    private fun aoEscolherNumero(isPar: Boolean?): Int? {
        if (isPar == null) return null

        val escolhaDoApp: Int = Random.nextInt(5)

        binding.textViewAppChoice.text = escolhaDoApp.toString()
        return escolhaDoApp
    }

    private fun checarResultados(escolhaDoUsuario: Int, escolhaDoApp: Int?) {
        if (escolhaDoApp == null) {
            binding.textViewResultado.text = "Escolha entre par e ímpar"
        } else {
            val resultadoIsPar = (escolhaDoApp + escolhaDoUsuario) % 2 == 0

            binding.textViewResultado.text =
                if (resultadoIsPar && isPar == true) getString(R.string.app_loses, escolhaDoUsuario, escolhaDoApp)
                else if (!resultadoIsPar && isPar == false) getString(R.string.app_loses, escolhaDoUsuario, escolhaDoApp)
                else getString(R.string.app_wins, escolhaDoUsuario, escolhaDoApp)
        }
        isPar = null
    }
}
