package APPLICATION;

public class TestUtility {
    public static boolean checkIfSorted(int[] valueList) {
        boolean isSorted = true;

        for (int i = 0; i < valueList.length - 1; i++)
            if (valueList[i + 1] < valueList[i])
                isSorted = false;

        return isSorted;
    }
}
