package com.coding.test.reward.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.coding.test.reward.constants.Constant;
import com.coding.test.reward.modal.CustomerReward;
import com.coding.test.reward.modal.Reward;

@Service
public class RewardService {

	
	Map<String, CustomerReward> rewardsValueMap = new HashMap<>();

	public CustomerReward getCustomerRewardByName(String customerName) {
		return rewardsValueMap.get(customerName);
	}

	public List<CustomerReward> rewardCalculator(Reward rewards) {
		List<CustomerReward> result = new ArrayList<>();
		String custName = rewards.getCustomerName();
		int month = Integer.parseInt(rewards.getDate().split("-")[1]);
		int amount = rewards.getAmount();
		int reward = calculateRewardPoint(amount);
		
		if (rewardsValueMap.containsKey(custName)) {
			rewardsValueMap.get(custName).addReward(month, reward);
		} else {
			CustomerReward customerReward = new CustomerReward(custName);
			customerReward.addReward(month, reward);
			rewardsValueMap.put(custName, customerReward);
		}
		for (Map.Entry<String, CustomerReward> cust : rewardsValueMap.entrySet()) {
			result.add(cust.getValue());
		}

		return result;

	}

	private static int calculateRewardPoint(int txnAmount) {
		if (txnAmount <= Constant.RATE_OF_DISCOUNT) {
			return 0;
		}
		if (txnAmount <= Constant.MAX_DISCOUNT) {
			return txnAmount - Constant.RATE_OF_DISCOUNT;
		}
		return (txnAmount - Constant.MAX_DISCOUNT) * 2 + Constant.RATE_OF_DISCOUNT;
	}

}
