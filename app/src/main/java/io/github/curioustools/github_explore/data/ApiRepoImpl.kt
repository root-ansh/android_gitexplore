package io.github.curioustools.github_explore.data

import javax.inject.Inject

class ApiRepoImpl @Inject constructor(private val apiService: ApiService): ApiRepo {
    override suspend fun getQuiz(url:String): List<QuizDTO> {
        return apiService.getQuiz(url)
    }
}