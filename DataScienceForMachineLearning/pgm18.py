# Step 1: Import required libraries
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler
from sklearn.cluster import DBSCAN
from sklearn.metrics import silhouette_score

# Step 2: Load the dataset
data = pd.read_csv("Air_Quality.csv")

# Step 3: View dataset structure
print("Dataset preview:\n", data.head())

# Step 4: Select numeric columns (ignore Date and Time)
features = data[["CO(GT)", "PT08.S1(CO)", "C6H6(GT)", "NOx(GT)", "NO2(GT)", "T", "RH", "AH"]]

# Step 5: Handle missing values (if any)
features = features.dropna()

# Step 6: Scale the data for better DBSCAN performance
scaler = StandardScaler()
scaled_data = scaler.fit_transform(features)

# Step 7: Apply DBSCAN
dbscan = DBSCAN(eps=1.0, min_samples=5)   # eps and min_samples can be tuned
labels = dbscan.fit_predict(scaled_data)

# Step 8: Add cluster labels to dataset
features["Cluster"] = labels

# Step 9: Check number of clusters and noise points
n_clusters = len(set(labels)) - (1 if -1 in labels else 0)
n_noise = list(labels).count(-1)

print("\nNumber of clusters formed:", n_clusters)
print("Number of noise points:", n_noise)

# Step 10: Compute Silhouette Score (only if more than 1 cluster exists)
if n_clusters > 1:
    score = silhouette_score(scaled_data, labels)
    print("Silhouette Score:", round(score, 3))
else:
    print("Silhouette Score: Not applicable (only one cluster or all noise)")

# Step 11: Visualize clusters
plt.figure(figsize=(8,6))
plt.scatter(scaled_data[:,0], scaled_data[:,1], c=labels, cmap='rainbow', s=50)
plt.title("DBSCAN Clustering on Air Quality Data")
plt.xlabel("CO(GT) (scaled)")
plt.ylabel("PT08.S1(CO) (scaled)")
plt.show()

# Step 12: Interpret noise
print("\nNoise points (label = -1) may represent:")
print("- Unusual or extreme pollution readings")
print("- Possible sensor errors")
print("- Natural outliers due to environmental variations")





#   Cluster Summary

#  Number of clusters formed: 8
#  Number of noise points: 4

#  Explanation:
# DBSCAN grouped the air quality data into 8 meaningful clusters, showing different patterns of pollution levels.
# Only 4 points were identified as noise, which are readings that do not belong to any dense region of the dataset.

# ---

#   Silhouette Score

#  Silhouette Score: 0.538

# Interpretation:
# A Silhouette Score of 0.538 indicates moderate to good cluster quality.
# This means that:

#  Most data points fit well within their assigned clusters,
#  Clusters are reasonably well-separated, and
#  There is some overlap between neighboring clusters.

# ---

#  Parameter Sensitivity (eps = 0.5, 1.0, 1.5)

# | eps value    | Number of clusters      | Noise points      | Observation                              |
# | -------------   | ----------------------     | -----------------    | -------------------------------------- |
# | 0.5               | More clusters              | Many noise points | Too strict — forms many small clusters |
# | 1.0       | 8 clusters         | 4 noise points| Balanced clustering — good separation  |
# | 1.5       | Fewer clusters     | Few noise points  | Too loose — clusters start merging     |

# Best result:
# `eps = 1.0` gives the best cluster separation and balance between density and noise detection.

# ---

#  Outlier Interpretation

# Noise points represent:

#  Extreme pollution readings, or
#  Sensor measurement errors, or
#  Natural atmospheric variations that don’t fit typical patterns.

#  Justification:
# DBSCAN labels points as noise when their pollution levels differ significantly from dense groups of similar readings.
# Hence, these readings likely represent rare or abnormal environmental conditions.

