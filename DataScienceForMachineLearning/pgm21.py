# Step 1: Import libraries
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report, roc_auc_score
import matplotlib.pyplot as plt
import seaborn as sns

# Step 2: Load dataset
data = pd.read_csv("Titanic_Train.csv")
print(data.head())

# Step 3: Select required features
features = data[["Pclass", "Sex", "Age", "Fare", "SibSp", "Parch"]]
target = data["Survived"]

# Step 4: Handle missing values
features["Age"] = features["Age"].fillna(features["Age"].mean())

# Step 5: Encode categorical data
le = LabelEncoder()
features["Sex"] = le.fit_transform(features["Sex"])

# Step 6: Split the data
X_train, X_test, y_train, y_test = train_test_split(features, target, test_size=0.2, random_state=42)

# Step 7: Train Random Forest
rf = RandomForestClassifier(n_estimators=100, random_state=42)
rf.fit(X_train, y_train)

# Step 8: Predict
y_pred = rf.predict(X_test)

# Step 9: Accuracy
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)

# Step 10: Classification report
print("\nClassification Report:\n", classification_report(y_test, y_pred))

# Step 11: Confusion Matrix
cm = confusion_matrix(y_test, y_pred)
print("\nConfusion Matrix:\n", cm)

sns.heatmap(cm, annot=True, fmt='d', cmap="Blues")
plt.title("Confusion Matrix")
plt.xlabel("Predicted")
plt.ylabel("Actual")
plt.show()

# Step 12: Feature Importance
importances = rf.feature_importances_
feature_names = features.columns

plt.figure(figsize=(8,5))
plt.barh(feature_names, importances)
plt.title("Feature Importance")
plt.xlabel("Importance Score")
plt.show()

# Step 13: Compare n_estimators
for n in [50, 100, 200]:
    model = RandomForestClassifier(n_estimators=n, random_state=42)
    model.fit(X_train, y_train)
    pred = model.predict(X_test)
    acc = accuracy_score(y_test, pred)
    print(f"Accuracy with {n} trees:", acc)

# Step 14: ROC-AUC Score
y_prob = rf.predict_proba(X_test)[:, 1]
auc = roc_auc_score(y_test, y_prob)
print("\nROC-AUC Score:", auc)
