package fr.davinhdot.fizzbuzz.ui.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import fr.davinhdot.fizzbuzz.R
import fr.davinhdot.fizzbuzz.util.getFizzBuzzResult
import timber.log.Timber

class ResultAdapter(
    private val limit: Int,
    private val firstMultiple: Int,
    private val secondMultiple: Int,
    private val fizz: String,
    private val buzz: String
) : RecyclerView.Adapter<ResultAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        Timber.d("onCreateViewHolder")

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_result,
                parent,
                false
            )

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Timber.d("onCreateViewHolder")

        holder.bind(
            position = position,
            firstMultiple = firstMultiple,
            secondMultiple = secondMultiple,
            fizz = fizz,
            buzz = buzz
        )
    }

    override fun getItemCount() = limit

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            position: Int,
            firstMultiple: Int,
            secondMultiple: Int,
            fizz: String,
            buzz: String
        ) {
            Timber.d("bind result at list position $position")

            val resultPosition = position + 1
            val result = resultPosition.getFizzBuzzResult(
                firstMultiple,
                secondMultiple,
                fizz,
                buzz
            )
            val textDisplayed = "$resultPosition -> $result"

            itemView.findViewById<AppCompatTextView>(R.id.result_item).text = textDisplayed

        }
    }
}