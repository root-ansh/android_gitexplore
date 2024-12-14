package io.github.curioustools.github_explore.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.github.curioustools.github_explore.data.QuizDTO
import io.github.curioustools.github_explore.databinding.ActivityQuizBinding
import io.github.curioustools.github_explore.ui.adapters.QuizNamesAdapter
import io.github.curioustools.github_explore.ui.adapters.QuizQuestionAdapter
import io.github.curioustools.github_explore.ui.models.QuizName

@AndroidEntryPoint
class QuizActivity : AppCompatActivity() {
    private val binding by lazy { ActivityQuizBinding.inflate(layoutInflater) }
    private val adpQuiz = QuizQuestionAdapter()
    private lateinit var quizNamesAdapter:QuizNamesAdapter
    private val quizViewModel by viewModels<QuizViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //init observers
        quizViewModel.quiz.observe(this) { resp: List<QuizDTO>? ->
           if(resp==null) adpQuiz.updateQuestions(QuizDTO.shimmer())
            else {
               println("question size === ${resp.size}")
               adpQuiz.updateQuestions(resp.take(50))
           }
        }

        //init ui adapters
        quizNamesAdapter = QuizNamesAdapter{
            quizViewModel.getQuiz(it)
            adpQuiz.updateQuestions(QuizDTO.shimmer())
            Toast.makeText(this@QuizActivity, it, Toast.LENGTH_SHORT).show()
        }

        //init ui
        binding.rcQuizzes.apply {
            adapter = quizNamesAdapter
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        }
        binding.rvQuestions.apply {
            adapter = adpQuiz
            layoutManager = LinearLayoutManager(this@QuizActivity)
        }


        //initial calls
        quizViewModel.getQuiz(QuizName.initialList().first().url)
        quizNamesAdapter.updateQuizzes()
        adpQuiz.updateQuestions(QuizDTO.shimmer())


    }
}



