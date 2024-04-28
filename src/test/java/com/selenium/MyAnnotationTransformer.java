package com.selenium;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IListenersAnnotation;

public class MyAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(IListenersAnnotation annotation, Class<?> testClass) {
        
    }
}
