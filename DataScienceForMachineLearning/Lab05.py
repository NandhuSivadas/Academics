# Lab Exercise #05
# kNN using Scikit-Learn on Iris Dataset

import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier

# Step 1: Load dataset
df = pd.read_csv("iris.csv")
print(df.head())   # Show first 5 rows

# Step 2: Separate features and target
X = df.drop("species", axis=1)   # Features (inputs)
y = df["species"]               # Target (output)

# Step 3: Split into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Step 4: Create and train kNN model
knn = KNeighborsClassifier(n_neighbors=5)  # k = 5
knn.fit(X_train, y_train)

# Step 5: Check accuracy
accuracy = knn.score(X_test, y_test)
print("Accuracy:", accuracy)

# Step 6: Predict a new instance
new_instance = [[5.1, 3.5, 1.4, 0.2]]
prediction = knn.predict(new_instance)
print("Prediction for new instance:", prediction[0])
