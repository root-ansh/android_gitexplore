package io.github.curioustools.github_explore.data

import retrofit2.Response
import javax.inject.Inject

class ApiRepoImpl @Inject constructor(private val apiService: ApiService): ApiRepo {
    override suspend fun getQuiz(): List<QuizItem> {
        return apiService.getQuiz()
    }
}