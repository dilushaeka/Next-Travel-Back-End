package lk.ijse.financialserivce.service.custom;

import lk.ijse.financialserivce.service.SuperService;

import java.util.List;


public interface FinancialService extends SuperService {

    Double getDailyIncome();

    Double getWeeklyIncome();

    Double getMonthlyIncome();

    Double getAnnualIncome();

    Long getTodaySalesCount();

    List<Double> getPastDayIncomes();
}
