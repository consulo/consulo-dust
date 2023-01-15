/**
 * @author VISTALL
 * @since 15/01/2023
 */
module com.linkedin.intellij.dust {
  requires consulo.ide.api;
  requires com.intellij.xml;
  
  exports com.linkedin.intellij.dust;
  exports com.linkedin.intellij.dust.parser;
  exports com.linkedin.intellij.dust.psi;
  exports com.linkedin.intellij.dust.psi.impl;
  exports consulo.dust.icon;
}