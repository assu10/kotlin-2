package com.assu.study.kotlin2me.chap06;

import java.io.File;
import java.util.List;

public interface FileContent {
  void process(File path, byte[] binary, List<String> text);
}
