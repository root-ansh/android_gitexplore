package io.github.curioustools.github_explore.ui.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.curioustools.github_explore.data.ApiRepo
import io.github.curioustools.github_explore.data.QuizDTO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val repo: ApiRepo): ViewModel() {

    private val quizMLD = MutableLiveData<List<QuizDTO>?>()
    val quiz: LiveData<List<QuizDTO>?> = quizMLD

    fun getQuiz(url:String) {
        viewModelScope.launch {
            runCatching {
                quizMLD.postValue(repo.getQuiz(url))
            }.getOrElse {
                it.printStackTrace()
                quizMLD.postValue(null)
            }
        }

    }
}