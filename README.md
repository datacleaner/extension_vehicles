This extension will validate a Vehicle Identification Number(VIN).

A VIN number is a 17-character string that uniquely identifies a motor vehicle. It also encodes the manufacturer and attributes of the vehicle.
To guard against accidentally entering an incorrect VIN number, the VIN number incorporates a check digit (the 9th character).
Each letter and number is assigned a value between 0 and 9. The check digit is chosen so to be the weighted sum of the values mod 11, using the symbol X if the remainder is 10.

See the wiki page for an example.

This extension takes the input VIN number and determines whether or not it is a valid VIN number.
It allows the input to be entered with upper or lower case, and allows dashes.
It will check if the input has the right length, that is has no illegal characters (I, O, Q), etc.


![Job Example](https://github.com/datacleaner/extension_vehicles/tree/master/src/main/resources/org/eobjects/datacleaner/vin/ExampleJob.jpg)

![Configuration Example](https://github.com/datacleaner/extension_vehicles/tree/master/src/main/resources/org/eobjects/datacleaner/vin/ConfigurationExample.jpg)

![Result Example](https://github.com/datacleaner/extension_vehicles/tree/master/src/main/resources/org/eobjects/datacleaner/vin/ExampleResult.jpg)


