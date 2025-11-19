import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.ensemble import AdaBoostClassifier
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report, roc_auc_score, roc_curve

# 1. Load Dataset
data = pd.read_csv("Heart_Disease.csv")
print("Dataset first rows:\n", data.head())

# 2. Check missing values
print("\nMissing values:\n", data.isnull().sum())

# 3. Features and Target
X = data.drop("target", axis=1)
y = data["target"]

# 4. Train-test split
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42
)

# 5. Scale data
scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)

# 6. Train AdaBoost Model
model = AdaBoostClassifier(n_estimators=50, learning_rate=1.0)
model.fit(X_train, y_train)

# 7. Accuracy
y_pred = model.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print("\nAccuracy:", accuracy)

# 8. Confusion Matrix
cm = confusion_matrix(y_test, y_pred)
print("\nConfusion Matrix:\n", cm)

# 9. Classification Report
print("\nClassification Report:\n", classification_report(y_test, y_pred))

# 10. ROC Curve & AUC
y_prob = model.predict_proba(X_test)[:, 1]
auc = roc_auc_score(y_test, y_prob)
print("\nROC-AUC Score:", auc)

fpr, tpr, _ = roc_curve(y_test, y_prob)
plt.plot(fpr, tpr)
plt.xlabel("False Positive Rate")
plt.ylabel("True Positive Rate")
plt.title("ROC Curve - AdaBoost")
plt.show()

# 11. Feature Importance
plt.figure(figsize=(10,6))
plt.bar(range(X.shape[1]), model.feature_importances_)
plt.xticks(range(X.shape[1]), X.columns, rotation=90)
plt.title("Feature Importance - AdaBoost")
plt.tight_layout()
plt.show()

# 12. Test with different estimators
for n in [10, 50, 100]:
    temp = AdaBoostClassifier(n_estimators=n)
    temp.fit(X_train, y_train)
    yp = temp.predict(X_test)
    print(f"Accuracy with {n} estimators: {accuracy_score(y_test, yp)}")
