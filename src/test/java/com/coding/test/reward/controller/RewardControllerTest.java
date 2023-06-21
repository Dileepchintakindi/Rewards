package com.coding.test.reward.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.coding.test.reward.modal.CustomerReward;
import com.coding.test.reward.modal.Reward;
import com.coding.test.reward.service.RewardService;

public class RewardControllerTest {

	@Test
	public void test_rewardsByCustomerCriteria() {

		Reward reward = new Reward();
		reward.setAmount(200);
		reward.setCustomerName("Alice");
		reward.setDate("2023-06-16");
		RewardService rewardController = new RewardService();
		List<CustomerReward> customers = rewardController.rewardCalculator(reward);
		assertNotNull(customers);
	}

	@Test
	public void test_rewardsByCustomerName_WhenNoCustomerFound() {
		Reward reward = new Reward();
		reward.setAmount(400);
		reward.setCustomerName("Nancy");
		reward.setDate("2023-06-16");
		RewardService rewardService = new RewardService();
		List<CustomerReward> customers = rewardService.rewardCalculator(reward);
		RewardService rewardController = new RewardService();
		CustomerReward customer = rewardController.getCustomerRewardByName("Adam");
		assertNull(customer);
	}

}
