package fr.davinhdot.fizzbuzz.ui.form

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import fr.davinhdot.fizzbuzz.databinding.ActivityFormBinding
import fr.davinhdot.fizzbuzz.ui.result.ResultActivity
import fr.davinhdot.fizzbuzz.util.trimmedIntOrNull
import fr.davinhdot.fizzbuzz.util.trimmedTextOrNull
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

        binding.formCta.setOnClickListener { goToResult() }

        binding.formBuzzInputEdit.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                goToResult()
                true
            } else {
                false
            }
        }
    }

    private fun goToResult() {
        Timber.d("goToResult")

        startActivity(
            ResultActivity.newIntent(
                context = this@FormActivity,
                limit = binding.formLimitInputEdit.trimmedIntOrNull,
                firstMultiple = binding.formFirstMultipleInputEdit.trimmedIntOrNull,
                secondMultiple = binding.formSecondMultipleInputEdit.trimmedIntOrNull,
                fizz = binding.formFizzInputEdit.trimmedTextOrNull,
                buzz = binding.formBuzzInputEdit.trimmedTextOrNull
            )
        )
    }
}