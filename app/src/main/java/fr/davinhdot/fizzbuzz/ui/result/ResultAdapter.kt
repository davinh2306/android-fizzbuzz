package fr.davinhdot.fizzbuzz.ui.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import fr.davinhdot.fizzbuzz.R
import fr.davinhdot.fizzbuzz.entity.FizzBuzz
import timber.log.Timber

class ResultAdapter(
    private val limit: Int,
    private val fizzBuzz: FizzBuzz
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
        Timber.d("onBindViewHolder")

        holder.bind(
            position = position,
            fizzBuzz = fizzBuzz
        )
    }

    override fun getItemCount() = limit

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            position: Int,
            fizzBuzz: FizzBuzz
        ) {
            Timber.d("bind result at list position $position")

            val resultPosition = position + 1
            val result = fizzBuzz.getResult(resultPosition)
            val textDisplayed = "$resultPosition -> $result"

            itemView.findViewById<AppCompatTextView>(R.id.result_item).text = textDisplayed

        }
    }
}