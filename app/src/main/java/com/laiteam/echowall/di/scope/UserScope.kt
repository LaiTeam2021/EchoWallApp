package com.laiteam.echowall.di.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@MustBeDocumented
@kotlin.annotation.Retention(value = AnnotationRetention.RUNTIME)
annotation class UserScope 