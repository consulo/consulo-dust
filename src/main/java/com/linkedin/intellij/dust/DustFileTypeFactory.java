package com.linkedin.intellij.dust;

import javax.annotation.Nonnull;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 1:07 PM
 */
public class DustFileTypeFactory extends FileTypeFactory {
  @Override
  public void createFileTypes(@Nonnull FileTypeConsumer consumer) {
    consumer.consume(DustFileType.INSTANCE, DustFileType.DEFAULT_EXTENSION);
  }
}
