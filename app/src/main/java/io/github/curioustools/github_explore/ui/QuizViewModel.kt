package io.github.curioustools.github_explore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.curioustools.github_explore.data.ApiRepo
import io.github.curioustools.github_explore.data.QuizItem
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val repo: ApiRepo): ViewModel() {

    private val quizMLD = MutableLiveData<List<QuizItem>?>()
    val quiz: LiveData<List<QuizItem>?> = quizMLD

    fun getQuiz() {
        viewModelScope.launch {
            runCatching {
                val quizItems = repo.getQuiz()
                quizMLD.postValue(repo.getQuiz())
            }.getOrElse {
                it.printStackTrace()
                quizMLD.postValue(null)
            }
        }

    }
}