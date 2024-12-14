package io.github.curioustools.github_explore.data

interface ApiRepo{
    suspend fun getQuiz(url:String): List<QuizDTO>
}