/*
 * Copyright (c) 2000-2004 by JetBrains s.r.o. All Rights Reserved.
 * Use is subject to license terms.
 */
package com.intellij.refactoring.openapi.impl;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.refactoring.RefactoringImpl;
import com.intellij.refactoring.TypeCookRefactoring;
import com.intellij.refactoring.typeCook.Settings;
import com.intellij.refactoring.typeCook.deductive.TypeCookProcessor;

import java.util.List;

/**
 * @author dsl
 */
public class TypeCookRefactoringImpl extends RefactoringImpl<TypeCookProcessor> implements TypeCookRefactoring {
  TypeCookRefactoringImpl(Project project,
                          PsiElement[] elements,
                          final boolean dropObsoleteCasts,
                          final boolean leaveObjectsRaw,
                          final boolean preserveRawArrays) {
    super(new TypeCookProcessor(project, elements, new Settings() {
      public boolean dropObsoleteCasts() {
        return dropObsoleteCasts;
      }

      public boolean leaveObjectParameterizedTypesRaw() {
        return leaveObjectsRaw;
      }

      public boolean preserveRawArrays() {
        return preserveRawArrays;
      }
    }));
  }

  public List<PsiElement> getElements() {
    return myProcessor.getElements();
  }
}
