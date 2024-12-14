package io.github.curioustools.github_explore.data

import retrofit2.Response

interface ApiRepo{
    suspend fun getQuiz(): List<QuizItem>
}