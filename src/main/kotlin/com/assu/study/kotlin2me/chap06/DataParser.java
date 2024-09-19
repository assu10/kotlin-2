package com.assu.study.kotlin2me.chap06;

import java.util.List;

// 인터페이스를 구현한 클래스가 아래의 내용들을 처리함
// - 텍스트 폼에서 읽은 데이터를 파싱하여 객체 리스트를 만듦
// - 그 리스트의 객체들을 출력 리스트 뒤에 추가함
// - 데이터를 파싱하는 과정에서 발생한 오류 메시지를 별도의 리스트에 넣음
public interface DataParser<T> {
  void parseData(String input, List<T> output, List<String> errors);
}
