package com.fikrialfian.aplikasi_pertama


class Player {
    var QUESTIONS = createRandomQuestion()
    var QUESTION_TOTAL = this.QUESTIONS.size
    var QUESTION_INDEX_ACTIVE = 0

    fun isFinish(): Boolean {
        return QUESTION_INDEX_ACTIVE + 1 == QUESTION_TOTAL
    }
    fun updateQuestion() {
        QUESTION_INDEX_ACTIVE += 1
    }

    fun getQuestion(): QuestionStructure {
        return QUESTIONS[QUESTION_INDEX_ACTIVE]
    }

    fun newGame() {
        QUESTIONS = createRandomQuestion()
        QUESTION_TOTAL = this.QUESTIONS.size
        QUESTION_INDEX_ACTIVE = 0
    }

    fun createRandomQuestion(): List<QuestionStructure> {
        return Questions.questions.shuffled().slice(IntRange(0, 9))
    }
}