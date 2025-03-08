package com.example.monopoly;

import java.util.ArrayList;

import java.util.List;

import easyaccept.EasyAcceptFacade;

public class MonopolyGameTestClient {

        public static void main(String[] args) throws Exception {

              List<String> files = new ArrayList<String>();

              //Put the us1.txt file into the "test scripts" list

              files.add("us1.txt");

  //Instantiate the Monopoly Game façade

              MonopolyFacade monopolyGameFacade = new MonopolyFacade();

              //Instantiate EasyAccept façade

              EasyAcceptFacade eaFacade = new EasyAcceptFacade(monopolyGameFacade, files);

  //Execute the tests

              eaFacade.executeTests();

  //Print the tests execution results

              System.out.println(eaFacade.getCompleteResults());

        }

}