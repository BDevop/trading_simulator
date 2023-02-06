import java.lang.Math;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        // Creating an array for each strategy in the trading simulation. Each system has a unique trading expectancy.
        int[] meanRev = {-1, 8, -2, -1, 10, 7, 6, -1, -2, 6, -1, -1, 8, 7, 6, 5, 1, -1, -1, -1, -1, -1, 8, 10, 8, 6, 6, 3, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2, 10, 10, 10, 7, 6, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -5, -1, -1, -1, -2, -2, -4, 8, 8, 6, 6, 6, 5, 4, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 7, 6, 5, -1, -1, -1, -1, -1, -2, -2, -3, 10, 10, 4, -1, -2, 7};
        int[] breakout = {5, 10, 4, 2, 1, 4, 4, 5, 5, 1, 5, 5, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 5, 2, 4, 4, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -6, -4, -2, -2, -2, -2, -10, -5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -3, -3, -3, -3, 1, -5};
        int[] ipo = {1, 2, 5, 5, 3, 2, 4, 4, 4, -5, 4, -3, 3, 2, 5, -2, 3, 3, 3, 3, 3, 3, 1, 2, 1, 4, -3, 2, 2, 2, 2, 2, 2, 2, -5, 2, 2, 2, 1, 1, 3, 2, -5, 1, 1, 1, 1, 1, 1, -2, -1, 3, 1, 1, 1, 1, -3, -3, -3, -1, -1, -1, 1, 1, -1, 2, 2, 1, -1, -1, -3, -5, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, 2, 3, 3, -2, 4, -2, -2, 5, 2, -2, -2, -2, 1, 1, -3, -3, -5, 5};
        int[] trendF = {5, 2, 5, 1, 1, 1, 2, 4, 4, 2, 4, 4, 3, 3, 5, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -3, -1, -2, -2, -2, -2, -2, -2, -2, -2, -5, -2, -2, -2, -2, -2, -3, -3, -5, -3};
        int[] goodN = {10, 8, 8, 8, 8, 7, 7, 7, 5, 5, 6, 6, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, -1, -1, 2, 2, 2, 2, 2, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -3, -3, -3, -3, -1, -4};
        int[] moveAvg = {10, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -3, -3, -3, -3, -5, -5};
        int[] contract = {3, 3, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1, -2};
        int[] deltaN = {3, 3, 5, 3, 3, 3, 3, 3, 3, 3, 4, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -1, -1, -1, -1, -1, -1, -2, -2, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -3, -3, -3, -3, 1, -5};
        int[] canslim = {10, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -5, -1, -1, -1, -5, -1, -1, -1, -3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, -5, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -5, -3, -3, -5, -3, -10, -5};
        int[] macro = {5, 5, 4, 4, 3, 3, 3, 8, 4, 4, 4, 6, 15, 3, 8, 3, 3, 10, 3, 3, 3, 3, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 8, 2, 2, 10, 1, 1, 1, 5, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, -1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -5, -2, -2, -4, -2, -3, -5, -3, -3, -10, -1};
        String[] stockArray = {"MMM", "AOS", "ABT", "ABBV", "ACN", "ATVI", "ADM", "ADBE", "ADP", "AAP", "AES", "GOOG", "MO", "AMZN", "AMCR", "AMD", "AEE", "AAL", "AEP", "AXP", "AIG", "AMT", "AWK", "AMP", "CDNS", "CZR", "CPT", "CPB", "COF", "CAH", "KMX", "CCL", "CARR", "CTLT", "CAT", "CBOE", "CBRE", "CDW", "CE", "CNC", "CNP", "CDAY", "CMG", "DOW", "DTE", "DUK", "DD", "DXC", "EMN", "ETN", "EBAY", "ECL", "EIX", "EW", "EA", "ELV", "LLY", "EMR", "ENPH", "ETR", "EOG", "EPAM", "GL", "GS", "HAL", "HIG", "HAS", "HCA", "PEAK", "HSIC", "HSY", "HES", "HPE", "HLT", "HOLX", "HON", "HRL", "LEN", "LNC", "LIN", "LYV", "LKQ", "REGN", "RF", "RSG", "RMD", "RHI", "ROK", "ROL", "ROP", "ROST", "RCL", "SPGI", "CRM", "SBAC", "SLB", "STX", "SEE", "SRE", "NOW", "SHW", "SBNY", "SPG", "SWKS", "SNA", "SEDG", "SO", "LUV", "SWK", "SBUX", "STT", "STLD", "STE", "SYK", "SIVB", "SYF", "SNPS", "SYY", "TMUS", "TROW", "TTWO", "TPR", "TRGP", "TGT", "TEL", "TDY", "TFX", "TER", "TSLA", "TXN", "TXT", "KO", "EL", "HD", "IPG", "SJM", "MOS", "TRV", "TMO", "TJX", "TSCO", "TT", "TDG", "TRMB", "TFC", "TYL", "TSN", "USB"};

        //Creating an array for win rate, loss rate, expectancy for all strategies.
        double[] statMeanRev = {38, 62, 0.61};
        double[] statBreakout = {57, 43, 0.52};
        double[] statIpo = {63, 37, 0.76};
        double[] statTrendF = {56, 44, 0.44};
        double[] statGoodN = {43, 57, 0.50};
        double[] statMoveAvg = {56, 44, 0.64};
        double[] statContract = {50, 50, 0.30};
        double[] statDeltaN = {62, 38, 0.86};
        double[] statCanslim = {60, 40, 0.54};
        double[] statMacro = {49, 51, 0.44};

        // Declaring & initializing user input.
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);

        // Declaring & initializing a randomization.
        Random randomValue = new Random();

        // Declaring & initializing a random starting capital.
        int balance = randomValue.nextInt(2000, 8000);

        // Declaring & initializing variables before loop.
        int startBalance = balance;
        int tradeCount = 0;
        int totalRisk = 0;

        //Optimizing repetition
        String outPerform = "\n-------------------------------\nYou out-performed the strategy!\n-------------------------------\n\n";
        String undPerform = "\n-------------------------------\nYou under-performed the strategy!\n-------------------------------\n\n";
        String successful = "\n----------------\nSUCCESSFUL TRADE\n----------------\n";
        String unsuccessful = "\n------------------\nUNSUCCESSFUL TRADE\n------------------\n";

        // System output, welcoming message.
        System.out.println("\n-------------------------------\nWelcome to The Risk Simulation!\n-------------------------------\n\n" +
                "Have you used this simulation before? (Y/N)");

        // User input, answer Y/N.
        String check1 = keyboard.nextLine();

        // Checks for valid inputs.
        while (!(check1.equalsIgnoreCase("y")) && !(check1.equalsIgnoreCase("n"))) {
            System.out.println("\nInvalid answer, please type (Y/N).");
            check1 = keyboard.nextLine();
        }
        // If user inputs no, print below.
        if (check1.equalsIgnoreCase("n")) {
            System.out.println("\n" +
                    "-----------\n" +
                    "Background:\n" +
                    "-----------\n\n" +
                    "Within the world of both investing and trading there is often one element that is overlooked, risk management. \n" +
                    "As humans, it’s in our nature to believe that we will be right when faced with a decision. \n" +
                    "We purchase a stock with the belief that the price will go up, otherwise we wouldn’t purchase it, right?\n" +
                    "Unfortunately, if the stock price goes down we may just hold the stock in “hopes” that price will eventually rise.\n" +
                    "This is the grim truth that leads to empty pockets, and sorrows..\n\n" +
                    "In order to be a profitable trader/investor we must manage our risk accordingly! Even with a profitable strategy,\n" +
                    "we might have risk tolerance far greater than our strategy allows. If we risk to much on a single trade, we lose.\n" +
                    "This simulation provides a risk-free environment to understand this concept on a fundamental level.\n\n" +
                    "------------\n" +
                    "How To Play:\n" +
                    "------------\n\n" +
                    "Your goal in this simulator is to generate as much profit as possible!\n" +
                    "You start by choosing a profitable strategy, and will be randomly assigned some amount of capital to trade.\n" +
                    "After this, your only decision is to quantify how much you are willing to risk on each trade!\n" +
                    "You have an unlimited number of trades during this simulation.\n\n" +
                    "Trading outcomes are random, and so our program will randomly generate either a winning or losing trade.\n" +
                    "These outcomes will be expressed in terms of R, or Initial Risk.\n" +
                    "For example, if you decide to risk $100 on a trade then we can say your risk is 1R. If you seek to profit \n" +
                    "$400 on this same trade, then your reward potential is 4R, or 4x your initial risk.");
        }
        // If user inputs yes, continue program.
        if (check1.equalsIgnoreCase("y")) {
        }
        // Asking below question.
        System.out.println("\nWould you like to start the simulation? (Y/N)");

        // User input, answer Y/N.
        String check2 = keyboard.nextLine();

        // Checks for valid inputs.
        while (!(check2.equalsIgnoreCase("y")) && !(check2.equalsIgnoreCase("n"))) {
            System.out.println("\nInvalid answer, please type (Y/N).");
            check2 = keyboard.nextLine();
        }
        // If user inputs no, system exit.
        if (check2.equalsIgnoreCase("n")) {
            System.exit(0);
        }
        // If user inputs yes, print below.
        if (check2.equalsIgnoreCase("y")) {
            System.out.println("\nGood luck and trade well!");
        }
        // Delaying the simulation by 1 second.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        // Output strategy options. Each strategy has a unique character length so that it can be
        // linked to the correct strategy array.
        System.out.println("\n-------------------------------------------------------------\nEach of the following strategies have a different expectancy:\n-------------------------------------------------------------\n\n" +
                "- Mean Reversion\n" + // 14 char
                "- Breakout\n" + // 8 char
                "- IPO\n" + // 3 char
                "- Trend Following\n" + // 15 char
                "- Good News\n" + // 9 char
                "- Moving Avg\n" + // 10 char
                "- Contraction\n" + // 11 char
                "- Delta Neutral\n" + // 13 char
                "- CANSLIM\n" + // 7 char
                "- Macro\n\n" + // 5 char
                "Which strategy would you like to chose?");

        // Input strategy selection.
        String userStrategy = keyboard.nextLine();

        // Checks for valid inputs.
        while (!(userStrategy.equalsIgnoreCase("mean reversion"))
                && !(userStrategy.equalsIgnoreCase("breakout"))
                && !(userStrategy.equalsIgnoreCase("ipo"))
                && !(userStrategy.equalsIgnoreCase("trend following"))
                && !(userStrategy.equalsIgnoreCase("good news"))
                && !(userStrategy.equalsIgnoreCase("moving avg"))
                && !(userStrategy.equalsIgnoreCase("contraction"))
                && !(userStrategy.equalsIgnoreCase("delta neutral"))
                && !(userStrategy.equalsIgnoreCase("canslim"))
                && !(userStrategy.equalsIgnoreCase("macro"))) {
            System.out.println("\nInvalid strategy, please try again.");
            userStrategy = keyboard.nextLine();
        }
        // Output strategy selection, and starting capital.
        System.out.println("\n" +
                "STRATEGY SELECTED: " + userStrategy + "\n" +
                "STARTING CAPITAL: $" + balance + "\n\n" +
                "Would you like to continue? (Y/N)");

        // User input, answer Y/N.
        String check3 = keyboard.nextLine();

        // Checks for valid inputs.
        while (!(check3.equalsIgnoreCase("y")) && !(check3.equalsIgnoreCase("n"))) {
            System.out.println("\nInvalid answer, please type (Y/N).");
            check3 = keyboard.nextLine();
        }
        // If user inputs no, system exit.
        if (check3.equalsIgnoreCase("n")) {
            System.exit(0);
        }
        // If user inputs yes, continue.
        if (check3.equalsIgnoreCase("y")) {
        }
        // Loop the following code if balance > 0.
        while (balance > 0) {

            // Declaring and initializing randomized stock information, rounding to 2 decimal places.
            int stock = randomValue.nextInt(stockArray.length);
            double stockPrice = randomValue.nextDouble(30.00, 150.00);
            double hunStockPrice = Math.round(stockPrice * 100);
            double roundStockPrice = hunStockPrice / 100;
            double targetMultiplier = randomValue.nextDouble(1.01, 1.20);
            double targetPrice = (stockPrice * targetMultiplier);
            double hunTargetPrice = Math.round(targetPrice * 100);
            double roundTargetPrice = hunTargetPrice / 100;
            double gain = (((roundTargetPrice / roundStockPrice) - 1) * 100);
            double hunGain = Math.round(gain * 100);
            double roundGain = hunGain / 100;
            int rValue = randomValue.nextInt(0, 99);

            // Output trading opportunity & request risk input.
            System.out.println("\n--------------------\nTrading Opportunity:\n--------------------\n\n" +
                    "STOCK: " + stockArray[rValue] +
                    "\nPRICE: $" + roundStockPrice +
                    "\nTARGET: $" + roundTargetPrice +
                    "\nGAIN: " + roundGain + "%" +
                    "\n\nCAPITAL: $" + balance +
                    "\n\nHow much would you like to risk? ($)");

            // Using keyboard2 scanner for integer, solves a "glitch".
            // Check to see if risk input is greater than 0 and less than available balance.
            int risk = keyboard2.nextInt();
            while (!(risk < 0) && !(risk <= balance)) {
                System.out.println("Invalid answer, please try again.");
                risk = keyboard2.nextInt();
            }
            // Mean Reversion = 14 characters, therefore randomize a data point from meanRev array.
            // Declaring and initializing formula.
            if (userStrategy.length() == 14) {
                int dollarV = risk * meanRev[rValue];
                // Output randomized results.
                if (meanRev[rValue]>0) {System.out.println(successful);
                }
                if (meanRev[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + meanRev[rValue] + "R" +
                        "\nDOLLAR RESULT: $" + dollarV +
                        "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                // Update balance and total risk for next loop.
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 8) {
                int dollarV = risk * breakout[rValue];
                if (breakout[rValue]>0) {System.out.println(successful);
                }
                if (breakout[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + breakout[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 3) {
                int dollarV = risk * ipo[rValue];
                if (ipo[rValue]>0) {System.out.println(successful);
                }
                if (ipo[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + ipo[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 15) {
                int dollarV = risk * trendF[rValue];
                if (trendF[rValue]>0) {System.out.println(successful);
                }
                if (trendF[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + trendF[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 9) {
                int dollarV = risk * goodN[rValue];
                if (goodN[rValue]>0) {System.out.println(successful);
                }
                if (goodN[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + goodN[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 10) {
                int dollarV = risk * moveAvg[rValue];
                if (moveAvg[rValue]>0) {System.out.println(successful);
                }
                if (moveAvg[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + moveAvg[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 11) {
                int dollarV = risk * contract[rValue];
                if (contract[rValue]>0) {System.out.println(successful);
                }
                if (contract[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + contract[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 13) {
                int dollarV = risk * deltaN[rValue];
                if (deltaN[rValue]>0) {System.out.println(successful);
                }
                if (deltaN[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + deltaN[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 7) {
                int dollarV = risk * canslim[rValue];
                if (canslim[rValue]>0) {System.out.println(successful);
                }
                if (canslim[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + canslim[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            if (userStrategy.length() == 5) {
                int dollarV = risk * macro[rValue];
                if (macro[rValue]>0) {System.out.println(successful);
                }
                if (macro[rValue]<0) {System.out.println(unsuccessful);
                }
                System.out.println(
                        "TRADING RESULT: " + macro[rValue] + "R" +
                                "\nDOLLAR RESULT: $" + dollarV +
                                "\nACCOUNT BALANCE: $" + (balance + dollarV) +
                                "\n\nTRADE COUNT: " + (tradeCount++ + 1));
                balance = (balance + dollarV);
                totalRisk = totalRisk + risk;
            }
            System.out.println("\nWould you like to continue? (Y/N)");

            // User input, answer Y/N.
            String check4 = keyboard.nextLine();

            // Checks for valid inputs.
            while (!(check4.equalsIgnoreCase("y")) && !(check4.equalsIgnoreCase("n"))) {
                System.out.println("\nInvalid answer, please type (Y/N).");
                check4 = keyboard.nextLine();
            }
            // If user inputs yes, continue.
            if (check4.equalsIgnoreCase("y")) {

            }
            // If user inputs no, break loop.
            if (check4.equalsIgnoreCase("n")) {
                break;
            }
        }
        // Final output, stats.
        System.out.println("-------------------\nTRADING STATISTICS:\n-------------------\n\n" +
                "TRADE COUNT: " + tradeCount +
                "\nACCOUNT BALANCE: $" + balance);

        // Output based on performance.
        if (balance >= startBalance) {
            System.out.println("ACCOUNT GAIN: $" + (balance - startBalance));
        }
        if (balance < startBalance) {
            System.out.println("ACCOUNT LOSS: $" + (balance - startBalance));
        }
        System.out.println("TOTAL RISK: $" + totalRisk +
                "\n\n--------------------\nSTRATEGY STATISTICS:\n--------------------\n");

        // The following if statements are all identical in function. They are taking the char
        // length of the user strategy and selecting the appropriate array to pull data from.
        if (userStrategy.length() == 14) {
            // Declaring and initializing expected account value.
            double eAccountVal = (startBalance + (totalRisk * statMeanRev[2]));
            //Output array information
            System.out.println("STRATEGY: Mean Reversion\n" +
                    "STRATEGY WIN RATE: " + statMeanRev[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statMeanRev[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statMeanRev[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            //Output based on performance.
            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            // Output based on performance.
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            // Output explaining expectation.
            System.out.println("* With a strategy expectancy of " + statMeanRev[2] + " we expect\nto make $" + statMeanRev[2] + " for every $1 of risk taken.");
        }

        if (userStrategy.length() == 8) {
            double eAccountVal = (startBalance + (totalRisk * statBreakout[2]));
            System.out.println("STRATEGY: Breakout\n" +
                    "STRATEGY WIN RATE: " + statBreakout[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statBreakout[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statBreakout[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statBreakout[2] + " we expect\nto make $" + statBreakout[2] + " for every $1 of risk taken.");
        }
        if (userStrategy.length() == 3) {
            double eAccountVal = (startBalance + (totalRisk * statIpo[2]));
            System.out.println("STRATEGY: IPO\n" +
                    "STRATEGY WIN RATE: " + statIpo[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statIpo[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statIpo[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statIpo[2] + " we expect\nto make $" + statIpo[2] + " for every $1 of risk taken.");
        }

        if (userStrategy.length() == 15) {
            double eAccountVal = (startBalance + (totalRisk * statTrendF[2]));
            System.out.println("STRATEGY: Trend Following\n" +
                    "STRATEGY WIN RATE: " + statTrendF[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statTrendF[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statTrendF[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statTrendF[2] + " we expect\nto make $" + statTrendF[2] + " for every $1 of risk taken.");
        }

        if (userStrategy.length() == 9) {
            double eAccountVal = (startBalance + (totalRisk * statGoodN[2]));
            System.out.println("STRATEGY: Good News\n" +
                    "STRATEGY WIN RATE: " + statGoodN[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statGoodN[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statGoodN[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statGoodN[2] + " we expect\nto make $" + statGoodN[2] + " for every $1 of risk taken.");
        }

        if (userStrategy.length() == 10) {
            double eAccountVal = (startBalance + (totalRisk * statMoveAvg[2]));
            System.out.println("STRATEGY: Moving Avg\n" +
                    "STRATEGY WIN RATE: " + statMoveAvg[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statMoveAvg[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statMoveAvg[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statMoveAvg[2] + " we expect\nto make $" + statMoveAvg[2] + " for every $1 of risk taken.");
        }

        if (userStrategy.length() == 11) {
            double eAccountVal = (startBalance + (totalRisk * statContract[2]));
            System.out.println("STRATEGY: Contraction\n" +
                    "STRATEGY WIN RATE: " + statContract[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statContract[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statContract[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statContract[2] + " we expect\nto make $" + statContract[2] + " for every $1 of risk taken.");
        }

        if (userStrategy.length() == 13) {
            double eAccountVal = (startBalance + (totalRisk * statDeltaN[2]));
            System.out.println("STRATEGY: Delta Neutral\n" +
                    "STRATEGY WIN RATE: " + statDeltaN[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statDeltaN[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statDeltaN[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statDeltaN[2] + " we expect\nto make $" + statDeltaN[2] + " for every $1 of risk taken.");
        }

        if (userStrategy.length() == 7) {
            double eAccountVal = (startBalance + (totalRisk * statCanslim[2]));
            System.out.println("STRATEGY: CANSLIM\n" +
                    "STRATEGY WIN RATE: " + statCanslim[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statCanslim[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statCanslim[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statCanslim[2] + " we expect\nto make $" + statCanslim[2] + " for every $1 of risk taken.");
        }
        if (userStrategy.length() == 5) {
            double eAccountVal = (startBalance + (totalRisk * statMacro[2]));
            System.out.println("STRATEGY: Macro\n" +
                    "STRATEGY WIN RATE: " + statMacro[0] + "%\n" +
                    "STRATEGY LOSS RATE: " + statMacro[1] + "%\n" +
                    "STRATEGY EXPECTANCY: " + statMacro[2] + "\n\n" +
                    "EXPECTED ACCOUNT VALUE: $" + eAccountVal + " *");

            if (balance > eAccountVal) {
                System.out.println(outPerform);
            }
            if (balance <= eAccountVal) {
                System.out.println(undPerform);
            }
            System.out.println("* With a strategy expectancy of " + statMacro[2] + " we expect\nto make $" + statMacro[2] + " for every $1 of risk taken.");
        }
        // Close program.
        System.exit(0);
    }
}