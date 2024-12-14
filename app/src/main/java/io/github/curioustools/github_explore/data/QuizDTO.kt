package io.github.curioustools.github_explore.data


import androidx.annotation.Keep

@Keep
data class QuizDTO(
    val answer: String = "",
    val category: String = "",
    val choices: List<String> = listOf(),
    val question: String = "",
    val isShimmer:Boolean = false,
    var madeChoice:Boolean = false
) {


    companion object{
        fun shimmer() = listOf(
            QuizDTO(isShimmer = true),
            QuizDTO(isShimmer = true),
            QuizDTO(isShimmer = true),
            QuizDTO(isShimmer = true),
            QuizDTO(isShimmer = true),
            )


    }
}