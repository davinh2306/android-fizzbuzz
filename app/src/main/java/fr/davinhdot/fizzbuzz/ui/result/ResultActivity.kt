package fr.davinhdot.fizzbuzz.ui.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.davinhdot.fizzbuzz.databinding.ActivityResultBinding
import timber.log.Timber

class ResultActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_LIMIT = "extra_limit"
        private const val EXTRA_FIRST_MULTIPLE = "extra_first_multiple"
        private const val EXTRA_SECOND_MULTIPLE = "extra_second_multiple"
        private const val EXTRA_FIZZ = "extra_fizz"
        private const val EXTRA_BUZZ = "extra_buzz"

        private const val DEFAULT_LIMIT = 100
        private const val DEFAULT_FIRST_MULTIPLE = 3
        private const val DEFAULT_SECOND_MULTIPLE = 5
        private const val DEFAULT_FIZZ = "fizz"
        private const val DEFAULT_BUZZ = "buzz"

        fun newIntent(
            context: Context,
            limit: Int,
            firstMultiple: Int,
            secondMultiple: Int,
            fizz: String,
            buzz: String
        ) = Intent(context, ResultActivity::class.java)
            .apply {
                putExtra(EXTRA_LIMIT, limit)
                putExtra(EXTRA_FIRST_MULTIPLE, firstMultiple)
                putExtra(EXTRA_SECOND_MULTIPLE, secondMultiple)
                putExtra(EXTRA_FIZZ, fizz)
                putExtra(EXTRA_BUZZ, buzz)
            }
    }

    private lateinit var binding: ActivityResultBinding

    private var limit = DEFAULT_LIMIT
    private var firstMultiple = DEFAULT_FIRST_MULTIPLE
    private var secondMultiple = DEFAULT_SECOND_MULTIPLE
    private var fizz = DEFAULT_FIZZ
    private var buzz = DEFAULT_BUZZ

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")

        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()

        binding.resultList.apply {
            adapter = ResultAdapter(
                limit = limit,
                firstMultiple = firstMultiple,
                secondMultiple = secondMultiple,
                fizz = fizz,
                buzz = buzz
            )
            layoutManager = LinearLayoutManager(this@ResultActivity)
        }
    }

    private fun getExtras() {
        Timber.d("getExtras")

        intent?.extras?.let {
            limit = it.getInt(EXTRA_LIMIT)
            firstMultiple = it.getInt(EXTRA_FIRST_MULTIPLE)
            secondMultiple = it.getInt(EXTRA_SECOND_MULTIPLE)
            fizz = it.getString(EXTRA_FIZZ, DEFAULT_FIZZ)
            buzz = it.getString(EXTRA_BUZZ, DEFAULT_BUZZ)
        }
    }
}