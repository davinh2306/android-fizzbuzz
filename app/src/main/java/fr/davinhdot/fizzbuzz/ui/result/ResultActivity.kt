package fr.davinhdot.fizzbuzz.ui.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.davinhdot.fizzbuzz.databinding.ActivityResultBinding
import fr.davinhdot.fizzbuzz.entity.FizzBuzz
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_BUZZ
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_FIRST_MULTIPLE
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_FIZZ
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_LIMIT
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_SECOND_MULTIPLE
import timber.log.Timber

class ResultActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_LIMIT = "extra_limit"
        private const val EXTRA_FIZZ_BUZZ = "extra_fizz_buzz"

        fun newIntent(
            context: Context,
            limit: Int?,
            fizzBuzz: FizzBuzz
        ) = Intent(context, ResultActivity::class.java)
            .apply {
                putExtra(EXTRA_LIMIT, limit ?: DEFAULT_LIMIT)
                putExtra(EXTRA_FIZZ_BUZZ, fizzBuzz)
            }
    }

    private lateinit var binding: ActivityResultBinding

    private var limit = DEFAULT_LIMIT

    private var fizzBuzz = FizzBuzz(
        DEFAULT_FIRST_MULTIPLE,
        DEFAULT_SECOND_MULTIPLE,
        DEFAULT_FIZZ,
        DEFAULT_BUZZ
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")

        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()

        initAdapter()
    }

    private fun getExtras() {
        Timber.d("getExtras")

        intent?.extras?.let { bundle ->
            limit = bundle.getInt(EXTRA_LIMIT)
            bundle.getParcelable<FizzBuzz>(EXTRA_FIZZ_BUZZ)?.let { data ->
                fizzBuzz = data
            }
        }
    }

    private fun initAdapter() {
        Timber.d("initAdapter")

        binding.resultList.apply {
            adapter = ResultAdapter(
                limit = limit,
                fizzBuzz = fizzBuzz
            )
            layoutManager = LinearLayoutManager(this@ResultActivity)
        }
    }
}