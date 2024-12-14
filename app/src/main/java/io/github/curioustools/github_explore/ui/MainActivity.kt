package io.github.curioustools.github_explore.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.curioustools.github_explore.databinding.ActivityMainBinding
import io.github.curioustools.github_explore.ui.views.QuizActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            btPlayQuiz.setOnClickListener {
                startActivity(Intent(this@MainActivity, QuizActivity::class.java))
            }
        }


    }
}