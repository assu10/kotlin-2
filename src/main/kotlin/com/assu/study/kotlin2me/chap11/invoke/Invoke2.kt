package com.assu.study.kotlin2me.chap11.invoke

data class Issue(
    val id: String, val project: String, val type: String,
    val priority: String, val description: String,
)

// 함수 타입을 기반 클래스로 사용
class IssuePredicate(private val project: String): (Issue) -> Boolean {

    // invoke() 메서드 구현
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }

    private fun Issue.isImportant(): Boolean {
        return type == "Bug" && (priority == "Major" || priority == "Critical")
    }
}

fun main() {
    val issue1 = Issue("111", "ONE", "Bug", "Major", "One desc")
    val issue2 = Issue("222", "TWO", "Feature", "Normal", "Two desc")

    val predicate = IssuePredicate("ONE")

    // Predicate 를 filter 로 넘김
    for (issue in listOf(issue1, issue2).filter(predicate)) {
        // Issue(id=111, project=ONE, type=Bug, priority=Major, description=One desc)
        println(issue)
    }
}