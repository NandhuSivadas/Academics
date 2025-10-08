# Import necessary libraries
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
import numpy as np

# Given data
car_age = [5,7,8,7,2,17,2,9,4,11,12,9,6]
car_speed = [99,86,87,88,111,86,103,87,94,78,77,85,86]

# Convert lists to numpy arrays and reshape
X = np.array(car_age).reshape(-1, 1)
y = np.array(car_speed)

# Create and train the model
model = LinearRegression()
model.fit(X, y)

# Predict values for drawing regression line
y_pred = model.predict(X)

# Plot the regression line
plt.scatter(X, y, color='blue', label='Actual Data')
plt.plot(X, y_pred, color='red', linewidth=2, label='Regression Line')
plt.xlabel('Car Age (years)')
plt.ylabel('Car Speed')
plt.title('Linear Regression: Car Age vs Speed')
plt.legend()
plt.show()

# (ii) Predict car_speed for car_age = 14
predicted_speed = model.predict([[14]])
print(f"Predicted car speed for car age 14 years: {predicted_speed[0]:.2f}")


