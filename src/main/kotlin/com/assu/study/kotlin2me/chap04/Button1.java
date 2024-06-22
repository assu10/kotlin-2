package com.assu.study.kotlin2me.chap04;


public class Button1 implements View {
  @Override
  public State getCurrentState() {
    return new ButtonState();
  }

  @Override
  public void restoreState(State state) {
    // ...
  }

  public class ButtonState implements State {
    // ...
  }
}
