<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JavaScript Fundamentals Project</title>
    <style>
        /* CSS Styles */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
            transition: background-color 0.5s ease;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        h1, h2 {
            color: #333;
        }

        section {
            margin-bottom: 30px;
            padding-bottom: 20px;
            border-bottom: 1px solid #eee;
        }

        .demo-box {
            background-color: #f9f9f9;
            padding: 15px;
            border-radius: 5px;
            margin-top: 10px;
        }

        button, input {
            padding: 8px 12px;
            margin: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

        .hidden {
            display: none;
        }

        #loop-output, #item-list {
            margin-top: 10px;
            padding: 10px;
            background-color: white;
            border-radius: 4px;
        }

        #item-list li {
            padding: 5px;
            margin: 3px 0;
            background-color: #e9e9e9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>JavaScript Fundamentals Demonstration</h1>
        
        <!-- Part 1: Variables and Conditionals Demo -->
        <section id="variables-section">
            <h2>Part 1: Variables & Conditionals</h2>
            <div class="demo-box">
                <button id="check-number">Check Number Type</button>
                <p id="number-result"></p>
            </div>
        </section>
        
        <!-- Part 2: Functions Demo -->
        <section id="functions-section">
            <h2>Part 2: Functions</h2>
            <div class="demo-box">
                <input type="number" id="rectangle-width" placeholder="Width">
                <input type="number" id="rectangle-height" placeholder="Height">
                <button id="calculate-area">Calculate Area</button>
                <button id="generate-password">Generate Password</button>
                <p id="function-results"></p>
            </div>
        </section>
        
        <!-- Part 3: Loops Demo -->
        <section id="loops-section">
            <h2>Part 3: Loops</h2>
            <div class="demo-box">
                <button id="countdown">Start Countdown</button>
                <button id="print-multiples">Print Multiples of 3</button>
                <div id="loop-output"></div>
            </div>
        </section>
        
        <!-- Part 4: DOM Interactions -->
        <section id="dom-section">
            <h2>Part 4: DOM Interactions</h2>
            <div class="demo-box">
                <button id="change-color">Change Background</button>
                <button id="add-item">Add List Item</button>
                <button id="toggle-content">Toggle Content</button>
                <ul id="item-list">
                    <li>Initial Item</li>
                </ul>
                <div id="toggle-content-area" class="hidden">
                    <p>This content can be toggled!</p>
                </div>
            </div>
        </section>
    </div>

    <script>
        // =============================================
        // Part 1: Variable Declarations and Conditionals
        // =============================================

        // Variable declarations with different data types
        const stringVar = "Hello, World!";
        let numberVar = 42;
        var booleanVar = true;
        let arrayVar = [1, 2, 3, 4, 5];
        const objectVar = { name: "Alice", age: 25 };

        // Conditional example
        document.getElementById('check-number').addEventListener('click', function() {
            // Get a random number between -10 and 10
            const randomNum = Math.floor(Math.random() * 21) - 10;
            let result;
            
            // Conditional checks
            if (randomNum > 0) {
                result = ${randomNum} is a positive number;
            } else if (randomNum < 0) {
                result = ${randomNum} is a negative number;
            } else {
                result = "The number is zero";
            }
            
            // Additional check for even/odd if positive
            if (randomNum > 0) {
                result += randomNum % 2 === 0 ? " and even" : " and odd";
            }
            
            document.getElementById('number-result').textContent = result;
        });

        // =============================================
        // Part 2: Custom Functions
        // =============================================

        // Function 1: Calculate area of a rectangle
        function calculateRectangleArea(width, height) {
            if (width <= 0 || height <= 0) {
                return "Dimensions must be positive numbers";
            }
            return width * height;
        }

        // Function 2: Generate a random password
        function generateRandomPassword(length = 8) {
            const charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
            let password = "";
            
            for (let i = 0; i < length; i++) {
                const randomIndex = Math.floor(Math.random() * charset.length);
                password += charset[randomIndex];
            }
            
            return password;
        }

        // Using the functions
        document.getElementById('calculate-area').addEventListener('click', function() {
            const width = parseFloat(document.getElementById('rectangle-width').value);
            const height = parseFloat(document.getElementById('rectangle-height').value);
            const area = calculateRectangleArea(width, height);
            document.getElementById('function-results').textContent = Area: ${area};
        });

        document.getElementById('generate-password').addEventListener('click', function() {
            const password = generateRandomPassword(10);
            document.getElementById('function-results').textContent = Generated Password: ${password};
        });

        // =============================================
        // Part 3: Loops
        // =============================================

        // Loop 1: Countdown using while loop
        document.getElementById('countdown').addEventListener('click', function() {
            let output = "";
            let count = 5;
            
            while (count >= 0) {
                output += Countdown: ${count}<br>;
                count--;
            }
            
            output += "Liftoff!";
            document.getElementById('loop-output').innerHTML = output;
        });

        // Loop 2: Print multiples of 3 using for loop
        document.getElementById('print-multiples').addEventListener('click', function() {
            let output = "Multiples of 3 up to 30:<br>";
            
            for (let i = 3; i <= 30; i += 3) {
                output += `${i} `;
            }
            
            document.getElementById('loop-output').innerHTML = output;
        });

        // =============================================
        // Part 4: DOM Interactions
        // =============================================

        // DOM Interaction 1: Change background color
        document.getElementById('change-color').addEventListener('click', function() {
            const colors = ["#ffcccc", "#ccffcc", "#ccccff", "#ffffcc", "#ffccff"];
            const randomColor = colors[Math.floor(Math.random() * colors.length)];
            document.body.style.backgroundColor = randomColor;
        });

        // DOM Interaction 2: Add item to list
        document.getElementById('add-item').addEventListener('click', function() {
            const list = document.getElementById('item-list');
            const newItem = document.createElement('li');
            newItem.textContent = Item ${list.children.length + 1};
            list.appendChild(newItem);
        });

        // DOM Interaction 3: Toggle content visibility
        document.getElementById('toggle-content').addEventListener('click', function() {
            const content = document.getElementById('toggle-content-area');
            content.classList.toggle('hidden');
        });
    </script>
</body>
</html>