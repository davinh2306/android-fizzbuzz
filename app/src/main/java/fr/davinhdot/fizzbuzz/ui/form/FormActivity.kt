package fr.davinhdot.fizzbuzz.ui.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.davinhdot.fizzbuzz.databinding.ActivityFormBinding
import fr.davinhdot.fizzbuzz.ui.result.ResultActivity
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

        binding.formCta.setOnClickListener { goToResult() }
    }

    private fun goToResult() {
        Timber.d("goToResult")

        startActivity(
            ResultActivity.newIntent(
                context = this@FormActivity,
                limit = binding.formLimitInputEdit.text.toString().trim().toInt(),
                firstMultiple = binding.formFirstMultipleInputEdit.text.toString().trim().toInt(),
                secondMultiple = binding.formSecondMultipleInputEdit.text.toString().trim().toInt(),
                fizz = binding.formFizzInputEdit.text.toString().trim(),
                buzz = binding.formBuzzInputEdit.text.toString().trim()
                )
        )
    }
}