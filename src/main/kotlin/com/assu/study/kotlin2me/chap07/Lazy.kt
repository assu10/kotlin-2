package com.assu.study.kotlin2me.chap07

data class Email(
    val email: String,
)

// DB 에서 이메일을 조회하는 함수
fun loadEmail(person: PersonByLazy): List<Email> {
    println("${person.name} 의 이메일")
    return listOf()
}

// data class PersonByBackingProperty(
//    val name: String,
// ) {
//    // 데이터를 저장하고 emails 의 위임 객체 역할을 하는 _emails 프로퍼티
//    private var _emails: List<Email>? = null
//    val emails: List<Email>
//        get() {
//            // 최초 접근 시 이메일을 가져옴
//            if (_emails == null) {
//                _emails = loadEmail(this)
//            }
//
//            // 저장해 둔 데이터가 있으면 그 데이터를 반환
//            return _emails!!
//        }
// }

data class PersonByLazy(
    val name: String,
) {
    val emails by lazy { loadEmail(this) }
}

fun main() {
    // val p = PersonByBackingProperty("assu")
    val p = PersonByLazy("assu")

    // assu 의 이메일  <-- 최초 emails 을 읽을 때 단 한번만 가져옴
    // []
    // []
    println(p.emails)
    println(p.emails)
}
