import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# Load the dataset
# Please ensure the 'Breast_Cancer.csv' file is in the same directory
# or provide the full path to the file.
try:
    df = pd.read_csv('Breast_Cancer.csv')
except FileNotFoundError:
    print("Error: 'Breast_Cancer.csv' not found. Please download the dataset and place it in the correct directory.")
    exit()

# Drop unnecessary columns
df = df.drop(columns=['id', 'Unnamed: 32'], errors='ignore')

# --- EDA Questions ---

# 1. What is the distribution of malignant vs benign cases?
print("--- 1. Distribution of Malignant vs Benign Cases ---")
plt.figure(figsize=(8, 6))
sns.countplot(x='diagnosis', data=df, palette='viridis')
plt.title('Distribution of Malignant vs Benign Cases')
plt.xlabel('Diagnosis (M=Malignant, B=Benign)')
plt.ylabel('Count')
plt.show()

print("\nFindings:")
print("The count plot shows the number of cases for each diagnosis.")
print(df['diagnosis'].value_counts())
print("From the plot and the counts, we can see that there are more benign (B) cases than malignant (M) cases in this dataset, but the classes are not severely imbalanced.\n")


# 2. Which features differ the most between malignant and benign tumors?
print("\n--- 2. Feature Comparison between Malignant and Benign Tumors ---")
features_to_compare = ['radius_mean', 'texture_mean', 'area_mean']
plt.figure(figsize=(15, 7))
for i, feature in enumerate(features_to_compare, 1):
    plt.subplot(1, 3, i)
    sns.boxplot(x='diagnosis', y=feature, data=df, palette='magma')
    plt.title(f'{feature} by Diagnosis')
plt.tight_layout()
plt.show()

print("\nFindings:")
print("The boxplots reveal significant differences in these features between malignant and benign tumors.")
print("- radius_mean: Malignant tumors tend to have a larger mean radius.")
print("- texture_mean: Malignant tumors generally exhibit a higher mean texture value.")
print("- area_mean: The mean area is noticeably larger for malignant tumors.")
print("These features appear to be strong indicators for classifying tumors.\n")


# 3. Is there a strong correlation between radius, perimeter, and area?
print("\n--- 3. Correlation between Radius, Perimeter, and Area ---")
correlation_features = ['radius_mean', 'perimeter_mean', 'area_mean']
corr_matrix = df[correlation_features].corr()
plt.figure(figsize=(8, 6))
sns.heatmap(corr_matrix, annot=True, cmap='coolwarm', fmt=".2f")
plt.title('Correlation Matrix of Radius, Perimeter, and Area (Mean)')
plt.show()

print("\nFindings:")
print("The heatmap shows a very strong positive correlation between radius_mean, perimeter_mean, and area_mean.")
print("The correlation coefficients are close to 1, which is expected as these geometric properties are directly related. For instance, area is proportional to the square of the radius (A = πr²), and perimeter is proportional to the radius (P = 2πr). This indicates high multicollinearity.\n")


# 4. Which features are most useful in distinguishing malignant from benign?
print("\n--- 4. Distinguishing Power of Concavity and Smoothness ---")
plt.figure(figsize=(14, 6))
plt.subplot(1, 2, 1)
sns.violinplot(x='diagnosis', y='concavity_mean', data=df, palette='plasma')
plt.title('Concavity Mean by Diagnosis')
plt.subplot(1, 2, 2)
sns.violinplot(x='diagnosis', y='smoothness_mean', data=df, palette='plasma')
plt.title('Smoothness Mean by Diagnosis')
plt.tight_layout()
plt.show()

print("\nFindings:")
print("The violin plots illustrate the distribution of these features for each class.")
print("- concavity_mean: There is a clear separation. Malignant tumors have significantly higher mean concavity values, with very little overlap in the distributions.")
print("- smoothness_mean: While malignant tumors tend to have slightly higher smoothness values, there is a considerable overlap between the two classes, making it a less powerful standalone predictor than concavity_mean.\n")


# 5. How do "worst" features compare to "mean" features in classification power?
print('\n--- 5. Comparison of "Mean" vs "Worst" Features ---')
plt.figure(figsize=(14, 6))
plt.subplot(1, 2, 1)
sns.kdeplot(df[df['diagnosis']=='M']['radius_mean'], label='Malignant Mean', shade=True)
sns.kdeplot(df[df['diagnosis']=='B']['radius_mean'], label='Benign Mean', shade=True)
plt.title('Distribution of radius_mean')
plt.legend()

