/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

import com.tridium.gradle.plugins.grunt.task.GruntBuildTask
import com.tridium.gradle.plugins.bajadoc.task.Bajadoc
import com.tridium.gradle.plugins.module.util.ModulePart.RuntimeProfile.*

plugins {
  // The Niagara Module plugin configures the "moduleManifest" extension and the
  // "jar" and "moduleTestJar" tasks.
  id("com.tridium.niagara-module")

  // The signing plugin configures the correct signing of modules. It requires
  // that the plugin also be applied to the root project.
  id("com.tridium.niagara-signing")

  // The bajadoc plugin configures the generation of Bajadoc for a module.
  id("com.tridium.bajadoc")

  // Configures JaCoCo for the "niagaraTest" task of this module.
  id("com.tridium.niagara-jacoco")

  // The Annotation processors plugin adds default dependencies on ":nre"
  // for the "annotationProcessor" and "moduleTestAnnotationProcessor"
  // configurations by creating a single "niagaraAnnotationProcessor"
  // configuration they extend from. This value can be overridden by explicitly
  // declaring a dependency for the "niagaraAnnotationProcessor" configuration.
  id("com.tridium.niagara-annotation-processors")

  // The niagara_home repositories convention plugin configures !bin/ext and
  // !modules as flat-file Maven repositories so that projects in this build can
  // depend on already-installed Niagara modules.
  id("com.tridium.convention.niagara-home-repositories")

  id("com.tridium.niagara-grunt")

  // The niagara-doc plugin configures tasks to generate indexes and process any
  // HTML docs to include in a doc module
  id("com.tridium.niagara-doc")

  // The bajadoc-module plugin configures the 'bajadoc' configuration
  // and tasks to aggregate docs from other modules
  id("com.tridium.bajadoc-module")
}

description = "TRAIL19"

moduleManifest {
  moduleName.set("trail19")
  runtimeProfile.set(rt)
  //NOTE: Temporarily ignore rt module part checks for module conversion exercise
  ignoreRuntimeProfileCheck.set("true")
  checkModuleName.set(false)
}

// See documentation at module://docDeveloper/doc/build.html#dependencies for the supported
// dependency types
dependencies {
  // 'indexJars' are the Niagara modules required to build the search index for
  // a doc module
  indexJars(":nre")
  indexJars(":baja")
  indexJars(":html")
  indexJars(":help")

  // NRE dependencies
  nre(":niagaraAnnotationProcessors")
  nre(":nre")

  // Niagara module dependencies
  api(":alarm")
  api(":baja")
  api(":bajaui")
  api(":control")
  api(":driver")
  api(":gx")
  api(":ndriver")
  api(":workbench")

  // Test Niagara module dependencies
  moduleTestImplementation(":test")

  // 'bajadocs' are the modules produced by your build whose API documentation this module
  // should include
  bajadocs(project(":trail19"))
}

tasks.named<GruntBuildTask>("gruntBuild") {
  tasks("babel:dist", "copy:dist", "requirejs")
}

tasks.named<Bajadoc>("bajadoc") {
  // Each of the packages you wish to include in your module's API documentation must be
  // enumerated below
  //includePackage("some.package")
}

tasks.named<Copy>("docCopy") {
  from("src") {
    include("doc/**/*.*")
  }
}