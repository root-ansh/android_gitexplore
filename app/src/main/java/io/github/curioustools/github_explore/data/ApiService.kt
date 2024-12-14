package io.github.curioustools.github_explore.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ApiDI.URL_QUIZ)
    suspend fun getQuiz(): List<QuizItem>

}