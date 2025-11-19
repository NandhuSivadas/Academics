import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import silhouette_score, davies_bouldin_score, accuracy_score

# DIFFERENT LIBRARY FOR K-MEDOIDS
from pyclustering.cluster.kmedoids import kmedoids
from pyclustering.cluster import cluster_visualizer
from pyclustering.utils import read_sample
from pyclustering.samples.definitions import FCPS_SAMPLES

# 1. LOAD DATA
try:
    df = pd.read_csv('Heart_Disease.csv')
except FileNotFoundError:
    print("File not found. Please ensure 'Heart_Disease.csv' is in the folder.")
    exit()

# ... (Keep your EDA and Visualization parts here) ...

# PREPROCESSING
X = df.drop('target', axis=1).values
y = df['target'].values
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

# ==========================================
# ALTERNATIVE K-MEDOIDS IMPLEMENTATION
# ==========================================
print("\n### K-Medoids using PyClustering ###")

k_values = [2, 3]

for k in k_values:
    print(f"\n--- Running for k={k} ---")
    
    # 1. Initialize Medoids (Randomly pick k indices)
    initial_medoids = np.random.choice(len(X_scaled), k, replace=False)
    
    # 2. Create and Run K-Medoids
    # PyClustering expects the data as a simple list, not numpy array
    kmedoids_instance = kmedoids(X_scaled.tolist(), initial_medoids)
    kmedoids_instance.process()
    
    # 3. Get clusters and medoids
    clusters = kmedoids_instance.get_clusters()
    medoids = kmedoids_instance.get_medoids()
    
    # 4. Convert PyClustering output to Sklearn format (labels array)
    # PyClustering gives a list of lists [[idx1, idx2], [idx3...]]
    # We need a single array [0, 0, 1, 0, 1...]
    labels = np.zeros(len(X_scaled))
    for cluster_id, point_indices in enumerate(clusters):
        for index in point_indices:
            labels[index] = cluster_id
            
    # 5. Calculate Scores
    sil_score = silhouette_score(X_scaled, labels)
    db_score = davies_bouldin_score(X_scaled, labels)
    
    print(f"Silhouette Score: {sil_score:.4f}")
    print(f"Davies-Bouldin Index: {db_score:.4f}")
    
    # 6. Plot
    plt.figure(figsize=(8, 5))
    plt.scatter(X_scaled[:, 0], X_scaled[:, 4], c=labels, cmap='viridis', s=50, alpha=0.6)
    # Plot Medoids
    medoid_points = X_scaled[medoids]
    plt.scatter(medoid_points[:, 0], medoid_points[:, 4], c='red', marker='X', s=200, label='Medoids')
    plt.title(f'K-Medoids (PyClustering) k={k}')
    plt.xlabel('Scaled Age')
    plt.ylabel('Scaled Cholesterol')
    plt.legend()
    plt.show()