package com.voterapp.service;

import com.voterapp.exceptions.InValidVoterException;

public interface IElectionBooth {
	
	boolean checkEligibility(int age,String locality,int vid)throws InValidVoterException;

}
