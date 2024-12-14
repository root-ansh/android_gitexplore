package io.github.curioustools.github_explore.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import io.github.curioustools.github_explore.R
import io.github.curioustools.github_explore.commons.updateState
import io.github.curioustools.github_explore.data.QuizDTO
import io.github.curioustools.github_explore.databinding.ItemQuizQuestionBinding
import io.github.curioustools.github_explore.ui.adapters.QuizQuestionAdapter.QuizQuestionVH


class QuizQuestionAdapter: RecyclerView.Adapter<QuizQuestionVH>() {
    private val quizQuestions = mutableListOf<QuizDTO>()

    fun updateQuestions(questions: List<QuizDTO>) {
        quizQuestions.clear()
        quizQuestions.addAll(questions.toList())
        println("question size === ${questions.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizQuestionVH {
        return QuizQuestionVH(
            ItemQuizQuestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = quizQuestions.size

    override fun onBindViewHolder(holder: QuizQuestionVH, position: Int) {
        holder.bind(quizQuestions[position],position+1){quizItem,pos ->
            val choiceMade = quizQuestions.indexOfFirst { it.question.equals(quizItem.question,true) }
            if(choiceMade in quizQuestions.indices){
                quizQuestions[choiceMade].madeChoice =true
                notifyItemChanged(choiceMade)
            }
        }
    }


    class QuizQuestionVH(private val binding: ItemQuizQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {


        @SuppressLint("SetTextI18n")
        fun bind(data: QuizDTO, idx:Int,onClick:(QuizDTO,Int)->Unit) {
            with(binding) {
                llShimer.isVisible = data.isShimmer
                llShimer.showShimmer(data.isShimmer)
                if (data.isShimmer) llShimer.startShimmer() else llShimer.stopShimmer()

                llQuestion.isVisible = data.isShimmer.not()
                tvQuestion.text = "Q$idx. ${data.question}"

                arrayOf(btChoice1, btChoice2, btChoice3, btChoice4).forEachIndexed { index, bt ->
                    bt.apply {
                        val value = data.choices.getOrNull(index).orEmpty()
                        isVisible = value.isBlank().not()
                        text = value
                        val afterSelRes = if (value.equals(data.answer, true)) R.color.green else R.color.red
                         bt.updateState(data.madeChoice,afterSelRes)
                        setOnClickListener {onClick(data,index) }
                    }
                }
            }
        }

    }
}