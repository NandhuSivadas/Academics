# Lab Exercise 20: Decision Tree Classifier on Wine Quality Dataset
# Beginner-friendly version 💡

import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.metrics import accuracy_score, confusion_matrix, ConfusionMatrixDisplay, classification_report
from sklearn.preprocessing import LabelEncoder
import matplotlib.pyplot as plt

# 1️⃣ Load the dataset
print("✅ Loading dataset...")
data = pd.read_csv("Wine_Quality.csv")
print("✅ Dataset loaded successfully!")
print(data.head(), "\n")

# 2️⃣ Encode 'type' column (convert 'white'/'red' to numbers)
le = LabelEncoder()
data['type'] = le.fit_transform(data['type'])  # red=0, white=1

# 3️⃣ Separate features (X) and target (y)
X = data.drop('quality', axis=1)
y = data['quality']

# 4️⃣ Split the dataset
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42
)

# 5️⃣ Train Decision Tree with Gini index
model_gini = DecisionTreeClassifier(criterion='gini', random_state=42)
model_gini.fit(X_train, y_train)

# 6️⃣ Predict
y_pred = model_gini.predict(X_test)

# 7️⃣ Evaluation
accuracy = accuracy_score(y_test, y_pred)
print(f"1️⃣ Accuracy (Gini): {accuracy * 100:.2f}%\n")


# 1. Compute confusion matrix
cm = confusion_matrix(y_test, y_pred)

# 2. Print confusion matrix
print("Confusion Matrix:")
print(cm)

# 3. Visualize confusion matrix
plt.figure(figsize=(6, 5))
disp = ConfusionMatrixDisplay(confusion_matrix=cm)
disp.plot(cmap='Blues', values_format='d')
plt.title("Confusion Matrix")
plt.show()
# Classification report
print("3️⃣ Classification Report:\n", classification_report(y_test, y_pred))

# 8️⃣ Feature importance
print("4️⃣ Feature Importance Scores:")
for name, score in zip(X.columns, model_gini.feature_importances_):
    print(f"{name:25}: {score:.4f}")

# 9️⃣ Visualize Decision Tree
plt.figure(figsize=(18, 10))
plot_tree(model_gini,
          feature_names=X.columns,
          class_names=[str(i) for i in sorted(y.unique())],
          filled=True,
          fontsize=8,
          max_depth=3)  # show top 3 levels
plt.title("5️⃣ Decision Tree - Wine Quality (Gini)")
plt.show()

# 🔟 Compare Gini vs Entropy
model_entropy = DecisionTreeClassifier(criterion='entropy', random_state=42)
model_entropy.fit(X_train, y_train)
y_pred_entropy = model_entropy.predict(X_test)
acc_entropy = accuracy_score(y_test, y_pred_entropy)

print(f"\n6️⃣ Accuracy Comparison:")
print(f"Gini Accuracy    : {accuracy * 100:.2f}%")
print(f"Entropy Accuracy : {acc_entropy * 100:.2f}%")









# Accuracy of the Decision Tree Classifier

# Accuracy (Gini Index): 61.00%
# This means the Decision Tree model correctly classified 61% of the test wine samples.
# In other words, out of every 100 wines, about 61 were correctly predicted for their quality label.

# ---

# Confusion Matrix (Interpretation)

# Although the exact matrix isn’t printed, we can interpret it using the classification report:

# | Class | Recall | Meaning                                                                            |
# | ----- | ------ | ---------------------------------------------------------------------------------- |
# | 3     | 0.00   | The model failed to correctly classify any wines with quality 3 (very rare class). |
# | 4     | 0.26   | About 26% of wines that truly had quality 4 were correctly predicted.              |
# | 5     | 0.67   | 67% of wines that were actually quality 5 were correctly identified.               |
# | 6     | 0.66   | 66% of quality 6 wines were correctly predicted (good performance).                |
# | 7     | 0.48   | 48% of wines rated 7 were correctly recognized.                                    |
# | 8     | 0.25   | 25% of wines with quality 8 were correctly classified.                             |
# | 9     | 0.00   | No samples with quality 9 were in the test set.                                    |

# 🔹 Most correct predictions occur for quality 5 and 6, which are the majority classes.
# 🔹 Classes 3, 4, 8, 9 are rare, so the model struggles due to class imbalance.

# ---

# Precision, Recall, and F1-Score

# From the classification report:

# | Quality | Precision | Recall | F1-Score | Support |
# | ------- | --------- | ------ | -------- | ------- |
# | 3       | 0.00      | 0.00   | 0.00     | 2       |
# | 4       | 0.29      | 0.26   | 0.27     | 46      |
# | 5       | 0.67      | 0.67   | 0.67     | 420     |
# | 6       | 0.67      | 0.66   | 0.67     | 579     |
# | 7       | 0.48      | 0.48   | 0.48     | 221     |
# | 8       | 0.24      | 0.25   | 0.25     | 32      |
# | 9       | 0.00      | 0.00   | 0.00     | 0       |

# Interpretation:

#  Precision (how many predicted positives are correct) is best for quality 5 and 6.
#  Recall (how many actual positives were found) is also best for 5 and 6.
#  F1-score combines both; these two classes dominate the dataset, explaining the overall weighted F1 ≈ 0.61.

# ---

# Classification Report (Interpretation)

# Overall accuracy: 61%
# Macro avg: 0.33 → average performance across all classes, treating each equally.
# Weighted avg: 0.61 → weighted by the number of samples per class.

# Inference:

#  The classifier performs moderately well on common wine qualities (5–6).
#  Poor generalization on rare classes (3, 4, 8, 9) due to class imbalance.
#  Improvement can be achieved via data resampling, Random Forest, or class weighting.

# ---

# Visualization and Decision Path (Conceptual Explanation)

# When visualized (e.g., using `plot_tree()`), the Decision Tree shows hierarchical splits based on key features such as:

# ```
# alcohol <= 10.35 → quality = 5
# alcohol > 10.35 and volatile acidity <= 0.45 → quality = 6 or 7
# ```

# Interpretation of one path:

# > If a wine has alcohol > 10.35 and volatile acidity ≤ 0.45,
# > then it is likely to be of higher quality (6 or 7).

# This aligns with domain knowledge — higher alcohol and lower acidity are characteristics of better-quality wines.

# ---

#  Comparison of Splitting Criteria (Gini vs. Entropy)

# | Criterion   | Accuracy   | Comment                                          |
# | ----------- | ---------- | ------------------------------------------------ |
# | Gini    | 61.00% | Slightly better — simpler and faster to compute. |
# | Entropy | 59.85% | Nearly similar but slightly lower accuracy.      |

# Interpretation:
# Both criteria give similar performance.
# The Gini Index slightly outperforms Entropy for this dataset, suggesting that Gini is a good choice for this classification task.

# ---

# Final Summary

# | Aspect                  | Key Observation                           |
# | ----------------------- | ----------------------------------------- |
# | Accuracy                | 61.00%                                    |
# | Best Performing Classes | 5 and 6                                   |
# | Key Predictors          | Alcohol, Volatile Acidity, Sulphates, pH  |
# | Weak Areas              | Rare classes (3, 4, 8, 9)                 |
# | Best Criterion          | Gini Index                                |
# | Model Interpretation    | Higher alcohol → higher predicted quality |

