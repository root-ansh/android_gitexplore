package io.github.curioustools.github_explore.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("${ApiDI.URL_QUIZ}/{url}")
    suspend fun getQuiz(@Path("url") url: String): List<QuizDTO>

}