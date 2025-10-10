# Import libraries
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
import numpy as np

# Given data
age = [18, 22, 30, 45, 65, 80]
accident_no = [38, 36, 24, 20, 18, 28]

# Convert to numpy arrays and reshape
X = np.array(age).reshape(-1, 1)  # Independent variable
y = np.array(accident_no)         # Dependent variable

# Create and train Linear Regression model
model = LinearRegression()
model.fit(X, y)

# Predict accident numbers (for regression line)
y_pred = model.predict(X)

# Plot data and regression line
plt.scatter(X, y, color='blue', label='Actual Data')
plt.plot(X, y_pred, color='red', linewidth=2, label='Regression Line')
plt.xlabel('Age of Driver')
plt.ylabel('Number of Accidents')
plt.title('Simple Linear Regression: Age vs Number of Accidents')
plt.legend()
plt.show()

# (ii) Predict accidents for ages 40 and 60
    
n=int(input("Ente the car age:"))
predict_ac=model.predict([[n]])
print(f"Predicted number of accident: {predict_ac[0]:.2f}")


# Display regression equation
# print(f"\nEquation of the line: y = {model.coef_[0]:.2f}x + {model.intercept_:.2f}")
