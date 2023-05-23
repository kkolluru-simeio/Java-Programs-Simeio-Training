package com.voterapp.service;

import com.voterapp.exceptions.InValidVoterException;
import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIDException;
import com.voterapp.exceptions.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {
	
	static String[] localities = {"bglr","mysore"};

	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InValidVoterException {
		return checkAge(age) && checkLocality(locality) && checkVoterId(voterId);
	}
	private boolean checkAge(int age) throws UnderAgeException{
		if(age < 18)
			throw new UnderAgeException("Candidate should be minimum of 18 to cast the vote");
		return true;
	}
	private boolean checkLocality(String location) throws LocalityNotFoundException{
		for(String loc:localities)
			if(loc.equals(location))
				return true;
		throw new LocalityNotFoundException("Candidate must be from a city in KN state");
	}
	private boolean checkVoterId(int voterId) throws NoVoterIDException {
		if (1000> voterId  || voterId > 9999)
			throw new NoVoterIDException("Voter Id should be in the range of 1000 to 9999");
		return true;
	}


}
