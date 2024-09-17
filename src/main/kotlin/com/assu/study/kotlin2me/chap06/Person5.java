package com.assu.study.kotlin2me.chap06;

interface JavaInterface {
  void action(String input);
}

public class Person5 {
  private final String name;

  public Person5(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
