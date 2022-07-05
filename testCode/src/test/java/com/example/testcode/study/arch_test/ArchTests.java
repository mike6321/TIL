package com.example.testcode.study.arch_test;

import com.example.testcode.TestCodeApplication;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packagesOf = TestCodeApplication.class)
public class ArchTests {

    @ArchTest
    ArchRule controllerClassRule = classes()
            .that()
            .haveSimpleNameEndingWith("Controller")
            .should()
            .accessClassesThat()
            .haveSimpleNameEndingWith("Service")
            .orShould()
            .accessClassesThat()
            .haveSimpleNameEndingWith("Repository");

    @ArchTest
    ArchRule domainPackageRule = classes()
            .that()
            .resideInAnyPackage("..domain..")
            .should()
            .onlyBeAccessed()
            .byClassesThat()
            .resideInAnyPackage("..study..", "..member..", "..domain..");

    @ArchTest
    ArchRule memberPackageRule = noClasses()
            .that()
            .resideInAnyPackage("..domain..")
            .should()
            .accessClassesThat()
            .resideInAPackage("..member..");

    @ArchTest
    ArchRule studyPackageRule = noClasses()
            .that()
            .resideOutsideOfPackage("..study..")
            .should()
            .accessClassesThat()
            .resideInAPackage("..study..");

    @ArchTest
    ArchRule freeOfCycles = slices()
            .matching("..testcode.(*)..")
            .should()
            .beFreeOfCycles();


}
