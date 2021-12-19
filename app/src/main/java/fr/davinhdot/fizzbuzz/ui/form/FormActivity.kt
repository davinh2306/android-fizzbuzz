package fr.davinhdot.fizzbuzz.ui.form

import android.os.Bundle
import android.text.InputFilter
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import fr.davinhdot.fizzbuzz.databinding.ActivityFormBinding
import fr.davinhdot.fizzbuzz.ui.result.ResultActivity
import fr.davinhdot.fizzbuzz.util.trimmedIntOrNull
import fr.davinhdot.fizzbuzz.util.trimmedTextOrNull
import timber.log.Timber

class FormActivity : AppCompatActivity() {

    companion object {
        private const val REGEX_NUMBER = "^[0-9]*\$"
    }

    private lateinit var binding: ActivityFormBinding

    private val numberFilter = InputFilter { source, _, _, _, _, _ ->
        if (source.toString().matches(Regex(REGEX_NUMBER))) {
            source.toString()
        } else ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")

        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initForm()
    }

    private fun initForm() {
        Timber.d("initForm")

        binding.formLimitInputEdit.filters = arrayOf(numberFilter)
        binding.formFirstMultipleInputEdit.filters = arrayOf(numberFilter)
        binding.formSecondMultipleInputEdit.filters = arrayOf(numberFilter)

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