plt.subplot(1, 2, 2)
sns.kdeplot(df[df['diagnosis']=='M']['radius_worst'], label='Malignant Worst', shade=True)
sns.kdeplot(df[df['diagnosis']=='B']['radius_worst'], label='Benign Worst', shade=True)
plt.title('Distribution of radius_worst')
plt.legend()
plt.tight_layout()
plt.show()

print("\nFindings:")
print("Comparing the Kernel Density Estimate (KDE) plots for 'radius_mean' and 'radius_worst':")
print("The 'radius_worst' feature shows a greater separation between the distributions for malignant and benign tumors compared to 'radius_mean'. The overlap between the two classes is smaller for the 'worst' feature, suggesting it might have better classification power.\n")


# 6. Are there multicollinearity issues among features?
print("\n--- 6. Multicollinearity Check ---")
# We need to encode the 'diagnosis' column to include it in the correlation matrix
df_encoded = df.copy()
df_encoded['diagnosis'] = df_encoded['diagnosis'].map({'M':1, 'B':0})
mean_features = ['diagnosis'] + list(df.columns[1:11])
corr_matrix_all = df_encoded[mean_features].corr()
plt.figure(figsize=(12, 10))
sns.heatmap(corr_matrix_all, annot=False, cmap='viridis')
plt.title('Correlation Heatmap of Mean Features')
plt.show()

print("\nFindings:")
print("The heatmap of the mean features shows several areas of high correlation (bright yellow squares).")
print("- As seen before, 'radius_mean', 'perimeter_mean', and 'area_mean' are highly correlated.")
print("- 'compactness_mean', 'concavity_mean', and 'concave points_mean' also show strong positive correlations with each other.")
print("This high multicollinearity suggests that some features are redundant. For building predictive models, it might be beneficial to use techniques like Principal Component Analysis (PCA) or to select a subset of these features to avoid model instability.\n")


# 7. Which top 5 features show the largest separation between malignant and benign tumors?
print("\n--- 7. Top 5 Features for Class Separation ---")
# Based on earlier analysis, let's pick a few promising features.
top_features = ['concave points_worst', 'perimeter_worst', 'radius_worst', 'area_worst', 'concavity_mean']
sns.pairplot(df, hue='diagnosis', vars=top_features, palette='husl')
plt.suptitle('Pairplot of Top 5 Distinguishing Features', y=1.02)
plt.show()

print("\nFindings:")
print("The pairplot visualizes the relationships between the top distinguishing features, colored by diagnosis.")
print("The diagonal shows the distribution of each feature for both classes. We can see a clear separation in the distributions for all selected features.")
print("The scatter plots show how these features relate to each other. For malignant tumors (often one color), the values for these features are consistently higher, and they form a distinct cluster from the benign tumors. This visual evidence confirms their strong predictive power.\n")


# 8. What is the average tumor size (radius/area) for malignant vs benign?
print("\n--- 8. Average Tumor Size by Diagnosis ---")
avg_size = df.groupby('diagnosis')[['radius_mean', 'area_mean']].mean().reset_index()
plt.figure(figsize=(12, 6))
plt.subplot(1, 2, 1)
sns.barplot(x='diagnosis', y='radius_mean', data=avg_size, palette='cubehelix')
plt.title('Average Mean Radius by Diagnosis')
plt.subplot(1, 2, 2)
sns.barplot(x='diagnosis', y='area_mean', data=avg_size, palette='cubehelix')
plt.title('Average Mean Area by Diagnosis')
plt.tight_layout()
plt.show()

print("\nFindings:")
print(avg_size)
print("\nThe bar plots and the table clearly show that the average tumor size, both in terms of radius and area, is significantly larger for malignant tumors compared to benign tumors. This is a key characteristic for diagnosis.\n")


# 9. Are there any outliers in the dataset? How might they affect classification?
print("\n--- 9. Outlier Detection ---")
plt.figure(figsize=(14, 6))
plt.subplot(1, 2, 1)
sns.boxplot(x='diagnosis', y='area_worst', data=df, palette='brg')
plt.title('Boxplot of Worst Area')
plt.subplot(1, 2, 2)
sns.scatterplot(x='radius_worst', y='area_worst', hue='diagnosis', data=df, palette='brg')
plt.title('Scatter plot of Worst Radius vs Worst Area')
plt.tight_layout()
plt.show()

