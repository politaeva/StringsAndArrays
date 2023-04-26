package ru.netology.stats;

public class StatsService {

// 1) сумма всех продаж;

    public long sum(long[] sales) {
        long totalSale = 0;
        for (long sale : sales) {
            totalSale += sale;
        }
        return totalSale;
    }

    // 2) средняя сумма продаж в месяц;
    public long average(long[] sales) {
        if (sales.length == 0) {
            return 0;
        }
        return sum(sales) / sales.length;
    }

// 3) номер месяца, в котором был пик продаж, то есть осуществлены продажи на максимальную сумму
// (последний месяц, соответствующий условиям)

    public int monthMaxSales(long[] sales) {
        int month = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[month]) {
                month = i;
            }
        }
        return month + 1;
    }

// 4) номер месяца, в котором был минимум продаж, то есть осуществлены продажи на минимальную сумму
// (последний месяц, соответствующий условиям)

    public int monthMinSales(long[] sales) {
        int month = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[month]) {
                month = i;
            }
        }
        return month + 1;
    }

// 5) количество месяцев, в которых продажи были ниже среднего
    public int monthsBelowAverage(long[] sales) {

        int count = 0;
        long averageSale = average(sales);
        for (long sale : sales) {
            if (sale < averageSale) {
                count++;
            }
        }
        return count;
    }

 // 6) количество месяцев, в которых продажи были выше среднего
    public int monthsMoreAverage(long[] sales) {

        int count = 0;
        long averageSale = average(sales);
        for (long sale : sales) {
            if (sale > averageSale) {
                count++;
            }
        }
        return count;
    }
}