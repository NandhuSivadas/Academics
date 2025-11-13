# pgm19_clean_tree.py
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.metrics import accuracy_score, confusion_matrix, ConfusionMatrixDisplay, classification_report

# Load Titanic dataset
data = sns.load_dataset('titanic')
print("Dataset Preview:")
print(data.head())

# Select important columns
data = data[['survived', 'pclass', 'sex', 'age', 'sibsp', 'parch', 'fare', 'embarked']]

# Handle missing values safely
data = data.copy()
data['age'] = data['age'].fillna(data['age'].median())
data['embarked'] = data['embarked'].fillna(data['embarked'].mode()[0])

# Encode categorical columns
label = LabelEncoder()
data['sex'] = label.fit_transform(data['sex'])
data['embarked'] = label.fit_transform(data['embarked'])

# Split features and target
X = data.drop('survived', axis=1)
y = data['survived']

# Train-test split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train Decision Tree with limited depth for clarity
model = DecisionTreeClassifier(random_state=42, max_depth=4)
model.fit(X_train, y_train)

# Predictions and evaluation
y_pred = model.predict(X_test)

print("\n1️⃣ Overall Accuracy: {:.2f} %".format(accuracy_score(y_test, y_pred) * 100))

print("\n2️⃣ Confusion Matrix:")
cm = confusion_matrix(y_test, y_pred)
print(cm)
ConfusionMatrixDisplay(cm).plot(cmap='Blues')
plt.show()

print("\n3️⃣ Classification Report:")
print(classification_report(y_test, y_pred))

print("\n4️⃣ Feature Importance Scores:")
importances = model.feature_importances_
for name, importance in zip(X.columns, importances):
    print(f"{name:12s}: {importance:.4f}")

# --- Tree Visualization (clean and simple) ---
plt.figure(figsize=(16, 10))
plot_tree(model,
          filled=True,
          feature_names=X.columns,
          class_names=["Not Survived", "Survived"],
          rounded=True,
          fontsize=10)
plt.title("Decision Tree (max_depth=4) - Titanic Survival Prediction")
plt.show()








#  Overall Accuracy

#  Accuracy of Decision Tree Classifier: 79.89 %
#  Interpretation:
#   The model correctly predicts the survival outcome for about 80% of passengers on the test data.
#   This indicates a good balance between bias and variance for a simple decision tree.

# ---

# Confusion Matrix

# |                         | Predicted Not Survived | Predicted Survived |
# | ----------------------- | ---------------------- | ------------------ |
# | Actual Not Survived | 96                     | 9                  |
# | Actual Survived     | 27                     | 47                 |

#   Correctly classified: 96 (not survived) + 47 (survived) = 143 passengers
#  Incorrectly classified: 9 (false positives) + 27 (false negatives) = 36 passengers

# Interpretation:
# The model performs better at identifying non-survivors than survivors.
# It misses some survivors (27 passengers misclassified as not survived).

# ---

# Precision, Recall, and F1-Score

# | Metric        | Not Survived (0) | Survived (1) |
# | ------------- | ---------------- | ------------ |
# | Precision | 0.78             | 0.84         |
# | Recall    | 0.91             | 0.64         |
# | F1-Score  | 0.84             | 0.72         |

# Interpretation:

#  The model has high recall (0.91) for not survived, meaning it captures most actual non-survivors.
#  Lower recall (0.64) for survived, meaning it misses some survivors.
#  Overall, the classifier performs reliably but slightly favors the majority class (non-survivors).

# ---

# Feature Importance

# | Feature  | Importance |
# | -------- | ---------- |
# | sex      | 0.5796     |
# | pclass   | 0.2005     |
# | age      | 0.0789     |
# | fare     | 0.0752     |
# | sibsp    | 0.0461     |
# | embarked | 0.0139     |
# | parch    | 0.0059     |

# Interpretation:

#  The most influential feature is `sex`, followed by `pclass`.
#  This means that gender and passenger class were the key factors in predicting survival —
#   women and first-class passengers had a much higher chance of survival.

# ---

#  Decision Tree Visualization & Path Explanation

#  The Decision Tree mainly splits based on:

#   1. `sex` (male/female)
#   2. `pclass` (passenger class)
#   3. `fare` and `age`

# Example Decision Path:

# > If `sex = female` → then check `pclass`.
# > If `pclass = 1 or 2` → Predicted as Survived
# > If `pclass = 3` → further checks on `fare` or `age` may apply.

# Interpretation:
# The tree captures the real Titanic trend —
# “Female passengers in higher classes had a higher probability of survival, while males in lower classes were less likely to survive.”


