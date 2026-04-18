/**
 * @author VISTALL
 * @since 15/01/2023
 */
module com.linkedin.intellij.dust {
  requires consulo.application.api;
  requires consulo.code.editor.api;
  requires consulo.color.scheme.api;
  requires consulo.datacontext.api;
  requires consulo.document.api;
  requires consulo.language.api;
  requires consulo.language.code.style.api;
  requires consulo.language.editor.api;
  requires consulo.language.impl;
  requires consulo.localize.api;
  requires consulo.project.api;
  requires consulo.ui.api;
  requires consulo.util.lang;
  requires consulo.virtual.file.system.api;

  requires com.intellij.xml;
  requires com.intellij.xml.html.api;

  exports com.linkedin.intellij.dust;
  exports com.linkedin.intellij.dust.parser;
  exports com.linkedin.intellij.dust.psi;
  exports com.linkedin.intellij.dust.psi.impl;
  exports consulo.dust.icon;
}
