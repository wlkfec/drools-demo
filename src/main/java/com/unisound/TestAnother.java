package com.unisound;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import person.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestAnother {


    static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession("PersonAgeKS");
    }


    public static void run(){
        KieSession ks = getSession();
        Person p1 = new Person("奥巴马", 68);
        Person p2 = new Person("普京", 32);
        Person p3 = new Person("朴槿惠", 18);
        Person p4 = new Person("川普", 10);
        Person p5 = new Person("金正恩", 66);

        System.out.println("before p1 : " + p1);
        System.out.println("before p2 : " + p2);
        System.out.println("before p3 : " + p3);
        System.out.println("before p4 : " + p4);
        System.out.println("before p5 : " + p5);
        ks.insert(p1);
        ks.insert(p2);
        ks.insert(p3);
        ks.insert(p4);
        ks.insert(p5);

        int count = ks.fireAllRules();

        System.out.println("总执行了" + count + "条规则------------------------------");
        System.out.println("after p1 : " + p1);
        System.out.println("after p2 : " + p2);
        System.out.println("after p3 : " + p3);
        System.out.println("after p4 : " + p4);
        System.out.println("after p4 : " + p5);
        ks.dispose();
    }
    public static void main(String[] args) throws Exception {
        checkDrl2();
    }


    public static void checkDrl() throws FileNotFoundException {



        File file = new File("D:\\temp\\Drools601\\src\\main\\resources\\person\\rule.xlsx");
        InputStream is = new FileInputStream(file);
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(is, InputType.XLS);
        System.out.println(drl);





    }

    public static void checkDrl2() throws FileNotFoundException {




        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(ResourceFactory.newClassPathResource("person/rule.xlsx"), InputType.XLS);
        System.out.println(drl);




    }


}
