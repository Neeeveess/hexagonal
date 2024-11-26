package br.com.jvneves.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.layeredArchitecture

@AnalyzeClasses(packages = ["br.com.jvneves.hexagonal"])
class LayeredArchitectureTest {

    @ArchTest
    val `layered architecture test` = layeredArchitecture()
        .consideringAllDependencies()
        .layer("AdaptersIn").definedBy("..adapters.in..")
        .layer("AdaptersOut").definedBy("..adapters.out..")
        .layer("Service").definedBy("..application.core.services..")
        .layer("PortsIn").definedBy("..application.ports.in..")
        .layer("PortsOut").definedBy("..application.ports.out..")
        .layer("Config").definedBy("..config..")

        .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("Service", "AdaptersIn")
        .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("Service", "AdaptersOut")
        .whereLayer("Config").mayNotBeAccessedByAnyLayer()
}