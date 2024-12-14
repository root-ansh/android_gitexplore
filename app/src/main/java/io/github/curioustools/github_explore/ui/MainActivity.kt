package io.github.curioustools.github_explore.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.curioustools.github_explore.data.QuizItem
import io.github.curioustools.github_explore.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val quizViewModel by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        quizViewModel.quiz.observe(this) { resp: List<QuizItem>? ->
            binding.tvTest.text = resp.toString()
        }

        quizViewModel.getQuiz()

    }
}