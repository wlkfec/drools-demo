package com.unisound;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import person.Person;

import java.text.SimpleDateFormat;

/**
 * @author unisound
 */
public class Test {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();

        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        long start = System.currentTimeMillis();
        KieSession kieSession = kieContainer.newKieSession();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        kieSession.setGlobal("fmt", simpleDateFormat);

        Drone drone = Drone.builder().normalCasesEnum(NormalCasesEnum.Emergency_Landing_Gear).build();
        Drone drone1 = Drone.builder().normalCasesEnum(NormalCasesEnum.Emergency_Landing_Gear).build();
        Drone drone2 = Drone.builder().normalCasesEnum(NormalCasesEnum.Landing_Gear).build();
        kieSession.insert(drone);
        kieSession.insert(drone1);
        kieSession.insert(drone2);
        int i = kieSession.fireAllRules();
//        try {
//            // 种被动模式启动引擎，在那儿规则会被连续引发，直到调用了halt()。
//            new Thread(kieSession::fireUntilHalt).start();
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



        kieSession.dispose();
        System.out.println(drone);
        System.out.println("当前花费时间：" + (System.currentTimeMillis() - start));
        System.out.println("触发的规则数：" + i);




        QueryResults results = kieSession.getQueryResults( "NormalCasesEnumisEmergency_Landing_Gear" );
        System.out.println( "we have " + results.size() + " NormalCasesEnumisEmergency_Landing_Gear" );
        for ( QueryResultsRow row : results ) {
            Drone d = (Drone) row.get( "$drone" );
            System.out.println(d + "\n" );
        }


//        kieSession = kieContainer.newKieSession();
//        drone = Drone.builder()
//                .specialCasesEnum(SpecialCasesEnum.Engine_Stops_Abnormally)
//                .aircraftPhaseEnum(AircraftPhaseEnum.Take_Off_Phase).build();
//        kieSession.insert(drone);
//        kieSession.fireAllRules();
//        kieSession.dispose();
//        System.out.println(drone);
//        System.out.println("当前花费时间：" + (System.currentTimeMillis() - start));
    }
}
