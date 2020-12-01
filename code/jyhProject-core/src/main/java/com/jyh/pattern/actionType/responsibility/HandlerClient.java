package com.jyh.pattern.actionType.responsibility;

public class HandlerClient {


    public static void main(String[] args) {

        Handler projectManager = new ProjectManager();
        Handler deptManager = new DeptManager();
        Handler generalManager = new GeneralManager();

        projectManager.setHandler(deptManager);
        deptManager.setHandler(generalManager);

        projectManager.handlerFeeRequest(true,300);
        projectManager.handlerFeeRequest(true,500);
        projectManager.handlerFeeRequest(true,1000);
    }
}
