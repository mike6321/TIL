package com.example.testcode.study;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction;
import com.tngtech.archunit.library.dependencies.SliceRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public class ArchTest {

    JavaClasses classes = new ClassFileImporter().importPackages("com.example.testcode");

    @DisplayName("..member.. 패키지에 있는 클래스는 ..study.. 와 ..member.. 에서만 참조 가능")
    @Test
    void packageDependencyTests() {
        ArchRule domainPackageRule = classes()
                .that()
                .resideInAnyPackage("..domain..")
                .should()
                .onlyBeAccessed()
                .byClassesThat()
                .resideInAnyPackage("..study..", "..member..", "..domain..");
        domainPackageRule.check(classes);
    }

    @DisplayName("..domain.. 패키지에 있는 클래스는  ..member.. 를 참조하지 못한다.")
    @Test
    void packageNoDependencyTests() {
        ArchRule domainPackageRule = noClasses()
                .that()
                .resideInAnyPackage("..domain..")
                .should()
                .accessClassesThat()
                .resideInAPackage("..member..");
        domainPackageRule.check(classes);
    }

    @DisplayName("..study.. 패키지에 있는 클래스는  ..study.. 에서만 참조 가능.")
    @Test
    void packageNoDependencyTests02() {
        ArchRule domainPackageRule = noClasses()
                .that()
                .resideOutsideOfPackage("..study..")
                .should()
                .accessClassesThat()
                .resideInAPackage("..study..");
        domainPackageRule.check(classes);
    }

    @DisplayName("순환 참조가 없어야 한다.")
    @Test
    void freeOfCycles() {
        ArchRule domainPackageRule = slices()
                .matching("..testcode.(*)..")
                .should()
                .beFreeOfCycles();
        domainPackageRule.check(classes);
    }

}
