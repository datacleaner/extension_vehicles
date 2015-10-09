/**
DataCleaner extension which validates a vehicle identification number.

 @author Mark Ansink
 */
package org.datacleaner.components.vehicles;

import javax.inject.Named;

import org.datacleaner.api.Categorized;
import org.datacleaner.api.Configured;
import org.datacleaner.api.Description;
import org.datacleaner.api.InputColumn;
import org.datacleaner.api.InputRow;
import org.datacleaner.api.OutputColumns;
import org.datacleaner.api.Transformer;
import org.datacleaner.components.categories.ProductDataCategory;

@Named("VIN (Vehicle Identification Number) Check")
@Description("The VIN validation takes the input and determines whether or not it is a valid VIN number.\n"
        + "It allows the input to be entered with upper or lower case, and allows dashes.\n"
        + "It will check if the input has the right length, that is has no illegal characters (I, O, Q), etc.")
@Categorized(ProductDataCategory.class)
public class VINCheckTransformer implements Transformer {

    private static final int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 0, 7, 0, 9, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static final int[] WEIGHTS = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };

    @Configured
    @Description("A field containing VIN numbers to check")
    InputColumn<String> column;

    @Override
    public OutputColumns getOutputColumns() {
        String[] columnNames = { "result", "severity", "message" };
        Class<?>[] columnTypes = new Class[] { String.class, Integer.class, String.class };
        return new OutputColumns(columnNames, columnTypes);
    }

    @Override
    public Object[] transform(InputRow inputRow) {
        String message = "";
        String result = "";
        Integer severity = null;
        int value = 0;

        String s = inputRow.getValue(column);
        s = s.replaceAll("-", "");
        s = s.toUpperCase();

        if (s.length() != 17) {
            result = ("Invalid");
            severity = 2;
            message = ("VIN number must be 17 characters");
        } else {
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                char c = s.charAt(i);

                int weight = WEIGHTS[i];

                // letter
                if (c >= 'A' && c <= 'Z') {
                    value = VALUES[c - 'A'];
                    if (value == 0) {
                        severity = 3;
                        message = ("Illegal character: " + c);
                    }
                }

                // number
                else if (c >= '0' && c <= '9')
                    value = c - '0';

                // illegal character
                else {
                    severity = 3;
                    message = ("Illegal character: " + c);
                }
                sum = sum + weight * value;

            }

            // check digit
            sum = sum % 11;
            char check = s.charAt(8);
            if (check != 'X' && (check < '0' || check > '9')) {
                severity = 4;
                message = ("Illegal check digit: " + check);
            }

            if (sum == 10 && check == 'X') {
                severity = 1;
                result = ("Valid");
            }

            else if (sum == check - '0') {
                severity = 1;
                result = ("Valid");
            } else {
                result = ("Invalid");

                if (message.equals("")) {
                    severity = 5;
                    message = ("Overall VIN is incorrect");
                }
            }
        }

        return new Object[] { result, severity, message };
    }
}
