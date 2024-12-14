package io.github.curioustools.github_explore.ui.models

import androidx.annotation.Keep

@Keep
data class QuizName(val name:String, val url:String, var isSelected:Boolean = false){
    companion object{
        fun initialList(): List<QuizName> {
            return listOf(
                QuizName("Science and Technology", "science-technology.json", isSelected = true),
                QuizName("Animal Kingdom", "animals.json"),
                QuizName("Brain Teasers", "brain-teasers.json"),
                QuizName("Celebrities", "celebrities.json"),
                QuizName("Entertainment", "entertainment.json"),
                QuizName("For Kids", "for-kids.json"),
                QuizName("General Knowledge", "general.json"),
                QuizName("Geography", "geography.json"),
                QuizName("History", "history.json"),
                QuizName("Hobbies", "hobbies.json"),
                QuizName("Humanities", "humanities.json"),
                QuizName("Literature", "literature.json"),
                QuizName("Movies", "movies.json"),
                QuizName("Music", "music.json"),
                QuizName("Newest Additions", "newest.json"),
                QuizName("People", "people.json"),
                QuizName("Rated", "rated.json"),
                QuizName("Religion and Faith", "religion-faith.json"),
                QuizName("Sports", "sports.json"),
                QuizName("Television", "television.json"),
                QuizName("Video Games", "video-games.json"),
                QuizName("World", "world.json")
            )
        }


    }
}