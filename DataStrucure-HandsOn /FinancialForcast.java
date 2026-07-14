public class FinancialForecast {


    // Recursive method to calculate future value

    public static double calculateFutureValue(
            double currentValue,
            double growthRate,
            int years) {


        // Base case
        if(years == 0) {
            return currentValue;
        }


        // Recursive case

        return calculateFutureValue(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1
        );
    }



    public static void main(String args[]) {


        double initialInvestment = 1000;

        double growthRate = 0.10; // 10%

        int years = 5;



        double futureValue =
                calculateFutureValue(
                    initialInvestment,
                    growthRate,
                    years
                );


        System.out.println(
            "Future Value after "
            + years
            + " years: "
            + futureValue
        );
    }
}