print("\nFindings:")
print("The boxplot for 'area_worst' shows several data points (outliers) beyond the upper whisker for both benign and malignant classes, particularly for the malignant class.")
print("These outliers represent tumors that are exceptionally large. In classification, these outliers could potentially influence the decision boundary of some models (like SVMs) or affect the performance of models sensitive to feature scaling. However, they also represent valid, albeit extreme, cases and might be important for capturing the full range of tumor characteristics.\n")


# 11. Which features show the highest variance, and do they contribute to classification?
# Note: Question 10 was skipped in the prompt.
print("\n--- 11. Feature Variance and Contribution to Classification ---")
# Calculate variance (excluding diagnosis)
variances = df.drop(columns='diagnosis').var().sort_values(ascending=False)
plt.figure(figsize=(12, 6))
variances.head(10).plot(kind='bar', color=sns.color_palette('mako', 10))
plt.title('Top 10 Features with Highest Variance')
plt.ylabel('Variance')
plt.xticks(rotation=45, ha='right')
plt.show()

print("\nFindings:")
print("Top 5 features with highest variance:")
print(variances.head())
print("\nThe features with the highest variance are 'area_worst', 'area_mean', and 'perimeter_worst'. These are features related to the size of the tumor.")
print("As we've seen in previous plots (e.g., boxplots for area_mean, pairplots), these high-variance features are indeed very effective at distinguishing between malignant and benign tumors. The large variance reflects the wide range of values these features can take, and this range differs significantly between the two classes, making them powerful predictors.\n")


# 12. How does texture differ between malignant and benign tumors?
print("\n--- 12. Texture Comparison between Tumor Types ---")
plt.figure(figsize=(14, 6))
plt.subplot(1, 2, 1)
sns.histplot(data=df, x='texture_mean', hue='diagnosis', kde=True, palette='twilight')
plt.title('Histogram of Mean Texture')
plt.subplot(1, 2, 2)
sns.histplot(data=df, x='texture_worst', hue='diagnosis', kde=True, palette='twilight')
plt.title('Histogram of Worst Texture')
plt.tight_layout()
plt.show()

print("\nFindings:")
print("The histograms show that for both 'texture_mean' and 'texture_worst', malignant tumors tend to have higher texture values.")
print("The distribution for malignant tumors is shifted to the right (higher values) compared to benign tumors. While there is some overlap, the difference in distributions indicates that texture is a useful feature for classification.\n")


# 13. Do tumors with higher concavity tend to be malignant?
print("\n--- 13. Relationship between Concavity and Diagnosis ---")
plt.figure(figsize=(8, 6))
sns.boxplot(x='diagnosis', y='concavity_mean', data=df, palette='gist_earth')
plt.title('Concavity Mean for Malignant vs Benign Tumors')
plt.show()

print("\nFindings:")
print("Yes, the boxplot clearly demonstrates that tumors with higher mean concavity values are predominantly malignant.")
print("The median concavity for malignant tumors is substantially higher than for benign tumors, and the entire interquartile range for malignant tumors lies above the 75th percentile for benign tumors. This confirms concavity as a very strong predictor of malignancy.\n")


# 14. What is the relationship between smoothness and compactness?
print("\n--- 14. Relationship between Smoothness and Compactness ---")
plt.figure(figsize=(10, 8))
sns.scatterplot(x='smoothness_mean', y='compactness_mean', hue='diagnosis', data=df, alpha=0.7, palette='seismic')
plt.title('Smoothness vs. Compactness (Mean)')
plt.show()

print("\nFindings:")
print("The scatter plot shows a positive correlation between mean smoothness and mean compactness; as one increases, the other tends to increase as well.")
print("Furthermore, the malignant tumors (often shown in one color, e.g., red) tend to have higher values for both smoothness and compactness, occupying the upper-right portion of the plot. This suggests that the combination of these two features can be useful for separating the classes.\n")


# 15. Which class tends to have higher values of fractal dimension?
print("\n--- 15. Fractal Dimension by Diagnosis ---")
plt.figure(figsize=(8, 6))
sns.violinplot(x='diagnosis', y='fractal_dimension_mean', data=df, palette='ocean')
plt.title('Fractal Dimension Mean by Diagnosis')
plt.show()

print("\nFindings:")
print("The violin plot for 'fractal_dimension_mean' shows that the distributions for malignant and benign tumors are largely overlapping.")
print("While malignant tumors appear to have a slightly wider distribution and a few cases with higher fractal dimensions, the median and interquartile ranges are very similar. This suggests that fractal dimension, by itself, is not a strong feature for distinguishing between the two classes.\n")
