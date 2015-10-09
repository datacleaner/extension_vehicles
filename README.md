This extension will validate a Vehicle Identification Number(VIN).

A VIN number is a 17-character string that uniquely identifies a motor vehicle. It also encodes the manufacturer and attributes of the vehicle.
To guard against accidentally entering an incorrect VIN number, the VIN number incorporates a check digit (the 9th character).
Each letter and number is assigned a value between 0 and 9. The check digit is chosen so to be the weighted sum of the values mod 11, using the symbol X if the remainder is 10.

<table style="width:100%">
<tr><td>A</td><td>B</td><td>C</td><td>D</td><td>E</td><td>F</td><td>G</td><td>H</td><td>I</td><td>J</td><td>K</td><td>L</td><td>M</td><td>N</td><td>O</td><td>P</td><td>Q</td><td>R</td><td>S<td>T</td><td>U</td><td>V</td><td>W</td><td>X</td><td>Y</td><td>Z</td></tr>
<tr><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>-</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>-</td><td>7</td><td>-</td><td>9</td><td>2<td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td></tr>
</table>

For example the check digit of the partial VIN number 1FA-CP45E-?-LF192944 is X because the weighted sum is 373 and 373 mod 11 is 10.

<table style="width:100%">
<tr><td>1st</td><td>2nd</td><td>3rd</td><td>4th</td><td>5th</td><td>6th</td><td>7th</td><td>8th</td><td>9th</td><td>10</td><td>11</td><td>12</td><td>13</td><td>14</td><td>15</td><td>16</td><td>17</td></tr>
<tr><td>8</td><td>7</td><td>6</td><td>5</td><td>4</td><td>3</td><td>2</td><td>10</td><td>0</td><td>9</td><td>8</td><td>7</td><td>6</td><td>5</td><td>4</td><td>3</td><td>2</td></tr>
</table>

This extension takes the input VIN number and determines whether or not it is a valid VIN number.
It allows the input to be entered with upper or lower case, and allows dashes.
It will check if the input has the right length, that is has no illegal characters (I, O, Q), etc.

Job Example:
![Job Example](src/main/resources/org/eobjects/datacleaner/vin/ExampleJob.jpg?raw=true "Job Example")

Configuration Example:
![Configuration Example](src/main/resources/org/eobjects/datacleaner/vin/ConfigurationExample.jpg?raw=true "Configuration Example")

Result Example:
![Result Example](src/main/resources/org/eobjects/datacleaner/vin/ExampleResult.jpg?raw=true "Result Example")


