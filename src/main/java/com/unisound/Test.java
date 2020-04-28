package com.unisound;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author unisound
 */
public class Test {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();

        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        long start = System.currentTimeMillis();
        KieSession kieSession = kieContainer.newKieSession();



        Drone drone = Drone.builder()
                .specialCasesEnum(SpecialCasesEnum.Engine_Stops_Abnormally)
                .aircraftPhaseEnum(AircraftPhaseEnum.Take_Off_Phase).build();
        kieSession.insert(drone);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(drone);
        System.out.println("当前花费时间：" + (System.currentTimeMillis() - start));


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
