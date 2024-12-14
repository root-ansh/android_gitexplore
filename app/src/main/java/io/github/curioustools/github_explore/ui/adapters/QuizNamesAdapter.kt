package io.github.curioustools.github_explore.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.curioustools.github_explore.commons.updateState
import io.github.curioustools.github_explore.databinding.ItemQuizNameBinding
import io.github.curioustools.github_explore.ui.adapters.QuizNamesAdapter.QuizNamesVH
import io.github.curioustools.github_explore.ui.models.QuizName

class QuizNamesAdapter(private val onClick:(String)->Unit):RecyclerView.Adapter<QuizNamesVH>(){
    private val names = mutableListOf<QuizName>()


    fun updateQuizzes(){
        names.clear()
        names.addAll(QuizName.initialList())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizNamesVH {
        return QuizNamesVH(ItemQuizNameBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: QuizNamesVH, position: Int) {
        holder.bind(names[position]){selected ->
            onClick.invoke(selected.url)
            val previousSelectedIdx = names.indexOfFirst { it.isSelected }
            val selectedIdx = names.indexOfFirst { it.name.equals(selected.name,true) }
            if(selectedIdx in names.indices){
                names[selectedIdx].isSelected = names[selectedIdx].isSelected.not()
                notifyItemChanged(selectedIdx)
            }
            if(previousSelectedIdx in names.indices){
                names[previousSelectedIdx].isSelected = false
                notifyItemChanged(previousSelectedIdx)
            }
        }
    }

    override fun getItemCount()= names.size



    class QuizNamesVH(private val binding: ItemQuizNameBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(data:QuizName,onClick: (QuizName) -> Unit){
            binding.btTag.text = data.name
            binding.btTag.updateState(data.isSelected)
            binding.btTag.setOnClickListener { onClick.invoke(data) }
        }
    }

}