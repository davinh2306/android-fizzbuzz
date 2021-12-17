package fr.davinhdot.fizzbuzz.ui.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.davinhdot.fizzbuzz.databinding.ActivityFormBinding
import timber.log.Timber

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")

        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initForm()
    }

    private fun initForm() {
        Timber.d("initForm")

        // TODO : only digits for limit and multiples
    }
}