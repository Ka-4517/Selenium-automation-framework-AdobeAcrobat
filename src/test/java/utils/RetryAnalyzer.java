// package utils;

// import org.testng.IRetryAnalyzer;
// import org.testng.ITestResult;

// public class RetryAnalyzer implements IRetryAnalyzer {

//     private int count = 0;
//     private static final int MAX_RETRY = 2;

//     @Override
//     public boolean retry(ITestResult result) {

//         if (!result.isSuccess() && count < MAX_RETRY) {
//             count++;
//             System.out.println("Retrying test: Attempt " + count);
//             return true;
//         }

//         return false;
//     }
// }